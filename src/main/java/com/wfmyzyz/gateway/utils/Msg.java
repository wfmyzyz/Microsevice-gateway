package com.wfmyzyz.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import com.wfmyzyz.gateway.config.ProjectConfig;
import com.wfmyzyz.gateway.enums.ProjectResEnum;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int code;
    private String msg;
    private Map<String,Object> data = new HashMap<>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static Msg success(){
        return success(ProjectResEnum.SUCCESS.getMsg());
    }


    public static Msg success(String message){
        Msg msg = new Msg();
        msg.setCode(ProjectResEnum.SUCCESS.getCode());
        msg.setMsg(message);
        return msg;
    }

    public static Msg success(ProjectResEnum projectResEnum){
        Msg msg = new Msg();
        msg.setCode(projectResEnum.getCode());
        msg.setMsg(projectResEnum.getMsg());
        return msg;
    }

    public static Msg error(){
        return error(ProjectResEnum.FAIL.getMsg());
    }

    public static Msg error(String message){
        Msg msg = new Msg();
        msg.setCode(ProjectResEnum.FAIL.getCode());
        msg.setMsg(message);
        return msg;
    }

    public static Msg error(ProjectResEnum projectResEnum){
        Msg msg = new Msg();
        msg.setCode(projectResEnum.getCode());
        msg.setMsg(projectResEnum.getMsg());
        return msg;
    }

    public Msg add(String key,Object value){
        data.put(key,value);
        return this;
    }

    public Msg add(Object value){
        data.put(ProjectConfig.RESPONSE_DATA,value);
        return this;
    }

    public static Msg needLogin(){
        Msg msg = new Msg();
        msg.setCode(ProjectResEnum.LOGIN.getCode());
        msg.setMsg(ProjectResEnum.LOGIN.getMsg());
        return msg;
    }

    public static Msg noPower(){
        Msg msg = new Msg();
        msg.setCode(ProjectResEnum.NONE_AUTHORITY.getCode());
        msg.setMsg(ProjectResEnum.NONE_AUTHORITY.getMsg());
        return msg;
    }

    public static Msg resultError(BindingResult result){
        Msg msg = Msg.error();
        for (FieldError error:result.getFieldErrors()){
        msg.add(error.getField(),error.getDefaultMessage());
        }
        return msg;
    }

    /**
     * 判断是否成功
     * @return
     */
    public boolean judgeSuccess(){
        if (this.code == ProjectResEnum.SUCCESS.getCode()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Msg{" +
        "code=" + code +
        ", msg='" + msg + '\'' +
        ", data=" + data +
        '}';
    }

}
