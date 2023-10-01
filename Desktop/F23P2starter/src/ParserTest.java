// On my honor:
// - I have not used source code obtained from another current or
// former student, or any other unauthorized source, either
// modified or unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
/**
 * Parser Test class
 * 
 * @author Jihoo Jeong
 * @author Jaison Dasika
 * @version 10/1/23
 */
public class ParserTest extends student.TestCase
{
    /**
     * test testReadAndProcessCommands
     * 
     * @throws Exception e
     */
    public void testReadAndProcessCommands() throws Exception {
        Parser.readAndProcessCommands("P2Sample_input.txt", 128);
        Exception exception = null;
        try {
            Parser.readAndProcessCommands("H", 128);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof Exception);
    }
}