package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {


    @Test
    void startCar(){
        System.out.println("startCar");

        //Assert.fail();
    }
    @Test(dependsOnMethods = {"startCar"})//Bu testin calismasi statCar in hatasiz calismasina bagli
    void driveCar(){
        System.out.println("driveCar");
    }
    @Test(dependsOnMethods = {"startCar" ,"driveCar"})
    void parkCar(){
        System.out.println("parkCar");
    }
    //alwaysRun =true bagimliklari var ama hata cikarsa da yine calisir
    @Test(dependsOnMethods = {"parkCar" },alwaysRun = true)
    void stopCar(){
        System.out.println("stopCar");
    }
    //ayni seviyedeki testler icicn priority verilebilir
    //bagimli testler,direk metodundan calistirdiginizda bagimli oldugu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.


}
