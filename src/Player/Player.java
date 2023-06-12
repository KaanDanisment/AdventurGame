package Player;

import Characters.Archer;
import Characters.Character;
import Characters.Knight;
import Characters.Samurai;
import Locations.*;
import Locations.Cave;

import java.util.Scanner;

public class Player {
    private Character character;
    private Location location;
    private int money;
    private String name;
    private Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void selectChar() {
        Character[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("------Select your character------");
        for (Character character : charList) {
            System.out.println(character.getID() + ") " + character.getName() +
                    "\t Damage: " + character.getDamage() +
                    "\t Health: " + character.getHealth() +
                    "\t Money: " + character.getMoney());
        }
        System.out.print("Enter Character Number: ");

        boolean isCharSelected;
        do {
            switch (scan.nextInt()) {
                case 1:
                    isCharSelected = true;
                    this.character = new Samurai();
                    break;
                case 2:
                    isCharSelected = true;
                    this.character = new Archer();
                    break;
                case 3:
                    isCharSelected = true;
                    this.character = new Knight();
                    break;
                default:
                    System.out.println("------Please enter valid number------");
                    isCharSelected = false;
                    break;
            }
        } while (!isCharSelected);
        System.out.println("------Character Chosen " + this.character.getName() + "------");

    }

    public void selectLocation() {
        Location[] locName = {new SafeHouse(this), new ToolStore(this),new Cave(this),new Forest(this),new River(this),new Mine(this)};
        boolean isLocated = true;
        do {
            System.out.println();
            System.out.println("###############################################################");
            System.out.println();
            System.out.println("------Select Playground or Location------");
            System.out.println("0) Exit");
            for (Location loc : locName) {
                System.out.println(loc.getID() + ") " + loc.getName());
            }
            System.out.println("Weapon: " + this.getCharacter().getInventory().getWeapons().getName()+
                                " Damage: " + this.getCharacter().getTotalDamage() +
                                " Health: " + this.getCharacter().getHealth() +
                                " Money: " + this.getCharacter().getMoney());
            System.out.print("Enter Playground or Location Number: ");
            int chosen = scan.nextInt();
            switch (chosen) {
                case 0:
                    System.out.println();
                    System.out.println("###############################################################");
                    System.out.println();
                    System.out.println("------See You Again------");
                    isLocated =false;
                    break;
                case 1:
                    if (this.getCharacter().getInventory().isFood() && this.getCharacter().getInventory().isFirewood() && this.getCharacter().getInventory().isWater() && this.getCharacter().getInventory().isMineAward()){
                        System.out.println("###############################################################");
                        System.out.println();
                        System.out.println("Congratulations!!! You Win!!!");
                        System.out.println();
                        System.out.println("###############################################################");
                        isLocated = false;
                        break;
                    }
                    this.location = new SafeHouse(this);
                    break;
                case 2:
                    this.location = new ToolStore(this);
                    break;
                case 3:
                    if (this.getCharacter().getInventory().isFood()){
                        System.out.println("You earned Food before. You can not fight here again.");
                        selectLocation();
                        break;
                    }
                    this.location = new Cave(this);
                    break;
                case 4:
                    if (this.getCharacter().getInventory().isFirewood()){
                        System.out.println("You earned Firewood before. You can not fight here again.");
                        selectLocation();
                        break;
                    }
                    this.location = new Forest(this);
                    break;
                case 5:
                    if (this.getCharacter().getInventory().isWater()){
                        System.out.println("You earned Water before. You can not fight here again.");
                        selectLocation();
                        break;
                    }
                    this.location = new River(this);
                    break;
                case 6:
                    if (this.getCharacter().getInventory().isMineAward()){
                        System.out.println("You earned Mine Award before. You can not fight here again.");
                        selectLocation();
                        break;
                    }
                    this.location = new Mine(this);
                    break;
                default:
                    this.location = new SafeHouse(this);
                    System.out.println();
                    System.out.println("------Please enter valid number------");
                    break;
            }

        } while (isLocated && location.onLocation());
    }
}