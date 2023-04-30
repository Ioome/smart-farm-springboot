package com.farm;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @name: GeneratorApp
 * @author: sutton
 * @date: 2023-04-30 14:19
 * @description: GeneratorApp
 */
public class GeneratorApp {


    /**
     * @param args 参数
     * @name: main
     * @description: main
     * 代码生成器
     */
    public static void main (String[] args) {
        FastAutoGenerator.create("jdbc:mysql://119.91.218.241:9240/smart_farm?useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                        , "root", "9978@wzb")
                .globalConfig(builder -> builder.author("sutton")
                        .commentDate("yyyy-MM-dd hh:mm:ss")
                        .outputDir("D:\\code\\farm\\src\\main\\java")
                        .disableOpenDir())
                .packageConfig(builder -> builder.parent("com.farm")
                        .moduleName("farm")
                        //将Mapper.xml 文件输出到resources目录下
                        .xml("mapper")
                )
                .strategyConfig(builder -> builder
                        .addInclude("farm_block")
                        //Entity 策略配置
                        .entityBuilder()
                        .enableLombok()
                        .enableFileOverride()
                        .naming(NamingStrategy.underline_to_camel)
                        .columnNaming(NamingStrategy.underline_to_camel)
                        //Mapper 策略配置
                        .mapperBuilder()
                        .enableFileOverride()
                        //Serviece 策略配置
                        .serviceBuilder()
                        .enableFileOverride()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        //Controller 策略配置
                        .controllerBuilder()
                        .enableFileOverride())
                .execute();
    }
}
