import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class scrolling extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
    }
}
