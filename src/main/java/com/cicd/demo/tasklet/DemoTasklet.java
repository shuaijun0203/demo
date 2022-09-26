package com.cicd.demo.tasklet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@NoArgsConstructor
@AllArgsConstructor
public class DemoTasklet implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(DemoTasklet.class);
    private String message;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.out.println("DemoTasklet!!!" + message);
        return RepeatStatus.FINISHED;
    }
}
