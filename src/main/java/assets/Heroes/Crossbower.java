package assets.Heroes;

import assets.BattleTypes.Distant;
import assets.HeroType;

public class Crossbower extends Distant {
    public Crossbower(String name, int[] position) {
        super(name, position);
        Range = 3;
        HeroType = assets.HeroType.Crossbower;
    }
}
