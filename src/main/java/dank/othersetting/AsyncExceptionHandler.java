package main.java.dank.othersetting;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		 	System.out.println("==============>>>>>>>>>>>> THREAD ERROR");
	        System.out.println("Exception Message :: " + ex.getMessage());
	        System.out.println("Method Name :: " + method.getName());
	        for (Object param : params) {
	            System.out.println("Parameter Value :: " + param);
	        }
	        
	        
	        System.out.println("==============>>>>>>>>>>>> THREAD ERROR END");
		
	}

}
