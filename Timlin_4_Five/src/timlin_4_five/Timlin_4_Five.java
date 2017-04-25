/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timlin_4_five;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author htimlin4238
 */

//  extends Application
public class Timlin_4_Five {
    
    /* @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    } */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        String[] words = {"dorks", "davis"};
        String word;
        int score;
        String guess = "";
        int loopCount = 0;
        
        while(true) {
            int randy = (int) Math.random() * words.length;
            score = 0;
            word = String.valueOf(words[randy]);
            words[randy] = null;
            Scanner scan = new Scanner(System.in);
            
            boolean good = false;
            while(!good) {
                good = true;
                if (loopCount == 0) {
                    System.out.println("Welcome to Five!");
                }
                loopCount ++;
                System.out.println("What is your guess?");
                
                guess = scan.nextLine();
                if (guess.length() == 5) {
                    for (int i = 0; i < guess.length(); i++) {
                        for (int j = 0; j < guess.length()-i-1; j++) {
                            if (guess.toCharArray()[i] == guess.toCharArray()[i+j]) {
                                j = guess.length();
                                i = guess.length();
                                good = false;
                                System.out.println("That's not a valid guess. Try again.");
                            }
                        }
                    }
                } else {
                    good = false;
                    System.out.println("That's not a valid guess. Try again.");
                }
            }
            
            for (int i = 0; i < word.length(); i++) {
                if (word.contains(guess.substring(i, i+1))) {
                    score += 1;
                }
                if (word.toCharArray()[i] == guess.toCharArray()[i]) {
                    score += 10;
                }
            }
            
            if (score == word.length() + word.length() * 10) {
                break;
            }
        }
    }
    
}
