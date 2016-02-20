package org.java.externalsort;

import java.util.List;

/**
 * Created by ulises on 19/02/16.
 */
public class ChunksInfo {

    private final int chunks;
    private final long chunkSize;
    private final List<PassInfo> passes;

    public ChunksInfo(int chunks, long chunkSize, List<PassInfo> passes) {
        this.chunks = chunks;
        this.chunkSize = chunkSize;
        this.passes = passes;
    }

    public int chunks() {
        return chunks;
    }

    public long chunkSize() {
        return chunkSize;
    }


    public int bucketGroup(int pass, int bucketNumber) {
        if (pass < passes.size()) {
            return bucketNumber % passes.get(pass).numberOfBuckets();
        } else {
            return PassesCalculator.MAX_CHUNKS_NUMBER;
        }
    }

    public List<PassInfo> passes() {
        return passes;
    }
}
