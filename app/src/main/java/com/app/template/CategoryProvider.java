package com.app.template;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.app.template.utils.CommonUtils;
import com.app.template.volleyutils.JsonRequestVolley;
import com.app.template.volleyutils.VolleyRequestManager;

import org.json.JSONObject;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 *
 * This class is just a sample data provider class. Rename this class based on actual data.
 *
 */
public class CategoryProvider {

    private static CategoryProvider mInstance;
    private Context mContext;

    public static CategoryProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CategoryProvider(context);
        }
        return mInstance;
    }

    private CategoryProvider(Context context) {
        if (mContext == null) {
            mContext = context;
        }
    }

    public void addCategoryListRequest() {
        VolleyRequestManager.getInstance(mContext).getRequestQueue().add(getJsonRequest());
    }

    private JsonRequestVolley getJsonRequest() {
        JsonRequestVolley request = new JsonRequestVolley(
                Request.Method.GET,
                Constants.BASE_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                CommonUtils.showToast(mContext, "Success", Toast.LENGTH_SHORT);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CommonUtils.showToast(mContext, "Error", Toast.LENGTH_SHORT);
            }
        });

        return request;
    }

}
