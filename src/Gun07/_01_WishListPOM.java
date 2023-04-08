package Gun07;

import Utility.BaseDriver;
import Gun06._03_PlaceOrderElements;
import Utility.MyFunc;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_WishListPOM extends BaseDriver {


    @Test
    @Parameters("searchText")
    void addToWishList(String text) {

        _03_PlaceOrderElements poe = new _03_PlaceOrderElements();

        poe.searchBox.sendKeys(text);
        poe.searchButton.click();

        _02_WishListElements wle = new _02_WishListElements();

        int randomSecim = MyFunc.RandomGenerator(wle.searhResult.size());
        String wishItemText = wle.searhResult.get(randomSecim).getText();
        wle.wishBtnList.get(randomSecim).click();
        wle.btnWisthProducts.click();
       MyFunc.listContainsString(wle.wishTableNames, wishItemText);

    }

}
