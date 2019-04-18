package com.cejv416.bankaccount;

/**
 * This class includes all methods to display the table in the report
 * 
 * @author jfeng
 *  
 * 
 */

public class Table {
    
    public static char reportDelimiter = ' ';
    public static char menuDelimiter = '#';
    
    /**
     * fix each cell to certain length
     * <p>
     * align the text to left, center or right in the cell
     *
     * @param cell
     * @param align
     * @param cellLength
     * @return return fixed cell
     */
    public static String fixCellLength(String cell, char align, int cellLength) {

        switch (align) {
            case 'l': // align text left
                cell = cell.length() < cellLength ? cell + new String(new char[cellLength - cell.length()]).replace("\0", " ") : cell.substring(0, cellLength);
                break;
            case 'c': // align text center
                int i;
                i = (cellLength - cell.length()) / 2;
                cell = cell.length() < cellLength ? new String(new char[i]).replace("\0", " ") + cell + new String(new char[cellLength - cell.length() - i]).replace("\0", " ") : cell.substring(0, cellLength);
                break;
            case 'r': // align text right
                cell = cell.length() < cellLength ? new String(new char[cellLength - cell.length()]).replace("\0", " ") + cell : cell.substring(0, cellLength);
                break;
        }

        return cell;
    }
    
    /**
     * print one line with the repeat amount of parameter String
     * 
     * @param s
     * @param length
     */
    public static void printReportLine(String s, int length) {
        System.out.println(new String(new char[length]).replace("\0", s));
    }
}
