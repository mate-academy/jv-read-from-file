package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] fileNames = {
                "test1", "test2", "test3", "test4", "test5"
        };
        String[] wordsStartingWithW = fileWork.readFromFile(fileNames);

        System.out.println("Words starting with 'w':");
        for (String word : wordsStartingWithW) {
            System.out.println(word);
        }
    }
}
