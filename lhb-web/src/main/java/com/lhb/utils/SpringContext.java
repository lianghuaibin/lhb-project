package com.lhb.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring context
 * 
 * @author Administrator
 * 
 */
@Component
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext contextArgu)
			throws BeansException {
		context = contextArgu;
	}
	
	/**
	 * 根据BeanID获取Spring容器中的bean
	 * 
	 * @param beanID
	 * @return
	 */
	public static Object getBean(String beanID) {
		Object obj = null;
		if (beanID != null) {
			obj = context.getBean(beanID);
		}
		return obj;
	}

	/**
	 * 根据类名获取容器中的bean
	 * 
	 * @param <T>
	 * @param clz
	 * @return
	 */
	public static <T> T getBean(Class<T> clz) {
		return (T) context.getBean(clz);
	}
	
}
