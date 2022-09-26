package com.cicd.demo.tasklet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.sql.*;

@NoArgsConstructor
@AllArgsConstructor
public class DemoTasklet implements Tasklet {
    private static final Logger log = LoggerFactory.getLogger(DemoTasklet.class);
    private String message;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        // データベースに接続
//        Connection conn;
//
//        try {
//
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://database-1.cjs3txxw4gba.ap-northeast-1.rds.amazonaws.com:3306/database-1",
//                    "admin",
//                    "mypassword"
//            );
//
//            try {
//                // SQL文の実行
//                System.out.println("JDBCデータベース接続成功");
//                System.out.println("conn = " + conn);
//                conn.close();
//            }
//            finally {
//                // 直前の try ブロックに入ったら、ここは必ず実行される
//                conn.close();
//            }
//        } catch (SQLException ex) {
//            // 接続できない時
//        }
        System.out.println("DemoTasklet!!!" + message);
        return RepeatStatus.FINISHED;
    }
}
