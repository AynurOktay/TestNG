package Gun07;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_PageObjectModel extends BaseDriver {

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamanlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */

    @Test

    public void Test1() {


        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("ipod");

        WebElement searchBtn = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchBtn.click();

        List<WebElement> products = driver.findElements(By.xpath("//button[contains(@onclick,'cart.add')]"));

       int a=(int)(Math.random()* products.size());
       products.get(a).click();

        WebElement wishList = driver.findElement(By.linkText("iPod Shuffle"));
        System.out.println( wishList.getText());


        WebElement productName= driver.findElement(By.xpath("(//i[@class='fa fa-check-circle']//following-sibling::a)[1]"));
        System.out.println(productName.getText());

        Assert.assertTrue(wishList.getText().equalsIgnoreCase(productName.getText()),"Iki urunun ismi ayni degil");







        }



    }



