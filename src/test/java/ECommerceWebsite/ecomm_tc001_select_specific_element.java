package ECommerceWebsite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ecomm_tc001_select_specific_element extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver=Capabilities();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rahul");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementById("com.androidsample.generalstore:id/productName").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                        + "new UiSelector().text(\"Jordan 6 Rings\"));");
        int count_product=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i=0;i<count_product;i++)
        {
           List< MobileElement> products=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
           String text=products.get(i).getText();
           if(text.equalsIgnoreCase("Jordan 6 Rings"))
           {
               List<MobileElement> clickable_product=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
               clickable_product.get(i).click();
               break;
           }

        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        //String text_add_to_cart=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        //Assert.assertEquals("Jordan 6 Rings",text_add_to_cart);
        //String lastpageText=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

        //Assert.assertEquals("Jordan 6 Rings", lastpageText);


    }
}
