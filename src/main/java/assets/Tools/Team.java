package assets.Tools;

import assets.Hero;
import assets.Heroes.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Team
{
    private static Random _random = new Random();

    private static List<String> _names;

    static {
        try {
            _names = Arrays.stream(new String(new FileInputStream("C:\\Users\\rikar\\Desktop\\names.txt").readAllBytes()).split("\n")).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TeamSide Side;
    public List<Hero> Heroes = new ArrayList<Hero>();

    public Team(TeamSide side)
    {
        Side = side;
        GenerateTeam();
    }

    public List<Hero> SortByPriority()
    {
        return (Heroes.stream().sorted(Comparator.comparingInt(Hero::getPriority)).toList().reversed());
    }

    public boolean CanFight()
    {
//        boolean canFight = true;
//
//        canFight = Heroes.stream().anyMatch(hero -> hero.BattleType == assets.BattleTypes.BattleType.Melee && hero.Health > 0);
//        canFight = Heroes.stream().anyMatch(hero -> hero.BattleType == assets.BattleTypes.BattleType.Bearer && hero.Health > 0);
//        return canFight;
        return Heroes.stream().anyMatch(hero -> hero.Health > 0);
    }

    private void GenerateTeam()
    {
        Heroes.add(CreateHero(1,
                _names.get(_random.nextInt(1, _names.size() - 1)),
                new int[] {3, Side == TeamSide.Darkness ? 1 : 10}));
        Heroes.add(CreateHero(1,
                _names.get(_random.nextInt(1, _names.size() - 1)),
                new int[] {8, Side == TeamSide.Darkness ? 1 : 10}));

        for (int i = 1; i <= 10; i++)
        {
            if (i == 3 || i == 8)
                continue;

            Heroes.add(CreateHero(_random.nextInt(2, 8),
                    _names.get(_random.nextInt(1, _names.size() - 1)),
                    new int[] {i, Side == TeamSide.Darkness ? 1 : 10}));
        }
    }

    public boolean contains(Hero hero)
    {
        return Heroes.contains(hero);
    }

    private static Hero CreateHero(int number, String name, int[] position)
    {
        switch (number) {
            case 1:
                return new Villager(name, position);
            case 2:
                return new Bandit(name, position);
            case 3:
                return new Priest(name, position);
            case 4:
                return new Wizard(name, position);
            case 5:
                return new Spearman(name, position);
            case 6:
                return new Crossbower(name, position);
            case 7:
                return new Sniper(name, position);
        }

        return null;
    }
}