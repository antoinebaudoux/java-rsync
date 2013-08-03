package org.taktik.rsync.checksum;

/**
 * User: abaudoux
 * Date: 03/08/13
 * Time: 15:18
 */
public interface RollingChecksum {
    public void reset();
    public int getValue();
    public int init(byte[] b, int off, int len);
    public int roll(byte previous, byte next);
}
