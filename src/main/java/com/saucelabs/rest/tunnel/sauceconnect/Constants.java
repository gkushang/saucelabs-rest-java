package com.saucelabs.rest.tunnel.sauceconnect;

/**
 * Constants
 *
 * @author Kushang Gajjar
 */
class Constants
{
    public class RestUrl
    {
        public static final String SAUCE_TUNNELS = "https://saucelabs.com/rest/{0}/tunnels";
        public static final String SAUCE_TUNNEL = "https://saucelabs.com/rest/{0}/tunnels/{1}";
    }


    public class RequestType
    {
        public static final String POST = "POST";
        public static final String GET = "GET";
        public static final String DELETE = "DELETE";
    }


}
