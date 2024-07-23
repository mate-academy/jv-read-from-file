package core.basesyntax;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String [] readFromFile = fileName.split(" ");
        if (readFromFile.length == 0) {
            return null;
        }
        int i = 0;
        for (String readFromFil : readFromFile) {
            readFromFile[i] = new StringBuilder(readFromFil).toString();
            i++;
            //write your code here
            return null;
        }
        return readFromFile;
    }
}
