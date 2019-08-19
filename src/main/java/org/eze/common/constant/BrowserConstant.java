package org.eze.common.constant;

/*
 * Created by Ksdl
 * 2019-04-21 20:31
 */
public final class BrowserConstant {

    private BrowserConstant() {
    }

    // token参数头
    public static final String HEADER = "accessToken";
    // JWT签名加密key
    public static final String JWT_SIGN_KEY = "eze";
    // 权限参数头
    public static final String AUTHORITIES = "authorities";
    // 用户选择JWT保存时间参数头
    public static final String SAVE_LOGIN = "saveLogin";
    // 用户token前缀key 单点登录使用
    public static final String USER_TOKEN = "USER_TOKEN:";
    // 交互token前缀key
    public static final String TOKEN_PRE = "TOKEN:";
    // 登录失败存redis的key前辍
    public static final String LOGIN_FAIL_FLAG = "loginFailFlag:";
    // 登录次数存redis的key前辍
    public static final String LOGIN_TIME_LIMIT = "loginTimeLimit:";
}
