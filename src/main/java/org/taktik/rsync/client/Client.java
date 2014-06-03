package org.taktik.rsync.client;

import org.taktik.rsync.SyncActions;
import org.taktik.rsync.SyncQuery;

/**
 * User: abaudoux
 * Date: 04/08/13
 * Time: 18:28
 */
public interface Client {
    public SyncActions computeSyncActions(SyncQuery syncQuery);
}
