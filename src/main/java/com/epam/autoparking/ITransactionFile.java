
package com.epam.autoparking;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Pavan_Mugathi
 * interface for transaction file.
 */
interface ITransactionFile {
    /**
     * method to remove data from file.
     * @param data info about slot and carnumber.
     * @throws IOException 
     */
    void removeData(String data) throws IOException;
    /**
     * returns the num of slots to be used in hashing.
     * @return num of slots.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    int numOfSlots() throws FileNotFoundException, IOException;
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
     * @throws FileNotFoundException 
     */
    String[] getFromFile() throws FileNotFoundException, IOException;
    /**
     * to close the reader and writer connections of file.
     * @return 
     */
    boolean close();
    public ITransactionFile addPath(String path1,String path2) throws IOException;
}
