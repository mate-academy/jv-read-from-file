package core.basesyntax;

public class Xor {
    public static String xor(String key, String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
        }

        return output.toString();
    }
}
