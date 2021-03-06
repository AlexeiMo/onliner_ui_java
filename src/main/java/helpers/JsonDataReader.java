package helpers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilities.CustomLogger;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class JsonDataReader extends BaseTest{

    public static Map<String, String> getTestData() {
        CustomLogger.info("Getting test data");
        Map<String, String> payment = null;
        try {
            payment = new ObjectMapper().readValue(new File(PropertiesReader.getProperty("testData.path")),
                    new TypeReference<Map<String, String>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            CustomLogger.info("Can't read testData.json file");
        }
        return payment;
    }

}
