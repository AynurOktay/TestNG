package Gun02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.Test;

public class _04_SubscribeNewsletter extends BaseDriver {

   /*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
 */


    @Test
    public void Test2() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.Bekle(2);


    }
}
