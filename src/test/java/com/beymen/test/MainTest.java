package com.beymen.test;

import com.beymen.driver.BaseTest;
import com.beymen.page.CartPage;
import com.beymen.page.HomePage;
import com.beymen.page.ProductPage;
import com.beymen.page.SearchPage;
import org.junit.Test;

public class MainTest extends BaseTest {

    @Test
    public void mainTest(){
        HomePage homePage=new HomePage();
        SearchPage searchPage=new SearchPage();
        ProductPage productpage=new ProductPage();
        CartPage cartPage=new CartPage();

        homePage.home();
        homePage.searchProduct();

        searchPage.scrollAndSelect();

        productpage.addToCart();
        productpage.priceControl();

        cartPage.increaseCartItem();
        cartPage.clearCart();
    }
}
