/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timlin_4_abstractingobjects;

import static java.lang.Math.random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.shape.*;


/**
 *
 * @author htimlin4238
 */
public class Timlin_4_AbstractingObjects extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Button btn = new Button();
        //btn.setText("Say 'Hello World'");
        //btn.setOnAction(new EventHandler<ActionEvent>() {
            
            /*@Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        
        
        
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        
        //sayHello(gc);
        //drawStuff(gc, 100);
        //int[][] p = {{20,10},{5,20}};
        //Tessellate tDawg = new Tessellate(30, 50, p);
        //gc.fillPolygon(tDawg.getXP(), tDawg.getYP(), tDawg.getNP());
        
        //Pentagon pent = new Pentagon(100, 100, 50);
        //gc.fillPolygon(pent.getXP(), pent.getYP(), 5);
        
        //Hexagon hex = new Hexagon(150, 150, 35);
        //gc.fillPolygon(hex.getXP(), hex.getYP(), 6);
        
        gc.fillOval(0, 0, 500, 500);
        
        Circle[] circs = new Circle[20];
        for (int i = 0; i < circs.length; i++) {
            circs[i] = new Circle(20*i, 20*i, 500/(i+1));
        }
        for (int i = 0; i < circs.length; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            gc.fillOval(circs[i].getCenterX(), circs[i].getCenterY(), 
                    circs[i].getRadiusX(), circs[i].getRadiusY());
        }
        
        Pentagon[] pents = new Pentagon[100];
        for (int i = 0; i < pents.length; i++) {
            pents[i] = new Pentagon(8*i, 200*Math.cos(Math.PI/15.625*i)+250, 10);
        }
        for (int i = 0; i < pents.length; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            gc.fillPolygon(pents[i].getXP(), pents[i].getYP(), 5);
        }
        
        Hexagon[] hexes = new Hexagon[7];
        hexes[0] = new Hexagon(250, 250, 15);
        hexes[1] = new Hexagon(250, 250+30, 15);
        hexes[2] = new Hexagon(250, 250-30, 15);
        hexes[3] = new Hexagon(250+30*Math.sqrt(3)/2, 250+15, 15);
        hexes[4] = new Hexagon(250+30*Math.sqrt(3)/2, 250-15, 15);
        hexes[5] = new Hexagon(250-30*Math.sqrt(3)/2, 250+15, 15);
        hexes[6] = new Hexagon(250-30*Math.sqrt(3)/2, 250-15, 15);
        
        for (int i = 0; i < hexes.length; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()*.25+.75));
            gc.fillPolygon(hexes[i].getXP(), hexes[i].getYP(), 6);
        }
        
        Square[] squares = new Square[76];
        for (int i = 0; i < squares.length/4; i++) {
            squares[i] = new Square(25*i + 25, 25, 25);
        }
        for (int i = 0; i < squares.length/4; i++) {
            squares[i + squares.length/4] = new Square(500, 25*i + 25, 25);
        }
        for (int i = 0; i < squares.length/4; i++) {
            squares[i + squares.length/2] = new Square(500-25*i, 500, 25);
        }
        for (int i = 0; i < squares.length/4; i++) {
            squares[i + 3*squares.length/4] = new Square(25, 500-25*i, 25);
        }
        for (int i = 0; i < squares.length; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()*.75+.25));
            gc.fillRect(squares[i].getX(), squares[i].getY(), squares[i].getWidth(), squares[i].getHeight());
        }
        
       
        Triangle1[] tri1 = new Triangle1[22];
        Triangle2[] tri2 = new Triangle2[21];
        for (int i = 0; i < tri1.length; i++) {
            tri1[i] = new Triangle1(20*i + 40, 460, 10);
        }
        for (int i = 0; i < tri2.length; i++) {
            tri2[i] = new Triangle2(20*i + 50, 465, 10);
        }
        for (int i = 0; i < tri1.length; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()*.75+.25));
            gc.fillPolygon(tri1[i].getXP(), tri1[i].getYP(), 3);
        }
        for (int i = 0; i < tri2.length; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()*.75+.25));
            gc.fillPolygon(tri2[i].getXP(), tri2[i].getYP(), 3);
        }
        
        /* aPentagon ap = new aPentagon(pent);
        for (int i = 0; i < 5; i++) {
            gc.strokeArc(ap.getPoints().get(i), ap.getPoints().get(i+1),
                    ap.getWidths()[i], ap.getHeights()[i], ap.getAngles()[i], 1, ArcType.CHORD);
        } */
        
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    void drawStuff(GraphicsContext gc, int max) {
        for(int i = 0; i < max; i++) {
            gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
            gc.fillRect(Math.random()*300, Math.random()*300, Math.random()*100, Math.random()*100);
        }
    }
}

