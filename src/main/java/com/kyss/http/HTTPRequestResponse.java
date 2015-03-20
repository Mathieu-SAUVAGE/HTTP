package com.kyss.http;

/**
 * @author mathieu.
 */

public class HTTPRequestResponse<T> {
//<editor-fold desc="logger">
//</editor-fold>

//<editor-fold desc="constants">
//</editor-fold>

//<editor-fold desc="attributes">
    private HTTPStatus status;
    private String message;
    private T data;
//</editor-fold>

//<editor-fold desc="getters & setters">
    public HTTPStatus getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
    //</editor-fold>

//<editor-fold desc="builders">

    public HTTPRequestResponse(final HTTPStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

//</editor-fold>

//<editor-fold desc="public methods">
//</editor-fold>

//<editor-fold desc="protected methods">
//</editor-fold>

//<editor-fold desc="package methods">
//</editor-fold>

//<editor-fold desc="private methods">
//</editor-fold>
}
