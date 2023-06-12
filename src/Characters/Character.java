package Characters;


import Player.Inventory;

public abstract class Character {
    private String name;
    private int ID;
    private int damage;
    private int health;
    private int beginningHealth;
    private int money;
    private Inventory inventory;

    public Character(String name, int ID, int damage, int health, int money) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.inventory = new Inventory();
        this.beginningHealth = health;

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

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapons().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBeginningHealth() {
        return beginningHealth;
    }

    public void setBeginningHealth(int beginningHealth) {
        this.beginningHealth = beginningHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
