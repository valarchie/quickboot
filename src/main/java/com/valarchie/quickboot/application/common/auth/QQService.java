package com.valarchie.quickboot.application.common.auth;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.valarchie.quickboot.infrastructure.entity.User;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.apache.http.impl.client.HttpClients;

/**
 * qq第三方登录
 * 第一步：授权，获取code
 * 第二步：通过code,获取accessToken
 * 第三步：通过accessToken,获取openid
 * 第四步:通过accessToken、openid获取用户信息
 * @author GunnyZeng
 *
 */
public class QQService {

    private String app_ID =    Config.getValue("qq_app_ID").trim();
    private String app_KEY =    Config.getValue("qq_app_KEY").trim();
    private String redirect_URI = Config.getValue("qq_redirect_URI").trim();
    private String scope = Config.getValue("qq_scope").trim();
    private String getUserInfoURL = Config.getValue("qq_getUserInfoURL").trim();
    private String authorizeURL = Config.getValue("qq_authorizeURL").trim();
    private String accessTokenURL = Config.getValue("qq_accessTokenURL").trim();
    private String getOpenIDURL = Config.getValue("qq_getOpenIDURL").trim();
    HttpClients client  = new HttpClients();

    public String authorize() {
        String state = RandomUtil.randomNumbers(10);
        if (scope != null && !scope.equals("")) {
            return (new StringBuilder()).append(authorizeURL).append("?client_id=").append(app_ID).append(
                    "&redirect_uri=").append(redirect_URI).append("&response_type=").append("code").append("&state=").append(state).append("&scope=").append(scope).toString();
        } else {
            return (new StringBuilder()).append(authorizeURL).append("?client_id=").append(app_ID).append(
                    "&redirect_uri=").append(redirect_URI).append("&response_type=").append("code").append("&state=").append(state).toString();
        }
    }

    public User getUser(Object parame) throws Exception {
        String code = (String) parame;
        AccessToken accessTokenObj = getAccessToken(code);

        User user =  new User();
        if (accessTokenObj.getAccessToken().equals("")) {
            throw new Exception("授权失败！");
        } else {

            // 利用获取到的accessToken 去获取当前用的openid -------- start
            String openID = getOpenID(accessTokenObj);
            //获取用户信息
            JSONObject json = showUser(openID,accessTokenObj);

            if (json!=null&&json.keys().hasNext()) {
                user.setId(openID);
                user.setAvatarLarge(json.getString("figureurl"));
                user.setNickName(json.getString("nickname"));
                user.setGender(json.getString("gender"));
                user.setSource("QQ");
            } else {
                throw new Exception("很抱歉，我们没能正确获取到您的信息! ");
            }
        }
        return user;
    }

    /**
     * 获取AccessToken
     * @param code
     * @return
     * @throws Exception
     */
    private AccessToken getAccessToken(String code) throws Exception{

        // TODO 用Hutool改写

//        return new AccessToken(client.post(
//                accessTokenURL,
//                new PostParameter[] {
//                        new PostParameter("client_id", app_ID),
//                        new PostParameter("client_secret",app_KEY),
//                        new PostParameter("grant_type", "authorization_code"),
//                        new PostParameter("code", code),
//                        new PostParameter("redirect_uri", redirect_URI) }, false, null),"openid");

        return null;
    }
    /**
     * 授权后获取用户json数据
     * @param accessToken
     * @return
     * @throws Exception
     */
    private JSONObject showUser(String openid,AccessToken accessToken) throws Exception
    {
//        return client.get(getUserInfoURL, new PostParameter[] {
//                new PostParameter("openid", openid),
//                new PostParameter("oauth_consumer_key", app_ID),
//                new PostParameter("access_token", accessToken.getAccessToken()),
//                new PostParameter("format", "json")
//        },accessToken.getAccessToken()).asJSONObject();

        // TODO 改写

        return null;
    }
    /**
     * 获取openID
     * @param accessToken
     * @return
     * @throws Exception
     */
    private String getOpenID(AccessToken accessToken) throws Exception{
        String openid = "";

        // TODO 改写

//        String jsonp = client.get(getOpenIDURL,
//                new PostParameter[] {
//                        new PostParameter("access_token", accessToken.getAccessToken())
//                },accessToken.getAccessToken()).asString();
//        Matcher m = Pattern.compile("\"openid\"\\s*:\\s*\"(\\w+)\"").matcher(jsonp);
//        if(m.find())
//            openid = m.group(1);
//        else
//            throw new Exception("server error!");
        return openid;
    }

}
