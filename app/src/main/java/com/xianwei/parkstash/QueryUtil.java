package com.xianwei.parkstash;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xianwei li on 11/20/2017.
 */

public class QueryUtil {

    public static String getJsonString(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response responses = null;
        String jsonData = null;
        try {
            responses = client.newCall(request).execute();
            jsonData = responses.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("12345jsonData", String.valueOf(jsonData == null));
        return jsonData;
    }

    public static String ParseJson(String jsonString) {
        JSONObject jsonObject = null;
        String result = null;
        try {
            jsonObject = new JSONObject(jsonString);
            result = jsonObject.getString("notes");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("12345jsonData", result);
        return result;
    }
}
