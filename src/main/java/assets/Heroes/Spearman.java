package assets.Heroes;

import assets.BattleTypes.Distant;
import assets.HeroType;

public class Spearman extends Distant {
    public Spearman(String name, int[] position) {
        super(name, position);
        Range = 2;
        HeroType = assets.HeroType.Spearman;
        Ammo = 1;
        MaxAmmo = 1;
    }
}
