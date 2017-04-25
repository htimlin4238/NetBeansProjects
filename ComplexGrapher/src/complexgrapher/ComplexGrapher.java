/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexgrapher;

import java.awt.MouseInfo;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author htimlin4238
 */
public class ComplexGrapher extends Application {
    
    final static int SIDE = 750;
    
    static StackPane root = new StackPane();
    static Scene scene = new Scene(root, SIDE, SIDE);
    static GraphicsContext gc;
    static boolean pressed;
    static double relX;
    static double absX;
    static double relY;
    static double absY;
    static double x;
    static double y;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Complex Function Grapher");
        primaryStage.setScene(scene);
        
        Timer timer = new Timer();
        TimerTask task = new MyTimerTask();
        timer.scheduleAtFixedRate(task, 0, 25);
        
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pressed = true;
                relX = mouseEvent.getSceneX();
                absX = MouseInfo.getPointerInfo().getLocation().x;
                relY = mouseEvent.getSceneY();
                absY = MouseInfo.getPointerInfo().getLocation().y;
            }
        });
        scene.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pressed = false;
            }
        });
        
        Image img = new Image("graph.png");
        ImageView imgView = new ImageView(img);
        
        Canvas canvas = new Canvas(SIDE, SIDE);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        root.getChildren().add(imgView);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    class MyTimerTask extends TimerTask {

        public void run() {
            if (pressed) {
                double drawX = MouseInfo.getPointerInfo().getLocation().x - absX + relX - 5;
                double drawY = MouseInfo.getPointerInfo().getLocation().y - absY + relY - 5;
                x = (drawX + 2)/ SIDE * 20 - 10;
                y = (750 - drawY - 2) / SIDE * 20 - 10;
                System.out.println(x+", "+y);
                
                gc.setFill(Color.WHITE);
                gc.fillRect(0, 0, SIDE, SIDE);
                gc.setFill(Color.BLACK);
                gc.fillOval(drawX, drawY, 5, 5);
                gc.setFill(Color.RED);
                gc.fillOval(fR(x), fC(y), 5, 5);
            }
        }
        
        public double fR(double x) {
            double real = x*2 - 2;
            return (real + 10) / 20 * SIDE - 2;
        }
        
        public double fC(double y) {
            double complex = y + 2;
            return (20 - (complex + 10)) / 20 * SIDE - 2;
        }
    }
}
