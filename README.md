# jv-read-from-file
You are given a file that contains different words as well as punctuation.

You need to filter out only the words starting with `w`, and remove any punctuation if necessary.

The result should be returned as a naturally sorted array.
All words should be lower-case.

If the file does not contain the necessary words, return an empty array.

Examples:
```
"Width world Wide web"
Result: ["web", "wide", "width", "world"]

"WWW? Four-bedroom farmhouse in the countryside. Wave! All of the four double bedrooms are en suite."
Result: ["wave", "www"]
```

Hint: try to split Strings with a regular expression that includes whitespace and punctuation characters.
Here is a good [article](https://stackoverflow.com/questions/13225175/java-string-split-with-a-regex).
#### [Try to avoid these common mistakes, while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/builder-file/read-from-file.html)


    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String[] arrayOfwords;
        String[] result;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                arrayOfwords = value.split(SPLITTER);
                for (String word : arrayOfwords) {
                    if (String.valueOf(word.charAt(0)).toLowerCase(Locale.ROOT).equals(DESIRED_LETTER)) {
                        builder.append(word).append(SPACE_SPLITTER);
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can’t read file", e);
        }
        if (builder.toString().equals(NO_ANY_WORDS)) {
            return new String[] {};
        }
        Arrays.sort (result = builder.toString().toLowerCase(Locale.ROOT).split(SPACE_SPLITTER));
        return result;
    }
}