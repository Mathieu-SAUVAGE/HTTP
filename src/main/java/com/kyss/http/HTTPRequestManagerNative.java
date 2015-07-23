package com.kyss.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mathieu.
 */

public class HTTPRequestManagerNative {
    //<editor-fold desc="logger">
    private static Logger LOGGER = LoggerFactory.getLogger(HTTPRequestManagerNative.class);
    //</editor-fold>

    //<editor-fold desc="constants">
    public static enum RequestType {
        GET, POST, PUT
    }
//</editor-fold>

//<editor-fold desc="attributes">
//</editor-fold>

//<editor-fold desc="getters & setters">
//</editor-fold>

//<editor-fold desc="builders">
//</editor-fold>

//<editor-fold desc="public methods">
    //<editor-fold desc="URL generation">

    /**
     * Create an encoded URL.
     *
     * @param charset Charset use for encoding.
     * @param urlPath URL to encode.
     * @return an Encoded URL with the charset.
     * @throws MalformedURLException        if no protocol is specified, or an unknown protocol is found.
     * @throws UnsupportedEncodingException if the charset is not valid.
     */
    public static URL getURL(final Charset charset, final String urlPath) throws MalformedURLException, UnsupportedEncodingException {
        return getURL(charset,
                urlPath,
                new HashMap<String, String>());
    }

    /**
     * Create an encoded URL.
     *
     * @param charset    Charset use for encoding.
     * @param urlPath    URL to encode.
     * @param parameters parameters place in the URL
     * @return an Encoded parametered URL with the charset.
     * @throws MalformedURLException        if no protocol is specified, or an unknown protocol is found.
     * @throws UnsupportedEncodingException if the charset is not valid.
     */
    public static URL getURL(final Charset charset, final String urlPath, final Map<String, String> parameters) throws MalformedURLException, UnsupportedEncodingException {
        StringBuilder parameterURL = new StringBuilder(URLEncoder.encode(urlPath,
                charset.name()));

        boolean isFirstParameter = true;
        for (Map.Entry<String, String> currentEntry : parameters.entrySet()) {
            if (isFirstParameter) {
                parameterURL.append("?");
                isFirstParameter = false;
            } else {
                parameterURL.append("&");
            }
            parameterURL.append(currentEntry.getKey()).append("=").append(URLEncoder.encode(currentEntry.getValue(),
                    charset.name()));

        }
        LOGGER.debug("generated URL " + parameterURL.toString());
        return new URL(parameterURL.toString());
    }
    //</editor-fold>

    public HttpURLConnection get(final URL url) throws IOException {
        return get(url, new HTTPRequestHeader());
    }

    public HttpURLConnection get(final URL url, final HTTPRequestHeader headers) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod(RequestType.GET.toString());

        for (Map.Entry<String, String> currentEntry : headers.entrySet()) {
            connection.addRequestProperty(currentEntry.getKey(), currentEntry.getValue());
        }

        return connection;
    }


    public <R> HTTPRequestResponse<R> get(final URL url, final HTTPRequestHandlerNative<R> consumer) throws Exception {
        return consumer.consume(get(url));
    }

    public <R> HTTPRequestResponse<R> get(final Charset charset, final String urlPath, final Map<String, String> URLParameters, final HTTPRequestHandlerNative<R> consumer) throws Exception {
        return get(getURL(charset,
                        urlPath,
                        URLParameters),
                consumer);
    }
//</editor-fold>

//<editor-fold desc="protected methods">
//</editor-fold>

//<editor-fold desc="package methods">
//</editor-fold>

//<editor-fold desc="private methods">
//</editor-fold>
}
