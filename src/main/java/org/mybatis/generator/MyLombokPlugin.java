package org.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * pojo类中生产lombok注解
 *
 * @author Karl Jin
 * @create 2019-05-17 22:51
 */

public class MyLombokPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //添加domain的import
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("lombok.Builder");
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
        topLevelClass.addImportedType("lombok.AllArgsConstructor");
        topLevelClass.addImportedType("lombok.ToString;");
        //topLevelClass.addImportedType("lombok.EqualsAndHashCode;");

        //添加domain的注解
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@Builder");
        topLevelClass.addAnnotation("@NoArgsConstructor");
        topLevelClass.addAnnotation("@AllArgsConstructor");
        topLevelClass.addAnnotation("@ToString");
        //topLevelClass.addAnnotation("@EqualsAndHashCode");

        //添加domain的注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author Mybatis Generator ");
        topLevelClass.addJavaDocLine(" * @create " + date2Str(new Date()));
        topLevelClass.addJavaDocLine(" */");

        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // Mapper文件的注释
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine(" * @author Mybatis Generator  ");
        interfaze.addJavaDocLine(" * @create " + date2Str(new Date()));
        interfaze.addJavaDocLine(" */");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 不生成getter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 不生成setter
        return false;
    }

    private String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }
}
