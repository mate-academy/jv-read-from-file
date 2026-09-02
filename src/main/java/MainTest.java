import core.basesyntax.FileWork;
import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] words = fileWork.readFromFile("test3");
        System.out.println(Arrays.toString(words));
    }
}
