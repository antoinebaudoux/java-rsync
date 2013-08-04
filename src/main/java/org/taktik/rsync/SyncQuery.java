package org.taktik.rsync;

/**
 * User: abaudoux
 * Date: 04/08/13
 * Time: 17:38
 */
public class SyncQuery {
    private String identifier;
    private boolean computeGlobalChecksum;
    private int blockSize;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isComputeGlobalChecksum() {
        return computeGlobalChecksum;
    }

    public void setComputeGlobalChecksum(boolean computeGlobalChecksum) {
        this.computeGlobalChecksum = computeGlobalChecksum;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }
}
