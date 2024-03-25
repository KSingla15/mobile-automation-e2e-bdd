package setup.capabilities.ios;

import org.openqa.selenium.MutableCapabilities;
import setup.capabilities.AppiumConfiguration;
import setup.capabilities.PlatformConfigurationFactory;
import utils.Generic;

import java.io.IOException;

public class IOSLocalConfigurationFactory extends IOSBaseConfigurationsFactory {
    @Override
    public AppiumConfiguration createConfiguration() throws IOException {
        MutableCapabilities mutableCapabilities;
        MutableCapabilities baseCapabilities;
        baseCapabilities= PlatformConfigurationFactory.getCapabilities(Generic.ConvertJsonToMap("src/test/resources/capabilities/ios/simulator/capabilities.json"));
        mutableCapabilities = create(baseCapabilities);
        return new AppiumConfiguration(mutableCapabilities);
    }
}
