package com.example.simple.batch.demo.batch;

import org.springframework.batch.item.ItemReader;

public class CustomReader implements ItemReader<String> {

    private String[] customersNames = {"luca","francesco","cesare","toni","raffa","giuseppe"};
    private int index =0;
    @Override
    public String read() throws Exception {

        if(index>= customersNames.length){
            return null;
        }
        String customerName = index + " : " + customersNames[index];
        index++;

        System.out.println("Reading data --> "+ customerName);
        return customerName;
    }
}
