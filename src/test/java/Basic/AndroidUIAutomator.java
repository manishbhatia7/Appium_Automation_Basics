package Basic;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AndroidUIAutomator extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        //System.out.println(driver.findElementByAndroidUIAutomator("new uiSelector().clickable(true)").getSize());

    }
}
