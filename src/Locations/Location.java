package Locations;

import Player.Player;

import java.util.Scanner;

public abstract class Location {
    private int ID;
    private Player player;
    private String name;
    public static Scanner scan = new Scanner(System.in);


    public Location(int ID, Player player, String name) {
        this.ID = ID;
        this.player = player;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
