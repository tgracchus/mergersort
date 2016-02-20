package org.java.externalsort;

import org.java.nio.BigFile;

import java.io.IOException;
import java.util.function.Function;

/**
 * Created by ulises on 17/02/16.
 * <p>
 * External sorting is a term for a class of sorting algorithms that can handle massive
 * amounts of data. External sorting is required when the data being sorted do not fit into
 * the main memory of a computing device (usually RAM) and instead they must reside in the
 * slower external memory (usually a hard drive).
 * <p>
 * Refer to https://en.wikipedia.org/wiki/External_sorting
 */
public interface BigFileSorter extends Function<BigFile,BigFile> {


}
