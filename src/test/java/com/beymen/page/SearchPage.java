package com.beymen.page;

import com.beymen.methods.Methods;
import org.openqa.selenium.By;

public class SearchPage {
    Methods methods;

    public SearchPage(){
        methods=new Methods();
    }
    public void scrollAndSelect(){
        methods.scrollWithAction(By.xpath("//button[@id='moreContentButton']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#moreContentButton"));
        methods.waitBySeconds(2);
        methods.clickRandomElement(By.cssSelector("div[class='col-sm-4 col-md-4 col-lg-4 o-productList__itemWrapper']"));
    }
}

