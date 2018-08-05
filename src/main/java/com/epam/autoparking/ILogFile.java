
package com.epam.autoparking;

import java.io.IOException;

/**
 * @author Pavan_Mugathi
 * interface for log file.
 */
public interface ILogFile {
    /**
     * method to add data to file.
     * @param data gives info about car and slot.
     * @throws IOException 
     */
    void addToFile(String data) throws IOException;
    /**
     * method to return the data from files.
     * @return all lines of file in the form of string array.
     * @throws IOException 
     */
    String[] getFromFile() throws IOException;
    public void addFilePath(String path) throws IOException;
}
