package com.saucelabs.rest.tunnel.exceptions;

public class TunnelExistsException extends Exception
{
    public TunnelExistsException(String error)
    {
        super(error);
    }
}
