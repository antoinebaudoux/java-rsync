package org.taktik.rsync.checksum;

import java.nio.ByteBuffer;

/**
 * A checksum that can "roll", given the previous and next bytes
 */
public interface RollingChecksum {
    public void reset();
    public int getValue();
    public int init(byte[] b, int off, int len);
    public int init(ByteBuffer b, int off, int len);
    public int roll(byte previous, byte next);
}
