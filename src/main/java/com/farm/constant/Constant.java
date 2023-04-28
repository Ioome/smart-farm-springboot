package com.farm.constant;

/**
 * @name: Constant
 * @author: sutton
 * @date: 2023-04-26 23:27
 * @description: 通用常量
 */
public class Constant {
    /**
     * 表达是否常量枚举
     *
     * @author sutton
     */
    public interface YesOrNoConstant {

        /**
         * 是
         */
        Integer YES = 1;

        /**
         * 否
         */
        Integer NO = 0;

        /**
         * 根据boolean获取Integer
         *
         * @param yesOrNo true是false否
         * @return Integer
         */
        static Integer valueOf (Boolean yesOrNo) {
            return yesOrNo.equals(YesOrNoBooleanConstant.YES) ? YES : NO;
        }
    }


    /**
     * 表达是否常量枚举
     *
     * @author sutton
     */
    public interface YesOrNoBooleanConstant {

        /**
         * 是
         */
        boolean YES = true;

        /**
         * 否
         */
        boolean NO = false;

        /**
         * 根据Integer获取boolean
         *
         * @param yesOrNo 1是0否
         * @return boolean
         */
        static boolean valueOf (Integer yesOrNo) {
            return yesOrNo.equals(YesOrNoConstant.YES) ? YES : NO;
        }

    }

    public interface YesOrNoStringConstant {


        /**
         * 根据Integer获取boolean
         *
         * @param yesOrNo 1是0否
         * @return boolean
         */
        static String valueOf (Integer yesOrNo) {
            return yesOrNo.equals(YesOrNoConstant.YES) ? "是" : "否";
        }

    }


    /**
     * 状态常量
     *
     * @author sutton
     */
    public interface StatusConstant {

        /**
         * 正常
         */
        Integer NORMAL = 0;

        /**
         * 停用
         */
        Integer DEACTIVATE = 1;

    }


    /**
     * 设备类型
     * @author sutton
     */
    public interface farm_equipment {


    }

}
