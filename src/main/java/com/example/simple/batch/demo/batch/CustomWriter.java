package com.example.simple.batch.demo.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class CustomWriter implements ItemWriter<String> {
    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        for (String str : chunk){
            System.out.println("Data is being written --> "+ str);
        }


        System.out.println("Completed writing data.");
        System.out.println("#####################################################################");
    }
}
