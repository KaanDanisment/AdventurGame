package Locations;

import Player.Player;

public abstract class NormalLoc extends Location{

    public NormalLoc(int ID,Player player,String name) {
        super(ID,player,name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
