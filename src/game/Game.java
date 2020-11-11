package game;

import java.util.HashMap;
import java.util.Map;


public class Game {


    int playMove() {
        int min = 1;
        int max = 6;
        int random_int;

        int positionOfDice = 1;
        // int random_int;
//        this.rollDice = rollDice;
//        this.positionOfDice = positionOfDice;
        Map<Integer, Integer> gameMap = new HashMap<>();
        gameMap.put(15, -6);
        gameMap.put(42, -25);
        gameMap.put(49, -37);
        gameMap.put(88, -51);
        gameMap.put(75, -28);
        gameMap.put(97, -32);

        //For the ladders
        gameMap.put(1, 37);
        gameMap.put(9, 40);
        gameMap.put(28, 35);
        gameMap.put(36, 50);
        gameMap.put(51, 65);
        gameMap.put(71, 91);
        while (positionOfDice < 101) {
            random_int = (int) (Math.random() * (max - min + 1) + min);
            System.out.println("dice " + random_int);
            positionOfDice += random_int;
            System.out.println(positionOfDice);
            for (Map.Entry<Integer, Integer> ga : gameMap.entrySet()) {
                if (positionOfDice == ga.getKey()) {
                    positionOfDice += ga.getValue();
                    System.out.println(positionOfDice + " " + ga.getValue());
                }
//            if (positionOfDice > 100) {
//                break;
//            }
            }
        }


        return positionOfDice;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playMove();
    }
}



