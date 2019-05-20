package org.mybatis.generator;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

/**
 * 指定jdbcType 映射成适合业务的JavaType
 * 如：把数据库的 TINYINT 映射成 Integer
 *
 * @author Karl Jin
 * @create 2019-05-17 23:40
 */

public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {
    public MyJavaTypeResolver() {
        super();
        //把数据库的 TINYINT 映射成 Integer
        super.typeMap.put(Types.TINYINT, new JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
    }

}
