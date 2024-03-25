package setup.capabilities.android;

import org.openqa.selenium.MutableCapabilities;
import setup.capabilities.AppiumConfiguration;
import setup.capabilities.PlatformConfigurationFactory;
import utils.Generic;

import java.io.IOException;

public class AndroidSauceLabsConfigurationFactory extends AndroidBaseConfigurationsFactory {
    @Override
    public AppiumConfiguration createConfiguration() throws IOException {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities = mutableCapabilities.merge(PlatformConfigurationFactory.getCapabilities(Generic.ConvertJsonToMap("src/test/resources/capabilities/android/saucelabs/capabilities.json")));
        mutableCapabilities.setCapability("sauce:options", PlatformConfigurationFactory.getCapabilities(Generic.ConvertJsonToMap("src/test/resources/capabilities/android/saucelabs/sauceoptions.json")));
        return new AppiumConfiguration(mutableCapabilities);
    }
}
