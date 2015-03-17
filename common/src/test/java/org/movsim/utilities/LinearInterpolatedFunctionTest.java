package org.movsim.utilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class LinearInterpolatedFunctionTest {

    @Test
    public void testValues() {
        double[] x = new double[] { 1, 3, 5, 7 };
        double[] y = new double[] { 0, 10, 10, 5 };
        LinearInterpolatedFunction fct = new LinearInterpolatedFunction(x, y);

        // constant extrapolation beyond defined range
        assertThat(fct.value(0), equalTo(y[0]));
        assertThat(fct.value(100), equalTo(y[y.length - 1]));

        for (int i = 0; i < x.length; i++) {
            assertThat(fct.value(x[i]), equalTo(y[i]));
        }
        assertThat(fct.value(5.5), equalTo(8.75));
    }

}