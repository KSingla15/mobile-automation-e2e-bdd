package setup.capabilities;

import org.openqa.selenium.MutableCapabilities;
import setup.capabilities.android.AndroidLocalConfigurationFactory;
import setup.capabilities.android.AndroidSauceLabsConfigurationFactory;
import setup.capabilities.ios.IOSLocalConfigurationFactory;
import setup.capabilities.ios.IOSSauceLabsConfigurationFactory;

import java.io.IOException;
import java.util.Map;

public interface PlatformConfigurationFactory {
    AppiumConfiguration createConfiguration() throws IOException;

    static PlatformConfigurationFactory getFactory(String platformName, boolean isLocalMode) {
        return switch (platformName) {
            case "ANDROID" -> isLocalMode ? new AndroidLocalConfigurationFactory() : new AndroidSauceLabsConfigurationFactory();
            case "IOS" -> isLocalMode ? new IOSLocalConfigurationFactory() : new IOSSauceLabsConfigurationFactory();
            default -> throw new IllegalArgumentException("Unsupported platform: " + platformName);
        };
    }

    static MutableCapabilities getCapabilities(Map<String, Object> jsonMap){
        MutableCapabilities capabilities = new MutableCapabilities();
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if(key.equalsIgnoreCase("app")) {
                if(value != null){
                    String newValue = System.getProperty("user.dir") + value;
                    capabilities.setCapability(key, newValue);
                }
            }else {
                capabilities.setCapability(key, value);
            }
        }

        return capabilities;
    }
}
