package com.wfmyzyz.gateway.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
public class AuthVo {
    private String url;
    private String token;
}
