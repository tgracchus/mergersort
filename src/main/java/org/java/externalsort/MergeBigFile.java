package org.java.externalsort;

import org.java.nio.TFileReader;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created by ulises on 20/02/16.
 */
public class MergeBigFile {

    private final TFileReader tFileReader;
    private final MergeSortInfo mergeSortInfo;

    public MergeBigFile(TFileReader tFileReader, MergeSortInfo mergeSortInfo) {
        this.tFileReader = tFileReader;
        this.mergeSortInfo = mergeSortInfo;
    }

    public MergeSortInfo chunksInfo() {
        return mergeSortInfo;
    }

    public TFileReader fileReader() {
        return tFileReader;
    }

    public Chunks map(Function<MergeBigFile, Chunks> mapper) {
        Objects.requireNonNull(mapper);
        return mapper.apply(this);
    }

}
