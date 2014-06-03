import org.junit.Test;
import org.taktik.rsync.server.impl.ServerImpl;
import org.taktik.rsync.SyncInfo;
import org.taktik.rsync.SyncQuery;

import static org.junit.Assert.*;


/**
 * User: abaudoux
 * Date: 04/08/13
 * Time: 18:11
 */
public class ReceiverImpleTests {
    @Test
    public void testReceiver() {
        ServerImpl receiver = new ServerImpl();
        SyncQuery sq = new SyncQuery();
        sq.setIdentifier("/Users/abaudoux/Downloads/ideaIU-130.1179.dmg");
        sq.setBlockSize(1000);
        SyncInfo syncInfo = receiver.getSyncInfo(sq);
        assertEquals(sq.getIdentifier(),syncInfo.getIdentifier());

    }
}
