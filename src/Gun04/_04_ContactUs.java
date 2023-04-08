package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {

    /*
      1- ContactUs a tıklayınız
      2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
      3- Submit ettikten sonra Contact US yazısını doğrulayınız.
     */
    @Test
    @Parameters("mesaj")
    void ContactUs(String gelenMesaj) {

        WebElement contactBtn = driver.findElement(By.linkText("Contact Us"));
        contactBtn.click();


        WebElement msgBox = driver.findElement(By.id("input-enquiry"));
        msgBox.sendKeys(gelenMesaj);

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();


        Assert.assertTrue(driver.getCurrentUrl().contains("success"));


    }


}
