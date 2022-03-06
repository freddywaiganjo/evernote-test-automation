package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {

    static Properties properties = new Properties();

    public static void main(String[] args) {

    }

    public static String readConfig(String property) {

        try {

            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/config/config.properties");
//            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/cucumber.properties");
            properties.load(inputStream);
            property = properties.getProperty(property);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return property;

    }

}
