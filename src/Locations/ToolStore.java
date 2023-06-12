package Locations;

import Items.Armors;
import Items.Weapons;
import Player.Player;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player)
    {
        super(2,player, "Market");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("###############################################################");
        System.out.println();
        System.out.println("------Market------");
        System.out.println("Balance: " + this.getPlayer().getCharacter().getMoney());
        System.out.println("0) Back \n" +
                            "1) Weapons \n" +
                            "2) Armors" );
        System.out.print("Enter Your Choice: ");
        int Choice = scan.nextInt();
        switch (Choice){
            case 0:
                break;
            case 1:
                System.out.println();
                System.out.println("###############################################################");
                System.out.println();
                System.out.println("------Weapons------");
                Weapons.printWeapon();
                chooseWeapon();
                break;
            case 2:
                System.out.println();
                System.out.println("###############################################################");
                System.out.println();
                System.out.println("------Armors------");
                Armors.printArmor();
                chooseArmor();
                break;
            default:
                System.out.println("------Please enter valid number------");
                System.out.print("Enter Your Choice: ");
                scan.nextInt();
                break;
        }
        return true;
    }
    public void chooseWeapon() {
        System.out.print("Select Weapon: ");
        int weaponChoice = scan.nextInt();
        if (weaponChoice == 4){
            onLocation();
        }/*
        if ((weaponChoice < 1) || (weaponChoice > Weapons.weapons().length)){
            System.out.println("------Please enter valid number------");
            chooseWeapon();
        }
        */
        Weapons selectedWeapon = Weapons.getWeaponByID(weaponChoice);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getCharacter().getMoney()){
                System.out.println("Insufficient Balance");
            }else {
                System.out.println("You bought " + selectedWeapon.getName());
                int newMoney = this.getPlayer().getCharacter().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().getCharacter().setMoney(newMoney);
                System.out.println("Balance: " + this.getPlayer().getCharacter().getMoney());
                this.getPlayer().getCharacter().getInventory().setWeapons(selectedWeapon);
            }
        }
    }
    public void chooseArmor(){
        System.out.print("Select Armor: ");
        int armorChoice = scan.nextInt();
        if (armorChoice == 4){
            onLocation();
        }
        if (armorChoice < 1 || armorChoice > Armors.armors().length){
            System.out.println("------Please enter valid number------");
            chooseArmor();
        }
        Armors selectedArmor = Armors.getArmorByID(armorChoice);
        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getCharacter().getMoney()){
                System.out.println("Insufficient Balance");
            }else {
                System.out.println("You bought " + selectedArmor.getLevel() + " armor");
                int newMoney = this.getPlayer().getCharacter().getMoney() - selectedArmor.getPrice();
                this.getPlayer().getCharacter().setMoney(newMoney);
                System.out.println("Balance: " + this.getPlayer().getCharacter().getMoney());
                this.getPlayer().getCharacter().getInventory().setArmors(selectedArmor);
            }
        }
    }
}
