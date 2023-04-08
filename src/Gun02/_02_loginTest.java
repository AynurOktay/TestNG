package Gun02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_loginTest extends BaseDriver {

  @Test
  public void loginTest()
    {

        //siteye dogru giris yapip yapmadigimizi kontrol ediyoruz

        System.out.println("Login Test");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail=driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("moonlight@gmail.com");
        MyFunc.Bekle(5);

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("bahar2009");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();


       Assert.assertTrue(driver.getTitle().equals("My Account"));
       //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
    }



}
