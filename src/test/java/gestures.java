import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class gestures extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        TouchAction t=new TouchAction(driver);
        WebElement expandList=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(tapOptions().withElement(element(expandList))).perform();
       driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
       WebElement peoplelist=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        t.longPress(longPressOptions().withElement(element(peoplelist)).withDuration(ofSeconds(2))).release().perform();
        driver.findElementByXPath("//android.widget.TextView[@text='Sample action']").isDisplayed();



    }
}
