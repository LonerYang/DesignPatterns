package com.ahead.builder;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class BigTerrainBuilder implements TerrainBuilder {
	Terrain terrain = new Terrain();

	@Override
	public TerrainBuilder builderWall() {
		terrain.wall = new Wall(100, 100, 500, 500);
		return this;
	}

	@Override
	public TerrainBuilder buildFort() {
		terrain.fort = new Fort(100, 100, 500, 500);
		return this;
	}

	@Override
	public TerrainBuilder buildMine() {
		terrain.mine = new Mine(100, 100, 500, 500);
		return this;
	}

	@Override
	public Terrain build() {
		return terrain;
	}
}