class Circle extends Ellipse {
    Circle(double cX, double cY, double r) {
        super(cX, cY, r, r);
    }
}

class Triangle1 extends Polygon {
    private int N;
    Triangle1(double cX, double cY, double scale) {
        super(new double[] {
           cX, cY+scale, cX+(scale*Math.sqrt(3)/2), cY-(scale/2), 
            cX-(scale*Math.sqrt(3)/2), cY-(scale/2)
        });
        this.N=3;
    }
    public double[] getXP() {
        double[] xp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            xp[i] = this.getPoints().get(i * 2);
        }
        return xp;
    }
    
    public double[] getYP() {
        double[] yp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            yp[i] = this.getPoints().get(i * 2 + 1);
        }
        return yp;
    }
}
class Triangle2 extends Polygon {
    private int N;
    Triangle2(double cX, double cY, double scale) {
        super(new double[] {
           cX, cY-scale, cX-(scale*Math.sqrt(3)/2), cY+(scale/2), 
            cX+(scale*Math.sqrt(3)/2), cY+(scale/2)
        });
        this.N=3;
    }
    public double[] getXP() {
        double[] xp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            xp[i] = this.getPoints().get(i * 2);
        }
        return xp;
    }
    
    public double[] getYP() {
        double[] yp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            yp[i] = this.getPoints().get(i * 2 + 1);
        }
        return yp;
    }
}

class Square extends Rectangle {
    Square(double cX, double cY, double scale) {
        super(cX-scale, cY-scale, scale, scale);
    }
}

class Pentagon extends Polygon {
    private int N;
    Pentagon() {
        
    }
    Pentagon(double cX, double cY, double scale) {
        super(new double[] {
            cX, (cY - scale),
            (cX + (scale/4) * Math.sqrt(10 + 2 * Math.sqrt(5))), 
            (cY - (scale/4) * (Math.sqrt(5) - 1)),
            (cX + (scale/4) * Math.sqrt(10 - 2 * Math.sqrt(5))), 
            (cY + (scale/4) * (Math.sqrt(5) + 1)),
            (cX - (scale/4) * Math.sqrt(10 - 2 * Math.sqrt(5))), 
            (cY + (scale/4) * (Math.sqrt(5) + 1)),
            (cX - (scale/4) * Math.sqrt(10 + 2 * Math.sqrt(5))), 
            (cY - (scale/4) * (Math.sqrt(5) - 1))
        });
        this.N = 5;
    }
    
    public double[] getXP() {
        double[] xp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            xp[i] = this.getPoints().get(i * 2);
        }
        return xp;
    }
    
    public double[] getYP() {
        double[] yp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            yp[i] = this.getPoints().get(i * 2 + 1);
        }
        return yp;
    }
}

class Hexagon extends Polygon {
    private int N;
    Hexagon(double cX, double cY, double scale) {
        super(new double[] {
            (cX - scale), cY,
            (cX - scale/2), (cY + scale * Math.sqrt(3) / 2),
            (cX + scale/2), (cY + scale * Math.sqrt(3) / 2),
            (cX + scale), cY,
            (cX + scale/2), (cY - scale * Math.sqrt(3) / 2),
            (cX - scale/2), (cY - scale * Math.sqrt(3) / 2)
        });
        this.N = 6;
    }
    
