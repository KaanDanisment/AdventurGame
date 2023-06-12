package Locations;

import Obstacles.Vampire;
import Player.Player;

public class Forest extends BattleLoc{

    public Forest(Player player) {
        super(4, player, "Forest", new Vampire(), "Firewood",3);
    }
}
