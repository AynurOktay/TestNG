package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {


    @Test(dataProvider = "data")
    void UserNameTest(String username){
        System.out.println("username="+username);

    }
    @DataProvider
    public Object[]data(){

        Object[] users={"Nurhayat", "Alper","Ugur" ,"Hakan"};

        return users;
    }
    @Test(dataProvider ="datalarim1" )
    void UserNameTest1(int id){
        System.out.println("useradi = " + id);
    }

    @DataProvider // bu metoda dataprovider görevi verildi.
    Object[] datalarim1() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        Object[] userlar={1,2,3,4};

        return userlar;
    }

}
