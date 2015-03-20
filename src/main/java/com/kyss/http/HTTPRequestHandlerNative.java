package com.kyss.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * This class consume an HTTP request.
 *
 * @author Mathieu SAUVAGE
 */
public abstract class HTTPRequestHandlerNative<T> implements RequestConsumerNative<T, HttpURLConnection> {
	/**
	 * Consume an HTTP request.
	 *
	 * @param connection the <code>HttpURLConnection</code> used to do the HTTP request.
	 * @return The consumption's result
	 */
	public HTTPRequestResponse<T> consume(final HttpURLConnection connection) throws Exception {
		HTTPRequestResponse<T> result = new HTTPRequestResponse<T>(HTTPStatus.getHHTPStatus(extractReturnCode(connection)),
																   connection.getResponseMessage(),
																   extractData(connection));
		connection.disconnect();
		return result;
	}

	public abstract T extractBody(final HttpURLConnection connection);

	private int extractReturnCode(final HttpURLConnection connection) throws IOException {
		return connection.getResponseCode();
	}

	protected BufferedReader getBodyBufferReader(final HttpURLConnection connection) throws IOException {
		return new BufferedReader(new InputStreamReader(connection.getInputStream()));
	}

	protected BufferedReader getErrorBufferReader(final HttpURLConnection connection) throws IOException {
		return new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	}

	protected String getBody(final HttpURLConnection connection) throws IOException {
		return readBuffer(getBodyBufferReader(connection));
	}

	protected String getError(final HttpURLConnection connection) throws IOException {
		return readBuffer(getErrorBufferReader(connection));
	}

	protected String readBuffer(BufferedReader buffer) throws IOException {
		String result;

		StringBuffer response = new StringBuffer();
		while ((result = buffer.readLine()) != null) {
			response.append(result);
		}
		buffer.close();

		return response.toString();
	}
}
