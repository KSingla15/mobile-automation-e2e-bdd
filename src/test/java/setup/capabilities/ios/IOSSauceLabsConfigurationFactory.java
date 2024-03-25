package setup.capabilities.ios;

import org.openqa.selenium.MutableCapabilities;
import setup.capabilities.AppiumConfiguration;
import setup.capabilities.PlatformConfigurationFactory;
import utils.Generic;

import java.io.IOException;

public class IOSSauceLabsConfigurationFactory extends IOSBaseConfigurationsFactory {
    @Override
    public AppiumConfiguration createConfiguration() throws IOException {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities = mutableCapabilities.merge(PlatformConfigurationFactory.getCapabilities(Generic.ConvertJsonToMap("src/test/resources/capabilities/ios/saucelabs/capabilities.json")));
        mutableCapabilities.setCapability("sauce:options", PlatformConfigurationFactory.getCapabilities(Generic.ConvertJsonToMap("src/test/resources/capabilities/ios/saucelabs/sauceoptions.json")));

        return new AppiumConfiguration(mutableCapabilities);
    }
}
