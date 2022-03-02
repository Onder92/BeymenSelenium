package com.beymen.test;

import com.beymen.driver.BaseTest;
import com.beymen.page.SearchPage;
import org.junit.Test;

public class SearchPageTest extends BaseTest {

    @Test
    public void searchPageTest(){
        SearchPage searchPage=new SearchPage();
        searchPage.scrollAndSelect();
    }
}
