import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * MyBatis工程逆向生成文件
 * 1、在generator.properties中修改配置文件
 * 2、在ApplicationGenerator运行main函数
 *
 * @author Karl Jin
 * @create 2019-05-17 21:34
 */

public class ApplicationGenerator {


    public static void main(String[] args) throws Exception {
        try {
            ApplicationGenerator mybatisGenerator = new ApplicationGenerator();
            mybatisGenerator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置设置
     *
     * @throws Exception
     */
    private void generator() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        // 指定 逆向工程配置文件
        String genCfg = "/generatorConfig.xml";
        File configFile = new File(ApplicationGenerator.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }

}
