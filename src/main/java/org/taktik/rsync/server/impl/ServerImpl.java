package org.taktik.rsync.server.impl;

import com.google.common.collect.Lists;
import org.taktik.rsync.server.Server;
import org.taktik.rsync.SyncBlock;
import org.taktik.rsync.SyncInfo;
import org.taktik.rsync.SyncQuery;
import org.taktik.rsync.checksum.Checksum;
import org.taktik.rsync.checksum.RollingChecksum;
import org.taktik.rsync.checksum.impl.MD5Checksum;
import org.taktik.rsync.checksum.impl.RsyncRollingChecksum;

import java.io.*;
import java.util.List;

/**
 * User: abaudoux
 * Date: 04/08/13
 * Time: 11:32
 */
public class ServerImpl implements Server {

    @Override
    public SyncInfo getSyncInfo(SyncQuery query) {
        RollingChecksum rc = new RsyncRollingChecksum();
        Checksum cs = new MD5Checksum();
        File f = new File(query.getIdentifier());
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(f))) {
            SyncInfo si = new SyncInfo();

            List<SyncBlock> blocks = Lists.newArrayList();

            byte[] block = new byte[query.getBlockSize()];

            long index = 0;
            int read;
            while ((read = inputStream.read(block, 0, query.getBlockSize())) >=0 ) {
                if (read == -1) {
                    break;
                }
                cs.update(block, 0, read);
                rc.init(block, 0, read);
                SyncBlock sb = new SyncBlock();
                sb.setIndex(index++);
                sb.setSize(read);
                sb.setWeakChecksum(rc.getValue());
                sb.setStrongChecksum(cs.checksum());
                blocks.add(sb);
                rc.reset();
                cs.reset();
            }

            si.setIdentifier(query.getIdentifier());
            si.setBlocks(blocks);
            return si;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
