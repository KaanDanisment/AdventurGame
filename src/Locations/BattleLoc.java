package Locations;

import Items.Armors;
import Items.Weapons;
import Obstacles.Obstacle;
import Player.Player;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public Random r = new Random();
    private int obstacleDamage;



    public BattleLoc(int ID, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(ID, player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {

        int obsNumber = this.randomObstacleNumber();
        System.out.println();
        System.out.println("###############################################################");
        System.out.println();
        System.out.println("------" + this.getName() + "------");
        System.out.println("There are " + obsNumber + " " + this.obstacle.getName() + " here!");
        System.out.println("If you want Fight, press <F>");
        System.out.println("Or you can Run, press <R>");
        System.out.print("Your Choice: ");
        String selectCase = scan.nextLine().toUpperCase();
        if (selectCase.equals("F")) {
            if (fight(obsNumber)) {
                System.out.println("###############################################################");
                System.out.println();
                System.out.println("You killed all " + this.obstacle.getName() + "s");
                if (this.getPlayer().getLocation().getName().equals("Mine")){
                    mineAward();
                    this.getPlayer().getCharacter().getInventory().setMineAward(true);
                }
                if (this.getAward().equals("Food") && this.getPlayer().getCharacter().getInventory().isFood() == false) {
                    System.out.println("You earned " + this.getAward());
                    System.out.println();
                    System.out.println("###############################################################");
                    this.getPlayer().getCharacter().getInventory().setFood(true);
                }
                if (this.getAward().equals("Water") && this.getPlayer().getCharacter().getInventory().isWater() == false) {
                    System.out.println("You earned " + this.getAward());
                    System.out.println();
                    System.out.println("###############################################################");
                    this.getPlayer().getCharacter().getInventory().setWater(true);
                }
                if (this.getAward().equals("Firewood") && this.getPlayer().getCharacter().getInventory().isFirewood() == false) {
                    System.out.println("You earned " + this.getAward());
                    System.out.println();
                    System.out.println("###############################################################");
                    this.getPlayer().getCharacter().getInventory().setFirewood(true);
                }
            }
            if (this.getPlayer().getCharacter().getHealth() <= 0) {
                System.out.println("###############################################################");
                System.out.println();
                System.out.println("------Game Over!!!------");
                System.out.println();
                System.out.println("###############################################################");
                return false;
            }
        }
        return true;
    }
    public void mineAward(){
        int randomAwardCategory = r.nextInt(1,100);
        int randomAward = r.nextInt(1,100);

        if (1 <= randomAwardCategory && randomAwardCategory <= 15){
            if (1 <= randomAward && randomAward <= 20){
                this.getPlayer().getCharacter().getInventory().setWeapons(Weapons.getWeaponByID(3));
                System.out.println("You earned " + this.getPlayer().getCharacter().getInventory().getWeapons());

            }else if (21 <= randomAward && randomAward <= 50){
                this.getPlayer().getCharacter().getInventory().setWeapons(Weapons.getWeaponByID(2));
                System.out.println("You earned " + this.getPlayer().getCharacter().getInventory().getWeapons());

            }else {
                this.getPlayer().getCharacter().getInventory().setWeapons(Weapons.getWeaponByID(1));
                System.out.println("You earned " + this.getPlayer().getCharacter().getInventory().getWeapons());

            }
        }if (16 <= randomAwardCategory && randomAwardCategory <= 30){
            if (1 <= randomAward && randomAward <= 20){
                this.getPlayer().getCharacter().getInventory().setArmors(Armors.getArmorByID(3));
                System.out.println("You earned " + this.getPlayer().getCharacter().getInventory().getArmors());
            }else if (21 <= randomAward && randomAward <= 50){
                this.getPlayer().getCharacter().getInventory().setArmors(Armors.getArmorByID(2));
                System.out.println("You earned " + this.getPlayer().getCharacter().getInventory().getArmors());

            }else {
                this.getPlayer().getCharacter().getInventory().setArmors(Armors.getArmorByID(1));
                System.out.println("You earned " + this.getPlayer().getCharacter().getInventory().getArmors());

            }
        }if (31 <= randomAwardCategory && randomAwardCategory <= 55){
            if (1 <= randomAward && randomAward <= 20){
                this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + 10 );
                System.out.println("You earned 10 Coin");

            } else if (21 <= randomAward && randomAward <= 50) {
                this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + 5);
                System.out.println("You earned 5 Coin");

            }else {
                this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + 1);
                System.out.println("You earned 1 Coin");

            }
        }else {
            System.out.println("You didn't get any award");
        }
    }

    public boolean fight(int obsNumber) {


        for (int i = 1; i <= obsNumber; i++) {

            this.obstacle.setRemainingHealth(this.obstacle.getHealth());
            while (this.getPlayer().getCharacter().getHealth() > 0 && this.getObstacle().getRemainingHealth() > 0) {
                System.out.print("<A> attack or <R> run: ");
                String selectFight = Location.scan.next().toUpperCase();
                if (selectFight.equals("A")) {
                    int firstAttack = r.nextInt(2);
                    if (firstAttack == 0){
                        playerAttack(i);
                        obsAttack(i);
                    }if (firstAttack == 1){
                        obsAttack(i);
                        playerAttack(i);
                    }
                } else {
                    return false;
                }
            }
            if (this.getPlayer().getCharacter().getHealth() <= 0) {
                System.out.println("You are DEAD!!!");
                return false;
            }
        }
        return true;
    }

    public void playerAttack(int i) {
        if (this.getPlayer().getCharacter().getHealth() > 0) {
            System.out.println("###############################################################");
            System.out.println();
            System.out.println("You Attacked!!!");
            this.obstacle.setRemainingHealth(this.obstacle.getRemainingHealth() - this.getPlayer().getCharacter().getTotalDamage());
            System.out.println(this.obstacle.getName() + "'s Health: " + this.obstacle.getRemainingHealth());
            System.out.println();
            System.out.println("###############################################################");
            if (this.obstacle.getRemainingHealth() <= 0) {
                System.out.println();
                System.out.println("You killed " + this.obstacle.getName());
                if (!this.getPlayer().getLocation().getName().equals("Mine")){
                    System.out.println("You earned " + this.obstacle.getMoney() + " Coin!!!");
                    this.getPlayer().getCharacter().setMoney(this.obstacle.getMoney() + this.getPlayer().getCharacter().getMoney());
                }
            }
        }
    }

    public void obsAttack(int i) {
        if (this.getObstacle().getRemainingHealth() > 0) {
            System.out.println("###############################################################");
            System.out.println();
            System.out.println(this.obstacle.getName() + " attacked!!!");
            if (this.obstacle.getName().equals("Snake")){
                int snakeDamage = r.nextInt(3,6);
                obstacleDamage = snakeDamage - this.getPlayer().getCharacter().getInventory().getArmors().getBlocking();
            }else {
                obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getCharacter().getInventory().getArmors().getBlocking();
            }
            if (obstacleDamage < 0) {
                obstacleDamage = 0;
            }
            this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getHealth() - obstacleDamage);
            System.out.println("Your Health: " + this.getPlayer().getCharacter().getHealth());
            System.out.println();
            System.out.println("###############################################################");
        }
    }

    public int randomObstacleNumber() {
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
