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
    private int returnCode;
    private T data;
//</editor-fold>

//<editor-fold desc="getters & setters">
    public int getReturnCode() {
        return returnCode;
    }

    public T getData() {
        return data;
    }
    //</editor-fold>

//<editor-fold desc="builders">

    public HTTPRequestResponse(int returnCode, T data) {
        this.returnCode = returnCode;
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
