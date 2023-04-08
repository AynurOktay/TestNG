package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    void hardAssert() {

        String s1 = "Merhaba";

        Assert.assertEquals("Merhaba", s1, "Expected und actual results are different");

    }

    @Test
    void softAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert = new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); //true
        _softAssert.assertEquals("www.facebook.com/profile", strCartPage);   //false
        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount); //false

        _softAssert.assertAll();  //butun assrtleri aktif ediyor,sonuclari isleme koyuyor

    }

}
