package myTest;

import android.test.InstrumentationTestCase;

/**
 * Created by taqtile on 1/11/16.
 */
public class ExampleTest extends InstrumentationTestCase {
    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
}
