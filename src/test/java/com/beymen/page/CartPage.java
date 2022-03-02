package com.beymen.page;

import com.beymen.methods.Methods;
import org.openqa.selenium.By;

public class CartPage {
    Methods methods;

    public CartPage(){
        methods=new Methods();
    }

    public void increaseCartItem(){
        methods.selectByValue(By.id("quantitySelect0"), "2");
    }
    public void clearCart(){
        methods.click(By.id("removeCartItemBtn0"));
        //String cartStatus=methods.getText(By.id("m-empty__messageTitle"));
        System.out.println(methods.getText(By.id("quantitySelect0")));
        System.out.println(methods.getText(By.cssSelector("div[id='emtyCart'] strong[class='m-empty__messageTitle']")));
    }
}
