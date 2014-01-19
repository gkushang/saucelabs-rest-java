package com.sauce.rest.tunnel.sauceconnect;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * Json Schema for Sauce Tunnel
 *
 * @author Kushang Gajjar
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {

        "ssh_port",
        "creation_time",
        "domain_names",
        "owner",
        "use_kgp",
        "id",
        "DomainNames",
        "Status",
        "direct_domains",
        "vm_version",
        "deletion_time",
        "rev",
        "Host",
        "shared_tunnel",
        "status",
        "squid_config",
        "shutdown_time",
        "fast_fail_regexps",
        "modification_time",
        "host",
        "no_ssl_bump_domains",
        "last_connected",
        "user_shutdown",
        "use_caching_proxy",
        "launch_time",
        "tunnel_identifier"
})
class SauceTunnel
{

    @JsonProperty("ssh_port")
    private Integer ssh_port;
    @JsonProperty("creation_time")
    private Integer creation_time;
    @JsonProperty("domain_names")
    private Object domain_names;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("use_kgp")
    private Boolean use_kgp;
    @JsonProperty("id")
    private String id;
    @JsonProperty("DomainNames")
    private Object DomainNames;
    @JsonProperty("Status")
    private String Status;
    @JsonProperty("direct_domains")
    private Object direct_domains;
    @JsonProperty("vm_version")
    private String vm_version;
    @JsonProperty("deletion_time")
    private Object deletion_time;
    @JsonProperty("rev")
    private Integer rev;
    @JsonProperty("Host")
    private String Host;
    @JsonProperty("shared_tunnel")
    private Boolean shared_tunnel;
    @JsonProperty("status")
    private String status;
    @JsonProperty("squid_config")
    private Object squid_config;
    @JsonProperty("shutdown_time")
    private Object shutdown_time;
    @JsonProperty("fast_fail_regexps")
    private Object fast_fail_regexps;
    @JsonProperty("modification_time")
    private Integer modification_time;
    @JsonProperty("host")
    private String host;
    @JsonProperty("no_ssl_bump_domains")
    private Object no_ssl_bump_domains;
    @JsonProperty("last_connected")
    private Integer last_connected;
    @JsonProperty("user_shutdown")
    private Object user_shutdown;
    @JsonProperty("use_caching_proxy")
    private Boolean use_caching_proxy;
    @JsonProperty("launch_time")
    private Integer launch_time;
    @JsonProperty("tunnel_identifier")
    private String tunnel_identifier;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("error")
    private String error;

    @JsonProperty("ok")
    private Boolean ok;


    @JsonProperty("ssh_port")
    public Integer getSsh_port()
    {
        return ssh_port;
    }

    @JsonProperty("ssh_port")
    public void setSsh_port(Integer ssh_port)
    {
        this.ssh_port = ssh_port;
    }

    @JsonProperty("creation_time")
    public Integer getCreation_time()
    {
        return creation_time;
    }

    @JsonProperty("creation_time")
    public void setCreation_time(Integer creation_time)
    {
        this.creation_time = creation_time;
    }

    @JsonProperty("domain_names")
    public Object getDomain_names()
    {
        return domain_names;
    }

    @JsonProperty("domain_names")
    public void setDomain_names(Object domain_names)
    {
        this.domain_names = domain_names;
    }

