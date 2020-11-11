package game;

import java.util.HashMap;
import java.util.Map;


public class Game {

    void beforePlaying(int rollingDice){

        if(rollingDice == 6){
            System.out.println("Place avatar on Number one");
            System.out.println("roll again for next move");
            playMove();
        }
        else{
            System.out.println("Roll again");
        }
        return;
    }


    int playMove() {
        int min = 1;
        int max = 6;
        int rolledDice;

        int positionOfDice = 1;
        // int random_int;
        // this.rollDice = rollDice;
        // this.positionOfDice = positionOfDice;
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
            rolledDice = (int) (Math.random() * (max - min + 1) + min);
            System.out.println("dice lands on " + rolledDice);
            positionOfDice += rolledDice;
            if(positionOfDice == 100){
                System.out.println("Game Over");
                break;
            }
            if(positionOfDice>100){
                int sub = positionOfDice - 100;
                positionOfDice = 100 - sub;
            }
            System.out.println(".... " + positionOfDice);
            for (Map.Entry<Integer, Integer> ga : gameMap.entrySet()) {
                if (positionOfDice == ga.getKey()) {
                    positionOfDice = (ga.getValue() < 0) ? positionOfDice + ga.getValue() : ga.getValue();
                    if(ga.getValue() < 0){
                    System.out.println("You been eaten by snake.." + ga.getKey() + " " + ga.getValue());}
                    else{
                        System.out.println("Get ready to climb on ladder " + ga.getKey() + " " + ga.getValue());
                    }
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

        game.beforePlaying(6);
        //game.playMove();
    }
}



