package core.basesyntax;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] str
                = fileWork.readFromFile("C:\\Users\\golem\\IdeaProjects\\jv-read-from-file\\test2");
        System.out.println(Arrays.toString(str));
    }
}
