package org.example.batallanaval1.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCRUD {
    private final String fileName;

    /**
     * Constructs a FileCRUD object with the specified file name.
     *
     * @param fileName the name of the file to perform CRUD operations on
     */
    public FileCRUD(String fileName){
        this.fileName = fileName;
    }
    public void createFile(double id){
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(fileName,true))) {
            bf.write((int) id);
            bf.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads all lines from the file and returns them as a list of strings.
     *
     * @return a list of all lines in the file
     */
    public List<String> read() {

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Updates a specific line in the file.
     *
     * @param lineNumber the line number to be updated (0-based index)
     * @param newContent the new content to replace the existing line
     */
    public void update(int lineNumber, String newContent) {
        List<String> lines = read();

        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.set(lineNumber, newContent);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }

    /**
     * Deletes a specific line from the file.
     *
     * @param lineNumber the line number to be deleted (0-based index)
     */

    public void delete(int lineNumber) {
        List<String> lines = read();
        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.remove(lineNumber);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }
}