package com.saucelabs.rest.tunnel.exceptions;

public class TunnelNotFoundException extends Exception
{
    public TunnelNotFoundException(String error)
    {
        super(error);
    }
}
