package com.wujingcheng7.hoteldemo_backend.config;

import java.io.*;
import java.util.Properties;

/**
 * 读取 *.properties中的属性
 */
public class ReadPropertiesUtil {
    public static Properties getProperties(String propertiesPath){
        Properties properties = new Properties();
        try{
            InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiesPath));
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
