package Gun07;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriver {
    /*
        Senaryo ;
        1- Siteye gidiniz..
       1.Test;
       2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
       3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
       4- Daha sonra WishList e tıklatınız
       5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
     */

    @Test
    @Parameters("serachText")
    void AddToWishList(String text) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(text);

        WebElement searchBtn = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchBtn.click();

        List<WebElement> searchResult = driver.findElements(By.cssSelector("div[class='caption']>h4>a"));
        int randomSecim = MyFunc.RandomGenerator(searchResult.size());
        String wishItemText = searchResult.get(randomSecim).getText();
        System.out.println(wishItemText);

        List<WebElement> wishBtnList = driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List'"));
        wishBtnList.get(randomSecim).click();

        WebElement btnWishProducts = driver.findElement(By.id("wishList-total"));
        btnWishProducts.click();

        List<WebElement> wishTableNames = driver.findElements(By.cssSelector("[class='text-left']>a"));

        // wishItemText  i  wishTableNames  ın gettext lerinde varmı diye kontrol edeceğim.
        MyFunc.listContainsString(wishTableNames, wishItemText);
    }


    }



