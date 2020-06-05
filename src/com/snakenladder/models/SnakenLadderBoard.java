package com.snakenladder.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakenLadderBoard {
	int size;
	private Map<Integer,Integer> snakes;
	private Map<Integer,Integer> ladders;
	private Map<String, Integer> positions;

	public SnakenLadderBoard(int size) {
		this.size = size;
		this.ladders = new HashMap<>();
		this.snakes = new HashMap<>();
		this.positions =new HashMap<>();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Map<Integer,Integer> getLadders() {
		return ladders;
	}

	public void setLadders(Map<Integer,Integer> ladders) {
		this.ladders = ladders;
	}

	public Map<Integer,Integer> getSnakes() {
		return snakes;
	}

	public void setSnakes(Map<Integer,Integer> snakes) {
		this.snakes = snakes;
	}

	public Map<String, Integer> getPositions() {
		return positions;
	}

	public void setPositions(Map<String, Integer> positions) {
		this.positions = positions;
	}
	
	
	

}
