package assets.Heroes;

import assets.BattleTypes.Distant;
import assets.HeroType;

public class Sniper extends Distant {
    public Sniper(String name, int[] position) {
        super(name, position);
        Range = 4;
        HeroType = assets.HeroType.Sniper;
    }
}
