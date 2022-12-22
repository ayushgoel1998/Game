package com.example.demo.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SnakeAndLadderRepository {

    HashMap<Integer, Integer> snakeHeads = new HashMap<>();
    HashMap<Integer, Integer> ladderTail = new HashMap<>();

    public void addSnake(int head, int tail){
        snakeHeads.put(head, tail);
    }

    public void addLadder(int head, int tail){
        ladderTail.put(tail, head);
    }

    public HashMap<Integer, Integer> getSnakePositions(){
        return snakeHeads;
    }

    public HashMap<Integer, Integer> getLadderPositions(){
        return ladderTail;
    }
}
