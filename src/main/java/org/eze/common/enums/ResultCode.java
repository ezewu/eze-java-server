package org.eze.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/*
 * Created by Ksdl
 * 2019-04-21 21:26
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    // 操作成功0
    SUCCESS(HttpServletResponse.SC_OK, "成功"),
    // 业务异常
    FAILURE(HttpServletResponse.SC_BAD_REQUEST, "失败"),
    //服务器异常
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器异常"),

    // 还未登录
    SC_UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "还未登录"),
    // 当前用户已存在
    USER_ALREADY_EXISTS(HttpServletResponse.SC_BAD_REQUEST, "当前用户已存在"),
    // 查询单条用户详请
    NO_SUCH_USER(HttpServletResponse.SC_BAD_REQUEST, "没有查到用户"),

    // 当前菜单name已存在
    MENU_ALREADY_EXISTS(HttpServletResponse.SC_BAD_REQUEST, "当前菜单name已存在"),
    // 菜单ID有误
    NO_SUCH_MENU(HttpServletResponse.SC_BAD_REQUEST, "菜单ID有误"),
    // 没有此角色
    NO_SUCH_REMUS(HttpServletResponse.SC_BAD_REQUEST, "没有可用的菜单"),
    // 没有此角色
    NO_SUCH_ROLE(HttpServletResponse.SC_BAD_REQUEST, "没有查到角色"),

    // 当前菜单下重复CODE
    RESOURCE_NUMBER_OCCUPIED(HttpServletResponse.SC_BAD_REQUEST, "此资源编号已占用"),
    // 没有可用的资源
    NO_SUCH_MENU_RESOURCE(HttpServletResponse.SC_BAD_REQUEST, "没有可用的资源"),


    // 还没可用有部门
    NO_SUCH_DEPARTMENT(HttpServletResponse.SC_BAD_REQUEST, "还没可用有部门"),


    // 此动作编号已占用
    ACTION_NUMBER_OCCUPIED(HttpServletResponse.SC_BAD_REQUEST, "此动作编号已占用"),
    // 没有可用的动作
    NO_SUCH_MENU_ACTION(HttpServletResponse.SC_BAD_REQUEST, "没有可用的动作"),

    // 前台JSON有误
    MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "参数不能析"),
    // 缺少必要的请求参数
    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "缺少必要的请求参数"),
    // 参数校验失败
    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数校验失败");
    public final int code;
    public final String msg;

}
