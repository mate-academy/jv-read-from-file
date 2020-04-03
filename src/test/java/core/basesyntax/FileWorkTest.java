package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FileWorkTest {
    private static final String FIRST_FILE_NAME = "test1";
    private static final String SECOND_FILE_NAME = "test2";
    private static final String THIRD_FILE_NAME = "test3";
    private static final String FOURS_FILE_NAME = "test4";

    private static final String[] EMPTY_ARRAY_RESULT = new String[0];
    private static final String[] RESULT_FROM_LOWER_CASE =
            new String[]{"walk", "warm", "with", "with"};
    private static final String[] RESULT_FROM_CAMEL_CASE =
            new String[]{"wall", "wave", "width", "world", "www"};

    @Test
    public void readFromEmptyFile() throws IOException {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(FIRST_FILE_NAME);
        Assert.assertArrayEquals("Test failed! You should returned empty array.",
                EMPTY_ARRAY_RESULT, actualResult);
    }

    @Test
    public void getLowerCaseResultFromFile() throws IOException {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(SECOND_FILE_NAME);
        Assert.assertArrayEquals("Test failed! You should returned next array "
                        + RESULT_FROM_LOWER_CASE + " but you returned " + actualResult,
                RESULT_FROM_LOWER_CASE, actualResult);
    }

    @Test
    public void getCamelCaseResultFromFile() throws IOException {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(FOURS_FILE_NAME);
        Assert.assertArrayEquals("Test failed! You should returned next array "
                        + RESULT_FROM_CAMEL_CASE + " but you returned " + actualResult,
                RESULT_FROM_CAMEL_CASE, actualResult);
    }

    @Test
    public void getEmptyResultFromFile() throws IOException {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(THIRD_FILE_NAME);
        Assert.assertArrayEquals("Test failed! You should returned empty array.",
                EMPTY_ARRAY_RESULT, actualResult);
    }
}
