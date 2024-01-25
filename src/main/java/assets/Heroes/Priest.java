package assets.Heroes;

import assets.BattleTypes.Melee;
import assets.HeroType;

public class Priest extends Melee {
    public Priest(String name, int[] position) {
        super(name, position);
        HeroType = assets.HeroType.Priest;
    }
}
