package com.ahead.builder;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public interface TerrainBuilder {
	TerrainBuilder builderWall();

	TerrainBuilder buildFort();

	TerrainBuilder buildMine();

	Terrain build();
}
