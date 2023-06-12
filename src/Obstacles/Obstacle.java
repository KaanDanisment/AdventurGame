package Obstacles;

public class Obstacle {
    private String name;
    private int ID;
    private int damage;
    private int health;
    private int money;
    private int remainingHealth;

    public Obstacle(String name, int ID, int damage, int health, int money) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.remainingHealth = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public int getRemainingHealth() {
        return remainingHealth;
    }

    public void setRemainingHealth(int remainingHealth) {
        if (remainingHealth < 0){
            remainingHealth = 0;
        }
        this.remainingHealth = remainingHealth;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
