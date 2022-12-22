package com.example.demo.repository;

import com.example.demo.entity.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerRepository {

    ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
    }

    public ArrayList<Player> getAllPlayers(){
        return players;
    }
}
