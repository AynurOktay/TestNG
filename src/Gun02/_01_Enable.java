package Gun02;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {

   @Test
   void test1(){
      System.out.println("Test 1");
   }


   @Test(enabled=false)
   void test2(){
      System.out.println("Test 2");
   }  //bu testi beklemeye aliyoruz,calistirmiyoruz.disable yapiyoruz

   @Test
   void test3(){
      System.out.println("Test 3");
   }
   @BeforeClass
   void baslangicIslemleri(){
      {
       // KalanOncekileriKapat();

         //Outputun loglarini kaldiran kod.Her bilgiyi bana verme,sadece errorlari ver dedik
         Logger logger=Logger.getLogger("");
         logger.setLevel(Level.SEVERE);

         //Outputtaki(konsoldaki) gerekmeyen loglari kaldirmak icin:
         System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

         ChromeDriver driver = new ChromeDriver();


         driver.manage().window().maximize(); //acildiginda web sayfasini maximize yapip tam ekran yapar

         Duration dr=Duration.ofSeconds(30);
         driver.manage().timeouts().pageLoadTimeout(dr);
         // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
         //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
         // eğer 2 sn yüklerse 30 sn. beklemez.

         driver.manage().timeouts().implicitlyWait(dr);
         // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
         // hazır hale gelmesi icin  verilen süre.O elemani bulmasi icin biraz süre  tanir
         // eğer 2 sn yüklerse 30 sn. beklemez.*/

      }}


   }



