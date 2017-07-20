package com.example.hojan.flytofit;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hojan on 2017-07-20.
 */

public class RegsiterRequest extends StringRequest {

    final static private String URL = "http://jisung0920.cafe24.com/Regsiter.php";
    private Map<String, String> parameters;

    public RegsiterRequest(String userID, String userPassword, String userName, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }

}
