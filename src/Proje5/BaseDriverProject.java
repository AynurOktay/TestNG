package Proje5;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverProject

{
    public  WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemler(String browserTipi)
    {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        if (browserTipi.equalsIgnoreCase("firefox"))
        {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver=new FirefoxDriver();
        }
        else if(browserTipi.equalsIgnoreCase("safari"))
        {
            driver=new SafariDriver();
        }
        else
        {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://admin-demo.nopcommerce.com/login%22)");

    }

    @AfterClass
    public void bitisIslemleri()
    {
        MyFunc.Bekle(5);
        driver.quit();
    }
}