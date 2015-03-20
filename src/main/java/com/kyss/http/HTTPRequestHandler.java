package com.kyss.http;

import com.squareup.okhttp.Response;

/**
 * This class consume an HTTP request.
 *
 * @author Mathieu SAUVAGE
 */
public interface HTTPRequestHandler<R> extends RequestConsumer<R, Response> {
    /**
     * Consume an HTTP resquest.
     *
     * @param response the <code>HttpURLConnection</code> used to do the HTTP request.
     *
     * @return The consumption's result.
     */
    @Override
    public R consume(Response response) throws Exception;
}
