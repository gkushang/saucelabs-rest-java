package com.sauce.rest.tunnel.sauceconnect;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Json Schema for Sauce Connect Status
 *
 * @author Kushang Gajjar
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
                           "ok",
                           "id",
                           "error"
                   })
class ConnectStatus
{

    @JsonProperty("ok")
    private Boolean ok;
    @JsonProperty("id")
    private String id;
    @JsonProperty("error")
    private String error;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

}
