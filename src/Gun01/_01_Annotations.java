package Gun01;

import org.testng.annotations.Test;

public class _01_Annotations {

  /*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */

    @Test(priority =1)  //proruty bisey yazmazsak ,default =0 (index gibi)
    void webSitesiniAc(){
        System.out.println("Test 1");
    }

    @Test(priority =2)
    void loginYap(){
        System.out.println("Test 2");
    }

    @Test(priority =3)
    void driveriKapat(){
        System.out.println("Test 3");
    }
//eger priority yazmassak,alfabetik calisir









}
