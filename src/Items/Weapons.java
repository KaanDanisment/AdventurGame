package Items;

import Player.Player;

import java.util.Scanner;

public class Weapons {
    private int ID;
    private String name;
    private int damage;
    private int price;

    public Weapons(int ID, String name, int damage, int price) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons() {
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons(1, "Sword", 2, 10);
        weaponList[1] = new Weapons(2, "Gun", 4, 25);
        weaponList[2] = new Weapons(3, "Rifle", 7, 40);
        return weaponList;
    }

    public static void printWeapon() {
        for (Weapons weapon : weapons()) {
            System.out.println(weapon.getID() + ") " + weapon.getName() +
                    " | Damage:" + weapon.getDamage() +
                    " | Price:" + weapon.getPrice());
        }
        System.out.println("4) Back");
    }

    public static Weapons getWeaponByID(int ID) {
        for (Weapons weapon : weapons()) {
            if (weapon.getID() == ID) {
                return weapon;
            }
        }
        return null;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
