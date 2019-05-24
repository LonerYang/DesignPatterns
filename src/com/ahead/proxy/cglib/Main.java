package com.ahead.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * cglib动态代理是通过继承出子类来实现的
 * @author Yang
 * @version 1.0
 * @time 2019/5/24
 */
public class Main {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Tank.class);
		//TimeMethodInterceptor作用相当于jdk动态代理里面的InvocationHandler
		enhancer.setCallback(new TimeMethodInterceptor());
		Tank tank = (Tank) enhancer.create();
		tank.move();
	}
}

class TimeMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		//父类是Tank
		System.out.println(o.getClass().getSuperclass().getName());
		System.out.println("before");
		Object result = null;
		//执行父类的方法
		result = methodProxy.invokeSuper(o, objects);
		System.out.println("after");
		return result;
	}
}

class Tank {
	public void move() {
		System.out.println("Tank moving claclacla...");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
