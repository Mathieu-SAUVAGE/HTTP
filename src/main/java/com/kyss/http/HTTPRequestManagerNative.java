package com.kyss.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
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
		GET, POST, PUT, HEAD, OPTIONS, DELETE, TRACE
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
	public static URL getURL(final Charset charset,
							 final String urlPath) throws MalformedURLException, UnsupportedEncodingException {
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
	public static URL getURL(final Charset charset,
							 final String urlPath,
							 final Map<String, String> parameters)
			throws MalformedURLException, UnsupportedEncodingException {
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

	//<editor-fold desc="Get methods">
	public HttpURLConnection get(final URL url) throws IOException {
		return get(url,
				   new HTTPRequestHeader(),
				   false);
	}

	public HttpURLConnection get(final URL url,
								 final boolean useCache) throws IOException {
		return get(url,
				   new HTTPRequestHeader(),
				   useCache);
	}

	public HttpURLConnection get(final URL url,
								 final HTTPRequestHeader headers,
								 final boolean useCache) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setUseCaches(useCache);
		connection.setDoOutput(false);
		connection.setDoInput(true);
		connection.setRequestMethod(RequestType.GET.toString());

		for (Map.Entry<String, String> currentEntry : headers.entrySet()) {
			connection.addRequestProperty(currentEntry.getKey(),
										  currentEntry.getValue());
		}

		return connection;
	}

	public <R> HTTPRequestResponse<R> get(final URL url,
										  final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(get(url,
									new HTTPRequestHeader(),
									false));
	}

	public <R> HTTPRequestResponse<R> get(final URL url,
										  final boolean useCache,
										  final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(get(url,
									new HTTPRequestHeader(),
									useCache));
	}

	public <R> HTTPRequestResponse<R> get(final URL url,
										  final boolean useCache,
										  final HTTPRequestHeader headers,
										  final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(get(url,
									headers,
									useCache));
	}

	//</editor-fold>
	//<editor-fold desc="Put methods">
	public HttpURLConnection put(final URL url,
								 final String body) throws IOException {
		return put(url,
				   new HTTPRequestHeader(),
				   body,
				   false);
	}

	public HttpURLConnection put(final URL url,
								 final HTTPRequestHeader headers,
								 final String body) throws IOException {
		return put(url,
				   headers,
				   body,
				   false);
	}

	public HttpURLConnection put(final URL url,
								 final HTTPRequestHeader headers,
								 final String body,
								 final boolean useCache) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setUseCaches(useCache);
		connection.setRequestMethod(RequestType.PUT.toString());
		connection.setDoInput(true);
		connection.setDoOutput(true);

		for (Map.Entry<String, String> currentEntry : headers.entrySet()) {
			connection.addRequestProperty(currentEntry.getKey(),
										  currentEntry.getValue());
		}

		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		return connection;
	}

	public <R> HTTPRequestResponse<R> put(final URL url,
										  final String body,
										  final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(post(url,
									 body));
	}

	public <R> HTTPRequestResponse<R> put(final URL url,
										  final HTTPRequestHeader headers,
										  final String body,
										  final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(put(url,
									headers,
									body));
	}

	public <R> HTTPRequestResponse<R> put(final URL url,
										  final HTTPRequestHeader headers,
										  final String body,
										  final boolean useCache,
										  final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(put(url,
									new HTTPRequestHeader(),
									body,
									useCache));
	}

	//</editor-fold>
	//<editor-fold desc="Post methods">
	public HttpURLConnection post(final URL url,
								  final String body) throws IOException {
		return post(url,
					new HTTPRequestHeader(),
					body,
					false);
	}

	public HttpURLConnection post(final URL url,
								  final HTTPRequestHeader headers,
								  final String body) throws IOException {
		return post(url,
					headers,
					body,
					false);
	}

	public HttpURLConnection post(final URL url,
								  final HTTPRequestHeader headers,
								  final String body,
								  final boolean useCache) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setUseCaches(useCache);
		connection.setRequestMethod(RequestType.POST.toString());
		connection.setDoInput(true);
		connection.setDoOutput(true);

		for (Map.Entry<String, String> currentEntry : headers.entrySet()) {
			connection.addRequestProperty(currentEntry.getKey(),
										  currentEntry.getValue());
		}

		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		return connection;
	}

	public <R> HTTPRequestResponse<R> post(final URL url,
										   final String body,
										   final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(post(url,
									 body));
	}

	public <R> HTTPRequestResponse<R> post(final URL url,
										   final HTTPRequestHeader headers,
										   final String body,
										   final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(post(url,
									 headers,
									 body));
	}

	public <R> HTTPRequestResponse<R> post(final URL url,
										   final HTTPRequestHeader headers,
										   final String body,
										   final boolean useCache,
										   final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(post(url,
									 new HTTPRequestHeader(),
									 body,
									 useCache));
	}

	//</editor-fold>
	//<editor-fold desc="Delete methods">
	public HttpURLConnection delete(final URL url) throws IOException {
		return delete(url,
					  new HTTPRequestHeader(),
					  false);
	}

	public HttpURLConnection delete(final URL url,
									final HTTPRequestHeader headers) throws IOException {
		return delete(url,
					  headers,
					  false);
	}

	public HttpURLConnection delete(final URL url,
									final HTTPRequestHeader headers,
									final boolean useCache) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setUseCaches(useCache);
		connection.setRequestMethod(RequestType.DELETE.toString());
		connection.setDoInput(true);
		connection.setDoOutput(true);

		for (Map.Entry<String, String> currentEntry : headers.entrySet()) {
			connection.addRequestProperty(currentEntry.getKey(),
										  currentEntry.getValue());
		}

		return connection;
	}

	public <R> HTTPRequestResponse<R> delte(final URL url,
											final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(delete(url));
	}

	public <R> HTTPRequestResponse<R> delete(final URL url,
											 final HTTPRequestHeader headers,
											 final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(delete(url,
									   headers));
	}

	public <R> HTTPRequestResponse<R> delete(final URL url,
											 final HTTPRequestHeader headers,
											 final boolean useCache,
											 final HTTPRequestHandlerNative<R> consumer) throws Exception {
		return consumer.consume(delete(url,
									   new HTTPRequestHeader(),
									   useCache));
	}

	//</editor-fold>
//</editor-fold>

//<editor-fold desc="protected methods">
//</editor-fold>

//<editor-fold desc="package methods">
//</editor-fold>

//<editor-fold desc="private methods">
//</editor-fold>
}
