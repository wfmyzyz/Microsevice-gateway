package com.wfmyzyz.gateway.enums;

/**
 * @author xiong
 */

public enum ProjectResEnum {

    /**
     * 用户
     */
    USER_NO_SAME_PASSWORD(20001,"输入的两次密码不一致！"),
    USER_ALREADY_EXISTED(20002,"用户已经存在！"),
    USER_ADD_FAIL(20003,"用户添加失败！"),
    USER_ADD_SUCCESS(200,"用户添加成功！"),
    USER_NONENTITY(20005,"用户不存在！"),
    USER_OLD_PASSWORD_ERROR(20006,"用户旧密码错误！"),
    USER_UPDATE_FAIL(20007,"用户修改失败！"),
    USER_UPDATE_SUCCESS(200,"用户修改成功！"),
    USER_DELETE_SIZE(20009,"删除的用户ID不能为空！"),
    USER_DELETE_FAIL(20010,"用户删除失败！"),
    USER_DELETE_SUCCESS(200,"用户删除成功！"),
    USER_ROLE_SUCCESS(200,"绑定成功！"),

    /**
     * 角色返回
     */
    ROLE_ADD_FAIL(21001,"角色新增失败！"),
    ROLE_ADD_SUCCESS(200,"角色新增成功！"),
    ROLE_UPDATE_FAIL(21003,"角色修改失败！"),
    ROLE_UPDATE_SUCCESS(200,"角色修改成功！"),
    ROLE_DELETE_SIZE(21005,"删除的角色ID不能为空！"),
    ROLE_DELETE_FAIL(21006,"删除角色失败！"),
    ROLE_DELETE_SUCCESS(200,"删除角色成功！"),
    ROLE_AUTHORITY_SUCCESS(200,"绑定成功！"),

    /**
     * 权限返回
     */
    AUTHORITY_ADD_FAIL(22001,"权限新增失败！"),
    AUTHORITY_ADD_SUCCESS(200,"权限新增成功！"),
    AUTHORITY_ROOT_ERROR(22003,"权限根节点不能为按钮！"),
    AUTHORITY_UPDATE_FAIL(22004,"权限修改失败！"),
    AUTHORITY_UPDATE_SUCCESS(200,"权限修改成功！"),
    AUTHORITY_DELETE_SIZE(22006,"删除的权限ID不能为空！"),
    AUTHORITY_DELETE_FAIL(22007,"删除权限失败！"),
    AUTHORITY_DELETE_SUCCESS(200,"删除权限成功！"),
    AUTHORITY_ALREADY_EXISTED(22009,"权限已经存在！"),

    /**
     * 登录返回
     */
    LOGIN_ERROR(206,"登录失败，请重新登录！"),
    LOGIN_ERROR_NO_USER(206,"登录失败，用户名或密码不正确！"),
    PUBLIC_ERROR(206,"获取公钥失败！"),

    /**
     * API调用
     */
    API_ERROR(210,"服务调用异常！"),

    /**
     * 通用
     */
    SUCCESS(200,"成功！"),
    FAIL(0,"失败！"),
    LOGIN(206,"请登录！"),
    NONE_AUTHORITY(208,"没有权限！");

    private final int code;
    private final String msg;

    ProjectResEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
}
