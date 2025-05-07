import core.basesyntax.FileWork;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork work = new FileWork();
        System.out.println(Arrays.toString(work.readFromFile("test2")));
        String a = "";
    }
}
