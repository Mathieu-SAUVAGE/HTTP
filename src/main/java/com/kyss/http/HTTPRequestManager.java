package com.kyss.http;


import com.squareup.okhttp.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mathieu SAUVAGE
 */
public class HTTPRequestManager {
    private static Logger LOGGER = LoggerFactory.getLogger(HTTPRequestManager.class);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * Create an encoded URL.
     *
     * @param charset Charset use for encoding.
     * @param url     URL to encode.
     *
     * @return an Encoded URL with the charset.
     *
     * @throws MalformedURLException        if no protocol is specified, or an unknown protocol is found.
     * @throws UnsupportedEncodingException if the charset is not valid.
     */
    public static URL getURL(final Charset charset, final String url) throws MalformedURLException, UnsupportedEncodingException {
        return getURL(charset,
                      url,
                      new HashMap<String,String>());
    }

    /**
     * Create an encoded URL.
     *
     * @param charset Charset use for encoding.
     * @param url     URL to encode.
     * @param parameters parameters place in the URL
     *
     * @return an Encoded parametered URL with the charset.
     *
     * @throws MalformedURLException        if no protocol is specified, or an unknown protocol is found.
     * @throws UnsupportedEncodingException if the charset is not valid.
     */
    public static URL getURL(final Charset charset, final String url, final Map<String, String> parameters) throws MalformedURLException, UnsupportedEncodingException {
        StringBuilder parameterURL = new StringBuilder(url);

        boolean isFirstParameter = true;
        for (Map.Entry<String, String> currentEntry : parameters.entrySet()) {
            if (isFirstParameter) {
                parameterURL.append("?");
                isFirstParameter = false;
            } else {
                parameterURL.append("&");
            }
            parameterURL.append(currentEntry.getKey()).append("=").append(URLEncoder.encode(currentEntry.getValue(),
                                                                                            charset.toString()));

        }
        LOGGER.trace("generated URL " + parameterURL.toString());
        return new URL(parameterURL.toString());
    }

    //<editor-fold desc="GET Request">

    /**
     * Execute a GET HTTP request.
     * @param url the URL of the HTTP request.
     * @return the request <code>Response</code>
     * @throws IOException
     */
    public Response get(final URL url) throws IOException {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }

    public Response get(final Charset charset, final String urlPath, final Map<String, String> parameters) throws IOException {
        return get(getURL(charset,
                          urlPath,
                          parameters));
    }

    public <R> R get(final URL url, final HTTPRequestHandler<R> consumer) throws Exception {
        return consumer.consume(get(url));
    }

    public <R> R get(final Charset charset, final String urlPath, final Map<String, String> parameters, final HTTPRequestHandler<R> consumer) throws Exception {
        return get(getURL(charset,
                          urlPath,
                          parameters),
                   consumer);
    }
    //</editor-fold>

    //<editor-fold desc="POST Request">
    public Response post(final Charset charset, final String urlPath, final Map<String, String> parameters, final JSONObject body) throws Exception {
        RequestBody bodyJSON = RequestBody.create(JSON,
                                                  body.toString());

        return post(getURL(charset,
                           urlPath,
                           parameters),
                    bodyJSON);
    }

    /**
     * Execute a POST http request.
     *
     * @param url  The server's <code>ULR</code>.
     * @param body The body's value as a <code>JSONObject</code>.
     *
     * @return The result return by the <code>HTTPRequestConsumer</code>.
     *
     * @throws IOException
     * @see HTTPRequestHandler
     */
    public <R> R post(final URL url, final JSONObject body, final HTTPRequestHandler<R> consumer) throws Exception {
        RequestBody bodyJSON = RequestBody.create(JSON,
                                                  body.toString());
        return consumer.consume(post(url,
                                     bodyJSON));
    }

    public <R> R post(final Charset charset, final String urlPath, final Map<String, String> parameters, final JSONObject body, final HTTPRequestHandler<R> consumer) throws Exception {
        return post(getURL(charset,
                           urlPath,
                           parameters),
                    body,
                    consumer);
    }

    /**
     * Execute a POST http request.
     *
     * @param url  The server's <code>ULR</code>.
     * @param body The body's value as a <code>String</code>.
     *
     * @return The <code>HttpURLConnection</code> opened on the server.
     *
     * @throws IOException
     */
    public Response post(final URL url, final RequestBody body) throws Exception {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public Response post(final URL url, final JSONObject body) throws Exception {
        RequestBody bodyJSON = RequestBody.create(JSON,
                                                  body.toString());
        return post(url,
                    bodyJSON);
    }

    public Response post(final Charset charset, final String urlPath, final Map<String, String> parameters, final RequestBody body) throws Exception {
        return post(getURL(charset,
                           urlPath,
                           parameters),
                    body);
    }

    /**
     * @param url  The server's <code>ULR</code>.
     * @param body The body's value as a <code>String</code>.
     *
     * @return The result return by the <code>HTTPRequestConsumer</code>.
     *
     * @throws IOException
     * @see HTTPRequestHandler
     */
    public <R> R post(final URL url, final RequestBody body, final HTTPRequestHandler<R> consumer) throws Exception {
        return consumer.consume(post(url,
                                     body));
    }

    public <R> R post(final Charset charset, final String urlPath, final Map<String, String> parameters, final RequestBody body, final HTTPRequestHandler<R> consumer) throws Exception {
        return post(getURL(charset,
                           urlPath,
                           parameters),
                    body,
                    consumer);
    }
    //</editor-fold>
}
