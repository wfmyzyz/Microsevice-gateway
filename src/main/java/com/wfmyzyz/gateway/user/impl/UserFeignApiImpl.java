package com.wfmyzyz.gateway.user.impl;

import com.wfmyzyz.gateway.enums.ProjectResEnum;
import com.wfmyzyz.gateway.user.UserFeignApi;
import com.wfmyzyz.gateway.user.vo.AuthVo;
import com.wfmyzyz.gateway.utils.Msg;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
@Slf4j
public class UserFeignApiImpl implements FallbackFactory<UserFeignApi> {

    @Override
    public UserFeignApi create(Throwable throwable) {
        return new UserFeignApi() {
            @Override
            public Msg auth(AuthVo authVo) {
                log.error("权限验证地址:["+authVo.getUrl()+"]-token:["+authVo.getToken()+"]，调用异常");
                return Msg.error(ProjectResEnum.API_ERROR);
            }
        };
    }
}
