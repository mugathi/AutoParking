
package com.epam.autoparking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavan_Mugathi
 *
 */
public class TransactionFile implements ITransactionFile {
    /**
     * transaction file has been created.
     */
    private File file = new File("src/main/resources/transactionfile.csv");
    /**
     * tempfile has been created.
     */
    private File tempFile = new File("src/main/resources/tempfile.csv");
    /**
     * to create singleton for transaction file.
     */
    private ITransactionFile transactionFile;
    /**
     * transaction file path.
     */
    private String path;
    /**
     * temp file path.
     */
    private String tempPath;
    /**
     * slots store the number of slots
     * when fetching the data from transaction file.
     */
    private String slots = null;
    /**
     * creates file and temp file it not exists.
     * @param givenPath stores path of transaction file.
     * @param givenTempPath stores path of temp file.
     * @param logFilepath path of log file.
     */
    public TransactionFile() throws IOException{
    	boolean isFileCreated = true;
    	boolean isTempFileCreated = true;
            if (!file.exists()) {
            	isFileCreated = file.createNewFile();
            } else if (!tempFile.exists()) {
            	isTempFileCreated = tempFile.createNewFile();
            }
        if(!isFileCreated) {
        	throw new IOException("file not created");
        } else if(!isTempFileCreated) {
        	throw new IOException("Temp file not created");
        }
    }
    /**
     * method to return the data from files.
     * @return all lines of file in the form of string array.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public final String[] getFromFile() throws FileNotFoundException, IOException {
        List<String> list = new ArrayList<String>();
        try (BufferedReader fileReader
                = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                list.add(line);
            }
        } 
        return list.toArray(new String[0]);

    }
    /**
     * returns the num of slots to be used in hashing.
     * @return num of slots.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public final int numOfSlots() throws FileNotFoundException, IOException {
    	slots = null;
    	int numOfSlots = -1;
        try (BufferedReader fileReader
                = new BufferedReader(new FileReader(file))) {
            if((slots = fileReader.readLine())!=null) {
            	numOfSlots = Integer.parseInt(slots);	
            }     
        }
        return numOfSlots;
    }
    /**
     * method to remove data from file.
     * @param data info about slot and carnumber.
     * @throws IOException 
     */
    public final void removeData(final String data) throws IOException {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter tempWriter
             = new BufferedWriter(new FileWriter(tempFile, true))) {
            while ((line = reader.readLine()) != null) {
                if (line.equals(data)) {
                    continue;
                }
                tempWriter.write(line + "\n");
                tempWriter.flush();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file
                ));
        BufferedReader tempReader
        = new BufferedReader(new FileReader(tempFile))) {
            while ((line = tempReader.readLine()) != null) {
                writer.write(line + "\n");
                writer.flush();
            }
        }
    }
    /**
     * adds the content od slot info to the file.
     * @param data slot info and carnumber.
     * @throws IOException 
     */
    public final void addToFile(final String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file
                , true))) {
            writer.write(data + "\n");
            writer.flush();
        }
    }
    /**
     * delets the tempFile.
     */
    public final boolean close() {
            return tempFile.delete();
    }
    public ITransactionFile addPath(String filePath, String tempFilePath) throws IOException {
    	file = new File(filePath);
    	tempFile = new File(tempFilePath);
    	return transactionFile = new TransactionFile();
    }
}
