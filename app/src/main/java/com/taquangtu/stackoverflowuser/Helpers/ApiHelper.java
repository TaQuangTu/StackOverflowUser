package com.taquangtu.stackoverflowuser.Helpers;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.taquangtu.stackoverflowuser.StackOverFlowApplication;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiHelper {
    private static ApiHelper instance = new ApiHelper();
    public static ApiHelper getInstance(){
        return instance;
    }
    private String mBaseUrl;
    private RequestQueue mRequestQueue;
    private ApiHelper(){
        mRequestQueue  = Volley.newRequestQueue(StackOverFlowApplication.getAppContext());
        mBaseUrl = "https://api.stackexchange.com/2.2/users?";
    }
    public interface FetchDataListener{
        void fetchDataDidStart();
        void fetchDataDidEnd(boolean isSuccess, Object data, String message);
    }
    public void fetchOthers(HashMap<String,String> params, int method, final FetchDataListener listener){
        listener.fetchDataDidStart();
        String paramsString = paramsStringFromMap(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, mBaseUrl+paramsString, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        listener.fetchDataDidEnd(true,response,"Fetched successfully");
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String errorMessage = error.getLocalizedMessage();
                        if(errorMessage.equals("")){
                            errorMessage = "Fetching failed";
                        }
                        listener.fetchDataDidEnd(false,null,errorMessage);
                    }
                });
        mRequestQueue.add(jsonObjectRequest);
    }
    public void fetchUserList(FetchDataListener listener,int pageSize){
        //page=1&pagesize=30&site=stackoverflow
        int method = Request.Method.GET;
        HashMap<String,String> params = new HashMap<>();
        params.put("page","1");
        params.put("pagesize",pageSize+"");
        params.put("site","stackoverflow");
        fetchOthers(params,method,listener);
    }
    public void fetchUserDetails(FetchDataListener listener,String userId){
        //TODO: I have not done this function cause I don't have time enough
        listener.fetchDataDidStart();
        listener.fetchDataDidEnd(false,null,"not done");
//        //page=1&pagesize=30&site=stackoverflow
//        int method = Request.Method.GET;
//        HashMap<String,String> params = new HashMap<>();
//        params.put("page","1");
//        params.put("pagesize",pageSize+"");
//        params.put("site","stackoverflow");
//        fetchOthers(params,method,listener);
    }

    private String paramsStringFromMap(HashMap<String,String> params){
        StringBuilder paramsBuilder = new StringBuilder();
        for(Map.Entry<String,String> pair: params.entrySet()){
            paramsBuilder.append(pair.getKey()).append("=").append(pair.getValue()).append("&");
        }
        return paramsBuilder.toString().substring(0,paramsBuilder.length());
    }
}
