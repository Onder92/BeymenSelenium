package com.beymen.page;

import com.beymen.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;


public class HomePage {

    Methods methods;
    Logger logger= LogManager.getLogger(ProductPage.class);

    public HomePage(){
        methods=new Methods();
    }

    public void home(){

        methods.waitBySeconds(3);
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".o-header__userInfo")));
        String homeControl=methods.getText(By.cssSelector(".o-header__userInfo"));
        System.out.println(homeControl);
        logger.info("Alınan text: "+homeControl);
    }

    public void searchProduct(){
        methods.sendKeys(By.cssSelector("input[class='default-input o-header__search--input']"),"pantolon");
        methods.pressEnter(By.cssSelector("input[class='default-input o-header__search--input']"));
    }

}

