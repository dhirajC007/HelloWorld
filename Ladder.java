import java.util.Scanner;
import java.util.Random;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int[] playerPositions = {1, 1};
        String[] playerNames = {"Player 1", "Player 2"};
        boolean gameWon = false;
        int currentPlayer = 0;
        int diceRoll;
        
        while (!gameWon) {
            System.out.println(playerNames[currentPlayer] + "'s turn");
            System.out.println("Press Enter to roll the dice...");
            new Scanner(System.in).nextLine();
            diceRoll = rollDice();
            System.out.println(playerNames[currentPlayer] + " rolled a " + diceRoll);
            playerPositions[currentPlayer] += diceRoll;
            
            if (playerPositions[currentPlayer] > 100) {
                playerPositions[currentPlayer] -= diceRoll;
            } else {
                playerPositions[currentPlayer] = checkForSnakesAndLadders(playerPositions[currentPlayer]);
            }
            
            if (playerPositions[currentPlayer] == 100) {
                gameWon = true;
                System.out.println(playerNames[currentPlayer] + " wins!");
            }
            
            printBoard(playerPositions);
            
            currentPlayer = (currentPlayer + 1) % 2;
        }
    }
    
    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public static int checkForSnakesAndLadders(int position) {
        switch (position) {
            case 4:
                System.out.println("Oops! You got bitten by a snake. Go back to position 1.");
                return 1;
            case 9:
                System.out.println("Yay! You found a ladder. Climb to position 34.");
                return 34;
            case 17:
                System.out.println("Oops! You got bitten by a snake. Go back to position 7.");
                return 7;
            case 20:
                System.out.println("Yay! You found a ladder. Climb to position 24.");
                return 24;
            case 28:
                System.out.println("Oops! You got bitten by a snake. Go back to position 4.");
                return 4;
            case 40:
                System.out.println("Oops! You got bitten by a snake. Go back to position 13.");
                return 13;
            case 51:
                System.out.println("Oops! You got bitten by a snake. Go back to position 9.");
                return 9;
            case 64:
                System.out.println("Yay! You found a ladder. Climb to position 42.");
                return 42;
            case 71:
                System.out.println("Oops! You got bitten by a snake. Go back to position 2.");
                return 2;
            case 87:
                System.out.println("Oops! You got bitten by a snake. Go back to position 24.");
                return 24;
            case 93:
                System.out.println("Oops! You got bitten by a snake. Go back to position 73.");
                return 73;
            case 95:
                System.out.println("Yay! You found a ladder. Climb to position 75.");
                return 75;
            case 98:
                System.out.println("Oops! You got bitten by a snake. Go back to position 78.");
                return 78;
            default:
                return position;
        }
    }
    
    public static void printBoard(int[] positions) {
        System.out.println("Player 1 is at position " + positions[0]);
        System.out.println("Player 2 is at position " + positions[1]);
    }
}
