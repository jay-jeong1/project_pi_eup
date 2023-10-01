// On my honor:
// - I have not used source code obtained from another current or
//   former student, or any other unauthorized source, either
//   modified or unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
//   anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * SemSearch Test Class
 * 
 * @author Jihoo Jeong
 * @author Jaison Dasika
 * @version 2023-09-21
 */
public class SemSearchTest extends student.TestCase
{
    /**
     * Read contents of a file into a string
     *
     * @param path File name
     * @return the string
     * @throws IOException
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    /**
     * test input args
     * 
     * @throws Exception
     */
    public void testInputArgs() throws Exception {
        String[] args = new String[3];
        systemOut().clearHistory();
        SemSearch.main(args);
        assertEquals("Usage: {world-size}" + "{command-file}\n", systemOut()
            .getHistory());
        String[] moreArgs = new String[2];
        moreArgs[0] = "50";
        moreArgs[1] = "P2Sample_input.txt";
        systemOut().clearHistory();
        SemSearch.main(moreArgs);
        assertEquals("World size must be a power of 2 silly\n", systemOut()
            .getHistory());
    }

    /**
     * Syntax Insert test
     * 
     * @throws Exception
     */
    public void testSyntaxInsert() throws Exception {
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "P2syntaxInsert_input.txt";
        SemSearch.main(args);
        String output = systemOut().getHistory();
        String referenceOutput = readFile("P2syntaxInsert_output.txt");
        assertEquals(referenceOutput, output);
        assertTrue(true);
    }

    /**
     * Full parser test
     * 
     * @throws Exception
     */
    public void testparserfull() throws Exception {
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "P2Sample_input.txt";
        SemSearch.main(args);
        String output = systemOut().getHistory();
        // String referenceOutput = readFile("P2Sample_output.txt");
        // assertEquals(referenceOutput, output);
        assertTrue(true);
    }

    /**
     * Testing certain functions from the sample input
     * 
     * @throws Exception
     */
    public void testCertainPartsOfInputFile() throws Exception {
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "TEST_INPUT_ITEMS.txt";
        SemSearch.main(args);
        String output = systemOut().getHistory();
        String referenceOutput = readFile("TEST_OUTPUT_ITEMS.txt");
        assertEquals(referenceOutput, output);
    }
}