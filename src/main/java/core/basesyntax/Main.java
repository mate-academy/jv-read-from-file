package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "WWW? Four-bedroom farmhouse in the countryside. Wave! All of the four double bedrooms are en suite.\n" +
                "Farm kitchen, tables and chairs outside. Great for groups of friends. World and the supermarket is\n" +
                "half an hour by car and you can take a train from wall the village into the city. Escape from normal\n" +
                "life for a few days, width.\n";
        FileWork fileWork = new FileWork();
        String [] file = fileWork.readFromFile(fileName);
        System.out.println(Arrays.toString(file));
    }
}
