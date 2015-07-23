package com.kyss.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author mathieu.
 */

public class HTTPStatus {
//<editor-fold desc="logger">
//</editor-fold>

    //<editor-fold desc="constants">
    public static final HTTPStatus CONTINUE = new HTTPStatus(100, "Continue");
    public static final HTTPStatus SWITCHING_PROTOCOLS = new HTTPStatus(101, "Switching Protocols");
    public static final HTTPStatus PROCESSING = new HTTPStatus(102, "Processing");

    public static final HTTPStatus OK = new HTTPStatus(200, "OK");
    public static final HTTPStatus CREATED = new HTTPStatus(201, "Created");
    public static final HTTPStatus ACCEPTED = new HTTPStatus(202, "Accepted");
    public static final HTTPStatus NON_AUTHORITATIVE_INFORMATION = new HTTPStatus(203, "Non Authoritative Information");
    public static final HTTPStatus NO_CONTENT = new HTTPStatus(204, "No Content");
    public static final HTTPStatus RESET_CONTENT = new HTTPStatus(205, "Reset Content");
    public static final HTTPStatus PARTIAL_CONTENT = new HTTPStatus(206, "Partial Content");
    public static final HTTPStatus MULTI_STATUS = new HTTPStatus(207, "Multi-Status");
    public static final HTTPStatus ALREADY_REPORTED = new HTTPStatus(208, "Already Reported");
    public static final HTTPStatus IM_USED = new HTTPStatus(226, "IM Used");

    public static final HTTPStatus MUTLIPLE_CHOICES = new HTTPStatus(300, "Mutliple Choices");
    public static final HTTPStatus MOVED_PERMANENTLY = new HTTPStatus(301, "Moved Permanently");
    public static final HTTPStatus MOVED_TEMPORARILY = new HTTPStatus(302, "Moved Temporarily");
    public static final HTTPStatus SEE_OTHER = new HTTPStatus(303, "See Other");
    public static final HTTPStatus NOT_MODIFIED = new HTTPStatus(304, "Not Modified");
    public static final HTTPStatus USE_PROXY = new HTTPStatus(305, "Use Proxy");
    public static final HTTPStatus SWITCH_PROXY = new HTTPStatus(306, "Switch Proxy");
    public static final HTTPStatus TEMPORARY_REDIRECT = new HTTPStatus(307, "Temporary Redirect");
    public static final HTTPStatus PERMANENT_REDIRECT = new HTTPStatus(308, "Permanent Redirect");

