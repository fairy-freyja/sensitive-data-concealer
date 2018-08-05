package fairy.dataconcealer.concealer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XEncoderTest {

    @Test
    public void test3X() {
        XEncoder encoder = new XEncoder(3);

        assertEquals("XXX", encoder.encode("life"));
        assertEquals("XXX", encoder.encode("universe"));
        assertEquals("XXX", encoder.encode("everything"));
        assertEquals("XXX", encoder.encode("42"));
    }

    @Test
    public void test5X() {
        XEncoder encoder = new XEncoder(5);

        assertEquals("XXXXX", encoder.encode("life"));
        assertEquals("XXXXX", encoder.encode("universe"));
        assertEquals("XXXXX", encoder.encode("everything"));
        assertEquals("XXXXX", encoder.encode("42"));
    }

    @Test
    public void testEmpty() {
        XEncoder encoder = new XEncoder(0);

        assertEquals("", encoder.encode("life"));
        assertEquals("", encoder.encode("universe"));
        assertEquals("", encoder.encode("everything"));
        assertEquals("", encoder.encode("42"));
    }
}
