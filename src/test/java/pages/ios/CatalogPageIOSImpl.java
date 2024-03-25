package pages.ios;

import pages.BasePageImpl;
import pages.CatalogPage;

public class CatalogPageIOSImpl extends BasePageImpl implements CatalogPage {

    public String item = "//XCUIElementTypeStaticText[@name=\"store item text\" and @label=\"placeholder\"]";
    public String colorCircle = "//XCUIElementTypeOther[@name=\"placeholder circle\"]";
    public String tabBarOptionCart = "//XCUIElementTypeButton[@name=\"tab bar option cart\"]";
}