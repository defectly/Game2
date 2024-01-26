package assets.BattleTypes;

import assets.Hero;

import java.util.List;

public class Distant extends Hero {
    public int Ammo;
    public int MaxAmmo;

    public Distant(String name, int[] position) {
        super(name, position);
        Ammo = 5;
        MaxAmmo = 5;
        Priority = 3;
    }

    @Override
    public void Step(List<Hero> mates, List<Hero> enemies)
    {
        if (Health <= 0)
            return;

        if(Ammo < MaxAmmo) {
            var bearers = mates.stream().filter(hero -> hero.BattleType == assets.BattleTypes.BattleType.Bearer
                    && hero.Health > 0 && ((Bearer) hero).IsReady).toList();

            if(bearers.isEmpty())
                return;

            ((Bearer)bearers.get(0)).IsReady = false;
            Ammo += 1;
        }

        var enemy = GetNearestEnemy(Position, enemies);

        if (GetDistance(Position, enemy.Position) > Range)
        {
            super.Step(mates, enemies);
            return;
        }

        if(Ammo <= 0)
            return;

        Attack(enemy);
    }

    @Override
    protected void Attack(Hero enemy)
    {
        super.Attack(enemy);
        Ammo -= 1;
    }
}
