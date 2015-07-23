package com.kyss.http;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * This class consume an HTTP request.
 *
 * @author Mathieu SAUVAGE
 */
public abstract class HTTPRequestHandlerNative<T> implements RequestConsumerNative<T, HttpURLConnection> {
    /**
     * Consume an HTTP resquest.
     *
     * @param connection the <code>HttpURLConnection</code> used to do the HTTP request.
     * @return The consumption's result
     */
    public HTTPRequestResponse<T> consume(final HttpURLConnection connection) throws Exception {
        return new HTTPRequestResponse<T>(extractReturnCode(connection), extractData(connection));
    }

    protected int extractReturnCode(final HttpURLConnection connection) throws IOException {
        return connection.getResponseCode();
    }

//    protected String extractData(final HttpURLConnection connection) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//        String inputLine;
//
//        StringBuffer response = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        return response.toString();
//    }
}
