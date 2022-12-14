package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public static final String SPACE_STRING = " ";

    public String[] readFromFile(String fileName) {
        String[] result = new String[]{};
        String dataFromFile;
        StringBuilder readerStringBuilder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            readerStringBuilder = new StringBuilder();
            dataFromFile = bufferedReader.readLine();
            if (dataFromFile == null) {
                return result;
            }
            while (dataFromFile != null) {
                readerStringBuilder.append(dataFromFile).append(SPACE_STRING);
                dataFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String dataString = readerStringBuilder.toString();
        FileDataConverter converter = new FileDataConverter();
        result = converter.convert(dataString);
        return result;
    }
}
