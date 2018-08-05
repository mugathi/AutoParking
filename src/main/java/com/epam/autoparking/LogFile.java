
package com.epam.autoparking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavan_Mugathi
 *
 */
public class LogFile implements ILogFile {
    /**
     * to create the new file as logfile.
     */
    private File file = new File("src/main/resources/logfile.csv");

    /**
     * creates bufferedreader and bufferedwriter objects.
     * @param path as string which gives path of log file.
     * @throws IOException 
     */
    public LogFile() throws IOException {
    	boolean flag = true;
            if (!file.exists()) {
                flag = file.createNewFile();
            } 
            if(!flag) {
            	throw new IOException("creation of file failed");
            }
    }

    /**
     * returns the data in log file as string array.
     * @return data as string array.
     * @throws IOException 
     */
    public String[] getFromFile() throws IOException {
        List<String> list = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
        return list.toArray(new String[0]);
    }

    /**
     * adds the content od slot info to the file.
     * @param data slot info and carnumber.
     * @throws IOException 
     */
    public void addToFile(final String data) throws IOException {
        try (BufferedWriter fileWriter
                = new BufferedWriter(new FileWriter(file, true))) {
            fileWriter.write(data + "\n");
            fileWriter.flush();
        }
    }
    /**
     * to create file with given path.
     * @param path
     * @throws IOException
     */
    public void addFilePath(String path) throws IOException {
    	file = new File(path);
    	boolean flag = true;
        if (!file.exists()) {
            flag = file.createNewFile();
        } 
        if(!flag) {
        	throw new IOException("creation of file failed");
        }
    }
}
