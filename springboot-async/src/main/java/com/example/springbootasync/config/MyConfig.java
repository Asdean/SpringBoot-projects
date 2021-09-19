package com.example.springbootasync.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync // 开启异步执行
@Configuration
public class MyConfig {

    private static final Logger logger = LoggerFactory.getLogger(MyConfig.class);

    /**
     * 可以覆盖springboot中默认的线程池
     *
     * 或者使用springboot中默认的线程池,在配置文件里修改属性值
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor asyncExecutor() {
        logger.info("start asyncExecutor......");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(16);
        //配置最大线程数
        executor.setMaxPoolSize(64);
        //配置队列大小
        executor.setQueueCapacity(9999);
        //配置线程池中的线程的名称前缀 (指定一下线程名的前缀)
        executor.setThreadNamePrefix("my-async-");
        // rejection-policy：当pool已经达到max pool size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
