package com.kyss.http;

/**
 * @author mathieu.
 */

public class HTTPStatusNotManageException extends Exception{
//<editor-fold desc="logger">
//</editor-fold>

//<editor-fold desc="constants">
//</editor-fold>

//<editor-fold desc="attributes">
//</editor-fold>

//<editor-fold desc="getters & setters">
//</editor-fold>

//<editor-fold desc="builders">

    public HTTPStatusNotManageException(int responseCode) {
        super(String.format("The response code : %d is not manage", responseCode));
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
