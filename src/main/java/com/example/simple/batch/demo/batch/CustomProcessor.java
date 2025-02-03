package com.example.simple.batch.demo.batch;

import org.springframework.batch.item.ItemProcessor;

     // later this processor will read customerName as a string,creates customer object and save in DB
public class CustomProcessor implements ItemProcessor<String,String> {
    @Override
    public String process(String item) throws Exception {
        item = item.toUpperCase() + " faheem";
        System.out.println("Data when processed --> "+item);
        return item;
    }
}
