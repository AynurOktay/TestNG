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

public class Test1 extends BaseDriver {
    @Test
    void Test1() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.xpath("(//a[text()='Ebook'])[1]"));
        eBook.click();

        WebElement addCard = driver.findElement(By.cssSelector("[class='view_product']"));
        addCard.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(frame);

        WebElement addPromo = driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        addPromo.click();


        MyFunc.Bekle(2);

        WebElement PromoCode = driver.findElement(By.cssSelector("[class='Promo-Code-Value']"));
        PromoCode.sendKeys("543216");

        WebElement applyBtn = driver.findElement(By.cssSelector("[class='Promo-Apply']"));
        applyBtn.click();

        bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.id("SnackBar")));

        WebElement txt = driver.findElement(By.id("SnackBar"));

        Assert.assertTrue(txt.getText().contains("Invalid promo code"));
    }

    /*   Test Case:2
➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
➢ E-book add to cart butonuna tıklatınız.
➢ Pay using debit card a tıklatınız.
➢ Pay butonuna tıklatınız.
➢ Invalid Email, Invalid Email, invalid billing name mesajlarının görüldüğünü doğrulayını*/
    @Test
    void Test2() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.xpath("(//a[text()='Ebook'])[1]"));
        eBook.click();

        WebElement addCard = driver.findElement(By.cssSelector("[class='view_product']"));
        addCard.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(frame);


        MyFunc.Bekle(3);
        WebElement paymentButton = driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        paymentButton.click();

        WebElement paybtn = driver.findElement(By.cssSelector("[class='Pay-Button']"));
        paybtn.click();


        WebElement txt = driver.findElement(By.xpath("//div[@id='SnackBar']/ion-icon/following-sibling::span"));
        MyFunc.Bekle(2);
        Assert.assertTrue(txt.getText().contains("Invalid Email\n" +
                "Invalid Email\n" +
                "Invalid Billing Name"));

        //BekleKapat();


    }
    /*Test Case:3
            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
            ➢ E-book add to cart butonuna tıklatınız.
            ➢ Pay using debit card a tıklatınız.
            ➢ Card numarasına “1111 1111 1111 1111” giriniz*/


    @Test
    void Test3() {

        driver.get("https://shopdemo.e-junkie.com/");


        WebElement eBook = driver.findElement(By.xpath("(//a[text()='Ebook'])[1]"));
        eBook.click();

        WebElement addCard = driver.findElement(By.cssSelector("[class='view_product']"));
        addCard.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(frame);


        MyFunc.Bekle(3);
        WebElement paymentbtn = driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        paymentbtn.click();

        MyFunc.Bekle(3);


        driver.switchTo().frame(2);

        WebElement cardNo = driver.findElement(By.xpath("//input[@class='InputElement is-empty Input Input--empty']"));
        cardNo.sendKeys("1111111111111111");
        MyFunc.Bekle(10);


        WebElement text = driver.findElement(By.cssSelector("[name='close-circle']+span"));

        //  Assert.assertTrue(text.getText().contains("Your card number is invalid"));
        Assert.assertTrue(text.isDisplayed());

        //BekleKapat();


    }

    @Test
    void Test4() {

        driver.get("https://shopdemo.e-junkie.com/");
        WebElement eBook = driver.findElement(By.xpath("(//a[text()='Ebook'])[1]"));
        eBook.click();

        WebElement addCard = driver.findElement(By.cssSelector("[class='view_product']"));
        addCard.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(frame);


        MyFunc.Bekle(3);
        WebElement paymentbtn = driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        paymentbtn.click();

        WebElement email = driver.findElement(By.cssSelector("[placeholder='Email'][type='email']"));
        email.sendKeys("alice.nl@gmail.com");

        WebElement confirmEmail = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirmEmail.sendKeys("alice.nl@gmail.com");

        WebElement nameonCard = driver.findElement(By.cssSelector("[placeholder='Name On Card'][type='text']"));
        nameonCard.sendKeys("Alice");


        WebElement phone = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[1]"));
        phone.sendKeys("316000000");

        WebElement company = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[2]"));
        company.sendKeys("Html");

        MyFunc.Bekle(3);

        driver.switchTo().frame(2);

        WebElement cardNo = driver.findElement(By.xpath("//input[@name='cardnumber']"));
        cardNo.sendKeys("4242424242424242");

        WebElement date = driver.findElement(By.xpath("//input[@name='exp-date']"));
        date.sendKeys("1223");

        WebElement cvc = driver.findElement(By.xpath("//input[@name='cvc']"));
        cvc.sendKeys("122");
        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        bekle = new WebDriverWait(driver, Duration.ofSeconds(30));
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(frame2);

        WebElement pay = driver.findElement(By.xpath("//button[text()='Pay 0.50 USD']"));
        pay.click();

        MyFunc.Bekle(15);
        WebElement txt = driver.findElement(By.xpath("//span[@class='green_text_margin']"));
        Assert.assertTrue(txt.isDisplayed());


    }
    @Test
    public void Test5() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ContactUs = driver.findElement(By.xpath("//a[@href='/contact']"));
        ContactUs.click();

        WebElement name = driver.findElement(By.cssSelector("[id='sender_name']"));
        name.sendKeys("Alice");

        WebElement email = driver.findElement(By.cssSelector("[id='sender_email']"));
        email.sendKeys("alice.nl@gmail.com");

        WebElement Subject = driver.findElement(By.cssSelector("[id='sender_subject']"));
        Subject.sendKeys("New Product Opinion");

        WebElement msj = driver.findElement(By.cssSelector("[id='sender_message']"));
        msj.sendKeys("A great product!!!!");

        WebElement sendButton = driver.findElement(By.cssSelector("[id='send_message_button']"));
        sendButton.click();
        MyFunc.Bekle(3);
        driver.switchTo().alert().accept();


    } }