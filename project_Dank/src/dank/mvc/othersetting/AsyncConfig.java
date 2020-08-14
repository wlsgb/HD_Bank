package dank.mvc.othersetting;

import java.util.concurrent.Executor;

import javax.annotation.Resource;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

	/** 기본 Thread 수  */
    private static int TASK_CORE_POOL_SIZE = 2;
    /** 최대 Thread 수 */
    private static int TASK_MAX_POOL_SIZE = 5;
    /** QUEUE 수 */
    private static int TASK_QUEUE_CAPACITY = 0;
    /** Thread Bean Name */
    private static String EXECUTOR_BEAN_NAME = "autoTransferExecutor";
    /** Thread */
    @Resource(name = "autoTransferExecutor")
    private ThreadPoolTaskExecutor executorAutoTransfer;
	
	
	
	
	@Bean(name="autoTransferExecutor")
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(TASK_CORE_POOL_SIZE);
		executor.setMaxPoolSize(TASK_MAX_POOL_SIZE);
        executor.setQueueCapacity(TASK_QUEUE_CAPACITY);
        executor.setBeanName(EXECUTOR_BEAN_NAME);
        executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
	}
	/**
     * Thread 등록 가능 여부
     *
     * @return 실행중인 task 개수가 최대 개수(max + queue)보다 크거나 같으면 false
     */
    public boolean isTaskExecute() {
        boolean rtn = true;
 
        System.out.println("EXECUTOR_SAMPLE.getActiveCount() : " + executorAutoTransfer.getActiveCount());
 
        // 실행중인 task 개수가 최대 개수(max + queue)보다 크거나 같으면 false
        if (executorAutoTransfer.getActiveCount() >= (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)) {
            rtn = false;
        }
 
        return rtn;
    }
 
    /**
     * thread 등록 가능 여부
     *
     * @param createCnt : 생성 개수
     * @return 실행중인 task 개수 + 실행할 개수가 최대 개수(max + queue)보다 크면 false
     */
    public boolean isTaskExecute(int createCnt) {
        boolean rtn = true;
 
        // 실행중인 task 개수 + 실행할 개수가 최대 개수(max + queue)보다 크거나 같으면 false
        if ((executorAutoTransfer.getActiveCount() + createCnt) > (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)) {
            rtn = false;
        }
 
        return rtn;
    }
    
    public String isTaskName() {
    	//String groups =executorAutoTransfer.getThreadGroup().getName();
    	String prefixname = executorAutoTransfer.getThreadNamePrefix();
    	
    	return prefixname.toString();//groups.toString();//+prefixname.toString();
    }
}
