package setup.capabilities.android;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import setup.capabilities.PlatformConfigurationFactory;

public abstract class AndroidBaseConfigurationsFactory implements PlatformConfigurationFactory {

    public UiAutomator2Options create(MutableCapabilities capabilities) {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setNoReset(true);
        if(capabilities != null) {
            capabilities.getCapabilityNames().forEach(key -> options.setCapability(key, capabilities.getCapability(key)));
        }
        System.out.println(options.toJson());
        return options;
    }
}
