package com.snakenladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.snakenladder.models.Player;
import com.snakenladder.service.SnakenLadderService;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the board size");
		int size=sc.nextInt();
		
		System.out.println("Enter total number of snakes to be added");
		int totsnks = sc.nextInt();
		Map<Integer,Integer> snakes = new HashMap<>();
		for (int i = 0; i < totsnks; i++) {
			System.out.println("Enter snake "+(i+1)+" starting position and ending position");
			snakes.put(sc.nextInt(), sc.nextInt());
		}
		System.out.println("Enter total number of ladders to be added");
		int totladders = sc.nextInt();
		Map<Integer,Integer> ladders = new HashMap<>();
		for (int i = 0; i < totladders; i++) {
			System.out.println("Enter ladder number "+(i+1)+" starting and ending position ");
			ladders.put(sc.nextInt(), sc.nextInt());
		}
		System.out.println("Enter total number of players to be added");
		int totplayers = sc.nextInt();
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < totplayers; i++) {
			System.out.println("Enter  player "+(i+1)+ " name");
			players.add(new Player(sc.next()));
		}
		

		SnakenLadderService snakenLadderService = new SnakenLadderService(size);

		snakenLadderService.setLadders(ladders);
		snakenLadderService.setSnakes(snakes);
		snakenLadderService.setPlayers(players);

		snakenLadderService.startGame();
        sc.close();
       		
	}

}
