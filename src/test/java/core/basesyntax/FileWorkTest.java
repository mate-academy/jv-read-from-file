package core.basesyntax;
public class FileWorkTest {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile("test.txt");
        String[] expected = {"web", "wide", "world"};
        if (java.util.Arrays.equals(result,expected)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed: " + java.util.Arrays.toString(result));
        }
    }
}