package com.valarchie.quickboot.core.common.auth.qq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
class AccessToken  implements Serializable {

    private static final long serialVersionUID = 6986530164134648944L;
    private String accessToken;
    private String expireIn;
    private String refreshToken;
    private String uid;


   /* AccessToken(String res,String typeid) throws Exception,JSONException{
        super();
        JSONObject json = JSON.parseObject(res);
        accessToken = json.getString("access_token");
        expireIn = json.getString("expires_in");
        try {
            refreshToken = json.getString("refresh_token");
            uid = json.getString(typeid);
        } catch (Exception e) {
            refreshToken = null;
            uid = null;
        }
    }*/



}
