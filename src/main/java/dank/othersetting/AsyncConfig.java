package main.java.dank.othersetting;

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

	/** �⺻ Thread ��  */
    private static int TASK_CORE_POOL_SIZE = 2;
    /** �ִ� Thread �� */
    private static int TASK_MAX_POOL_SIZE = 5;
    /** QUEUE �� */
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
     * Thread ��� ���� ����
     *
     * @return �������� task ������ �ִ� ����(max + queue)���� ũ�ų� ������ false
     */
    public boolean isTaskExecute() {
        boolean rtn = true;
 
        System.out.println("EXECUTOR_SAMPLE.getActiveCount() : " + executorAutoTransfer.getActiveCount());
 
        // �������� task ������ �ִ� ����(max + queue)���� ũ�ų� ������ false
        if (executorAutoTransfer.getActiveCount() >= (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)) {
            rtn = false;
        }
 
        return rtn;
    }
 
    /**
     * thread ��� ���� ����
     *
     * @param createCnt : ���� ����
     * @return �������� task ���� + ������ ������ �ִ� ����(max + queue)���� ũ�� false
     */
    public boolean isTaskExecute(int createCnt) {
        boolean rtn = true;
 
        // �������� task ���� + ������ ������ �ִ� ����(max + queue)���� ũ�ų� ������ false
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
