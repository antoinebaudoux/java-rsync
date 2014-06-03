package org.taktik.rsync.checksum;

import java.nio.ByteBuffer;

/**
 * User: abaudoux
 * Date: 03/08/13
 * Time: 16:54
 */
public interface Checksum {
    public void update(byte[] bytes, int offset, int length);
    public void update(ByteBuffer buffer);
    public void reset();
    public byte[] checksum();
}
