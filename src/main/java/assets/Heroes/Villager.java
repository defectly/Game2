package assets.Heroes;

import assets.BattleTypes.BattleType;
import assets.BattleTypes.Bearer;
import assets.BattleTypes.Distant;
import assets.Hero;
import assets.HeroType;

import java.util.List;

public class Villager extends Bearer {
    public Villager(String name, int[] position) {
        super(name, position);
        HeroType = assets.HeroType.Villager;
        Range = 1;
        IsReady = true;
    }

    @Override
    public void Step(List<Hero> mates, List<Hero> enemies) {
//        if(Health <= 0)
//            return;
//
//        var nearestMate = GetNearestEnemy(Position, mates.stream().filter(mate -> mate.BattleType == assets.BattleTypes.BattleType.Distant && ((Distant)mate).Ammo <= 0).toList());
//
//        if(GetDistance(Position, nearestMate.Position) > Range) {
//            super.Step(mates, mates);
//            return;
//        }
//
//        ((Distant)nearestMate).Ammo += 1;

//        for (var mate : mates.stream().filter(mate -> mate.Health > 0 && mate.BattleType == assets.BattleTypes.BattleType.Distant && ((Distant)mate).Ammo < ((Distant)mate).MaxAmmo).toList()) {
//            ((Distant)mate).Ammo += 1;
//        }

        IsReady = true;
    }
}
