package org.java.externalsort;

import org.java.nio.TFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

/**
 * Created by ulises on 17/02/16.
 * <p>
 * Not Thread Safe Class !!!
 */
public class Chunk extends TFile {

    private static final Logger log = LoggerFactory.getLogger(Chunk.class);

    private final int chunkgroup;

    public Chunk(int chunkgroup, Path file) {
        super(file);
        this.chunkgroup = chunkgroup;
    }

    public Chunk(String file, int chunkgroup) {
        super(file);
        this.chunkgroup = chunkgroup;
    }

    public int chunkgroup() {
        return chunkgroup;
    }


}
