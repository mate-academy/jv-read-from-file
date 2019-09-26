package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class FileWorkTest {
    private static final String FIRST_FILE_NAME = "test1";
    private static final String SECOND_FILE_NAME = "test2";
    private static final String THIRD_FILE_NAME = "test3";

    private static final String[] EMPTY_ARRAY_RESULT = new String[0];
    private static final String[] ARRAY_RESULT = new String[]{"walk", "warm", "with", "with"};

    @Test
    public void readFromEmptyFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(FIRST_FILE_NAME);
        Assert.assertArrayEquals("Test failed! ",EMPTY_ARRAY_RESULT, actualResult);
    }

    @Test
    public void getResultFromFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(SECOND_FILE_NAME);
        Assert.assertArrayEquals(ARRAY_RESULT, actualResult);
    }

    @Test
    public void getEmptyResultFromFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(THIRD_FILE_NAME);
        Assert.assertArrayEquals(EMPTY_ARRAY_RESULT, actualResult);
    }
}
