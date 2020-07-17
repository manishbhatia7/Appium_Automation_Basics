package ECommerceWebsite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class ecomm_tc002_complete_ecommerce_testcase extends base {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rahul");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        List<MobileElement> products = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));

        products.get(0).click();
        Thread.sleep(1000);
        products.get(1).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);
        List<MobileElement> prices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int size=prices.size();
        double sum=0;
        for(int i=0;i<size;i++)
        {
            String amount=prices.get(i).getText().substring(1);
            Double converted_amount=Double.parseDouble(amount);
            sum=sum+converted_amount;
        }
        System.out.println(sum);
        Assert.assertEquals(sum,280.97);
        WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
        WebElement read_text=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        TouchAction t=new TouchAction(driver);
        t.tap(tapOptions().withElement(element(checkbox))).perform();
        t.longPress(longPressOptions().withElement(element(read_text)).withDuration(ofSeconds(5))).release().perform();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.className("android.widget.Button")).click();
        Thread.sleep(3000);
        Set<String> contextNames=driver.getContextHandles();

        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Hello");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));



    }

}

