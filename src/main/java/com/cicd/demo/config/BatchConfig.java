package com.cicd.demo.config;

import com.cicd.demo.tasklet.DemoTasklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    //JobBuilderのFactoryクラス
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    //StepBuilderのFactoryクラス
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private static final Logger log = LoggerFactory.getLogger(BatchConfig.class);

    @Bean
    public Job fooJob() {
        log.info("fooJob メソッドを実行");
        return jobBuilderFactory.get("myFooJob") // 一意となる任意のジョブ名を指定
                .flow(helloStep()) // 実行する Step を指定
                .end()
                .build();
    }

    @Bean
    public Job barJob() {
        log.info("barJob メソッドを実行");
        return jobBuilderFactory.get("myBarJob") // 一意となる任意のジョブ名を指定
                .flow(helloStep()) // 実行する Step を指定
                .next(worldStep()) // 実行する Step を指定
                .end()
                .build();
    }

    @Bean
    public Step helloStep() {
        log.info("helloStep メソッドを実行");
        return stepBuilderFactory.get("myHelloStep") // 任意のステップ名を指定
                .tasklet(new DemoTasklet("＄＄＄Hello＄＄＄")) // 実行する Tasklet を指定
                .build();
    }

    @Bean
    public Step worldStep() {
        log.info("worldStep メソッドを実行");
        return stepBuilderFactory.get("myWorldStep") // 任意のステップ名を指定
                .tasklet(new DemoTasklet("％％％World％％％")) // 実行する Tasklet を指定
                .build();
    }
}