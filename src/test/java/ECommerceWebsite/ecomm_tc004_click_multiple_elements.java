package ECommerceWebsite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ecomm_tc004_click_multiple_elements extends base{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {


    AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rahul");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        List<MobileElement> products=driver.findElements(By.xpath("//*[@text='ADD TO CART']"));

        products.get(0).click();
        Thread.sleep(1000);
        products.get(1).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();





    }
}
