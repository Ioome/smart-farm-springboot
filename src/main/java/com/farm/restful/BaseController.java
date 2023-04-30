package com.farm.restful;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangjie
 * @date 2022年02月09日 9:55
 * @description controller基类
 */
@Component
public class BaseController {


    protected Object toResult () {
        return toResult(null, "请求成功", 200);
    }

    protected Object toResult (boolean b) {
        if (b) {
            return toResult();
        }
        return toErrorResult();
    }


    /**
     * 让注解FieId生效，需要指定class
     *
     * @param data
     * @param c
     * @return
     */
    protected Object toResult (Object data, Class c) {

        return toResult(data, "请求成功", 200, c);
    }

    protected Object toResult (Object data, Class c, boolean showTitle) {

        return toResult(data, "请求成功", 200, c, showTitle);
    }

    protected Object toResult (Object data) {

        return toResult(data, "操作成功", 200);
    }

    protected Object toErrorResult () {
        return new ResultModel<Object>(1100, "操作失败", 0L, new LinkedList<>(), null);
    }

    protected Object toErrorResult (int code, String message) {
        return new ResultModel<Object>(code, message, 0L, new LinkedList<>(), null);
    }

    protected Object toErrorResult (String message) {
        return new ResultModel<Object>(1100, message, 0L, new LinkedList<>(), null);
    }

    protected Object toErrorResult (ErrorCode errorCode) {
        return new ResultModel<Object>(errorCode.getCode(), errorCode.getDesc(), 0L, new LinkedList<>(), null);
    }

    protected Object toResult (Object data, String message, int code, Class c) {
        return toResult(data, message, code, c, true);
    }

    /**
     * crm
     *
     * @param data
     * @param message
     * @return
     */
    protected Object toResult (Object data, String message, int code, Class c, boolean showTitle) {
        String[] zero = new String[0];
        ResultModel<Object> objectResultModel = new ResultModel<>();
        LinkedList<Dto> linkedList = new LinkedList<>();

        linkedList = linkedList.stream().sorted(Comparator.comparing(Dto::getNumber)).collect(Collectors.toCollection(LinkedList::new));


        if (showTitle) {
            List<ResultModel.ColumnVo> title = linkedList.stream().map(f -> {
                ResultModel.ColumnVo columnVo = new ResultModel.ColumnVo();

                columnVo.setLabel(f.getMsg());
                columnVo.setProp(f.getName());
                columnVo.setWidth(f.getWidth());
                return columnVo;
            }).collect(Collectors.toList());
            objectResultModel.setColumns(title);
        }

        Map<String, Dto> collectDto = linkedList.stream().filter(f -> {
            return CollUtil.isNotEmpty(f.getDictValue());
        }).distinct().collect(Collectors.toMap(Dto::getName, f -> f));
        objectResultModel.setCode(code);
        if (code < 300) {
            if (data instanceof Page) {
                Page page = (Page) data;

                objectResultModel.setTotal(page.getTotal());
                if (page.getRecords() == null) {
                    objectResultModel.setData(zero);
                }
            } else if (data instanceof Collection) {
                Collection list = (Collection) data;
                objectResultModel.setTotal((long) list.size());
                //放置无法正常返回单纯的列表
                if (CollUtil.isEmpty(linkedList)) {
                    objectResultModel.setData(list);
                }
            } else {
                objectResultModel.setTotal(1L);
                objectResultModel.setData(data);
            }
        }

        objectResultModel.setMessage(message);

        return objectResultModel;
    }

    protected Object toResult (Object data, String message, int code) {

        return toResult(data, message, code, null);
    }

    /**
     * 两个结果返回
     *
     * @param data
     * @param otherData
     * @param message
     * @param code
     * @param c
     * @return
     */
    protected Object toResultData (Object data, Object otherData, String message, int code, Class c, boolean showTitle) {

        String[] zero = new String[0];
        ResultModel<Object> objectResultModel = new ResultModel<>();
        //设置title
        LinkedList<Dto> linkedList = new LinkedList<>();


        linkedList = linkedList.stream().sorted(Comparator.comparing(Dto::getNumber)).collect(Collectors.toCollection(LinkedList::new));

        List<ResultModel.ColumnVo> title = linkedList.stream().map(f -> {
            ResultModel.ColumnVo columnVo = new ResultModel.ColumnVo();

            columnVo.setLabel(f.getMsg());
            columnVo.setProp(f.getName());
            columnVo.setWidth(f.getWidth());
            return columnVo;
        }).collect(Collectors.toList());

        Map<String, Dto> collectDto = linkedList.stream().filter(f -> {
            return CollUtil.isNotEmpty(f.getDictValue());
        }).distinct().collect(Collectors.toMap(Dto::getName, f -> f));
        if (showTitle) {
            objectResultModel.setColumns(title);
        }
        objectResultModel.setColumns(title);

        objectResultModel.setCode(code);
        if (code < 300) {
            if (data instanceof Page) {
                Page page = (Page) data;

                objectResultModel.setTotal(page.getTotal());
                if (page.getRecords() == null) {
                    objectResultModel.setData(zero);
                } else {
                    List records = page.getRecords();
                    //放置无法正常返回单纯的列表
                    if (CollUtil.isEmpty(linkedList)) {
                        objectResultModel.setData(records);
                    }

                }

            }
        }

        objectResultModel.setMessage(message);

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("rows", objectResultModel.getData());
        hashMap.put("otherData", otherData);
        objectResultModel.setData(hashMap);
        return objectResultModel;
    }


    static class Dto {

        private String msg;

        private String name;

        private Integer number;

        private String width;
        /**
         * 字典值
         */
        private Map<String, String> dictValue = new HashMap<>();

        public String getName () {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        public Integer getNumber () {
            return number;
        }

        public void setNumber (Integer number) {
            this.number = number;
        }

        public String getMsg () {
            return msg;
        }

        public void setMsg (String msg) {
            this.msg = msg;
        }

        public Map<String, String> getDictValue () {
            return dictValue;
        }

        public void setDictValue (Map<String, String> dictValue) {
            this.dictValue.putAll(dictValue);
        }


        public String getWidth () {
            return width;
        }

        public void setWidth (String width) {
            this.width = width;
        }
    }
}
