package Basic;

import Basic.base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDrop extends base {
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        TouchAction touch=new TouchAction(driver);
        //WebElement source=driver.findElement(By.xpath("//android.view.View)[0]"));
        //WebElement destination=driver.findElement(By.xpath("//android.view.View)[2]"));
        WebElement source= (WebElement) driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination= (WebElement) driver.findElementsByClassName("android.view.View").get(2);
        touch.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();


    }
}
