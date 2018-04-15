package com.skurlow;

/**
 * Class CanvasApp.
 */
public class CanvasApp {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        CanvasCli canvasCli = new CanvasCli(canvas);
        canvasCli.takeAndProcessInput();
    }
}
