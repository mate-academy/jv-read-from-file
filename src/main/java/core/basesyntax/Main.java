package core.basesyntax;

public class Main {

    public static void main(String[] args) {
        FileMateAcademy fileMateAcademy = new FileMateAcademy();

        String [] text = new String []{"WWW? Four-bedroom farmhouse in the countryside. " +
                "Wave! All of the four double bedrooms are en suite."};

        fileMateAcademy.writeToFile(text);
    }
}
