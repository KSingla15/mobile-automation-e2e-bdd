package setup.capabilities.android;

import org.openqa.selenium.MutableCapabilities;
import setup.DeviceType;
import setup.capabilities.AppiumConfiguration;
import setup.capabilities.PlatformConfigurationFactory;
import utils.ConfigurationReader;
import utils.Generic;

import java.io.IOException;

public class AndroidLocalConfigurationFactory extends AndroidBaseConfigurationsFactory {

    static {
        System.setProperty("ANDROID_HOME", ConfigurationReader.getAndroidHome());
        System.setProperty("ANDROID_SDK_ROOT", ConfigurationReader.getAndroidHome());
    }
    @Override
    public AppiumConfiguration createConfiguration() throws IOException {
        MutableCapabilities mutableCapabilities;
        MutableCapabilities baseCapabilities;
        baseCapabilities = PlatformConfigurationFactory.getCapabilities(ConfigurationReader.getDeviceType().equals(DeviceType.VIRTUAL.name()) ? Generic.ConvertJsonToMap("src/test/resources/capabilities/android/emulator/capabilities.json")
                : Generic.ConvertJsonToMap("src/test/resources/capabilities/android/real/capabilities.json"));
        mutableCapabilities = create(baseCapabilities);
        return new AppiumConfiguration(mutableCapabilities);
    }
}
