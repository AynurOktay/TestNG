package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends BaseDriver {
    /*
       Senaryo :
       1- Siteyi açınız.
       2- Sitede "ipod" kelimesini aratınız
       3- Çıkan sonuçlardan ilkini sepete atınız.
       4- Shopping Chart a tıklatınız.
       5- Checkout yapınız.
       6- Continue butonalarına tıklatıp bilgileri giriniz.
       7- En confirm ile siparişi verdiğinizi doğrulayınız.
          doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
    */
    @Test
    public void ProceedToCheckout() {

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("ipod");

        WebElement searchBtn = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchBtn.click();

        WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCart.click();

        WebElement shoppingCart = driver.findElement(By.linkText("Checkout"));
        shoppingCart.click();

        WebElement checkout = driver.findElement(By.linkText("Checkout"));
        checkout.click();

        WebElement continue1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        continue1.click();

        WebElement continue2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        continue2.click();

        WebElement continue3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        continue3.click();

        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();

        WebElement continue4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        continue4.click();

        WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement msg=driver.findElement(By.cssSelector("[id='content']>h1"));

        Assert.assertEquals(msg.getText(),"Your order has been placed!","Onay texti bulunamadi");


    }


}
