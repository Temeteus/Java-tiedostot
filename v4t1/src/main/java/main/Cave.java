package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {

    private static final long serialVersionUID = 1L;

    private Player player;
    private ArrayList<Monster> monsters;

    public Cave(Player player) {
        this.player = player;
        this.monsters = new ArrayList<>();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void listMonsters() {
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).printInfo(i + 1);
        }
    }

    public void attackMonster(int index) {
        if (index < 0 || index >= monsters.size()) {
            return;
        }

        Monster monster = monsters.get(index);

        boolean dead = player.attack(monster);
            if (dead) {
                monsters.remove(index);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
}