    public static final HTTPStatus BAD_REQUEST = new HTTPStatus(400, "Bad Request");
    public static final HTTPStatus UNAUTHORIZED = new HTTPStatus(401, "Unauthorized");
    public static final HTTPStatus PAYMENT_REQUIRED = new HTTPStatus(402, "Payment Required");
    public static final HTTPStatus FORBIDDEN = new HTTPStatus(403, "Forbidden");
    public static final HTTPStatus NOT_FOUND = new HTTPStatus(404, "Not Found");
    public static final HTTPStatus METHOD_NOT_ALLOWED = new HTTPStatus(405, "Method Not Allowed");
    public static final HTTPStatus NOT_ACCEPTABLE = new HTTPStatus(406, "Not Acceptable");
    public static final HTTPStatus PROXY_AUTHENTICATION_REQUIRED = new HTTPStatus(407, "Proxy Authentication Required");
    public static final HTTPStatus REQUEST_TIMEOUT = new HTTPStatus(408, "Request Timeout");
    public static final HTTPStatus CONFLICT = new HTTPStatus(409, "Conflict");
    public static final HTTPStatus GONE = new HTTPStatus(410, "Gone");
    public static final HTTPStatus LENGTH_REQUIRED = new HTTPStatus(411, "Length Required");
    public static final HTTPStatus PRECONDITION_FAILED = new HTTPStatus(412, "Precondition Failed");
    public static final HTTPStatus REQUEST_ENTITY_TOO_LARGE = new HTTPStatus(413, "Request Entity Too Large");
    public static final HTTPStatus REQUEST_URI_TOO_LONG = new HTTPStatus(414, "Request-URI Too Long");
    public static final HTTPStatus UNSUPPORTED_MEDIA_TYPE = new HTTPStatus(415, "Unsupported Media Type");
    public static final HTTPStatus REQUESTED_RANGE_NOT_SATISFIABLE = new HTTPStatus(416, "Requested Range Not Satisfiable");
    public static final HTTPStatus EXPECTATION_FAILED = new HTTPStatus(417, "Expectation Failed");
    public static final HTTPStatus I_M_A_TEAPOT = new HTTPStatus(418, "I'm a teapot");
    public static final HTTPStatus AUTHENTICATION_TIMEOUT = new HTTPStatus(419, "Authentication Timeout");
    public static final HTTPStatus MISDIRECTED_REQUEST = new HTTPStatus(421, "Misdirected Request");
    public static final HTTPStatus UNPROCESSABLE_ENTITY = new HTTPStatus(422, "Unprocessable Entity");
    public static final HTTPStatus LOCKED = new HTTPStatus(423, "Locked");
    public static final HTTPStatus FAILED_DEPENDENCY = new HTTPStatus(424, "Failed Dependency");
    public static final HTTPStatus UPGRADE_REQUIRED = new HTTPStatus(426, "Upgrade Required");
    public static final HTTPStatus PRECONDITION_REQUIRED = new HTTPStatus(428, "Precondition Required");
    public static final HTTPStatus TOO_MANY_REQUESTS = new HTTPStatus(429, "Too Many Requests");
    public static final HTTPStatus REQUEST_HEADER_FIELDS_TOO_LARGE = new HTTPStatus(431, "Request Header Fields Too Large");
    public static final HTTPStatus LOGIN_TIMEOUT = new HTTPStatus(440, "Login Timeout");
    public static final HTTPStatus NO_RESPONSE = new HTTPStatus(444, "No Response");
    public static final HTTPStatus RETRY_WITH = new HTTPStatus(449, "Retry With");
    public static final HTTPStatus BLOCKED_BY_WINDOWS_PARENTAL_CONTROLS = new HTTPStatus(450, "Blocked by Windows Parental Controls");
    public static final HTTPStatus UNAVAILABLE_FOR_LEGAL_REASONS  = new HTTPStatus(451, "Unavailable For Legal Reasons");
    public static final HTTPStatus REQUEST_HEADER_TOO_LARGE  = new HTTPStatus(494, "Request Header Too Large");

    public static final HTTPStatus SERVER_ERROR = new HTTPStatus(500, "Server Error");
    public static final HTTPStatus NOT_IMPLEMENTED = new HTTPStatus(501, "Not Implemented");
    public static final HTTPStatus BAD_GATEWAY = new HTTPStatus(502, "Bad Gateway");
    public static final HTTPStatus SERVICE_UNAVAILABLE = new HTTPStatus(503, "Service Unavailable");
    public static final HTTPStatus GATEWAY_TIMEOUT = new HTTPStatus(504, "Gateway Timeout");
    public static final HTTPStatus HTTP_VERSION_NOT_SUPPORTED = new HTTPStatus(505, "HTTP Version Not Supported");
    public static final HTTPStatus VARIANT_ALSO_NEGOTIATES = new HTTPStatus(506, "Variant Also Negotiates");
    public static final HTTPStatus INSUFFICIENT_STORAGE = new HTTPStatus(507, "Insufficient Storage");
    public static final HTTPStatus LOOP_DETECTED = new HTTPStatus(508, "Loop Detected");
    public static final HTTPStatus NOT_EXTENDED = new HTTPStatus(510, "Not Extended");
    public static final HTTPStatus NETWORK_AUTHENTICATION_REQUIRED = new HTTPStatus(511, "Network Authentication Required");
    public static final HTTPStatus UNKNOWN_ERROR = new HTTPStatus(520, "Unknown Error");

