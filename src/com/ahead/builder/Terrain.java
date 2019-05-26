package com.ahead.builder;

/**
 * 地形
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class Terrain {
	Wall wall;
	Fort fort;
	Mine mine;
}

class Wall {
	int x, y, width, height;

	Wall(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Fort {
	int x, y, width, height;

	Fort(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Mine {
	int x, y, width, height;

	Mine(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
