package Locations;
import Player.Player;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(1,player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("###############################################################");
        System.out.println();
        System.out.println("------Safe House------");
        System.out.println("Your health refill");
        this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getBeginningHealth());
        return true;
    }
}
