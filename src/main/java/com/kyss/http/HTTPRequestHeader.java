package com.kyss.http;

import java.util.HashMap;

/**
 * @author mathieu.
 */

public class HTTPRequestHeader extends HashMap<String, String> {
//<editor-fold desc="logger">
//</editor-fold>

//<editor-fold desc="constants">
//</editor-fold>

//<editor-fold desc="attributes">
//</editor-fold>

//<editor-fold desc="getters & setters">
//</editor-fold>

//<editor-fold desc="builders">
    public HTTPRequestHeader() {
    }
//</editor-fold>

//<editor-fold desc="public methods">
    public void add(final String key, final String value){
        super.put(key, value);
    }
//</editor-fold>

//<editor-fold desc="protected methods">
//</editor-fold>

//<editor-fold desc="package methods">
//</editor-fold>

//<editor-fold desc="private methods">
//</editor-fold>
}
