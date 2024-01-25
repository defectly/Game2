package assets.BattleTypes;
import assets.Hero;

import java.util.List;

public abstract class Magic extends Hero {

    public int Mane = 100;

    public Magic(String name, int[] position) {
        super(name, position);
        Priority = 1;
        Range = 2;
    }

    @Override
    public void Step(List<Hero> mates, List<Hero> enemies)
    {
        if (Health <= 0)
            return;

        if (Mane <= 0)
        {
            Mane += 10;
            return;
        }

        var enemy = GetNearestEnemy(Position, enemies);

        if (GetDistance(Position, enemy.Position) > Range)
        {
            super.Step(mates, enemies);
            return;
        }

        Attack(enemy);
    }

    @Override
    protected void Attack(Hero enemy)
    {
        super.Attack(enemy);
        Mane -= Damage;
    }
}