    private static Map<Integer, HTTPStatus> statusMap = new HashMap<Integer, HTTPStatus>();
    static {
        statusMap.put(CONTINUE.getResponseCode(), CONTINUE);
        statusMap.put(SWITCHING_PROTOCOLS.getResponseCode(), SWITCHING_PROTOCOLS);
        statusMap.put(PROCESSING.getResponseCode(),PROCESSING);

        statusMap.put(OK.getResponseCode(),OK);
        statusMap.put(CREATED.getResponseCode(),CREATED);
        statusMap.put(ACCEPTED.getResponseCode(),ACCEPTED);
        statusMap.put(NON_AUTHORITATIVE_INFORMATION.getResponseCode(),NON_AUTHORITATIVE_INFORMATION);
        statusMap.put(NO_CONTENT.getResponseCode(),NO_CONTENT);
        statusMap.put(RESET_CONTENT.getResponseCode(),RESET_CONTENT);
        statusMap.put(PARTIAL_CONTENT.getResponseCode(),PARTIAL_CONTENT);
        statusMap.put(MULTI_STATUS.getResponseCode(),MULTI_STATUS);
        statusMap.put(ALREADY_REPORTED.getResponseCode(),ALREADY_REPORTED);
        statusMap.put(IM_USED.getResponseCode(),IM_USED);

        statusMap.put(MUTLIPLE_CHOICES.getResponseCode(),MUTLIPLE_CHOICES);
        statusMap.put(MOVED_PERMANENTLY.getResponseCode(),MOVED_PERMANENTLY);
        statusMap.put(MOVED_TEMPORARILY.getResponseCode(),MOVED_TEMPORARILY);
        statusMap.put(SEE_OTHER.getResponseCode(),SEE_OTHER);
        statusMap.put(NOT_MODIFIED.getResponseCode(),NOT_MODIFIED);
        statusMap.put(USE_PROXY.getResponseCode(),USE_PROXY);
        statusMap.put(SWITCH_PROXY.getResponseCode(),SWITCH_PROXY);
        statusMap.put(TEMPORARY_REDIRECT.getResponseCode(),TEMPORARY_REDIRECT);
        statusMap.put(PERMANENT_REDIRECT.getResponseCode(),PERMANENT_REDIRECT);

        statusMap.put(BAD_REQUEST.getResponseCode(),BAD_REQUEST);
        statusMap.put(UNAUTHORIZED.getResponseCode(),UNAUTHORIZED);
        statusMap.put(PAYMENT_REQUIRED.getResponseCode(),PAYMENT_REQUIRED);
        statusMap.put(FORBIDDEN.getResponseCode(),FORBIDDEN);
        statusMap.put(NOT_FOUND.getResponseCode(),NOT_FOUND);
        statusMap.put(METHOD_NOT_ALLOWED.getResponseCode(),METHOD_NOT_ALLOWED);
        statusMap.put(NOT_ACCEPTABLE.getResponseCode(),NOT_ACCEPTABLE);
        statusMap.put(PROXY_AUTHENTICATION_REQUIRED.getResponseCode(),PROXY_AUTHENTICATION_REQUIRED);
        statusMap.put(REQUEST_TIMEOUT.getResponseCode(),REQUEST_TIMEOUT);
        statusMap.put(CONFLICT.getResponseCode(),CONFLICT);
        statusMap.put(GONE.getResponseCode(),GONE);
        statusMap.put(LENGTH_REQUIRED.getResponseCode(),LENGTH_REQUIRED);
        statusMap.put(PRECONDITION_FAILED.getResponseCode(),PRECONDITION_FAILED);
        statusMap.put(REQUEST_ENTITY_TOO_LARGE.getResponseCode(),REQUEST_ENTITY_TOO_LARGE);
        statusMap.put(REQUEST_URI_TOO_LONG.getResponseCode(),REQUEST_URI_TOO_LONG);
        statusMap.put(UNSUPPORTED_MEDIA_TYPE.getResponseCode(),UNSUPPORTED_MEDIA_TYPE);
        statusMap.put(REQUESTED_RANGE_NOT_SATISFIABLE.getResponseCode(),REQUESTED_RANGE_NOT_SATISFIABLE);
        statusMap.put(EXPECTATION_FAILED.getResponseCode(),EXPECTATION_FAILED);
        statusMap.put(I_M_A_TEAPOT.getResponseCode(),I_M_A_TEAPOT);
        statusMap.put(AUTHENTICATION_TIMEOUT.getResponseCode(),AUTHENTICATION_TIMEOUT);
        statusMap.put(MISDIRECTED_REQUEST.getResponseCode(),MISDIRECTED_REQUEST);
        statusMap.put(UNPROCESSABLE_ENTITY.getResponseCode(),UNPROCESSABLE_ENTITY);
        statusMap.put(LOCKED.getResponseCode(),LOCKED);
        statusMap.put(FAILED_DEPENDENCY.getResponseCode(),FAILED_DEPENDENCY);
        statusMap.put(UPGRADE_REQUIRED.getResponseCode(),UPGRADE_REQUIRED);
        statusMap.put(PRECONDITION_REQUIRED.getResponseCode(),PRECONDITION_REQUIRED);
        statusMap.put(TOO_MANY_REQUESTS.getResponseCode(),TOO_MANY_REQUESTS);
        statusMap.put(REQUEST_HEADER_FIELDS_TOO_LARGE.getResponseCode(),REQUEST_HEADER_FIELDS_TOO_LARGE);
        statusMap.put(LOGIN_TIMEOUT.getResponseCode(),LOGIN_TIMEOUT);
        statusMap.put(NO_RESPONSE.getResponseCode(),NO_RESPONSE);
        statusMap.put(RETRY_WITH.getResponseCode(),RETRY_WITH);
        statusMap.put(BLOCKED_BY_WINDOWS_PARENTAL_CONTROLS.getResponseCode(),BLOCKED_BY_WINDOWS_PARENTAL_CONTROLS);
        statusMap.put(UNAVAILABLE_FOR_LEGAL_REASONS.getResponseCode(),UNAVAILABLE_FOR_LEGAL_REASONS);
        statusMap.put(REQUEST_HEADER_TOO_LARGE.getResponseCode(),REQUEST_HEADER_TOO_LARGE);

        statusMap.put(SERVER_ERROR.getResponseCode(),SERVER_ERROR);
        statusMap.put(NOT_IMPLEMENTED.getResponseCode(),NOT_IMPLEMENTED);
        statusMap.put(BAD_GATEWAY.getResponseCode(),BAD_GATEWAY);
        statusMap.put(SERVICE_UNAVAILABLE.getResponseCode(),SERVICE_UNAVAILABLE);
        statusMap.put(GATEWAY_TIMEOUT.getResponseCode(),GATEWAY_TIMEOUT);
        statusMap.put(HTTP_VERSION_NOT_SUPPORTED.getResponseCode(),HTTP_VERSION_NOT_SUPPORTED);
        statusMap.put(VARIANT_ALSO_NEGOTIATES.getResponseCode(),VARIANT_ALSO_NEGOTIATES);
        statusMap.put(INSUFFICIENT_STORAGE.getResponseCode(),INSUFFICIENT_STORAGE);
        statusMap.put(LOOP_DETECTED.getResponseCode(),LOOP_DETECTED);
        statusMap.put(NOT_EXTENDED.getResponseCode(),NOT_EXTENDED);
        statusMap.put(NETWORK_AUTHENTICATION_REQUIRED.getResponseCode(),NETWORK_AUTHENTICATION_REQUIRED);
        statusMap.put(UNKNOWN_ERROR.getResponseCode(),UNKNOWN_ERROR);
    }

    //</editor-fold>

    //<editor-fold desc="attributes">
    private int responseCode;
    private String message;
//</editor-fold>

    //<editor-fold desc="getters & setters">
    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }
    //</editor-fold>

    //<editor-fold desc="builders">

    public HTTPStatus() {
    }

    private HTTPStatus(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }
    //</editor-fold>

    //<editor-fold desc="public methods">
    public static HTTPStatus getHHTPStatus(int responseCode) throws HTTPStatusNotManageException {
        if(!statusMap.containsKey(responseCode)){
            throw new HTTPStatusNotManageException(responseCode);
        }
        return statusMap.get(responseCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HTTPStatus)) return false;
        HTTPStatus that = (HTTPStatus) o;
        return Objects.equals(responseCode, that.responseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseCode);
    }

    //</editor-fold>

//<editor-fold desc="protected methods">
//</editor-fold>

//<editor-fold desc="package methods">
//</editor-fold>

//<editor-fold desc="private methods">
//</editor-fold>
}
