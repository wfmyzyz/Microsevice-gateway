package com.wfmyzyz.gateway.config;

/**
 * @author admin
 */
public class ProjectConfig {
    /**
     * 前端的
     */
    public final static String TOKEN_KEY = "token";

    /**
     * response
     */
    public static final String RESPONSE_DATA = "data";

    /**
     * 不检查的地址
     */
    public static final String[] PASS_PATH_ARR = {
            "/user/api/login/getRsaPublicKey",
            "/user/api/login"
    };
}
