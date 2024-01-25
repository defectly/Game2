package assets.Heroes;

import assets.BattleTypes.Melee;

public class Bandit extends Melee {
    public Bandit(String name, int[] position) {
        super(name, position);
        HeroType = assets.HeroType.Bandit;
    }
}
