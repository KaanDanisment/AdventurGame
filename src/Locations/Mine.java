package Locations;

import Obstacles.Snake;
import Player.Player;

public class Mine extends BattleLoc{

    public Mine(Player player) {
        super(6, player, "Mine", new Snake(), "", 5);
    }
}
