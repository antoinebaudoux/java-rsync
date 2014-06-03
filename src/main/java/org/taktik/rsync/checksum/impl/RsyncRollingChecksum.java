package org.taktik.rsync.checksum.impl;

import org.taktik.rsync.checksum.RollingChecksum;

import java.nio.ByteBuffer;

/**
 * Original rsync implementation of rolling checksum
 * See http://rsync.samba.org/tech_report/node3.html
 */
public class RsyncRollingChecksum implements RollingChecksum {

    private int value = 0;
    private int s1 = 0;
    private int s2 = 0;
    private int blockSize = 0;

    public int init(byte[] bytes, int off, int len) {
        blockSize = len;
        int last = off + blockSize - 1;
        while (off <= last) {
            byte b = bytes[off];
            s1 += b;
            s2 += (last - off + 1) * b;
            off++;
        }
        s2 &= 0xFFFF;
        s1 &= 0xFFFF;
        value = (s2 << 16) | s1;
        return value;
    }

    public int init(ByteBuffer bytes, int off, int len) {
        blockSize = len;
        int last = off + blockSize - 1;
        while (off <= last) {
            byte b = bytes.get(off);
            s1 += b;
            s2 += (last - off + 1) * b;
            off++;
        }
        s2 &= 0xFFFF;
        s1 &= 0xFFFF;
        value = (s2 << 16) | s1;
        return value;
    }

    /**
     * Reset checksum to initial value.
     */
    public void reset() {
        s1 = s2 = value = blockSize = 0;
    }

    /**
     * Returns current checksum value.
     */
    public int getValue() {
        return value;
    }

    @Override
    public int roll(byte previous, byte next) {
        s1 = (s1 - previous + next) & 0xFFFF;
        s2 = (s2 - (blockSize * previous) + s1) & 0xFFFF;
        value = (s2 << 16) | s1;
        return value;
    }
}
