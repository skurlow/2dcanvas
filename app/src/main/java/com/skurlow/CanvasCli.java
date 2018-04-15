package com.skurlow;

import java.util.Scanner;

/**
 * Class CanvasCli.
 */
public class CanvasCli {
    private static final String CMD_QUIT = "Q";
    private static final String CMD_CREATE_CANVAS = "C";
    private static final String CMD_DRAW_LINE = "L";
    private static final String CMD_DRAW_RECTANGLE = "R";
    private static final String CMD_FILL_AREA = "B";
    private static final int CMD_CREATE_CANVAS_ARG_LEN = 2;
    private static final int CMD_DRAW_LINE_ARG_LEN = 4;
    private static final int CMD_DRAW_RECTANGLE_ARG_LEN = 4;
    private static final int CMD_FILL_AREA_ARG_LEN = 3;

    private final Canvas canvas;

    public CanvasCli(Canvas canvas) {
        this.canvas = canvas;
    }

    private void processCanvasCommand(String[] canvasCommand) {
        switch(canvasCommand[0]) {
            case CMD_CREATE_CANVAS:
                if (canvasCommand.length == CMD_CREATE_CANVAS_ARG_LEN + 1) {
                    processCreateCanvasCommand(canvasCommand);
                } else {
                    System.out.println("Expected " + CMD_CREATE_CANVAS_ARG_LEN + " arguments for the create canvas command");
                }
                break;
            case CMD_DRAW_LINE:
                if (canvasCommand.length == CMD_DRAW_LINE_ARG_LEN + 1) {
                    processDrawLineCommand(canvasCommand);
                } else {
                    System.out.println("Expected " + CMD_DRAW_LINE_ARG_LEN + " arguments for the draw line command");
                }
                break;
            case CMD_DRAW_RECTANGLE:
                if (canvasCommand.length == CMD_DRAW_RECTANGLE_ARG_LEN + 1) {
                    processDrawRectangleCommand(canvasCommand);
                } else {
                    System.out.println("Expected " + CMD_DRAW_RECTANGLE_ARG_LEN + " arguments for the draw rectangle command");
                }
                break;
            case CMD_FILL_AREA:
                if (canvasCommand.length == CMD_FILL_AREA_ARG_LEN + 1) {
                    processFillAreaCommand(canvasCommand);
                } else {
                    System.out.println("Expected " + CMD_FILL_AREA_ARG_LEN + " arguments for the fill area command");
                }
                break;
        }
    }

    private void processFillAreaCommand(String[] canvasCommand) {
        canvas.fillArea(Integer.valueOf(canvasCommand[1]), Integer.valueOf(canvasCommand[2]), canvasCommand[3].charAt(0));
    }

    private void processDrawRectangleCommand(String[] canvasCommand) {
        canvas.drawRectangle(Integer.valueOf(canvasCommand[1]), Integer.valueOf(canvasCommand[2]),
                Integer.valueOf(canvasCommand[3]), Integer.valueOf(canvasCommand[4]));
    }

    private void processDrawLineCommand(String[] canvasCommand) {
        canvas.drawLine(Integer.valueOf(canvasCommand[1]), Integer.valueOf(canvasCommand[2]),
                Integer.valueOf(canvasCommand[3]), Integer.valueOf(canvasCommand[4]));
    }

    private void processCreateCanvasCommand(String[] canvasCommand) {
        canvas.create(Integer.valueOf(canvasCommand[1]), Integer.valueOf(canvasCommand[2]));
    }

    public void takeAndProcessInput() {
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter command: ");
            String command = input.nextLine();
            if (command.length() > 0) {
                final String[] commandParts = command.split(" ");
                String commandType = commandParts[0];
                if (CMD_QUIT.equals(commandType)) {
                    quit = true;
                } else {
                    processCanvasCommand(commandParts);
                    canvas.renderToConsole();
                }
            }
        } while (!quit);
    }
}
