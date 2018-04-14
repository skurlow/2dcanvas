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

    /**
     * Draw a straight line either in a horizontal or vertical direction.
     *
     * Diagonal lines are not currently supported.
     *
     * @param x1 the x coordinate of the first point on the line.
     * @param y1 the y coordinate of the first point on the line.
     * @param x2 the x coordinate of the last point on the line.
     * @param y2 the y coordinate of the last point on the line.
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        if (x1 != x2 && y1 != y2) {
            throw new IllegalArgumentException("Horizontal and vertical lines are currently supported.");
        }
        if (x1 < 1 || x1 > width) {
            throw new IllegalArgumentException("The first point must have an x-coordinate within the canvas area.");
        }
        if (y1 < 1 || y1 > height) {
            throw new IllegalArgumentException("The first point must have a y-coordinate within the canvas area.");
        }
        if (x2 < 1 || x2 > width) {
            throw new IllegalArgumentException("The last point must have an x-coordinate within the canvas area.");
        }
        if (y2 < 1 || y2 > height) {
            throw new IllegalArgumentException("The last point must have a y-coordinate within the canvas area.");
        }
        if (x1 == x2) {
            // Draw a vertical line.
            if (y1 < y2) {
                // Draw from top to bottom.
                for (int position = y1; position <= y2; position++) {
                    fillCell(x1, position, 'x');
                }
            } else {
                // Draw from bottom to top.
                for (int position = y2; position <= y1; position++) {
                    fillCell(x1, position, 'x');
                }
            }
        } else {
            // Draw a horizontal line.
            if (x1 < x2) {
                for (int position = x1; position <= x2; position++) {
                    fillCell(position, y1, 'x');
                }
            } else {
                for (int position = x2; position <= x1; position++) {
                    fillCell(position, y1, 'x');
                }
            }
        }
    }

    /**
     * Write a character onto a single point on the canvas.
     *
     * Localise translation of a coordinate into the canvas' 0-index array in this one method to avoid potential defects
     * and simplify code that uses this method.
     *
     * @param x the x-coordinate of a point.
     * @param y the y-coordinate of a point.
     * @param fillChar the character to write onto the (x,y) point on the canvas.
     */
    private void fillCell(int x, int y, char fillChar) {
        area[y - 1][x - 1] = fillChar;
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
