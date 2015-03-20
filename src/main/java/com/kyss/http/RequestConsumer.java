package com.kyss.http;


/**
 * This class consume a request.
 *
 * @author Mathieu SAUVAGE
 */
public interface RequestConsumer<R, I> {
    /**
     * Treat a request.
     *
     * @param input The connection used to do the HTTP request.
     *
     * @return The result of the request treatment.
     * @throws java.lang.Exception If an error occurs during the request treatment.
     */
    R consume(I input) throws Exception;
}
