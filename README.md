# simplate-app-template

模板项目 v1.0.0

## 概述

这个模板提供了项目的基础结构，为单体结构提供了基础建构，为微服务提供了基础建构。

## 贡献者

| 用户名    | 积分  | 更新时间      |
|--------|-----|-----------|
| sutton | 10  | 2023/4/28 |

## 要求

1. 标准Markdown
2. 方法，类，方法，必须带有 doc 注释
3. 注释内容需要足够的清晰
4. 来源注明出处，尊重别人的劳动果实。
5. 必须 80 % 遵循 SonarLint 规范
6. 增加框架必须遵循提交规范
7. 及时清楚不可用的 软件包
8. 项目必须有单元测试
9. 每写一个功能对应一个测试
10. 命名必须遵循 阿里规范
11. 项目必须有文档

## TODO

- [x] 项目结构
- [x] 项目功能
- [x] 项目部署
- [ ] 项目截图
- [ ] 项目文档
- [ ] 项目演示
- [ ] 项目测试
- [ ] 项目维护
- [ ] 项目发布
- [ ] 项目升级
- [ ] 项目迭代
- [ ] 项目优化
- [ ] 项目重构
- [ ] 项目重写
- [ ] 项目重启

## 目标

创建一个模板项目，用于快速构架项目。项目的前提是需要构建成功.

## 现状

目前 template 做的不错的是项目结构.项目的基础建构.项目的基础配置.

## 不足

目前 template 做的不够好的是全局异常.项目结构划分不够清晰.转微服务

## 方案

结构需要遵循一定的规范.需要有一定的约束.需要有一定的规范.需要有一定的标准.

查看大公司编写 Java 结构的规范，提升自己的规范

## 目标用户

Only me'

## 收益评估

带来更多的构建项目速度

## 风险评估

重构， 向微服务转换

## 项目周期

2天半

##       

## 项目结构

- `src/main/java`: Java 代码目录
    - `com/farm`: 项目的 Java 包名
        - `annotions`: 注解
        - `config`: 配置类
        - `constant`: 常量类
        - `data`: 硬件数据
        - `enums`: 枚举类
        - `exception`: 异常类
        - `filter`: 过滤器
        - `listener`: 监听器
        - `handler`: 处理器
        - `restful`: restful接口
        - `controller`: 控制器类
        - `dao`: mapper接口
        - `entity`: 实体类
        - `service`: 服务类
        - `utils`: 工具类
        - `interceptor`: 拦截器
        - `xxxxxxApplication.java`: 项目启动类
- `src/main/resources`: 资源目录
    - `application.properties`: 应用程序配置文件
- `src/test/java`: 测试代码目录
    - `com/example/myproject`: 项目的 Java 包名
        - `controller`: 控制器测试类
        - `service`: 服务测试类
- `pom.xml`: Maven 项目配置文件


