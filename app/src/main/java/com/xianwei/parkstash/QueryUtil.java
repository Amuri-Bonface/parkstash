package com.xianwei.parkstash;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Pair<String, String>> ParseJson(String jsonString) {
        if (TextUtils.isEmpty(jsonString)) return null;
        List<Pair<String, String>> result = new ArrayList<>();
        Pair<String, String> location;

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject locationJsonObject = jsonArray.getJSONObject(i);
                String latitude = locationJsonObject.getString("latitude");
                String longitude = locationJsonObject.getString("longitude");
                location = new Pair<>(latitude, longitude);
                result.add(location);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
