package org.solosinger;

import assets.Hero;
import assets.Tools.Team;
import assets.Tools.TeamSide;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Team darkness;
    public static Team heaven;
    public static ArrayList<Hero> darkTeam = new ArrayList<Hero>();
    public static ArrayList<Hero> holyTeam = new ArrayList<Hero>();
    public static ArrayList<Hero> allTeam = new ArrayList<Hero>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        darkness = new Team(TeamSide.Darkness);
        heaven = new Team(TeamSide.Heaven);
        darkTeam.addAll(darkness.SortByPriority());
        holyTeam.addAll(heaven.SortByPriority());
        allTeam.addAll(darkTeam);
        allTeam.addAll(holyTeam);

        while(true) {
            View.view();

            if(!darkness.CanFight()) {
                System.out.println("Heaven won");
                break;
            }
            if(!heaven.CanFight()) {
                System.out.println("Darkness won");
                break;
            }

            try {
                for(var hero : allTeam) {
                    if(holyTeam.contains(hero))
                        hero.Step(holyTeam, darkTeam);
                    else
                        hero.Step(darkTeam, holyTeam);
                }
            } catch(Exception e) {

            }
            scanner.nextLine();
        }

    }
}