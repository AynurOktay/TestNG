package Gun03;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static Utility.BaseDriver.driver;

public class _02_AddressFunctionality extends BaseDriver {
/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */

    @Test
    void addAddress() {
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Aynur");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Oktay");

        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("AA");
        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Unterm Feist ");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Kusel ");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("66869 ");

        WebElement country = driver.findElement(By.id("input-country"));
        Select countryMenu=new Select(country);
        countryMenu.selectByVisibleText("Germany");

        WebElement options= driver.findElement(By.cssSelector("select[id='input-zone']>option"));
        wait.until(ExpectedConditions.stalenessOf(options));

        //2.secenek(selectByIndex  icin:)
        wait.until(ExpectedConditions.elementToBeClickable(country));

        WebElement state= driver.findElement(By.id("input-zone"));
        Select stateMenu=new Select(state);
        //stateMenu.selectByVisibleText("Rheinland-Pfalz");
        //stateMenu.selectByValue("3321");
        stateMenu.selectByIndex(7);


        //stale element hatasi:(tez buldum erken kaybettim)ülkeyi sectikten sonra o ülkeye ait sehir secenekleri olusna kadar beklemek gerekiyor.
        //bu yuzden wait yapiyoruz

        //selectByVisibleText,selectByValue: findElement gibi calistirdigindan implicitly wait i kullanir

        //selectByIndex:implicitlyWait ile calismiyor.Ancak explicitlyWait ile calisir


        WebElement defaddress = driver.findElement(By.xpath("//input[@value='1']"));
        defaddress.click();

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBtn.click();

         MyFunc.successMessageValidation();

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress(){
        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll= driver.findElements(By.linkText("Edit"));
        WebElement sonEdit= editAll.get( editAll.size()-1 ); // son edit
        sonEdit.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Ayn");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Okt");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        MyFunc.successMessageValidation();
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress(){

        WebElement addressBook= driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll= driver.findElements(By.linkText("Delete"));
        WebElement deleteAddress= editAll.get( editAll.size()-2 ); // son edit
        deleteAddress.click();

        MyFunc.successMessageValidation();



    }






    }


