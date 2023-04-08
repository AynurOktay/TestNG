package Proje3;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test2 extends BaseDriver {
    @Test
    void Test2() {
        driver.get("https://shopdemo.e-junkie.com/%22");

        WebElement eBook = driver.findElement(By.xpath("//(//a[text()='Ebook'])[1])"));
        eBook.click();

        WebElement addCard = driver.findElement(By.cssSelector("[class='view_product']"));
        addCard.click();

        WebElement frame=driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(30) );
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(frame);


        MyFunc.Bekle(3);
        WebElement paymentButton = driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        paymentButton.click();

        WebElement paybtn = driver.findElement(By.cssSelector("[class='Pay-Button']"));
        paybtn.click();


        WebElement txt=driver.findElement(By.xpath("//div[@id='SnackBar']/ion-icon/following-sibling::span"));

        Assert.assertTrue(txt.getText().contains("Invalid Email\n" +
                "Invalid Email\n" +
                "Invalid Billing Name"));




}}