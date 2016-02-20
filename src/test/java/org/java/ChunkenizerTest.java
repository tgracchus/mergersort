package org.java;


import org.java.externalsort.*;
import org.java.nio.BigFile;
import org.java.nio.TFileReader;
import org.java.system.MemoryManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ulises on 20/02/16.
 */
public class ChunkenizerTest {

    private BigFile inFile;
    private Chunkenizer chunkenizer;

    @Before
    public void setUp() throws Exception {
        inFile = new BigFile("src/test/resources/file.txt");
        chunkenizer = new Chunkenizer();
    }

    @Test
    public void testMoreChunks() throws Exception {
        TFileReader tFileReader = new TFileReader(inFile);
        MemoryManager memoryManager = mock(MemoryManager.class);

        when(memoryManager.availableMemory()).thenReturn(MemoryManager.MEGABYTE / 2);

        ChunkCalculator chunkCalculator = new ChunkCalculator(memoryManager);
        MergeSortInfo mergeSortInfo = chunkCalculator.calculateChunks(inFile);


        try {
            Chunks chunkList = chunkenizer.apply(new MergeBigFile(tFileReader, mergeSortInfo));
            assertEquals(mergeSortInfo.chunks(), chunkList.size());


        } finally {
            tFileReader.close();
        }

    }

    @Test
    public void testOneChunks() throws Exception {
        TFileReader tFileReader = new TFileReader(inFile);

        MergeSortInfo mergeSortInfo = new MergeSortInfo(1, inFile.size(), Arrays.asList(new PassInfo(1, 1)));

        try {
            Chunks chunkList = chunkenizer.apply(new MergeBigFile(tFileReader, mergeSortInfo));
            assertEquals(mergeSortInfo.chunks(), chunkList.size());

        } finally {
            tFileReader.close();
        }
    }
}
