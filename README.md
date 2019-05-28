## mybatis-generator 基于mybatis-generator1.3.6 和 JDK1.8环境下
* 支持POJO生成基于数据库comment的中文字段注释
* 支持lombok的注解加入，去除手工的getter和setter方法
* 支持生成实现序列化接口
* 支持生成的mapper.xml字段前后默认加上 "`"。
* 支持TINYINT字段生成为Java的Integer 同时支持自定义其他字段类型的扩展
* 支持表前缀去除 或自定义映射成自己想要的表名
* 后续支持字段自定义映射

## 使用方式
* 1、在generator.properties中修改配置文件
* 2、在ApplicationGenerator运行main函数
