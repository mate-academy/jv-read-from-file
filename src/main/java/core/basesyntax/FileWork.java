package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String readString = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            readString = builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (readString.isEmpty()) {
            return new String[0];
        }
        Pattern re = Pattern.compile("[^A-Za-z0-9 ]+", Pattern.CASE_INSENSITIVE);
        Matcher m = re.matcher(readString);
        String noSpecialCharactersString = m.replaceAll(" ");
        String[] stringsSeparately = noSpecialCharactersString.split(" ");
        StringBuilder filteredBuilder = new StringBuilder();
        for (int i = 0; i < stringsSeparately.length; i++) {
            String lowerCaseString = stringsSeparately[i].toLowerCase();
            if (lowerCaseString.startsWith("w")) {
                filteredBuilder.append(lowerCaseString).append(" ");
            }
        }
        String resultString = filteredBuilder.toString();
        if (resultString.isEmpty()) {
            return new String[0];
        }
        String[] result = resultString.split(" ");
        Arrays.sort(result);
        return result;
    }
}
