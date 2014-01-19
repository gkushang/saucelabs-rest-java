package com.saucelabs.rest.tunnel.restclient;

import com.saucelabs.rest.tunnel.credentials.Credentials;
import com.saucelabs.rest.tunnel.sauceconnect.SauceConnect;
import org.apache.commons.lang.Validate;


/**
 * Sauce Rest Client
 *
 * @author Kushang Gajjar
 */

public class SauceRestClient
{
    private final Credentials _credentials;

    public SauceRestClient(String username, String key)
    {
        Validate.notEmpty(username, "username cannot be null or empty");
        Validate.notEmpty(key, "key cannot be null or empty");

        _credentials = new Credentials(username, key);
    }

    public SauceConnect sauceConnect()
    {
        return new SauceConnect(_credentials);
    }

}
