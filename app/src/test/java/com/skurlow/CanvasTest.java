package com.skurlow;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class com.skurlow.CanvasTest.
 */
 class CanvasTest {

    @Test
    void should_render_empty_canvas() {
        Canvas canvas = new Canvas();
        canvas.create(2, 3);
        char[][] expectedArea =  {
                {' ', ' '},
                {' ', ' '},
                {' ', ' '}
        };
        assertThat(canvas.getArea(), equalTo(expectedArea));
    }
}