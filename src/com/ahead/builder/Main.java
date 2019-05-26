package com.ahead.builder;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class Main {
	public static void main(String[] args) {
//		TerrainBuilder terrainBuilder = new BigTerrainBuilder();
		TerrainBuilder terrainBuilder = new SmallTerrainBuilder();
		Terrain terrain = terrainBuilder.builderWall().buildFort().buildMine().build();

		Person person = new Person.PersonBuilder()
				.buildBasic(1, "Yang", 18)
				.buildWeight(120.00)
				.buildLocation("先锋", 100)
					.build();

	}
}
