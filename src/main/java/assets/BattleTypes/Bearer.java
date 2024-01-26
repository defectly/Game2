package assets.BattleTypes;

import assets.Hero;

public abstract class Bearer extends Hero {
    public boolean IsReady;
    public Bearer(String name, int[] Position) {
        super(name, Position);
        Priority = 0;
    }
}