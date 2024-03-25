package utils;

import lombok.Getter;
import lombok.Setter;
import setup.DeviceType;
import setup.PlatformName;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    @Getter @Setter
    private static String platformName;

    @Getter @Setter
    private static String deviceType;

    @Getter @Setter
    private static String appiumServerMode;

    private static final Properties props;
    static{
        props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/Config.properties"));

            platformName = props.getProperty("platformName") == null ? PlatformName.ANDROID.name() : props.getProperty("platformName");
            System.out.println("The platform is: "+ platformName);

            deviceType = props.getProperty("deviceType") == null ? DeviceType.VIRTUAL.name() : props.getProperty("deviceType");
            System.out.println("The deviceType is: "+ deviceType);

            appiumServerMode = props.getProperty("appiumServerMode");
            System.out.println("The appiumServerMode is: "+ appiumServerMode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAndroidHome(){
        return props.getProperty("androidHome");
    }

    public static long getImplicitWaitTime(){
        return Long.parseLong(props.getProperty("implicitWaitTime"));
    }
}
