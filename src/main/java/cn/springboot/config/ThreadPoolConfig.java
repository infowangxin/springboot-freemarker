package cn.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 胡桃夹子
 * @date 2021-12-02 17:33
 */
@Configuration
public class ThreadPoolConfig {


    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(2);
        //设置最大线程数
        taskExecutor.setMaxPoolSize(10);
        //设置线程空闲等待时间
        taskExecutor.setKeepAliveSeconds(3000);
        //设置任务等待队列的大小
        taskExecutor.setQueueCapacity(100);
        // 设置线程池内线程名称的前缀-------阿里编码规约推荐--方便出错后进行调试
        taskExecutor.setThreadNamePrefix("site-tool-task-");
        //设置任务的拒绝策略，RejectedExecutionHandler类型的变量，表示线程池的饱和策略。
        //如果阻塞队列满了并且没有空闲的线程，这时如果继续提交任务，就需要采取一种策略处理该任务。线程池提供了4种策略：
        //AbortPolicy：直接抛出异常，这是默认策略；
        //CallerRunsPolicy：用调用者所在的线程来执行任务；
        //DiscardOldestPolicy：丢弃阻塞队列中靠最前的任务，并执行当前任务；
        //DiscardPolicy：直接丢弃任务；
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化
        taskExecutor.initialize();
        return taskExecutor;
    }
}
