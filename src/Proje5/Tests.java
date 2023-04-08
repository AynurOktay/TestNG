package Proje5;

import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseDriverProject {

    @Test(priority = 1)
    public void LoginTest() {


        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.clear();
        email.sendKeys("admin@yourstore.com");

        WebElement password = driver.findElement(By.cssSelector("[id='Password'] "));
        password.clear();
        password.sendKeys("admin");

        WebElement login = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        login.click();

        //  WebElement loginCheck = driver.findElement(By.cssSelector("[class='content-header']>h1"));
        //  Assert.assertTrue(loginCheck.getText().contains("Dashboard"));
        WebElement kontrol_yazi = driver.findElement(By.xpath("//li[@class='nav-item']//a[@class='nav-link disabled']"));
        Assert.assertTrue(kontrol_yazi.getText().contains("John Smith"));
    }

    @Test(priority = 2)
    public void CatalogTest() {


        WebElement catalog = driver.findElement(By.cssSelector("[class='nav-icon fas fa-book']"));
        catalog.click();
        WebElement attributes = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[6]"));
        wait.until(ExpectedConditions.elementToBeClickable(attributes));
        Assert.assertTrue(attributes.isDisplayed());

        WebElement sales = driver.findElement(By.cssSelector("[class='nav-icon fas fa-shopping-cart']"));
        sales.click();
        WebElement cart = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[12]"));
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        Assert.assertTrue(cart.isDisplayed());

        WebElement customer = driver.findElement(By.cssSelector("[class='nav-icon far fa-user']+p"));
        customer.click();
        WebElement request = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[19]"));
        wait.until(ExpectedConditions.elementToBeClickable(request));
        Assert.assertTrue(request.isDisplayed());

        WebElement promotion = driver.findElement(By.cssSelector("[class='nav-icon fas fa-tags']+p"));
        promotion.click();
        WebElement campaigns = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[23]"));
        wait.until(ExpectedConditions.elementToBeClickable(campaigns));
        Assert.assertTrue(campaigns.isDisplayed());

        WebElement contentManagement = driver.findElement(By.cssSelector("[class='nav-icon fas fa-cubes']+p"));
        contentManagement.click();
        WebElement forums = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[31]"));
        wait.until(ExpectedConditions.elementToBeClickable(forums));
        Assert.assertTrue(forums.isDisplayed());

        WebElement configuration = driver.findElement(By.cssSelector("[class='nav-icon fas fa-cogs']+p"));
        configuration.click();
        WebElement allPlugins = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[49]"));
        wait.until(ExpectedConditions.elementToBeClickable(allPlugins));
        Assert.assertTrue(allPlugins.isDisplayed());

        WebElement system = driver.findElement(By.cssSelector("[class='nav-icon fas fa-cube']+p"));
        system.click();
        WebElement templates = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[57]"));
        wait.until(ExpectedConditions.elementToBeClickable(templates));
        Assert.assertTrue(templates.isDisplayed());

        WebElement report = driver.findElement(By.cssSelector("[class='nav-icon fas fa-chart-line']+p"));
        report.click();
        WebElement customerReports = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[63]"));
        wait.until(ExpectedConditions.elementToBeClickable(customerReports));
        Assert.assertTrue(customerReports.isDisplayed());

        WebElement help = driver.findElement(By.cssSelector("[class='nav-icon fas fa-question-circle']+p"));
        help.click();
        WebElement solutionPartners = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[71]"));
        wait.until(ExpectedConditions.elementToBeClickable(solutionPartners));
        Assert.assertTrue(solutionPartners.isDisplayed());

    }

    @Test(priority = 3)
    public void CreateCustomerTest() {
        WebElement customers = driver.findElement(By.cssSelector("[class='nav-icon far fa-user']+p"));
        customers.click();

        WebElement customersBtn = driver.findElement(By.xpath("(//i[@class='nav-icon far fa-dot-circle'])[13]"));
        customersBtn.click();

        WebElement addNewBtn = driver.findElement(By.cssSelector("[class='btn btn-primary']"));
        addNewBtn.click();

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("ayy@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("12345");

        WebElement firstname = driver.findElement(By.id("FirstName"));
        firstname.sendKeys("aaaa");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("bbbb");

        WebElement gender = driver.findElement(By.id("Gender_Male"));
        gender.click();

        WebElement dateBirth = driver.findElement(By.id("DateOfBirth"));
        dateBirth.sendKeys("1/8/1999");

        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("dell");

        WebElement Tax = driver.findElement(By.id("IsTaxExempt"));
        Tax.click();

        WebElement newsletter = driver.findElement(By.xpath("//input[@class='k-input k-readonly']"));
        newsletter.click();

        WebElement customerReports = driver.findElement(By.xpath("(//ul[@class='k-list k-reset'])[1]//li"));
        wait.until(ExpectedConditions.elementToBeClickable(customerReports));

        WebElement menu = driver.findElement(By.xpath("(//ul[@class='k-list k-reset'])[1]//li"));
        menu.click();

        WebElement customerRoles = driver.findElement(By.id("SelectedCustomerRoleIds"));
        Select menu2 = new Select(customerRoles);
        menu2.selectByIndex(3);

        WebElement managerVendor = driver.findElement(By.id("VendorId"));
        Select menu3 = new Select(managerVendor);
        menu3.selectByIndex(2);

        WebElement adminComment = driver.findElement(By.id("AdminComment"));
        adminComment.sendKeys("dddddd");

        WebElement saveBtn = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        saveBtn.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissable']"))));
        WebElement msg = driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissable']"));

        Assert.assertTrue(msg.getText().contains("successfully"));

    }

    @Test(priority = 4)
    public void EditCustomerTest() {

        WebElement customers = driver.findElement(By.cssSelector("[class='nav-icon far fa-user']+p"));
        customers.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='SearchEmail']"));
        email.sendKeys("ayy@gmail.com");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='SearchFirstName']"));
        firstName.sendKeys("aaaa");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='SearchLastName']"));
        lastName.sendKeys("bbbb");

        WebElement search = driver.findElement(By.xpath("//button[@id='search-customers']"));
        search.click();

        WebElement avtiveSign = driver.findElement(By.xpath("//i[@class='fas fa-check true-icon']"));

        Assert.assertTrue(avtiveSign.isDisplayed());

        WebElement editBtn = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        editBtn.click();

        WebElement adminComment = driver.findElement(By.id("AdminComment"));
        adminComment.clear();
        adminComment.sendKeys("eee");

        WebElement saveBtn = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        saveBtn.click();

        WebElement updateMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));
        Assert.assertTrue(updateMsg.getText().contains("updated"));

    }

    @Test(priority = 5)
    public void DeleteCustomerTest() {

        WebElement customers = driver.findElement(By.cssSelector("[class='nav-icon far fa-user']+p"));
        customers.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='SearchEmail']"));
        email.sendKeys("ayy@gmail.com");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='SearchFirstName']"));
        firstName.sendKeys("aaaa");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='SearchLastName']"));
        lastName.sendKeys("bbbb");

        WebElement search = driver.findElement(By.xpath("//button[@id='search-customers']"));
        search.click();


        WebElement editBtn = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        editBtn.click();

        WebElement deleteBtn1 = driver.findElement(By.xpath("(//span[@id='customer-delete'])[1]"));
        deleteBtn1.click();


        WebElement deleteBtn2 = driver.findElement(By.xpath("//button[@class='btn btn-danger float-right']"));
        deleteBtn2.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"))));

        WebElement deleteMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"));
        Assert.assertTrue(deleteMsg.getText().contains("deleted"));

    }

    @Test(priority = 6)
    public void SearchTest() {

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='form-control admin-search-box typeahead tt-input']"));
        searchBox.click();
        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar
                .moveToElement(searchBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("S")
                .keyUp(Keys.SHIFT)
                .sendKeys("hipments")
                .build();

        aksiyon.perform();

        WebElement shipmentText = driver.findElement(By.xpath("//h1[@class='float-left']"));
        Assert.assertTrue(shipmentText.isDisplayed());






}}