package com.wilfwolf.ibatis.generator;

import com.wildwolf.helper.BusinessFailure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;

import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class IBatisGenerator {

    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     * @throws SQLException
     * @throws XMLParserException
     * @throws InvalidConfigurationException
     */
    public static void main(String[] args) throws SQLException, IOException, InterruptedException, XMLParserException, InvalidConfigurationException, BusinessFailure {
        //替换
        String tableName = "team";
        /////////////////////

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
//        File configFile = new File("E:\\NetBeansProjects\\smartdafront\\src\\java\\com\\wilfwolf\\ibatis\\generator\\generatorConfig.xml");
        String sqlClassPath = "/com/wilfwolf/ibatis/generator/generatorConfig.xml";
	    InputStream is = IBatisGenerator.class.getResourceAsStream(sqlClassPath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        List list = config.toDocument().getRootElement().getElements();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        
        //自动在SqlMapConfig.xml添加_SqlMap.xml
//        File sqlMapConfigFile = new File("D:\\Codes\\项目\\Football\\Football\\config\\SqlMapConfig.xml");
//        String sqlClassPath2 = "/SqlMapConfig.xml";
//        InputStream is2 = IBatisGenerator.class.getResourceAsStream(sqlClassPath2);
//        SAXReader reader = new SAXReader();
//        try {
//            Document document = reader.read(is2);
//            Element root = document.getRootElement();
//            boolean exist = false;
//            for (Iterator<Element> i = root.elementIterator("sqlMap"); i.hasNext();) {
//                Element element = i.next();
//                String resource = element.attributeValue("resource");
//                if (resource.equalsIgnoreCase(tableName + "_SqlMap.xml")) {
//                    exist = true;
//                }
//            }
//            if (exist == false) {
//                root.addElement("sqlMap")
//                        .addAttribute("resource", tableName + "_SqlMap.xml");
//            }
//            // Pretty print the document to System.out
//             XMLWriter writer = new XMLWriter(
//            new FileWriter( sqlMapConfigFile), OutputFormat.createPrettyPrint()
//        );
//        writer.write( document );
//        writer.close();    
//
//        } catch (DocumentException e) {
//            e.printStackTrace();
//            throw new BusinessFailure(e.getMessage());
//        }
        System.out.println("Generated!");


    }
}
