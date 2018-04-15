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
            drawVerticalLine(y1, y2, x1);
        } else {
            // Draw a horizontal line.
            drawHorizontalLine(x1, x2, y1);
        }
    }

    private void drawHorizontalLine(int x1, int x2, int y) {
        if (x1 < x2) {
            for (int position = x1; position <= x2; position++) {
                writeCharacterOntoPoint(position, y, 'x');
            }
        } else {
            for (int position = x2; position <= x1; position++) {
                writeCharacterOntoPoint(position, y, 'x');
            }
        }
    }

    private void drawVerticalLine(int y1, int y2, int x) {
        if (y1 < y2) {
            // Draw from top to bottom.
            for (int position = y1; position <= y2; position++) {
                writeCharacterOntoPoint(x, position, 'x');
            }
        } else {
            // Draw from bottom to top.
            for (int position = y2; position <= y1; position++) {
                writeCharacterOntoPoint(x, position, 'x');
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
    private void writeCharacterOntoPoint(int x, int y, char fillChar) {
        area[y - 1][x - 1] = fillChar;
    }

    /**
     * Draw a rectangle.
     *
     * @param x1 the x-coordinate of one corner of the rectangle.
     * @param y1 the y-coordinate of one corner of the rectangle.
     * @param x2 the x-coordinate of the other corner of the rectangle.
     * @param y2 the y-coordinate of the other corner of the rectangle.
     */
    public void drawRectangle(int x1, int y1, int x2, int y2) {
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
        drawHorizontalLine(x1, x2, y1);
        drawVerticalLine(y1, y2, x2);
        drawHorizontalLine(x2, x1, y2);
        drawVerticalLine(y2, y1, x1);
    }

    /**
     * Fill an area on a canvas with a particular character.
     *
     * @param x the x-coordinate of a point on the canvas where to start filling.
     * @param y the y-coordinate of a point on the canvas where to start filling.
     * @param replacementCharacter the character to use to fill the area.
     */
    public void fillArea(int x, int y, char replacementCharacter) {
        if (x < 1 || x > width) {
            throw new IllegalArgumentException("The starting point must have an x-coordinate within the canvas area.");
        }
        if (y < 1 || y > height) {
            throw new IllegalArgumentException("The starting point must have a y-coordinate within the canvas area.");
        }
        fillCellInArea(x, y, getCharacterAt(x, y), replacementCharacter);
    }

    /**
     * Get the character at a single point on the canvas.
     *
     * Localise translation of a coordinate into the canvas' 0-index array in this method to avoid potential defects
     * and simplify code that uses this method.
     *
     * @param x the x-coordinate of a point.
     * @param y the y-coordinate of a point.
     */
    private char getCharacterAt(int x, int y) {
        return area[y - 1][x - 1];
    }

    private void fillCellInArea(int x, int y, char colourToChange, char paintColour) {
        if (x > 0 && y > 0 && x <= width && y <= height) {
            char currentColor = getCharacterAt(x,y);
            if (currentColor == colourToChange) {
                writeCharacterOntoPoint(x, y, paintColour);
                fillCellInArea(x + 1, y, colourToChange, paintColour);
                fillCellInArea(x - 1, y, colourToChange, paintColour);
                fillCellInArea(x, y + 1, colourToChange, paintColour);
                fillCellInArea(x, y - 1, colourToChange, paintColour);
            }
        }
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
