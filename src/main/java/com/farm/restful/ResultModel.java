package com.farm.restful;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Data
public class ResultModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String message;

    /**
     * 总数
     */
    private Long total;

    /**
     * 标题
     */
    private List<ColumnVo> columns;

    /**
     * 数据
     */
    private T data;

    public ResultModel(int code, String message, Long total, List<ColumnVo> columns, T data) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.columns = columns;
        this.data = data;
    }

    public ResultModel() {

    }

    @Data
    public static class ColumnVo{
        private String label;
        private String prop;
        private String width;
    }


    public static ResultModel error(String message){
        return new ResultModel( 500,  message,  1L, new ArrayList<>(),null);
    }
    public static ResultModel success( ){
        return new ResultModel( 200,  "成功",  1L, new ArrayList<>(),null);
    }
    public static ResultModel success(Object data){
        return new ResultModel<>( 200,  "成功",  1L, new ArrayList<>(),data);
    }
}
