package com.farm.restful;

public enum ErrorCode {
    UN_KNOW_ERROR(1, "未知错误"),
    COMMON_PARAM_EMPTY(2, "必选参数为空"),
    COMMON_PARAM_ERROR(3, "参数格式错误"),
    USER_VALID_ERROR(4, "用户验证失败"),


    QUERY_RESULT_IS_NULL(5, "查询结果为空"),
    NOT_ONLY_REQUEST(6, "重复请求~"),
    RSA_FAIL(7, "解密错误~~"),

    DATABASE_SAVE_ERROR(8, "保存失败"),
    DATABASE_DELETE_ERROR(9, "删除失败"),

    DATABASE_UPDATE_ERROR(10, "修改失败"),
    DATABASE_ADD_ERROR(11, "增加失败"),
    /**
     * 权限不足
     */
    PERMISSION_ERROR(12, "权限不足~~");






    private final int code;
    private final String desc;

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnum{" + "code='" + code + '\'' + ", desc='" + desc + '\'' + '}';
    }
}
