package com.wfmyzyz.gateway.utils;

import com.wfmyzyz.gateway.config.ProjectConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * @author admin
 */
public class PassAuthUtils {

    /**
     * 判断路径是否放行
     * @param url
     * @return
     */
    public static boolean judgePassAuth(String url){
        for (String path: ProjectConfig.PASS_PATH_ARR){
            String[] split = path.split("/");
            for (int i=0;i<split.length;i++){
                if (i==0){
                    continue;
                }
                if (split[i].indexOf("**") > -1){
                    split[i] = split[i].replace("**",".*");
                    continue;
                }
                if (split[i].indexOf("*") > -1){
                    split[i] = split[i].replace("*","[^/]*");
                }
            }
            String regPath = StringUtils.join(split, "/");
            if (url.matches(regPath)){
                return true;
            }
        }
        return false;
    }
}
