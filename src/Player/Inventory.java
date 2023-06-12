package Player;

import Items.Armors;
import Items.Weapons;

public class Inventory {

    private Weapons weapons;
    private Armors armors;
    private boolean food = false;
    private boolean firewood = false;
    private boolean water = false;
    private boolean mineAward = false;

    public Inventory() {
        this.weapons = new Weapons(0,"punch",0,0);
        this.armors = new Armors("Empty", 0,0,0);
    }

    public Armors getArmors() {
        return armors;
    }

    public void setArmors(Armors armors) {
        this.armors = armors;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isMineAward() {
        return mineAward;
    }

    public void setMineAward(boolean mineAward) {
        this.mineAward = mineAward;
    }
}
