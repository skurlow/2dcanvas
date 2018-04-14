package com.skurlow;

/**
 * Class Canvas.
 */
public class Canvas {

    private int width = 0;
    private int height = 0;
    private char[][] area = null;

    /**
     * Create a rectangular shaped canvas.
     *
     * @param width the width
     * @param height the height
     */
    public void create(int width, int height) {
        if (width < 1) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        if (height < 1) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.width = width;
        this.height = height;
        area = new char[height][width];
        // Initialise the area to contain spaces. This represents an empty canvas.
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
                System.out.print(area[y][x]);
            }
            System.out.print(System.lineSeparator());
        }
    }

    public char[][] getArea() {
        return area;
    }
}
