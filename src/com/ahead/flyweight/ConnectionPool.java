package com.ahead.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
public class ConnectionPool {
	private Map<String, Connection> connectionMap = new HashMap<>();

	public Connection getConnection(String key) {
		//如果连接池中包含这个连接就直接返回
		if (connectionMap.containsKey(key)) {
			return connectionMap.get(key);
		} else {
			//不包含创建一个然后添加新连接池中
			Connection connection = new Connection();
			connectionMap.put(key, connection);
			return connection;
		}
	}
	private class Connection {
		private String id;

		Connection() {
			id = UUID.randomUUID().toString();
		}

		@Override
		public String toString() {
			return "Connection{" +
					"id='" + id + '\'' +
					'}';
		}
	}

	public static void main(String[] args) {
		ConnectionPool pool = new ConnectionPool();
		Connection connection1 = pool.getConnection("c1");
		Connection connection2 = pool.getConnection("c1");
		System.out.println(connection1 == connection2);
		System.out.println(connection1);
	}
}

