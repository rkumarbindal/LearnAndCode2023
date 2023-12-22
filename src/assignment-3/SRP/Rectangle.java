/*
 * The first example follows SRP, below is the update second example.
 */

import java.io.FileWriter;
import java.io.IOException;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void writeAreaToFile(double area) {
        try (FileWriter writer = new FileWriter("area.txt")) {
            writer.write("Area: " + area);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public double calculateArea() {
       return length * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        double area = rectangle.calculateArea();
        rectangle.writeAreaToFile(area);
        System.out.println("Calculated Area: " + area);
    }
}