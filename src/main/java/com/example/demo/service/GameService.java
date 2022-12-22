package com.example.demo.service;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.SnakeAndLadderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SnakeAndLadderRepository snakeAndLadderRepository;
    public void addSnake(int head, int tail){
        snakeAndLadderRepository.addSnake(head, tail);
    }

    public void addLadder(int head, int tail){
        snakeAndLadderRepository.addLadder(head, tail);
    }

    public void addPlayer(Player player){
        playerRepository.addPlayer(player);
    }
}
