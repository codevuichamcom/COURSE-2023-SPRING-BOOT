package com.funnycode.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("tshirt")
public class TShirt implements IOutfit {

    @Override
    public void wear() {
        System.out.println("Đang mặc T shirt");
    }
}
