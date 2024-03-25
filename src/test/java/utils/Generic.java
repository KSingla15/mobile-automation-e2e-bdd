package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import setup.Driver;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Generic {

    public static Map<String, Object> ConvertJsonToMap(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        return mapper.readValue(file, Map.class);
    }

    /**
     * Generic method to convert a JSON file into a Collection of models or a single model.
     * @param filePath Path to the JSON file.
     * @param valueTypeRef TypeReference of the target type.
     * @return Collection of models or a single model depending on the TypeReference provided.
     * @throws IOException If an error occurs reading the file.
     */
    public static <T> T convertJsonFileToModel(String filePath, TypeReference<T> valueTypeRef) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), valueTypeRef);
    }

    public static String getBASE64Screenshot() {
        try {
            // Generate the path where the screenshot will be saved
            return ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to capture screenshot: " + e.getMessage();
        }
    }

    public static byte[] getByteScreenshot() throws IOException {
        return ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}