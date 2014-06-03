package org.taktik.rsync.checksum.impl;

import org.taktik.rsync.checksum.Checksum;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: abaudoux
 * Date: 03/08/13
 * Time: 18:17
 */
public class MD5Checksum implements Checksum{

    MessageDigest md5;

    public MD5Checksum() {
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(byte[] bytes, int offset, int length) {
        md5.update(bytes, offset, length);
    }

    @Override
    public void update(ByteBuffer buffer) {
        md5.update(buffer);
    }

    @Override
    public void reset() {
        md5.reset();
    }

    @Override
    public byte[] checksum() {
        return md5.digest();
    }
}
