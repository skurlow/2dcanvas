package com.skurlow;

/**
 * Class com.skurlow.Canvas.
 */
public class Canvas {

    private int width = 0;
    private int height = 0;
    private char[][] area = null;

    public void create(int width, int height) {
        if (width < 1) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        if (height < 1) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
        this.height = height;
        area = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                area[y][x] = ' ';
            }
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2) {

    }

    public void drawRectangle(int x1, int y1, int x2, int y2) {

    }

    public void fill(int x, int y, char colour) {

    }

    public void renderToConsole() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print("A");
            }
            System.out.print(System.lineSeparator());
        }
    }

    public char[][] getArea() {
        return area;
    }
}
