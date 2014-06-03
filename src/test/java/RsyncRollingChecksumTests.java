import org.junit.Test;
import org.taktik.rsync.checksum.impl.RsyncRollingChecksum;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * User: abaudoux
 * Date: 03/08/13
 * Time: 16:38
 */
public class RsyncRollingChecksumTests {
    @Test
    public void testReset() {
        byte[] bytes = new byte[20];
        new Random().nextBytes(bytes);
        RsyncRollingChecksum checksum = new RsyncRollingChecksum();
        int cs1 = checksum.init(bytes, 0, 5);
        int cs1Val = checksum.getValue();
        assertEquals(cs1, cs1Val);
        checksum.reset();
        int cs2 = checksum.init(bytes, 0, 5);
        assertEquals(cs1, cs2);
    }

    @Test
    public void testRoll() {
        byte[] bytes = new byte[20];
        new Random().nextBytes(bytes);
        int from = 0;
        int len = 5;
        RsyncRollingChecksum checksum = new RsyncRollingChecksum();
        checksum.init(bytes, from, len);
        int rolled = checksum.roll(bytes[from], bytes[from + len]);
        int rolled2 = checksum.roll(bytes[from + 1], bytes[from + len + 1]);
        checksum.reset();
        int cs2 = checksum.init(bytes, from + 1, len);
        checksum.reset();
        int cs3 = checksum.init(bytes, from + 2, len);
        assertEquals(cs2, rolled);
        assertEquals(cs3, rolled2);
    }
}
