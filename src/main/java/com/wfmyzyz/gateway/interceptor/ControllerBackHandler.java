package com.wfmyzyz.gateway.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.wfmyzyz.gateway.config.ProjectConfig;
import com.wfmyzyz.gateway.enums.ProjectResEnum;
import com.wfmyzyz.gateway.user.UserFeignApi;
import com.wfmyzyz.gateway.user.vo.AuthVo;
import com.wfmyzyz.gateway.utils.Msg;
import com.wfmyzyz.gateway.utils.PassAuthUtils;
import com.wfmyzyz.gateway.utils.RequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.HttpMessageWriterResponse;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author admin
 */
@Component
public class ControllerBackHandler implements GlobalFilter,Ordered {

    @Autowired
    private UserFeignApi userFeignApi;
    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (false) {
            return chain.filter(exchange);
        }
        //在此处做拦截
        System.out.println("拦截器开启");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //根据request获取token
        String token = RequestUtils.getTokenByRequest(request);
        String url = request.getPath().toString();
        //判断访问的权限是否为需要放行的
        String msg = ProjectResEnum.LOGIN.getMsg();
        Integer code = ProjectResEnum.LOGIN.getCode();
        if (PassAuthUtils.judgePassAuth(url)){
            return chain.filter(exchange);
        }
        System.out.println(url);
        if (StringUtils.isNotBlank(token)){
            AuthVo authVo = new AuthVo(url,token);
            Msg auth = userFeignApi.auth(authVo);
            if (auth.judgeSuccess()){
                return chain.filter(exchange);
            }
            msg = auth.getMsg();
            code = auth.getCode();
        }
        JSONObject message = new JSONObject();
        message.put("code",code);
        message.put("msg",msg);
        byte[] backMessage = message.toJSONString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(backMessage);
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
