package com.skurlow;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class com.skurlow.CanvasTest.
 */
 class CanvasTest {

    @Test
    void should_create_empty_canvas() {
        Canvas canvas = new Canvas();
        canvas.create(2, 3);
        char[][] expectedArea =  {
                {' ', ' '},
                {' ', ' '},
                {' ', ' '}
        };
        assertThat(canvas.getArea(), is(equalTo(expectedArea)));
    }

    @Test
    void should_draw_horizontal_line() {
        Canvas canvas = new Canvas();
        canvas.create(20, 4);
        canvas.drawLine(1, 2, 6, 2);
        char[][] expectedArea =  {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        assertThat(canvas.getArea(), is(equalTo(expectedArea)));
    }
}