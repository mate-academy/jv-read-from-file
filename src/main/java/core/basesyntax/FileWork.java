package core.basesyntax;

import java.io.*;
import java.util.*;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String readedFile = getFileContent(fileName);
        String[] fileAsArray = readedFile.split(" ");
        List<String> filterredElements = new ArrayList<>();
        for (int i = 0; i < fileAsArray.length; i++) {
            String currentElement = fileAsArray[i].toLowerCase();
            if (currentElement.startsWith("w")) {
                if (currentElement.endsWith(",") || currentElement.endsWith(".")
                        || currentElement.endsWith("!") || currentElement.endsWith("?")) {
                    currentElement = currentElement.substring(0, currentElement.length() - 1);
                }
                filterredElements.add(currentElement);
            }
        }
        Collections.sort(filterredElements);
        return filterredElements.toArray(new String[0]);
    }

    private String getFileContent(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file", e);
        }
        StringBuilder fileContent = new StringBuilder();
        try {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                if (!currentLine.endsWith(" ")) {
                    fileContent.append(currentLine).append(" ");
                } else {
                    fileContent.append(currentLine);
                }
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading line", e);
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Error while closing reader", e);
        }
        return fileContent.toString();
    }
}
