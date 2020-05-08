package com.wfmyzyz.gateway.user;

import com.wfmyzyz.gateway.config.FeignConfig;
import com.wfmyzyz.gateway.user.impl.UserFeignApiImpl;
import com.wfmyzyz.gateway.user.vo.AuthVo;
import com.wfmyzyz.gateway.utils.Msg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author admin
 */
@FeignClient(name = "${project.user.name}", fallbackFactory = UserFeignApiImpl.class)
public interface UserFeignApi {


    @PostMapping(value = "/user/api/authority/auth")
    /**
     * 验权限
     * @param authVo
     * @return
     */
    Msg auth(@RequestBody AuthVo authVo);
}
