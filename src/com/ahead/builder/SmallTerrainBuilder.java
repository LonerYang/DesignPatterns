package com.ahead.builder;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/26
 */
public class SmallTerrainBuilder implements TerrainBuilder {
	Terrain terrain = new Terrain();

	@Override
	public TerrainBuilder builderWall() {
		terrain.wall = new Wall(10, 10, 50, 50);
		return this;
	}

	@Override
	public TerrainBuilder buildFort() {
		terrain.fort = new Fort(10, 10, 50, 50);
		return this;
	}

	@Override
	public TerrainBuilder buildMine() {
		terrain.mine = new Mine(10, 10, 50, 50);
		return this;
	}

	@Override
	public Terrain build() {
		return terrain;
	}
}