    @JsonProperty("owner")
    public String getOwner()
    {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    @JsonProperty("use_kgp")
    public Boolean getUse_kgp()
    {
        return use_kgp;
    }

    @JsonProperty("use_kgp")
    public void setUse_kgp(Boolean use_kgp)
    {
        this.use_kgp = use_kgp;
    }

    @JsonProperty("id")
    public String getId()
    {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id)
    {
        this.id = id;
    }

    @JsonProperty("DomainNames")
    public Object getDomainNames()
    {
        return DomainNames;
    }

    @JsonProperty("DomainNames")
    public void setDomainNames(Object DomainNames)
    {
        this.DomainNames = DomainNames;
    }

    @JsonProperty("Status")
    public String getStatus()
    {
        return Status;
    }

    @JsonProperty("Status")
    public void setStatus(String Status)
    {
        this.Status = Status;
    }

    @JsonProperty("direct_domains")
    public Object getDirect_domains()
    {
        return direct_domains;
    }

    @JsonProperty("direct_domains")
    public void setDirect_domains(Object direct_domains)
    {
        this.direct_domains = direct_domains;
    }

    @JsonProperty("vm_version")
    public String getVm_version()
    {
        return vm_version;
    }

    @JsonProperty("vm_version")
    public void setVm_version(String vm_version)
    {
        this.vm_version = vm_version;
    }

    @JsonProperty("deletion_time")
    public Object getDeletion_time()
    {
        return deletion_time;
    }

    @JsonProperty("deletion_time")
    public void setDeletion_time(Object deletion_time)
    {
        this.deletion_time = deletion_time;
    }

    @JsonProperty("rev")
    public Integer getRev()
    {
        return rev;
    }

    @JsonProperty("rev")
    public void setRev(Integer rev)
    {
        this.rev = rev;
    }


    @JsonProperty("shared_tunnel")
    public Boolean getShared_tunnel()
    {
        return shared_tunnel;
    }

    @JsonProperty("shared_tunnel")
    public void setShared_tunnel(Boolean shared_tunnel)
    {
        this.shared_tunnel = shared_tunnel;
    }

    @JsonProperty("squid_config")
    public Object getSquid_config()
    {
        return squid_config;
    }

    @JsonProperty("squid_config")
    public void setSquid_config(Object squid_config)
    {
        this.squid_config = squid_config;
    }

    @JsonProperty("shutdown_time")
    public Object getShutdown_time()
    {
        return shutdown_time;
    }

    @JsonProperty("shutdown_time")
    public void setShutdown_time(Object shutdown_time)
    {
        this.shutdown_time = shutdown_time;
    }

    @JsonProperty("fast_fail_regexps")
    public Object getFast_fail_regexps()
    {
        return fast_fail_regexps;
    }

    @JsonProperty("fast_fail_regexps")
    public void setFast_fail_regexps(Object fast_fail_regexps)
    {
        this.fast_fail_regexps = fast_fail_regexps;
    }

    @JsonProperty("modification_time")
    public Integer getModification_time()
    {
        return modification_time;
    }

    @JsonProperty("modification_time")
    public void setModification_time(Integer modification_time)
    {
        this.modification_time = modification_time;
    }

    @JsonProperty("host")
    public String getHost()
    {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host)
    {
        this.host = host;
    }

    @JsonProperty("no_ssl_bump_domains")
    public Object getNo_ssl_bump_domains()
    {
        return no_ssl_bump_domains;
    }

    @JsonProperty("no_ssl_bump_domains")
    public void setNo_ssl_bump_domains(Object no_ssl_bump_domains)
    {
        this.no_ssl_bump_domains = no_ssl_bump_domains;
    }

    @JsonProperty("last_connected")
    public Integer getLast_connected()
    {
        return last_connected;
    }

    @JsonProperty("last_connected")
    public void setLast_connected(Integer last_connected)
    {
        this.last_connected = last_connected;
    }

    @JsonProperty("user_shutdown")
    public Object getUser_shutdown()
    {
        return user_shutdown;
    }

    @JsonProperty("user_shutdown")
    public void setUser_shutdown(Object user_shutdown)
    {
        this.user_shutdown = user_shutdown;
    }

    @JsonProperty("use_caching_proxy")
    public Boolean getUse_caching_proxy()
    {
        return use_caching_proxy;
    }

    @JsonProperty("use_caching_proxy")
    public void setUse_caching_proxy(Boolean use_caching_proxy)
    {
        this.use_caching_proxy = use_caching_proxy;
    }

    @JsonProperty("launch_time")
    public Integer getLaunch_time()
    {
        return launch_time;
    }

    @JsonProperty("launch_time")
    public void setLaunch_time(Integer launch_time)
    {
        this.launch_time = launch_time;
    }

    @JsonProperty("tunnel_identifier")
    public String getTunnel_identifier()
    {
        return tunnel_identifier;
    }

    @JsonProperty("tunnel_identifier")
    public void setTunnel_identifier(String tunnel_identifier)
    {
        this.tunnel_identifier = tunnel_identifier;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties()
    {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value)
    {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("error")
    public String getError()
    {
        return error;
    }

    @JsonProperty("error")
    public void setError(String error)
    {
        this.error = error;
    }

    @JsonProperty("ok")
    public Boolean getOk()
    {
        return ok;
    }

    @JsonProperty("ok")
    public void setOk(Boolean ok)
    {
        this.ok = ok;
    }
}