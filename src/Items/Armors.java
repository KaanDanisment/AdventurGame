package Items;

public class Armors {
    private String level;
    private int ID;
    private int blocking;
    private int price;

    public Armors(String level, int ID, int blocking, int price) {
        this.level = level;
        this.ID = ID;
        this.blocking = blocking;
        this.price = price;
    }

    public static Armors[] armors() {
        Armors[] armorsList = new Armors[3];
        armorsList[0] = new Armors("Light", 1, 1, 15);
        armorsList[1] = new Armors("Medium", 2, 3, 25);
        armorsList[2] = new Armors("Heavy", 3, 5, 40);
        return armorsList;
    }

    public static void printArmor() {
        for (Armors armors : armors()) {
            System.out.println(armors.getID() + ") " + armors.getLevel() +
                    "\t Blocking:" + armors.getBlocking() +
                    "\t Price:" + armors.getPrice());
        }
        System.out.println("4) Back");
    }

    public static Armors getArmorByID(int ID) {
        for (Armors armor : armors()) {
            if (armor.getID() == ID) {
                return armor;
            }
        }
        return null;
    }

    public int getBlocking() {
        return blocking;
    }

    public void setBlocking(int blocking) {
        this.blocking = blocking;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
