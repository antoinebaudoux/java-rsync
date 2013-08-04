package org.taktik.rsync.server;

import org.taktik.rsync.SyncInfo;
import org.taktik.rsync.SyncQuery;

/**
 * User: abaudoux
 * Date: 04/08/13
 * Time: 11:24
 */
public interface Server {
    public SyncInfo getSyncInfo(SyncQuery query);
}
