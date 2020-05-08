package com.wfmyzyz.gateway.utils;

import com.wfmyzyz.gateway.config.ProjectConfig;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author admin
 */
public class RequestUtils {

    public static String getTokenByRequest(ServerHttpRequest request){
        HttpHeaders headers = request.getHeaders();
        Iterator<Map.Entry<String, List<String>>> iterator = headers.entrySet().iterator();
        String token = null;
        //必须要保证token为一个
        while (iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            if (Objects.equals(next.getKey(), ProjectConfig.TOKEN_KEY)){
                token = next.getValue().get(0);
                break;
            }
        }
        return token;
    }
}
