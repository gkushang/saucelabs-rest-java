package com.sauce.rest.tunnel.authentication;

import org.apache.commons.lang.Validate;


/**
 * Sauce Labs Authentication
 *
 * @author Kushang Gajjar
 */
public class Authentication
{
    private final String _username;
    private final String _key;

    public Authentication(String username, String key)
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
