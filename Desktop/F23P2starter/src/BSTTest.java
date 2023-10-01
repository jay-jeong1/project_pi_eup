/**
 * Test case class for BST
 * 
 * @author kevinc97
 * @author Jaison Dasika
 * @version 2023-10-1
 */
public class BSTTest extends student.TestCase
{
    // private BST<Integer, Seminar> idTree;
    private Seminar sem;
    private Seminar sem2;
    private Seminar sem3;
    private SeminarDB db;
    private Seminar ksem;
    private Seminar ksem2;
    private Seminar ksem3;
    private Seminar ksem4;

    /**
     * Basic set up
     */
    public void setUp() {
        // idTree = new BST<>();
        db = new SeminarDB(128);
        sem = new Seminar(10, "Overview of HCI Research at VT", "06100516", 90,
            (short) 10, (short) 10, 45, new String[] { "HCI",
                "Computer_Science", "VT", "Virginia_Tech" },
            "This seminar will present an overview of HCI research at VT");
        sem2 = new Seminar(5, // ID
            "Computing Systems Research at VT", // Title
            "0701250830", // Date
            30, // Length
            (short) 30, // X coordinate
            (short) 10, // Y coordinate
            17, // Cost
            new String[] { "high_performance_computing", "grids", "VT",
                "computer", "science" }, // Keywords
            "Seminar about the Computing systems research at VT");
        sem3 = new Seminar(12, // ID
            "Computing Systems Research at VT", // Title
            "0701250830", // Date
            30, // Length
            (short) 30, // X coordinate
            (short) 10, // Y coordinate
            17, // Cost
            new String[] { "high_performance_computing", "grids", "VT",
                "computer", "science" }, // Keywords
            "Seminar about the Computing systems research at VT");
        ksem = new Seminar(1, "Overview of HCI Research at VT", "0610051600",
            90, (short) 10, (short) 10, 45, new String[] { "HCI",
                "Computer_Science", "VT", "Virginia_Tech" },
            "This seminar will present an overview of HCI research at VT");
        ksem2 = new Seminar(2, "Computational Biology and Bioinformatics "
            + "in CS at Virginia Tech", "0610071600", 60, (short) 10,
            (short) 10, 30, new String[] { "Bioinformatics",
                "computation_biology", "Biology", "Computer_Science", "VT",
                "Virginia_Tech" },
            "Introduction to bioinformatics and computation biology");
        ksem3 = new Seminar(10, "Computing Systems Research at VT",
            "0701250830", 30, (short) 30, (short) 10, 17, new String[] {
                "high_performance_computing", "grids", "VT",
                "computer science" },
            "Seminar about the Computing systems research at VT");
        ksem4 = new Seminar(3, "Overview of HPC and CSE Research at VT",
            "1203301125", 35, (short) 0, (short) 0, 25, new String[] { "HPC",
                "CSE", "computer_science" },
            "Learn what kind of research is done on HPC and CSE at VT");
    }

