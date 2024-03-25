package pages;

import java.lang.reflect.Constructor;

public class PageFactory {

    public static <T> T getPage(Class<T> pageClass, String platformType) {
        try {
            switch (platformType) {
                case "ANDROID":
                    String androidPageClassName = pageClass.getPackage().getName() + ".android." + pageClass.getSimpleName() + "AndroidImpl";
                    Class<T> androidPageClass = (Class<T>) Class.forName(androidPageClassName);
                    Constructor<T> androidConstructor = androidPageClass.getConstructor();
                    return androidConstructor.newInstance();
                case "IOS":
                    String iosPageClassName = pageClass.getPackage().getName() + ".ios." + pageClass.getSimpleName() + "IOSImpl";
                    Class<T> iosPageClass = (Class<T>) Class.forName(iosPageClassName);
                    Constructor<T> iosConstructor = iosPageClass.getConstructor();
                    return iosConstructor.newInstance();
                default:
                    throw new IllegalArgumentException("Unsupported platform: " + platformType);
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to create page instance: " + pageClass.getSimpleName(), e);
        }
    }
}
