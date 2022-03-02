package com.beymen.test;

import com.beymen.driver.BaseTest;
import com.beymen.page.HomePage;
import org.junit.Test;

public class HomeTest extends BaseTest {

    @Test
    public void homeTest() {
        HomePage homePage = new HomePage();
        homePage.home();
        homePage.searchProduct();
    }
}
