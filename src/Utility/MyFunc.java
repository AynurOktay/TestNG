package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Utility.BaseDriver.driver;

public class MyFunc {

    public static void Bekle(int sn) {
        try {
            Thread.sleep(1000 * sn); // ms beklediği
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void BekleKapat() {
        MyFunc.Bekle(3);
        driver.quit();
    }

    public static void successMessageValidation() {
        WebElement msgLabel = BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }

    public static int RandomGenerator(int max){ //4
        return (int)(Math.random()*max); // 0,1,2,3
    }

    public static void listContainsString(List<WebElement> list, String aranacakKelime){

        boolean bulundu=false;
        for(WebElement e: list){
            if (e.getText().toLowerCase().contains(aranacakKelime.toLowerCase()))
            {
                bulundu=true;
                break;
            }
        }

        if (bulundu==false)
            Assert.fail();

    }

}