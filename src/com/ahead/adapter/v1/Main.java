package com.ahead.adapter.v1;

import java.io.*;

/**
 * AdapterXXX类不是适配器模式(什么设计模式都不是，只是编程的一种技巧)
 * Adapter模式应用的地方：
 * 		1、Java访问SQL Server：SQL Server需要ODBC技术来访问，所以Java中的JDBC要借助JDBC-ODBC-bridge再加上ODBC才能访问SQL Server
 * 		2、小米6的Type-c接口，小米6只有充电口没有耳机孔，可以通过Type-c接口一边连接耳机，一边连接手机的充电孔
 * 		3、Java中的IO InputStreamReader也充当了适配器的角色，InputStream是无法执行readLine的方法的，可以通过InputStreamReader来适配
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class Main {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(new File("D:/workspaces/核心技术点/DesignPatterns/README.md"));
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);
		String result = "";
		String line = "";
		while((line = reader.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
		reader.close();
	}
}
