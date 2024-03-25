package pages.android;

import pages.BasePageImpl;
import pages.CatalogPage;

public class CatalogPageAndroidImpl extends BasePageImpl implements CatalogPage {
    
    public String item = "//android.widget.TextView[@content-desc=\"store item text\" and @text=\"placeholder\"]";
    public String colorCircle = "//android.view.ViewGroup[@content-desc=\"placeholder circle\"]/android.view.ViewGroup";
    public String tabBarOptionCart = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView";
}
