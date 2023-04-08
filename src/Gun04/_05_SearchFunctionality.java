package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SearchFunctionality extends BaseDriver {
/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

    @Test
    @Parameters("aranacakKelime")
    void test1(String text) {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(text);

        WebElement searchBtn = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchBtn.click();

        List<WebElement> captions = driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for (WebElement a : captions) {
            Assert.assertTrue(a.getText().toLowerCase().contains(text));
        }

    }


}
