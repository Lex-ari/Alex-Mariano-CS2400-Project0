import GameControl.*;
import PlayerTypes.*;

import java.util.Scanner;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

/*
Hello from the future!
CS2400
Professor Qichao Dong
- Future Alex Mariano
 */

public class Main {

    public static void main(String[] args) throws Exception {
        /*
        Notes: Please initialize the map first, and then the map printer before any players.

        To add a new player, simply add: Brain "playerName" = new "BrainType"(new "PlayerType"());
        Also add them under Brain[] players list so that they are counted in the move terms
         */

        boolean activeGame = true;
        boolean reachedEnd = false;
        Map.initializeMap();
        MapPrinter.initializeMapPrinter();
        Brain firstPlayer = new ComplexBrain(new Player());
        Brain secondPlayer = new OmegaBrain(new BornRunner());
        Brain thirdPlayer = new TwoBrainCellsBrain(new NeedsAGallonPerDay());

        Brain[] players = {firstPlayer, secondPlayer, thirdPlayer};

        Scanner scanner = new Scanner(System.in);

        int turn = 0;

        while (activeGame){
            System.out.println("Turn " + turn + "\n");
            activeGame = false;
            for (int x = 0; x < players.length; x++){
                players[x].move();

                if (players[x].isWinner()) {
                    activeGame = false;
                    reachedEnd = true;
                    System.out.println(players[x] + "\n");
                } else if (!players[x].isAlive()){
                    System.out.println(players[x] + "\n");
                } else {
                    activeGame = true;
                    System.out.println(players[x] + "\n");
                }
            }
            MapPrinter.printMap(players);
            System.out.println("Please enter any key in the terminal to advance 1 turn");
            if(scanner.hasNextLine()){
                turn++;
                scanner.next();
            }
        }

        if(!reachedEnd){
            System.out.println("All players have died as of turn " + (turn - 1) + ".");
        } else {
            System.out.println("A player reached the end of the map.");
        }

        int longestLength = 0;
        Brain winner = null;
        for (int x = 0; x < players.length; x++){
            if (players[x].getXCood() > longestLength){
                longestLength = players[x].getXCood();
                winner = players[x];
            }
        }

        System.out.println(winner.getName() + " has won the game with a distance of " + winner.getXCood() + " from the start of the map");
        System.out.println(winner);
        System.out.println();
        System.out.println("Thank you for playing");
    }

}