    /**
     * Testing insert in BST
     */
    public void testInsert() {
        KVPair<Integer, Seminar> idPair = new KVPair<>(sem.id(), sem);
        db.insertIdTree(idPair);
        assertEquals(1, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair4 = new KVPair<>(sem.id(), sem);
        db.insertIdTree(idPair4);
        assertEquals(1, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair2 = new KVPair<>(sem2.id(), sem2);
        db.insertIdTree(idPair2);
        assertEquals(2, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair3 = new KVPair<>(sem3.id(), sem3);
        db.insertIdTree(idPair3);
        assertEquals(3, db.getIdTree().getNodeCount());
        db.getIdTree().clear();
        assertEquals(0, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair5 = new KVPair<>(sem2.id(), sem2);
        db.insertIdTree(idPair5);
        assertEquals(1, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair6 = new KVPair<>(sem.id(), sem);
        db.insertIdTree(idPair6);
        assertEquals(2, db.getIdTree().getNodeCount());
        KVPair<String, Seminar> kwPair = new KVPair<>(sem.keywords()[0], sem);
        db.insertKeywordTree(kwPair);
        KVPair<String, Seminar> kwPair1 = new KVPair<>(sem.keywords()[1], sem);
        db.insertKeywordTree(kwPair1);
        KVPair<String, Seminar> kwPair2 = new KVPair<>(sem.keywords()[2], sem);
        db.insertKeywordTree(kwPair2);
        KVPair<String, Seminar> kwPair3 = new KVPair<>(sem.keywords()[3], sem);
        db.insertKeywordTree(kwPair3);
        KVPair<String, Seminar> kwPair4 = new KVPair<>(sem.keywords()[0], sem);
        db.insertKeywordTree(kwPair4);
        KVPair<String, Seminar> kwPair5 = new KVPair<>(sem.keywords()[1], sem);
        db.insertKeywordTree(kwPair5);
        KVPair<String, Seminar> kwPair6 = new KVPair<>(sem.keywords()[2], sem);
        db.insertKeywordTree(kwPair6);
        KVPair<String, Seminar> kwPair7 = new KVPair<>(sem.keywords()[3], sem);
        db.insertKeywordTree(kwPair7);
        assertEquals(8, db.getKeywordTree().getNodeCount());
    }

    /**
     * Testing search method in BST
     */
    public void testSearch() {
        KVPair<Integer, Seminar> idPair = new KVPair<>(sem.id(), sem);
        db.insertIdTree(idPair);
        boolean isFound = db.searchIdTree(idPair.getKey());
        assertTrue(isFound);
        KVPair<Integer, Seminar> idPair2 = new KVPair<>(sem2.id(), sem2);
        boolean isFound2 = db.searchIdTree(idPair2.getKey());
        assertFalse(isFound2);
        db.insertIdTree(idPair2);
        Seminar found2 = db.getIdTree().find(idPair2.getKey());
        assertEquals(sem2, found2);
        KVPair<Integer, Seminar> idPair3 = new KVPair<>(sem3.id(), sem3);
        db.insertIdTree(idPair3);
        Seminar found3 = db.getIdTree().find(idPair3.getKey());
        assertEquals(sem3, found3);
        String[] keywords = sem.keywords();
        String firstKeyword = (keywords.length > 0) ? keywords[0] : "";
        KVPair<String, Seminar> keywordPair = new KVPair<>(firstKeyword, sem);
        db.insertKeywordTree(keywordPair);
        // boolean keywordFound = db.searchKeywordTree("HCI");
        // assertTrue(keywordFound);
        KVPair<String, Seminar> datePair3 = new KVPair<>(sem.date(), sem);
        db.insertDateTree(datePair3);
        // boolean dateFound = db.searchDateTree(0, 1);
        // assertTrue(dateFound);
    }

    /**
     * test range search
     */
    public void testRangeSearch() {
        KVPair<Integer, Seminar> costPair = new KVPair<>(sem.cost(), sem);
        db.insertCostTree(costPair);
        KVPair<Integer, Seminar> costPair2 = new KVPair<>(sem2.cost(), sem2);
        db.insertCostTree(costPair2);
        db.searchCostTree(10, 48);
        db.getCostTree().printCostTree();
        KVPair<String, Seminar> datePair = new KVPair<>(sem.date(), sem);
        db.insertDateTree(datePair);
        KVPair<String, Seminar> datePair2 = new KVPair<>(sem2.date(), sem2);
        db.insertDateTree(datePair2);
        db.searchDateTree("0", "1");
        db.getDateTree().printDateTree();
    }

    /**
     * test keyword tree
     */
    public void testKeywordTree() {
        KVPair<String, Seminar> keywordPair = new KVPair<>(ksem.keywords()[0],
            ksem);
        db.insertKeywordTree(keywordPair);
        KVPair<String, Seminar> keywordPair2 = new KVPair<>(ksem.keywords()[1],
            ksem);
        db.insertKeywordTree(keywordPair2);
        KVPair<String, Seminar> keywordPair3 = new KVPair<>(ksem.keywords()[2],
            ksem);
        db.insertKeywordTree(keywordPair3);
        KVPair<String, Seminar> keywordPair4 = new KVPair<>(ksem.keywords()[3],
            ksem);
        db.insertKeywordTree(keywordPair4);
        KVPair<String, Seminar> keywordPair5 = new KVPair<>(ksem2.keywords()[0],
            ksem2);
        db.insertKeywordTree(keywordPair5);
        KVPair<String, Seminar> keywordPair6 = new KVPair<>(ksem2.keywords()[1],
            ksem2);
        db.insertKeywordTree(keywordPair6);
        KVPair<String, Seminar> keywordPair7 = new KVPair<>(ksem2.keywords()[2],
            ksem2);
        db.insertKeywordTree(keywordPair7);
        KVPair<String, Seminar> keywordPair8 = new KVPair<>(ksem2.keywords()[3],
            ksem2);
        db.insertKeywordTree(keywordPair8);
        KVPair<String, Seminar> keywordPair9 = new KVPair<>(ksem3.keywords()[0],
            ksem3);
        db.insertKeywordTree(keywordPair9);
        KVPair<String, Seminar> keywordPair10 = new KVPair<>(ksem3
            .keywords()[1], ksem3);
        db.insertKeywordTree(keywordPair10);
        KVPair<String, Seminar> keywordPair11 = new KVPair<>(ksem3
            .keywords()[2], ksem3);
        db.insertKeywordTree(keywordPair11);
        KVPair<String, Seminar> keywordPair12 = new KVPair<>(ksem3
            .keywords()[3], ksem3);
        db.insertKeywordTree(keywordPair12);
        KVPair<String, Seminar> keywordPair13 = new KVPair<>(ksem4
            .keywords()[0], ksem4);
        db.insertKeywordTree(keywordPair13);
        KVPair<String, Seminar> keywordPair14 = new KVPair<>(ksem4
            .keywords()[1], ksem4);
        db.insertKeywordTree(keywordPair14);
        KVPair<String, Seminar> keywordPair15 = new KVPair<>(ksem4
            .keywords()[2], ksem4);
        db.insertKeywordTree(keywordPair15);
        System.out.println("**************************************");
        System.out.println(db.getKeywordTree().getNodeCount());
        System.out.println("**************************************");
        db.getKeywordTree().printKeywordTree();
        db.searchKeywordTree("VT");
    }

    /**
     * test clear
     */
    public void testClear() {
        KVPair<Integer, Seminar> idPair = new KVPair<>(sem.id(), sem);
        db.insertIdTree(idPair);
        assertEquals(1, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair2 = new KVPair<>(sem2.id(), sem2);
        db.insertIdTree(idPair2);
        assertEquals(2, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair3 = new KVPair<>(sem3.id(), sem3);
        db.insertIdTree(idPair3);
        assertEquals(3, db.getIdTree().getNodeCount());
        KVPair<Integer, Seminar> idPair4 = new KVPair<>(sem.id(), sem);
        db.insertIdTree(idPair4);
        db.getIdTree().printIDTree();
        assertEquals(3, db.getIdTree().getNodeCount());
        db.getIdTree().clear();
        assertEquals(0, db.getIdTree().getNodeCount());
    }

    /**
     * test print tree
     */
    public void testPrintTree() {
        db.getIdTree();
        db.getCostTree();
        db.getDateTree();
        db.getKeywordTree();
        systemOut().clearHistory();
        db.printDateTree();
        assertEquals("This tree is empty\n", systemOut()
            .getHistory());
        systemOut().clearHistory();
        db.printCostTree();
        assertEquals("This tree is empty\n", systemOut()
            .getHistory());
    }
}