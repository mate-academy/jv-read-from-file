package core.basesyntax;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileWorkTest {
    private static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir") + "/";
    private static final String EMPTY_FILE_NAME = TEMP_DIRECTORY + "test1";
    private static final String SECOND_FILE_NAME = TEMP_DIRECTORY + "test2";
    private static final String THIRD_FILE_NAME = TEMP_DIRECTORY + "test3";
    private static final String FOURS_FILE_NAME = TEMP_DIRECTORY + "test4";
    private static final String FIFTH_FILE_NAME = TEMP_DIRECTORY + "test5";

    private static final String[] EMPTY_ARRAY_RESULT = new String[0];
    private static final String[] RESULT_FROM_LOWER_CASE =
        new String[]{"walk", "warm", "with", "with"};
    private static final String[] RESULT_FROM_CAMEL_CASE =
        new String[]{"wall", "wave", "width", "world", "www"};
    private static final String[] RESULT_FROM_ADJACENT_WORDS_CASE =
        new String[]{"was", "was", "whenever", "which", "which", "worse"};

    @BeforeClass
    public static void beforeClass() throws Exception{
        Files.writeString(Path.of(EMPTY_FILE_NAME), "", (StandardCharsets.UTF_8));
        Files.writeString(Path.of(SECOND_FILE_NAME), """
                Beautiful two-bedroom city flat five minutes' walk from the cathedral.
                Fully equipped kitchen, living room with a large sofa and chairs, big TV and balcony.
                The balcony has space for four people to sit and gets the sun in the mornings,
                and the flat is light and warm. The upstairs bedroom sleeps four people, with two double beds;
                the downstairs bedroom sleeps two in single beds.
                The flat is perfect for families and is near shops, bars and restaurants.
                """, (StandardCharsets.UTF_8));
        Files.writeString(Path.of(THIRD_FILE_NAME), """
                Four-bedroom farmhouse in the countryside. All of the four double bedrooms are en suite.
                Farm kitchen, tables and chairs outside. Great for groups of friends. The supermarket is half
                an hour by car and you can take a train from the village into the city. Escape from normal life
                for a few days.
                """, (StandardCharsets.UTF_8));
        Files.writeString(Path.of(FOURS_FILE_NAME), """
                WWW? Four-bedroom farmhouse in the countryside. Wave! All of the four double bedrooms are en suite.
                Farm kitchen, tables and chairs outside. Great for groups of friends. World and the supermarket is
                half an hour by car and you can take a train from wall the village into the city. Escape from normal
                life for a few days, width.
                """, (StandardCharsets.UTF_8));
        Files.writeString(Path.of(FIFTH_FILE_NAME), """
                Whenever I have gone there, there have been either so many
                people that I have not been able to see the pictures, which
                was dreadful, or so many pictures that I have not been able to see the people, which was
                worse. The Grosvenor is really the only place.
                """, (StandardCharsets.UTF_8));
    }

    @Test
    public void readFromEmptyFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(EMPTY_FILE_NAME).toArray(new String[0]);
        Assert.assertArrayEquals("Test failed! You should returned empty array.",
            EMPTY_ARRAY_RESULT, actualResult);
    }

    @Test
    public void getLowerCaseResultFromFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(SECOND_FILE_NAME).toArray(new String[0]);
        Assert.assertArrayEquals("Test failed! You should returned next array "
                + Arrays.toString(RESULT_FROM_LOWER_CASE) + " but you returned "
                + Arrays.toString(actualResult),
            RESULT_FROM_LOWER_CASE, actualResult);
    }

    @Test
    public void getCamelCaseResultFromFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(FOURS_FILE_NAME).toArray(new String[0]);
        Assert.assertArrayEquals("Test failed! You should returned next array "
                + Arrays.toString(RESULT_FROM_CAMEL_CASE) + " but you returned "
                + Arrays.toString(actualResult),
            RESULT_FROM_CAMEL_CASE, actualResult);
    }

    @Test
    public void getEmptyResultFromFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(THIRD_FILE_NAME).toArray(new String[0]);
        Assert.assertArrayEquals("Test failed! You should returned empty array.",
            EMPTY_ARRAY_RESULT, actualResult);
    }

    @Test
    public void getAdjacentWordsResultFromFile() {
        FileWork fileWork = new FileWork();
        String[] actualResult = fileWork.readFromFile(FIFTH_FILE_NAME).toArray(new String[0]);
        Assert.assertArrayEquals("Test failed! You should returned next array "
                + Arrays.toString(RESULT_FROM_ADJACENT_WORDS_CASE) + " but you returned "
                + Arrays.toString(actualResult),
            RESULT_FROM_ADJACENT_WORDS_CASE, actualResult);
    }
}


