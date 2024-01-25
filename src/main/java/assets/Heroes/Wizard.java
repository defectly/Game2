package assets.Heroes;

import assets.BattleTypes.Melee;
import assets.HeroType;

public class Wizard extends Melee {
    public Wizard(String name, int[] position) {
        super(name, position);
        HeroType = assets.HeroType.Wizard;
    }
}
