package org.taktik.rsync;

import java.util.List;

/**
 * User: abaudoux
 * Date: 03/08/13
 * Time: 15:29
 */
public class SyncInfo {
    private String identifier;
    private List<SyncBlock> blocks;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<SyncBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<SyncBlock> blocks) {
        this.blocks = blocks;
    }
}
