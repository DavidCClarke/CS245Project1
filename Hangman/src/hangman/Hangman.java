/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author dcclarke
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random randomNum = new Random();
        Scanner scan = new Scanner(System.in);
        String[] wordList = {"abstract","cemetary","nurse","pharmacy","climbing"};
        int wordNum;
        int points = 100;
        int tries = 6;
        char[] targetWord;
        char[] displayWord;
        char guess;
        boolean correct;
        
        wordNum = randomNum.nextInt(wordList.length);
        targetWord = wordList[wordNum].toCharArray();
        displayWord = new char[targetWord.length];
        Arrays.fill(displayWord, '*');
        for(int i = 0; i < tries; i++) {
            System.out.println(Arrays.toString(displayWord));
            System.out.println("Guess a char: ");
            guess = scan.nextLine().charAt(0);
            correct = false;
            for(int j = 0; j < targetWord.length; j++) {
                if(guess == targetWord[j]) {
                    displayWord[j] = guess;
                    correct = true;
                }  
            }
            if (correct) {
                System.out.println("points: " + points);
                System.out.println("Tries left: " + (tries-i));
                i--;
            }
            else {
                points -= 10;
                System.out.println("points: " + points);
                System.out.println("Tries left: " + (tries-(i+1)));
            }
            if(Arrays.equals(displayWord, targetWord)) {
               i = tries;
               System.out.println("You win");
            }
        }
        if(!Arrays.equals(displayWord, targetWord)) {
               System.out.println("You lose");
            }
    }
}
