import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.test.externalsort.imp.ChunkFile;
import org.test.lang.TString;
import org.test.nio.TFile;
import org.test.nio.TStreamWriter;

import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ulises.olivenza on 18/02/16.
 */
public class TStringWriterTest {

    private TStreamWriter tStreamWriter;
    private TFile outFile;
    private Path checkFile;

    private List<TString> lines = Arrays.asList(new TString(
                    "dichroous counterobligation metaplastic inexpectedly Janus supersedeas osculiferous initial relativistic intraplant Hallstatt thoracograph unsaddling reef trimetrogon marigram\n"
                            .toCharArray()), new TString(
                    "Gi oxberry hud postique auriscope oothecal hygric statorhab pterosaurian unrelinquishing pithecometric androkinin unornamented barlafummil preinvestigate bibliopegy\n"
                            .toCharArray()), new TString("nonextracted monosyllable\n".toCharArray()),
            new TString("\n".toCharArray()), new TString("1\n".toCharArray()));

    @Before
    public void setUp() throws Exception {
        checkFile = Paths.get("src/test/resources/lineReaderTest.txt");
        outFile = new TFile(Paths.get("src/test/resources/tmpWriterTest.txt"));
        tStreamWriter = new TStreamWriter(outFile);
    }

    @After
    public void tearDown() throws Exception {
        outFile.delete();
    }

    @Test
    public void testReadLine() throws Exception {
        tStreamWriter.writeLines(lines);
        assertTrue(outFile.file().exists());

        byte[] in = Files.readAllBytes(checkFile);
        byte[] out = Files.readAllBytes(outFile.path());

        assertTrue(Arrays.equals(in, out));
    }

}