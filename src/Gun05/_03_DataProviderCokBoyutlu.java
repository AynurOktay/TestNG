package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProviderCokBoyutlu {


    @Test(dataProvider = "credentials")
    void UsernameTest(String username, String password) {

        System.out.println("user=" + username + " " + password);
    }

    @DataProvider
    public Object[][] credentials() {

        Object[][] data = {
                {"Nurhayat", "122333"},
                {"Aynur", "2333"},
                {"Ismet", "1333"},
                {"Hakan", "1223"}
        };
        return data;

    }
}