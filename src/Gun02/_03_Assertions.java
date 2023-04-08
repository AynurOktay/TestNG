package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void EqualsOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba1";

        //Actual(olusan,Expected (beklenen) ,Mesaj(opsiyonel))  -TestNg de asertion da siralama bu sekilde
        Assert.assertEquals(s1, s2, "Olusanla beklenen esit degil");
       //Assert.assertEquals(driver.getTitle() ,"My Account" , " Login olamadi")
    }
    @Test
    void notEqualsOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba1";
        Assert.assertNotEquals(s1, s2, "Olusanla beklenen esit oldu");

    }

        @Test
    void TrueOrnek() {
        int s1 = 55;
        int s2 = 66;

        Assert.assertTrue(s1 == s2, "Olusa ve beklenen  esit olmadi");

    }
    @Test
    void nullOrnek() {

        String s1 = null;
        Assert.assertNull(s1, "Olusan Null olmadi");
    }
    @Test
    void direkFail() {
        int a=55;
        if (a==55)
            Assert.fail();  //Assert fail("hata olustu")

    }
}
