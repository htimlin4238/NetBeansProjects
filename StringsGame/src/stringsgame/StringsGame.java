/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringsGame {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file0 = new File("/usr/share/dict/words");
        Scanner scan0 = new Scanner(file0);
 
        ArrayList words = new ArrayList();
        
        String wordCheck = "";
        while (scan0.hasNextLine()) {
            wordCheck = scan0.nextLine();
            
            if (inFormat(wordCheck)) {
                words.add(wordCheck);
            }
        }

        String word;
        int score;
        String guess = "";
        int loopCount = 0;

        while (true) {
            int randy = (int) (Math.random() * words.size());
            
            //word = String.valueOf(words.get(randy));
            word = "nerds";
            words.remove(randy);
            
            if (loopCount == 0) {
                System.out.println("Welcome to Five!");
                System.out.println("I'm thinking of a five leter word.");
            } else {
                System.out.println("Would you like to play again? (yes/no)");
                Scanner scan1 = new Scanner(System.in);
                if (scan1.nextLine().toLowerCase().equals("no")) {
                    break;
                } else {
                    System.out.println("I'm thinking of a five leter word.");
                }
            }
            loopCount++;

            while (true) {
                score = 0;
                Scanner scan2 = new Scanner(System.in);

                boolean good = false;
                while (!good) {
                    good = true;
                    System.out.println("What is your guess?");
                    guess = scan2.nextLine();
                    
                    if(!inFormat(guess)) {
                        System.out.println("That's not a valid guess. Try again.");
                        good = false;
                    }
                }
                
                for (int i = 0; i < word.length(); i++) {
                    if (word.contains(guess.substring(i, i + 1))) {
                        score += 1;
                    }
                    if (word.toCharArray()[i] == guess.toCharArray()[i]) {
                        score += 10;
                    }
                }

                System.out.println("Score: " + score);

                if (score == word.length() + word.length() * 10) {
                    System.out.println("You guessed it!");
                    break;
                }
            }
        }
    }

    public static boolean inFormat(String word) {
        if (word.length() == 5) {
            for (int i = 0; i < word.length(); i++) {
                if (word.toCharArray()[i] < 97
                        || word.toCharArray()[i] > 122) {
                    return false;
                }
                for (int j = 0; j < word.length() - i - 1; j++) {
                    if (word.toCharArray()[i] == word.toCharArray()[i + j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
