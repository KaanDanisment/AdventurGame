package Locations;

import Obstacles.Bear;
import Player.Player;

public class River extends BattleLoc{

    public River(Player player) {
        super(5,player,"River",new Bear(),"Water",3);
    }
}
