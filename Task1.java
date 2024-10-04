package Internship.projects;


import java.util.Random;
import java.util.Scanner;

class Number_Guessing_Game {
    public static int generate_Random_Number() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
    public static void Play_Rounds(int Max_Try, int[] score){
        int random_No=generate_Random_Number();
        int attempt=0;
        boolean has_Won=false;
        Scanner Sc=new Scanner(System.in);

        System.out.println("Guess the number between 1 and 100: -   ");
        while(attempt<Max_Try && !has_Won){
            System.out.println("Enter the guess number("+(Max_Try-attempt)+")attempts left: -  ");
            int user_guess=Sc.nextInt();
            attempt++;

            if(user_guess==random_No){
                System.out.println("Yay! Your guess was correct");
                score[0]++;
                has_Won=true;

            }

            else if (Math.abs(user_guess - random_No) <= 5) {
                System.out.println("You're very close! But the guess is " + (user_guess > random_No ? "high." : "low."));
            }
            else if (user_guess > random_No) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
            if (attempt==Max_Try && !has_Won) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + random_No);
            }

            System.out.println("You took " + attempt + " attempts till now.\n");

        }


    }
    public static void startGame(int Max_Try) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        int[] score = {0}; // Array to keep track of the rounds won

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            System.out.println("\n--- Round " + rounds + " ---");
            Play_Rounds(Max_Try, score);

            System.out.println("Would you like to play another round? (yes/no)");
            String response = scanner.next().toLowerCase();

            playAgain = response.equals("yes");
        }
        System.out.println("\nGame Over! You played " + rounds + " rounds.");
        System.out.println("Rounds won: " + score[0]);
        System.out.println("Thank you for playing!");
    }

}
public class Task1 {
    public static void main(String[] args) {
        Number_Guessing_Game NBG=new Number_Guessing_Game();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You need to guess a number between 1 and 100.");

        // Specify the maximum number of attempts allowed per round
        System.out.println("Enter the maximum number of attempts per round: ");
        int Max_Try = sc.nextInt();

        // Start the game
        Number_Guessing_Game.startGame(Max_Try);

        sc.close();
    }

}
