package com.snakenladder.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import com.snakenladder.models.Player;
import com.snakenladder.models.SnakenLadderBoard;

public class SnakenLadderService {

	private Queue<Player> players;
	private SnakenLadderBoard snakenLadderBoard;
	private int boardSize;

	public SnakenLadderService(int boardSize) {
		super();
		this.players = new LinkedList<>();
		this.snakenLadderBoard = new SnakenLadderBoard(boardSize);
		this.boardSize = boardSize;
	}

	public void setLadders(Map<Integer, Integer> ladders) {
		snakenLadderBoard.setLadders(ladders);
	}

	public void setSnakes(Map<Integer, Integer> snakes) {
		snakenLadderBoard.setSnakes(snakes);
	}

	public void setPlayers(List<Player> players) {
		this.players = new LinkedList<>();
		Map<String, Integer> mp = new HashMap<>();
		for (Player player : players) {
			this.players.add(player);
			mp.put(player.getName(), 0);
		}
		snakenLadderBoard.setPositions(mp);

	}

	public void startGame() {
		while (true) {
			Player currentPlayer = players.poll();
			System.out.println(currentPlayer.getName() + " Rolling the dice");
			int number = roll();
			int currentPosition = changeMove(currentPlayer, number);
			if (hasPlayerWon(currentPosition)) {
				System.out.println(currentPlayer.getName() + " Won the game");
				break;
			} else {
				players.add(currentPlayer);
			}

			System.out.println(currentPlayer.getName() + " moves to " + currentPosition);

		}

	}

	private boolean hasPlayerWon(int currentPosition) {

		if (currentPosition == boardSize) {
			return true;
		}
		return false;
	}

	private int changeMove(Player currentPlayer, int number) {
		int prevPosition = snakenLadderBoard.getPositions().get(currentPlayer.getName());
		int curPosition = prevPosition + number;
		int newPos = curPosition;
		if (prevPosition + number > boardSize) {
			newPos = prevPosition;
		} else {
			Map<Integer, Integer> snakes = snakenLadderBoard.getSnakes();
			if (snakes.containsKey(curPosition)) {
				newPos = snakes.get(curPosition);
			}
			Map<Integer, Integer> ladders = snakenLadderBoard.getLadders();
			if (ladders.containsKey(curPosition)) {
				newPos = ladders.get(curPosition);
			}
		}
		snakenLadderBoard.getPositions().put(currentPlayer.getName(), newPos);
		return newPos;
	}
	
	public static int roll() {
		int val = new Random().nextInt(6);
		return val;
	}

}
