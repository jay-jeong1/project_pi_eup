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

import java.io.File;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Parser Class
 * 
 * @author Jihoo Jeong
 * @author Jaison Dasika
 * @version 10/1/2023
 */
class Parser
{
    /**
     * It reads the text file and execute the commands in SeminarDB class.
     *  
     * @param filePath String
     * @param theWorldSize the worldSize
     * @throws Exception
     */
    static void readAndProcessCommands(String filePath, int theWorldSize)
            throws Exception {
        File file = new File(filePath);
        SeminarDB semDB = new SeminarDB(theWorldSize);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.startsWith("insert")) {
                    int id = Integer.parseInt(line.split(" ")[1]);
                    String title = scan.nextLine().replaceAll("\\s+", " ");
                    title = title.trim();
                    String secondLine = scan.nextLine().replaceAll("\\s+", " ");
                    secondLine = secondLine.trim();
                    String[] secondLines = secondLine.split(" ");
                    String date = secondLines[0];
                    int length = Integer.parseInt(secondLines[1]);
                    short x = (short) Integer.parseInt(secondLines[2]);
                    short y = (short) Integer.parseInt(secondLines[3]);
                    int cost = Integer.parseInt(secondLines[4]);
                    String keywordLine = scan.nextLine().replaceAll("\\s+",
                            " ");
                    keywordLine = keywordLine.trim();
                    String[] keywords = keywordLine.split(" ");
                    ArrayList<String> keywordList = new ArrayList<>();
                    for (String keyword : keywords) {
                        keywordList.add(keyword);
                    }
                    String[] keywordString = keywordList.toArray(
                            new String[keywordList.size()]);
                    String description = scan.nextLine();
                    description = description.trim();
                    Seminar sem = new Seminar(id, title, date, length, x, y,
                            cost, keywordString, description);
                    KVPair<Integer, Seminar> idPair = new KVPair<Integer,
                            Seminar>(id, sem);
                    int[] coords = new int[2];
                    coords[0] = x;
                    coords[1] = y;
                                        
                    if (semDB.insertLocationTree(coords, sem) && semDB
                            .insertIdTree(idPair)) {
                        for (String s : keywordString) {
                            KVPair<String, Seminar> keywordPair = new KVPair<
                                    String, Seminar>(s, sem);
                            semDB.insertKeywordTree(keywordPair);
                        }
                        KVPair<Integer, Seminar> costPair = new KVPair<Integer,
                                Seminar>(cost, sem);
                        semDB.insertCostTree(costPair);
                        KVPair<String, Seminar> datePair = new KVPair<String,
                                Seminar>(date, sem);
                        semDB.insertDateTree(datePair);
                    }
                }
                else if (line.startsWith("search")) {
                    line = line.replaceAll("\\s+", " ").trim();
                    String[] parts = line.split(" ");
                    if (parts[1].equals("keyword")) {
                        String keywordTobeSearched = parts[2];
                        semDB.searchKeywordTree(keywordTobeSearched);
                    }
                    else if (parts[1].equals("ID")) {
                        int id = Integer.parseInt(parts[2]);
                        semDB.searchIdTree(id);
                    }
                    else if (parts[1].equals("cost")) {
                        int cost1 = Integer.parseInt(parts[2]);
                        int cost2 = Integer.parseInt(parts[3]);
                        semDB.searchCostTree(cost1, cost2);
                    }
                    else if (parts[1].equals("location")) {
                        // SEARCHING LOCATION LOGIC MUST BE HERE
                        int location1 = Integer.parseInt(parts[2]);
                        int location2 = Integer.parseInt(parts[3]);
                        int location3 = Integer.parseInt(parts[4]);
                    }
                    else if (parts[1].equals("date")) {
                        String min = parts[2];
                        String max = parts[3];
                        semDB.searchDateTree(min, max);
                    }
                }
                else if (line.startsWith("delete")) {
                    line = line.replaceAll("\\s+", " ").trim();
                    String[] parts = line.split(" ");
                    if (parts.length >= 2) {
                        int idToDelete = Integer.parseInt(parts[1]);
                        semDB.delete(idToDelete);
                    }
                }
                else if (line.startsWith("print")) {
                    line = line.replaceAll("\\s+", " ").trim();
                    String[] lines = line.split(" ");
                    if (lines[1].equals("ID")) {
                        System.out.println("ID Tree:");
                        semDB.printIDTree();
                    }
                    else if (lines[1].equals("location")) {
                        System.out.println("Location Tree:");
                        semDB.printLocationTree();
                    }
                    else if (lines[1].equals("date")) {
                        System.out.println("Date Tree:");
                        semDB.printDateTree();
                    }
                    else if (lines[1].equals("cost")) {
                        System.out.println("Cost Tree:");
                        semDB.printCostTree();
                    }
                    else if (lines[1].equals("keyword")) {
                        System.out.println("Keyword Tree:");
                        semDB.printKeywordTree();
                    }
                }
            }
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}