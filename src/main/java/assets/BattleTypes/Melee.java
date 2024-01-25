package assets.BattleTypes;
import assets.Hero;

import java.util.List;

public abstract class Melee extends Hero {
    public Melee(String name, int[] position) {
        super(name, position);
        Priority = 2;
        Range = 1;
    }

    @Override
    public void Step(List<Hero> mates, List<Hero> enemies)
    {
        if (Health <= 0)
            return;

        var enemy = GetNearestEnemy(Position, enemies);

        if (GetDistance(Position, enemy.Position) > Range)
        {
            super.Step(mates, enemies);
            return;
        }

        Attack(enemy);
    }
}
