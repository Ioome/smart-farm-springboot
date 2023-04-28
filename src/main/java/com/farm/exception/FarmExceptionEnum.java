package com.farm.exception;

/**
 * @author 25722
 * @name: FarmExceptionEnum
 * @description: FarmExceptionEnum
 */
public enum FarmExceptionEnum {

    /**
     * 枚举类
     */
    NEED_USER_NAME(10001, "用户名不能为空"),
    NEED_PASSWORD(10002, "密码不能为空"),
    PASSWORD_TOO_SHORT(10003, "密码长度不能小于8位"),
    NAME_EXISTED(10004, "不允许重名"),
    INSERT_FAILED(10005, "插入失败，请重试"),
    LOGIN_ERROR(500, "注册失败"),
    WRONG_PASSWORD(10006, "密码错误"),
    NEED_LOGIN(10007, "用户未登录"),
    UPDATE_FAILED(10008, "更新失败"),
    NEED_ADMIN(10009, "无管理员权限"),
    PARA_NOT_NULL(10010, "参数不能为空"),
    CREATE_FAILED(10011, "新增失败"),
    REQUEST_PARAM_ERROR(10012, "参数错误"),
    DELETE_FAILED(10013, "删除失败"),
    MKDIR_FAILED(10014, "文件夹创建失败"),
    UPLOAD_FAILED(10015, "图片上传失败"),
    NOT_SALE(10016, "商品状态不可售"),
    NOT_ENOUGH(10017, "商品库存不足"),
    CART_EMPTY(10018, "购物车已勾选的商品为空"),
    NO_ENUM(10019, "未找到对应的枚举"),
    NO_DATA(10019, "数据不存在"),
    NO_ORDER(10020, "订单不存在"),
    NOT_YOUR_ORDER(10021, "订单不属于你"),
    WRONG_ORDER_STATUS(10022, "订单状态不符"),
    SYSTEM_ERROR(20000, "系统异常，请从控制台或日志中查看具体错误信息");

    int code;
    String message;

    FarmExceptionEnum (int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode () {
        return code;
    }

    void setCode (int code) {
        this.code = code;
    }

    public String getMessage () {
        return this.message;
    }

    void setMes (String message) {
        this.message = message;
    }
}
