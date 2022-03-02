package com.beymen.page;

import com.beymen.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;
    Logger logger= LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        methods=new Methods();
    }

    public void addToCart(){
        methods.waitBySeconds(4);
        methods.clickRandomElement(By.cssSelector("span[class='m-variation__item']"));
        methods.click(By.id("addBasket"));
        methods.waitBySeconds(3);
    }
    public void priceControl(){
        String price=methods.getText(By.id("priceNew"));
        System.out.println("Sayfa Fiyatı: "+ price);

        methods.click(By.cssSelector(".icon.icon-cart"));
        methods.waitBySeconds(2);
        String cartPrice=methods.getText(By.cssSelector(".m-productPrice__salePrice"));
        System.out.println("Sepet Fiyatı: " + cartPrice);
        Assert.assertEquals(price,cartPrice);
        logger.info("Fiyat karşılaştırması: " +price+cartPrice);

    }
}
