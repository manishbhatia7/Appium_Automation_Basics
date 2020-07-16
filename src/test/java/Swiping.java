import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Swiping extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        TouchAction t=new TouchAction(driver);
        WebElement first=driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second=driver.findElementByXPath("//*[@content-desc='45']");
        t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();





    }
}
