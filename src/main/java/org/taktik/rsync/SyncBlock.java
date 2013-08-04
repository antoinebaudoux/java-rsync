package org.taktik.rsync;

/**
 * User: abaudoux
 * Date: 03/08/13
 * Time: 15:30
 */
public class SyncBlock {
    private long index;
    private long size;
    private int weakChecksum;
    private byte[] strongChecksum;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getWeakChecksum() {
        return weakChecksum;
    }

    public void setWeakChecksum(int weakChecksum) {
        this.weakChecksum = weakChecksum;
    }

    public byte[] getStrongChecksum() {
        return strongChecksum;
    }

    public void setStrongChecksum(byte[] strongChecksum) {
        this.strongChecksum = strongChecksum;
    }
}
