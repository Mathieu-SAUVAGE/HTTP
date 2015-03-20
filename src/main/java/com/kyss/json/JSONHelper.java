package com.kyss.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * Created by mathieu on 2/23/15.
 */
public class JSONHelper {
    //<editor-fold desc="get">
    public static <T> T get(JSONObject input, String key){
        T result = (T)input.get(key);
        return result;
    }

    public static <T> T get(JSONObject input,String key, T defaultValue){
        if(!input.has(key)){
            return defaultValue;
        }

        return get(input,key);
    }
    //</editor-fold>

    //<editor-fold desc="extract">
    public static <T> T extract(JSONObject input, String key){
        T result = (T)input.get(key);
        input.remove(key);
        return result;
    }

    public static <T> T extract(JSONObject input,String key, T defaultValue){
        if(!input.has(key)){
            return defaultValue;
        }

        return extract(input,key);
    }
    //</editor-fold>

    //<editor-fold desc="JSONArray">
    public static <T> T get(JSONArray input, int index){
        T result = (T)input.get(index);
        return result;
    }

    public static <T> T extract(JSONArray input, int index){
        T result = (T)input.get(index);
        input.remove(index);
        return result;
    }
    //</editor-fold>

    public static Map<String, Object> convert(JSONObject input){
        Map<String, Object> result = new HashMap<String, Object>();

        Iterator<String> iterator = input.keys();
        while(iterator.hasNext()) {
            String key = iterator.next();
            Object value = input.get(key);

            if(value instanceof Integer) {
                result.put(key, input.getInt(key));
            }
            else if(value instanceof Long) {
                result.put(key, input.getLong(key));
            }
            else if(value instanceof Double) {
                result.put(key, input.getDouble(key));
            }
            else if(value instanceof String) {
                result.put(key, input.getString(key));
            }
            else if(value instanceof Boolean) {
                result.put(key, input.getBoolean(key));
            }
            else if(value instanceof JSONArray) {
                result.put(key, convert(input.getJSONArray(key)));
            }
            else if(value instanceof JSONObject) {
                result.put(key, convert(input.getJSONObject(key)));
            }
        }

        return result;
    }

    public static List<Object> convert(JSONArray input) throws JSONException {
        List<Object> result = new ArrayList<Object>();

        for(int index = 0; index < input.length(); index++) {
            Object value = input.get(index);

            if(value instanceof Integer) {
                result.add(input.getInt(index));
            }
            else if(value instanceof Long) {
                result.add(input.getLong(index));
            }
            else if(value instanceof Double) {
                result.add(input.getLong(index));
            }
            else if(value instanceof String) {
                result.add(input.getString(index));
            }
            else if(value instanceof Boolean) {
                result.add(input.getBoolean(index));
            }
            else if(value instanceof JSONArray) {
                result.add(convert(input.getJSONArray(index)));
            }
            else if(value instanceof JSONObject) {
                result.add(convert(input.getJSONObject(index)));
            }
        }

        return result;
    }
}
