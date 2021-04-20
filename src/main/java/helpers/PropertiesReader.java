package helpers;

import utilities.CustomLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropertiesReader extends BaseTest{

    private static Properties properties;
    private PropertiesReader() {
        throw new IllegalStateException("Utility class");
    }
    private static void readPropertiesFile() {
        ClassLoader classLoader = PropertiesReader.class.getClassLoader();
        File propertiesFile = null;
        try {
            propertiesFile = new File(classLoader.getResource("test_framework.properties").toURI());
        }
        catch (URISyntaxException e) {
            CustomLogger.info("Can't find properties file");
        }
        properties = new Properties();
        try (InputStream inputStream =
                     new FileInputStream(propertiesFile)) {
            CustomLogger.info("Reading properties file...");
            properties.load(inputStream);
        } catch (IOException e) {
            CustomLogger.info("Can't read properties file");
        }
    }

    public static String getProperty(final String key) {
        if (properties == null) {
            readPropertiesFile();
        }
        return properties.getProperty(key);
    }

}
