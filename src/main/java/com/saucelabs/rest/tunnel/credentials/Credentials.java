package com.saucelabs.rest.tunnel.credentials;

import org.apache.commons.lang.Validate;


/**
 * Sauce Labs Credentials
 *
 * @author Kushang Gajjar
 */
public class Credentials
{
    private final String _username;
    private final String _key;

    public Credentials(String username, String key)
    {
        Validate.notEmpty(username, "username cannot be null or empty");
        Validate.notEmpty(key, "key cannot be null or empty");

        _username = username;
        _key = key;
    }

    public String getUsername()
    {
        return _username;
    }

    public String getKey()
    {
        return _key;
    }
}
