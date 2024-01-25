package assets;

import java.util.List;

public abstract class Hero {
    public String Name;
    public HeroType HeroType;
    public assets.BattleTypes.BattleType BattleType;
    public int Range;
    public int Priority;
    public int Damage;
    public int Health;
    public int[] Position;

    public Hero(String name, int[] position) {
        Name = name;
        Position = position;
        Health = 100;
        Damage = 10;
    }

    public void ChangeHealth(int points, boolean isHealing)
    {
        if (isHealing)
        {
            Health += points;
            if (Health > 100)
                Health = 100;
        }
        else
        {
            Health -= points;
            if (Health < 0)
                Health = 0;
        }
    }

    public void Step(List<Hero> mates, List<Hero> enemies)
    {
        var enemy = GetNearestEnemy(Position, enemies);

        var nextPosition = NextPosition(Position, enemy.Position);

        if (mates.stream().noneMatch(mate -> mate.Position == nextPosition && mate.getHp() > 0))
            Position = nextPosition;
    }

    protected static Hero GetNearestEnemy(int[] selfPosition, List<Hero> enemies)
    {
        Hero hero = null;
        float min = 900;

        for(var enemy : enemies.stream().filter(enemy -> enemy.Health > 0).toList()) {
            var distance = GetDistance(selfPosition, enemy.Position);

            if(min > distance) {
                min = distance;
                hero = enemy;
            }
        }

        return hero;
    }

    protected static float GetDistance(int[] selfPosition, int[] enemyPosition)
    {
        return (float)Math.sqrt(Math.pow(enemyPosition[0] - selfPosition[0], 2) + Math.pow(enemyPosition[1] - selfPosition[1], 2));
    }

    public int[] NextPosition(int[] selfPosition, int[] enemyPosition)
    {
        var difference = GetPositionDifference(selfPosition, enemyPosition);
        var nextPosition = Position;

        if (difference[0] < 0)
            nextPosition = new int[] {nextPosition[0] + 1, nextPosition[1]};
        else if(difference[0] > 0)
            nextPosition = new int[] {nextPosition[0] - 1, nextPosition[1]};
        else if(difference[1] < 0)
            nextPosition = new int[] {nextPosition[0], nextPosition[1] + 1};
        else if(difference[1] > 0)
            nextPosition = new int[] {nextPosition[0], nextPosition[1] - 1};

        return nextPosition;
    }

    public static int[] GetPositionDifference(int[] selfPosition, int[] enemyPosition)
    {
        return new int[] {selfPosition[0] - enemyPosition[0], selfPosition[1] - enemyPosition[1]};
    }

    protected void Attack(Hero enemy)
    {
        enemy.ChangeHealth(Damage, false);
    }

    public int[] getCoords() {
        return Position;
    }

    public int getHp() {
        return Health;
    }

    public int getPriority() {
        return Priority;
    }

    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return HeroType + " " + Name + " " + Health + " [" + Position[0] + ", " + Position[1] + "]";
    }
}
