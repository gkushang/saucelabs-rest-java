package com.sauce.rest.tunnel.sauceconnect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import com.sauce.rest.tunnel.authentication.Authentication;
import com.sauce.rest.tunnel.exceptions.TunnelExistsException;
import com.sauce.rest.tunnel.exceptions.TunnelNotFoundException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.Validate;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.ANY;
import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NONE;


/**
 * Sauce Connect
 *
 * @author Kushang Gajjar
 */

public class SauceConnect
{
    private final Authentication _authentication;

    private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();

    private final Logger LOG = LoggerFactory.getLogger(SauceConnect.class);

    static
    {
        OBJ_MAPPER.setVisibilityChecker(new VisibilityChecker.Std(NONE, NONE, NONE, NONE, ANY));
    }

    public SauceConnect(Authentication authentication)
    {
        Validate.notNull(authentication, "authentication cannot be null");

        _authentication = authentication;
    }

    private URL _getTunnelRestUrl() throws MalformedURLException
    {
        return new URL(MessageFormat.format(Constants.RestUrl.SAUCE_TUNNELS, _authentication.getUsername()));
    }

    public ConnectStatus connect(String tunnelIdentifier, String... domainNames) throws IOException, TunnelExistsException
    {
        Validate.notEmpty(tunnelIdentifier, "tunnelIdentifier cannot be null or empty");

        HttpURLConnection connection = _getConnection(_getTunnelRestUrl(), Constants.RequestType.POST);

        connection.connect();

        OutputStream out = connection.getOutputStream();

        SauceTunnel tunnelStatus = new SauceTunnel();
        tunnelStatus.setDomainNames(Arrays.asList(domainNames));
        tunnelStatus.setTunnel_identifier(tunnelIdentifier);

        LOG.info("Requesting Sauce Tunnel connection for tunnel_identifier '{}' and domainNames '{}'", tunnelIdentifier, domainNames);

        OBJ_MAPPER.writeValue(out, tunnelStatus);

        if (connection.getResponseCode() == 400)
        {
            ByteArrayOutputStream errorMessage = new ByteArrayOutputStream();
            IOUtils.copy(connection.getErrorStream(), errorMessage);

            throw new IOException(String.format("Could not established tunnel connection %d %s \n %s",
                                                connection.getResponseCode(),
                                                connection.getResponseMessage(),
                                                errorMessage
            ));
        }
        else if (connection.getResponseCode() == 500)
        {
            throw new TunnelExistsException(MessageFormat.format("Looks like connection exist for tunnelIdentifier: {0} and domainNames: {1}",
                                                                 tunnelIdentifier,
                                                                 Arrays.asList(domainNames)));
        }

        ConnectStatus connectStatus = OBJ_MAPPER.readValue(connection.getInputStream(), ConnectStatus.class);

        if (connectStatus.getOk())
            LOG.info("Connection established successfully with id '{}'", connectStatus.getId());

        return connectStatus;

    }


    public void disconnect(String tunnelIdentifier) throws IOException, TunnelNotFoundException
    {
        Validate.notEmpty(tunnelIdentifier, "tunnelIdentifier cannot be null or empty");

        SauceTunnel sauceTunnel = getSauceTunnel(tunnelIdentifier);

        HttpURLConnection connection = _getConnection(_getTunnelRestUrl(sauceTunnel.getId()), Constants.RequestType.DELETE);
        connection.connect();

        if (connection.getResponseCode() != 200)
            throw new IOException(String.format("Could not delete tunnel by tunnelIdentifier %s connection %d %s",
                                                tunnelIdentifier,
                                                connection.getResponseCode(),
                                                connection.getResponseMessage()
            ));

        connection.getInputStream().close();
    }

    public SauceTunnel getSauceTunnel(String tunnelIdentifier) throws IOException, TunnelNotFoundException
    {
        Validate.notEmpty(tunnelIdentifier, "tunnelIdentifier cannot be null or empty");

        HttpURLConnection connection = _getConnection(_getTunnelRestUrl(), Constants.RequestType.GET);
        connection.connect();

        List<SauceTunnel> sauceTunnels = OBJ_MAPPER.readValue(connection.getInputStream(), new TypeReference<List<SauceTunnel>>()
        {
        });

        for (SauceTunnel sauceTunnel : sauceTunnels)
            if (sauceTunnel.getTunnel_identifier().equalsIgnoreCase(tunnelIdentifier))
                return sauceTunnel;

        throw new TunnelNotFoundException(MessageFormat.format("Tunnel by tunnelIdentifier {0} was not found", tunnelIdentifier));
    }

    private URL _getTunnelRestUrl(String jobId) throws MalformedURLException
    {
        Validate.notEmpty(jobId, "jobId cannot be null or empty");

        return new URL(MessageFormat.format(Constants.RestUrl.SAUCE_TUNNEL, _authentication.getUsername(), jobId));
    }

    private HttpURLConnection _getConnection(final URL restUrl, final String requestType) throws IOException
    {

        Validate.notEmpty(requestType, "requestType cannot be null or empty");
        Validate.notNull(restUrl, "restUrl cannot be null or empty");

        HttpURLConnection connection = (HttpURLConnection) restUrl.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + new String(
                Base64.encodeBase64((_authentication.getUsername() + ":" + _authentication.getKey())
                                            .getBytes())));

        connection.setRequestMethod(requestType);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        return connection;
    }

}
