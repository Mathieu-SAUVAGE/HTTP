package com.json;

import com.kyss.json.JSONHelper;
import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class APXPressItemTest {

    @Test
    public void testUpdate() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("publicPressItem.json").getFile());
        JSONObject itemJson = new JSONObject(new JSONTokener(new FileReader(file)));

        Map<String, Object> result = JSONHelper.convert(itemJson);
        assertEquals(itemJson.length(), result.size());
    }
}