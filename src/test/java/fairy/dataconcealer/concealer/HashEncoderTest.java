package fairy.dataconcealer.concealer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashEncoderTest {

    @Test
    public void testMD5() {
        HashEncoder encoder = new HashEncoder();

        assertEquals("e155e1bb4a9c38e3baf90637ab7865df", encoder.encode("life"));
        assertEquals("7d9a0d11cb36e12a68817aff945390de", encoder.encode("universe"));
        assertEquals("312db69f5bf4447dfe3c58983083b54f", encoder.encode("everything"));
        assertEquals("a1d0c6e83f027327d8461063f4ac58a6", encoder.encode("42"));
    }
}
