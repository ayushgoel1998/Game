package com.example.demo.controller;

import com.example.demo.entity.Player;
import com.example.demo.service.GameService;
import com.example.demo.service.GameSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


@RestController
public class SnakeLadderController {

    @Autowired
    private GameSimulationService gameSimulationService;

    @Autowired
    private GameService gameService;

    @GetMapping("/snake_and_ladder")
    public void snakeAndLadder() {

        Scanner sc = new Scanner(System.in);
        int numberOfSnakes = sc.nextInt();

        while (numberOfSnakes != 0) {
            int head = sc.nextInt();
            int tail = sc.nextInt();
            gameService.addSnake(head, tail);
            numberOfSnakes--;
        }
        int numberOfLadders = sc.nextInt();
        while (numberOfLadders != 0) {
            int tail = sc.nextInt();
            int head = sc.nextInt();
            gameService.addLadder(head, tail);
            numberOfLadders--;
        }
        int numberOfPlayers = sc.nextInt();
        int playerId = 0;
        while (numberOfPlayers != 0) {
            String playerName = sc.next();
            Player player = Player.builder().playerName(playerName).id(playerId++).build();
            gameService.addPlayer(player);
            numberOfPlayers--;
        }
        gameSimulationService.beginGame();
    }
}
