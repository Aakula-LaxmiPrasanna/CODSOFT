package codeSoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGame 
{

    private int generatedNumber;
    private int numberOfAttempts;
    private int score;
    private boolean isCorrect;

    public NumberGame()
    {
        this.generatedNumber = 0;
        this.numberOfAttempts = 0;
        this.score = 0;
        this.isCorrect = false;
    }

    public static void main(String[] args) 
    {
        NumberGame game = new NumberGame();
        game.playGame();
    }

    public void playGame() 
    {
        Scanner sc = new Scanner(System.in);

        
        generatedNumber = generateRandomNumber(1, 100);

        
        numberOfAttempts = 5;

        
        while (numberOfAttempts > 0 && !isCorrect) 
        {

            
            System.out.println("Guess a number between 1 and 100:");
            int guess = sc.nextInt();

            
            if (guess < generatedNumber) {
                System.out.println("Your guess is too low.");
            }

            
            else if (guess > generatedNumber) {
                System.out.println("Your guess is too high.");
            }

            
            else {
                System.out.println("Correct! You guessed the number in " + numberOfAttempts + " attempts.");
                isCorrect = true;
                score++;
            }

            
            numberOfAttempts--;
        }

        
        if (numberOfAttempts == 0 && !isCorrect) {
            System.out.println("Sorry, you ran out of attempts. The correct number was " + generatedNumber + ".");
        }

        
        System.out.println("Do you want to play again? (y/n)");
        String answer = sc.next();

        
        if (answer.equalsIgnoreCase("y")) {
            resetGame();
            playGame();
        }

        
        else {
            System.out.println("Thanks for playing! Your score was " + score + ".");
        }
    }

    private void resetGame() {
        generatedNumber = 0;
        numberOfAttempts = 5;
        score = 0;
        isCorrect = false;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
