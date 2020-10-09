package com.testNGOfis.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
    //This class will READ THE DATA FROM configuration.properties file!!!!!!!
    //create a properties instance. Data type=Properties, instance name =properties
    private static Properties properties;

    static {
        //path of teh configuration.properties file
        String path = "configuration.properties";
        try {
            //Openning the configuration.properties file
            FileInputStream fileInputStream = new FileInputStream(path);
            //loading the file
            properties = new Properties();
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}