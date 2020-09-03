package com.valarchie.quickboot.core.common.auth.qq;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * qq第三方登录
 * 第一步：授权，获取code
 * 第二步：通过code,获取accessToken
 * 第三步：通过accessToken,获取openid
 * 第四步:通过accessToken、openid获取用户信息
 */
@Component
@ConfigurationProperties("qq.open")
@Data
public class QQService {

    private String appId;
    private String appKey;

    private final static String REDIRECT_URL = "my-website.com";
    private final static String SCOPE = "get_user_info";
    private final static String GET_USER_INFO_URL = "https://openmobile.qq.com/user/get_simple_userinfo";
    private final static String GET_AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize";
    private final static String GET_ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";
    private final static String GET_OPEN_ID_URL = "https://graph.qq.com/oauth2.0/me";


    /**
     * 进行授权认证
     *
     * @return
     */
    public String authorize() {

        // 组装get请求参数参数
        Map<String, Object> paramsMap = new HashMap<>();
        // 固定参数
        paramsMap.put("response_type", "code");

        String state = RandomUtil.randomNumbers(10);
        paramsMap.put("state", state);

        paramsMap.put("client_id", appId);
        paramsMap.put("redirect_uri", REDIRECT_URL);

        paramsMap.put("scope", SCOPE);

        return HttpUtil.get(GET_AUTHORIZE_URL, paramsMap);

    }


    /**
     * 通过authorization code获取用户信息
     * @param authorizationCode
     * @return
     * @throws Exception
     */
    public UserInfo getUserInfoByAuthorizationCode(String authorizationCode) {

        AccessToken accessToken = getAccessToken(authorizationCode);

        if (StrUtil.isBlank(accessToken.getAccessToken())) {
            throw new RuntimeException("access token is empty, authorization is fail !");
        }

        // 利用获取到的accessToken 去获取当前用的openid
        String openId = getOpenId(accessToken.getAccessToken());

        //获取用户信息
        return getUserInfo(openId, accessToken.getAccessToken());

    }


    /**
     * 获取用户json数据
     * @param openid openId
     * @param accessToken 通过code获取的accessToken
     * @return 用户信息
     */
    public UserInfo getUserInfo(String openid, String accessToken) {

        if (StrUtil.isEmpty(openid)) {
            throw new RuntimeException("openid is null or empty!");
        }

        Map<String, Object> paramsMap = new HashMap<>(8);

        System.out.println(appId);

        paramsMap.put("openid", openid);
        paramsMap.put("oauth_consumer_key", appId);
        paramsMap.put("access_token", accessToken);
        paramsMap.put("format", "json");

        String responseJson = HttpUtil.get(GET_USER_INFO_URL, paramsMap);

        UserInfo userInfo = JSONUtil.toBean(responseJson, UserInfo.class);

        if (StrUtil.isNotBlank(userInfo.getMsg())) {
            throw new RuntimeException("获取用户信息失败！"+ userInfo.getMsg());
        }

        return userInfo;

    }



    /**
     * 获取accessToken
     * @param authorizationCode 授权码
     * @return
     */
    public AccessToken getAccessToken(String authorizationCode) {

        // 组装请求参数
        Map<String, Object> paramsMap = new HashMap<>(8);

        paramsMap.put("client_id", appId);
        paramsMap.put("client_secret", appKey);
        paramsMap.put("grant_type", "authorization_code");
        paramsMap.put("code", authorizationCode);
        paramsMap.put("redirect_url", REDIRECT_URL);

        String responseJson = HttpUtil.get(GET_ACCESS_TOKEN_URL, paramsMap);

        return JSONUtil.toBean(responseJson, AccessToken.class);

    }


    /**
     * 获取openId
     * @param accessToken
     * @return
     */
    public String getOpenId(String accessToken) {

        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("access_token", accessToken);

        String responseJson = HttpUtil.get(GET_OPEN_ID_URL, paramsMap);

        cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(responseJson);

        if (jsonObject.containsKey("openid")) {
            return (String) jsonObject.get("openid");
        }

        return null;

    }

}








