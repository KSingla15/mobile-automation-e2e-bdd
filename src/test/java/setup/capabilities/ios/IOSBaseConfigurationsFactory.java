package setup.capabilities.ios;

import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;
import setup.capabilities.PlatformConfigurationFactory;

public abstract class IOSBaseConfigurationsFactory implements PlatformConfigurationFactory {

    public XCUITestOptions create(MutableCapabilities capabilities) {
        XCUITestOptions options= new XCUITestOptions();
        options.setNoReset(true);
        if(capabilities != null) {
            capabilities.getCapabilityNames().forEach(key -> options.setCapability(key, capabilities.getCapability(key)));
        }
        return options;
    }
}
