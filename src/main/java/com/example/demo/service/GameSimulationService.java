package com.example.demo.service;


import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.SnakeAndLadderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Service
public class GameSimulationService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SnakeAndLadderRepository snakeAndLadderRepository;

    public void beginGame() {

        ArrayList<Player> players = playerRepository.getAllPlayers();
        HashMap<Integer, Integer> snakePositions = snakeAndLadderRepository.getSnakePositions();
        HashMap<Integer, Integer> ladderPositions = snakeAndLadderRepository.getLadderPositions();

        Boolean isGameOn = true;
        while (Boolean.TRUE.equals(isGameOn)) {
            String wonPlayer = null;
            for (Player player : players) {
                int diceNumber = rollDice();
                int currPosition = player.getCurrPosition();
                if (currPosition + diceNumber == 100) {
                    isGameOn = false;
                    wonPlayer = player.getPlayerName();
                    break;
                }
                if (currPosition + diceNumber < 100) {
                    int newPosition = getNewPosition(currPosition + diceNumber, snakePositions, ladderPositions, player.getPlayerName());
                    player.setCurrPosition(newPosition);
                }
                System.out.println(player.getPlayerName() + " rolled a "+ diceNumber + " and Moved from "+ currPosition +" to " + player.getCurrPosition());
            }
            if (Boolean.FALSE.equals(isGameOn)) {
                System.out.println(wonPlayer + " has win the game!");
            }
        }
    }

    private int getNewPosition(int currPosition, HashMap<Integer, Integer> snakePositions, HashMap<Integer, Integer> ladderPositions, String playerName) {
        if (snakePositions.containsKey(currPosition)) {
            System.out.println(playerName +" has beaten by snake! ");
            return snakePositions.get(currPosition);
        }
        if (ladderPositions.containsKey(currPosition)) {
            System.out.println(playerName +" has climb the ladder! ");
            return ladderPositions.get(currPosition);
        }
        return currPosition;
    }

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
}