    public double[] getXP() {
        double[] xp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            xp[i] = this.getPoints().get(i * 2);
        }
        return xp;
    }
    
    public double[] getYP() {
        double[] yp = new double[this.N];
        for (int i = 0; i < this.N; i++) {
            yp[i] = this.getPoints().get(i * 2 + 1);
        }
        return yp;
    }
}

/* class SmallRectangle extends Rectangle {
    public SmallRectangle(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
} */

/* class Tessellate extends Rectangle {
    private int[][] points;
    
    public Tessellate(int height, int width, int[][] points) {
        this.setHeight(height);
        this.setWidth(height);
        this.setPoints(points);
    }
    
    public void setPoints(int[][] points) {
        this.points = points;
    }
    
    public int getNP() {
        return 2 * points.length + 4;
    }
    
    public double[] getXP() {
        double[] xp = new double[2 * points.length + 4];
        for (int i = 0; i < points.length; i++) {
            xp[i] = points[i][0];
        }
        for (int i = 0; i < points.length; i++) {
            xp[i + points.length] = points[i][0] + (int) this.getWidth();
        }
        xp[2 * points.length] = 0;
        xp[2 * points.length + 1] = 0;
        xp[2 * points.length + 2] = (int) this.getWidth();
        xp[2 * points.length + 3] = (int) this.getWidth();
        return xp;
    }
    
    public double[] getYP() {
        double[] yp = new double[2 * points.length + 4];
        for (int i = 0; i < points.length; i++) {
            yp[i] = points[i][1];
        }
        for (int i = 0; i < points.length; i++) {
            yp[i + points.length] = points[i][1];
        }
        yp[2 * points.length] = 0;
        yp[2 * points.length + 1] = (int) this.getHeight();
        yp[2 * points.length + 2] = 0;
        yp[2 * points.length + 3] = (int) this.getHeight();
        return yp;
    }
} */

/* class aPentagon extends Polygon {
    private double[] heights = new double[5];
    private double[] widths = new double[5];
    private double[] angles = new double[5];
    aPentagon(Pentagon pent) {
        super(new double[] {
            (pent.getXP()[0] + pent.getXP()[1])/2, (pent.getYP()[0] + pent.getYP()[1])/2,
            (pent.getXP()[1] + pent.getXP()[1])/2, (pent.getYP()[1] + pent.getYP()[1])/2,
            (pent.getXP()[2] + pent.getXP()[1])/2, (pent.getYP()[2] + pent.getYP()[1])/2,
            (pent.getXP()[3] + pent.getXP()[1])/2, (pent.getYP()[3] + pent.getYP()[1])/2,
            (pent.getXP()[4] + pent.getXP()[1])/2, (pent.getYP()[4] + pent.getYP()[1])/2,
        });
        for (int i = 0; i < heights.length-1; i++) {
            heights[i] = Math.abs(pent.getYP()[i]-pent.getYP()[i+1]);
        }
        heights[4] = Math.abs(pent.getYP()[4] - pent.getYP()[0]);
        
        for (int i = 0; i < widths.length-1; i++) {
            widths[i] = Math.abs(pent.getXP()[i]-pent.getXP()[i+1]);
        }
        widths[4] = Math.abs(pent.getXP()[4] - pent.getXP()[0]);
        
        for (int i = 0; i < angles.length-1; i++) {
            angles[i] = Math.atan((pent.getYP()[i]-pent.getYP()[i+1]) / 
                    pent.getXP()[i]-pent.getXP()[i+1]);
        }
        angles[4] = Math.atan((pent.getYP()[4]-pent.getYP()[0]) / 
                    pent.getXP()[4]-pent.getXP()[0]);
    }
    
    public double[] getHeights() {return heights;}
    public double[] getWidths() {return widths;}
    public double[] getAngles() {return angles;}

} */