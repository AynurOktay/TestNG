package Proje4;


import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

    public class Proje4 extends BaseDriverParameter {

        @Test(priority = 1)
        void Registrations()
        {
            WebElement register=driver.findElement(By.linkText("Register"));
            register.click();

            WebElement gender=driver.findElement(By.id("gender-female"));
            gender.click();

            WebElement f_name=driver.findElement(By.id("FirstName"));
            f_name.sendKeys("kalem");

            WebElement l_name=driver.findElement(By.id("LastName"));
            l_name.sendKeys("silgi");

            WebElement Select_=driver.findElement(By.cssSelector("[name='DateOfBirthDay']"));
            Select dayMenu=new Select(Select_);
            dayMenu.selectByIndex(1);

            WebElement month_=driver.findElement(By.cssSelector("[name='DateOfBirthMonth']"));
            Select Ay_Menu=new Select(month_);
            Ay_Menu.selectByIndex(1);

            WebElement Yil=driver.findElement(By.cssSelector("[name='DateOfBirthYear']"));
            Select yilMenu=new Select(Yil);
            yilMenu.selectByIndex(1);

            WebElement email=driver.findElement(By.id("Email"));
            email.sendKeys("26deneme_group2_@gmail.com");

            WebElement company=driver.findElement(By.id("Company"));
            company.sendKeys("Techno Study");

            WebElement newsletter=driver.findElement(By.cssSelector("[id='Newsletter']"));
            newsletter.click();

            WebElement password=driver.findElement(By.cssSelector("[id='Password']"));
            password.sendKeys("123456");

            WebElement password_confirm=driver.findElement(By.cssSelector("[id='ConfirmPassword']"));
            password_confirm.sendKeys("123456");

            WebElement btn_register=driver.findElement(By.cssSelector("[id='register-button']"));
            btn_register.click();

            WebElement kontrol_yazi=driver.findElement(By.xpath("//div[text()='Your registration completed']"));

            Assert.assertTrue(kontrol_yazi.getText().contains("Your registration completed"));
        }
        @Test(priority = 3)
        void LoginTest()
        {
            WebElement log_out= driver.findElement(By.linkText("Log out"));
            log_out.click();

            WebElement log_in=driver.findElement(By.linkText("Log in"));
            log_in.click();

            WebElement email_=driver.findElement(By.cssSelector("[id='Email']"));
            email_.sendKeys("25deneme_group2_@gmail.com");

            WebElement pass_=driver.findElement(By.cssSelector("[id='Password']"));
            pass_.sendKeys("123456");

            WebElement btn_tikla=driver.findElement(By.cssSelector("[class='button-1 login-button'"));
            btn_tikla.click();

            WebElement kontrol_yazi=driver.findElement(By.xpath("//*[text()='Log out']"));

            Assert.assertTrue(kontrol_yazi.getText().contains("Log out"));
        }
        @Test(dataProvider = "UserData",dependsOnMethods = {"Registrations"}, priority = 2)
        void DataProviderLogin(String username,String password)
        {
            WebElement log_in=driver.findElement(By.linkText("Log in"));
            log_in.click();

            WebElement email_=driver.findElement(By.cssSelector("[id='Email']"));
            email_.sendKeys(username);

            WebElement pass_=driver.findElement(By.cssSelector("[id='Password']"));
            pass_.sendKeys(password);

            WebElement btn_tikla=driver.findElement(By.cssSelector("[class='button-1 login-button'"));
            btn_tikla.click();

            if(!username.contains("25deneme_group2_@gmail.com")||!password.contains("123456"))
            {
                WebElement errorMsg=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
                Assert.assertTrue(errorMsg.getText().contains("Login was unsuccessful. Please correct the errors and try again."));
            }
            else
            {
                WebElement kontrol_yazi=driver.findElement(By.xpath("//*[text()='Log out']"));
                Assert.assertTrue(kontrol_yazi.getText().contains("Log out"));
            }
        }
        @DataProvider()
        public Object[][] UserData()
        {
            Object[][] data={
                    {"ayse@gmail.com","22ccc33"},
                    {"25deneme_group2_@gmail.com","123456"}
            };
            return data;
        }
        @Test(dependsOnMethods = {"LoginTest"},priority = 4)
        void TabMenuTest()
        {
            List<String> isimler=new ArrayList<>();
            isimler.add("Computers");
            isimler.add("Electronics");
            isimler.add("Apparel");
            isimler.add("Digital downloads");
            isimler.add("Books");
            isimler.add("Jewelry");
            isimler.add("Gift Cards");

            List<WebElement> tab_menu_liste=driver.findElements(By.cssSelector("[class='top-menu notmobile']>li"));

            Boolean varMi=false;
            for (int i = 0; i < isimler.size(); i++)
                for (int j = 0; j <tab_menu_liste.size() ; j++) {
                    if(isimler.get(i).contains(tab_menu_liste.get(j).getText()))
                    {
                        varMi=true;
                        break;
                    }
                }
            Assert.assertTrue(varMi,"true");
        }
        @Test(dependsOnMethods = {"TabMenuTest"},priority = 5)
        void OrderGiftsTest()   {

            WebElement gifts_= driver.findElement(By.xpath("(//ul[@class='top-menu notmobile']/*)[7]"));
            gifts_.click();

            List<WebElement> urunler_=driver.findElements(By.xpath("//div[@class='item-grid']/*"));

            int a=(int)(Math.random()* urunler_.size());
            urunler_.get(a).click();

            if (a==0)
            {
                WebElement recipients_name=driver.findElement(By.cssSelector("[class='recipient-name']"));
                recipients_name.sendKeys("kalem");

                WebElement recipients_email=driver.findElement(By.cssSelector("[class='recipient-email']"));
                recipients_email.sendKeys("21deneme_group2_@gmail.com");

                WebElement your_name=driver.findElement(By.xpath("//input[@id='giftcard_43_SenderName']"));
                your_name.sendKeys("silgi");

                WebElement your_email=driver.findElement(By.xpath("//input[@id='giftcard_43_SenderEmail']"));
                your_email.sendKeys("18deneme_group2_@gmail.com");

                WebElement mesaj_=driver.findElement(By.cssSelector("[class='message']"));
                mesaj_.sendKeys("merhaba dünya");

                WebElement addToCart=driver.findElement(By.xpath("//*[@class='button-1 add-to-cart-button']"));
                addToCart.click();

                //dogrulama
                WebElement yazi_dogrula= driver.findElement(By.cssSelector("[class='bar-notification success']"));

                wait.until(ExpectedConditions.visibilityOf(yazi_dogrula));
                Assert.assertTrue(yazi_dogrula.getText().toLowerCase().contains("the product has been added to your "));
            }
            else {

                WebElement recipients_name=driver.findElement(By.cssSelector("[class='recipient-name']"));
                recipients_name.sendKeys("kalem");

                WebElement your_name=driver.findElement(By.xpath("//label[text()='Your Name:']/following-sibling::input"));
                your_name.sendKeys("silgi");

                WebElement mesaj_=driver.findElement(By.cssSelector("[class='message']"));
                mesaj_.sendKeys("merhaba dünya");

                WebElement addToCart=driver.findElement(By.xpath("//*[@class='button-1 add-to-cart-button']"));
                addToCart.click();

                //dogrulama
                WebElement yazi_dogrula= driver.findElement(By.cssSelector("[class='bar-notification success']"));

                wait.until(ExpectedConditions.visibilityOf(yazi_dogrula));
                Assert.assertTrue(yazi_dogrula.getText().toLowerCase().contains("the product has been added to your "));
            }
        }
        @Test(dependsOnMethods = {"OrderGiftsTest"},priority = 6)
        void OrderComputerTest()  {
            Actions aksiyonlar=new Actions(driver);

            WebElement computer_= driver.findElement(By.xpath("(//ul[@class='top-menu notmobile']/*)[1]"));
            aksiyonlar.moveToElement(computer_).build().perform();

            WebElement desktops_= driver.findElement(By.xpath("(//a[text()='Desktops '])[1]"));
            aksiyonlar.moveToElement(desktops_).click().build().perform();

            List<WebElement> urun_basliklari=driver.findElements(By.xpath("//h2[@class='product-title']//a"));
            String aranan_urun="Build your own computer";

            for (WebElement baslik:urun_basliklari)
                if(baslik.getText().contains(aranan_urun)) {
                    baslik.click(); break;
                }

            //Random bir RAM secimi
            WebElement ram= driver.findElement(By.id("product_attribute_2"));
            Select ramMenu=new Select(ram);
            int ramSec=(int) (Math.random()*(ramMenu.getOptions().size()-1)+1);
            ramMenu.selectByIndex(ramSec);

            //Random bir HDD secimi
            List<WebElement> hdd=driver.findElements(By.xpath("//input[@name='product_attribute_3']"));
            int hddSec=(int) (Math.random()*hdd.size());
            hdd.get(hddSec).click();

            WebElement add_tikla= driver.findElement(By.id("add-to-cart-button-1"));
            add_tikla.click();

            WebElement yazi_dogrula= driver.findElement(By.cssSelector("[class='bar-notification success']"));

            Assert.assertTrue(yazi_dogrula.getText().toLowerCase().contains("the product has been added to your "));
        }
        @Test(dependsOnMethods = {"OrderComputerTest"},priority = 7)
        @Parameters("kelime")
        void SearchTest(String search_kelime)
        {
            WebElement search_= driver.findElement(By.id("small-searchterms"));
            search_.sendKeys(search_kelime);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button-1 search-box-button']"))).click();

            // kontroll
            WebElement baslik_= driver.findElement(By.xpath("//h2[@class='product-title']"));

            Assert.assertTrue(baslik_.getText().contains(search_kelime));
        }
}
