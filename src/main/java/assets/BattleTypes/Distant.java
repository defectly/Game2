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
        if (Health <= 0 || Ammo <= 0)
            return;

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
        Ammo -= 1;
    }
}
