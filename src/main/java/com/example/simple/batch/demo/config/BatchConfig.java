package com.example.simple.batch.demo.config;

import com.example.simple.batch.demo.batch.CustomProcessor;
import com.example.simple.batch.demo.batch.CustomReader;
import com.example.simple.batch.demo.batch.CustomWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    //Job bean
     @Bean
    Job createJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){
    return new JobBuilder("job",jobRepository)
            .flow(createStep(jobRepository,transactionManager)).end().build();
     }

    // Step bean
    @Bean
     Step createStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
         return new StepBuilder("step",jobRepository)
                 .<String,String> chunk(2,transactionManager)
                 .allowStartIfComplete(true)
                 .reader(new CustomReader())
                 .processor(new CustomProcessor())
                 .writer(new CustomWriter())
                 .build();
     }





}
