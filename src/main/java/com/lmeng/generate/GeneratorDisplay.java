package com.lmeng.generate;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorDisplay
{
    public void generator() throws Exception
    {
        List<String> warnings = new ArrayList<String>();
        boolean over_write_ = true;
        File config_file_ = ResourceUtils.getFile("classpath:generate/generatorConfig.xml");
        //File config_file_ = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(config_file_);
        DefaultShellCallback callback = new DefaultShellCallback(over_write_);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static  void main(String[] args) throws Exception
    {
        try
        {
            GeneratorDisplay generatorDisplay = new GeneratorDisplay();
            generatorDisplay.generator();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
