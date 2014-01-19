package com.saucelabs.rest.tunnel;

import com.saucelabs.rest.tunnel.restclient.SauceRestClient;
import org.junit.Test;


/**
 * Sauce Rest Client Test
 *
 * @author Kushang Gajjar
 */
public class SauceRestClientTest
{
    private static final String USERNAME = "walletboston";
    private static final String KEY = "f8e2548a-f454-4e23-bcfd-f125ecc14070";

    @Test
    public void testSauceConnect() throws Exception
    {
        SauceRestClient restClient = new SauceRestClient(USERNAME, KEY);
//        restClient.sauceconnect().connect("kugajjar00111322212");
        restClient.sauceConnect().disconnect("kugajjar00111322212");


    }
}
