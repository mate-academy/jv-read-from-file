### Common mistakes

#### Create variables with informative names.
```
Bad naming:
BufferedReader br = new BufferedReader(new FileReader(fileName))
```  
```
Good naming: 
BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))
```  

#### Use constants where applicable.
If you have strange strings or numbers in the code it's better to declare them as constants.
The name of the constant should display this object's purpose.
```
Bad practice:
    public boolean startWithLetter(String word) {
        return word.startsWith("d"); // why do we use 'd' here???
    }
```
```
Good practice:
    private static final String SPECIFIED_CHARACTER = "d";
    
    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER); 
    }
```
[Correct constant names](https://google.github.io/styleguide/javaguide.html#s5.2.4-constant-names)

#### Close all resources.
Connections, streams, files, and other classes that implement the `Closeable` or `AutoCloseable` interface, need to be closed after use. Furthermore, that close should be done in a `finally` block. Preferably, when the class implements `AutoCloseable`, the resource should be created using the "try-with-resources" pattern and will be closed automatically.

#### Don't ignore exceptions.
Leaving an empty catch block or `e.printStackTrace` here is a bad practice. 
Better re-throw `RuntimeException` with the original exception in the parameters:
```
catch (Exception e) {
    throw new RuntimeException(e);
}
```

#### Don’t create redundant variables.
Let's make your code simple and easy to read. So better avoid using redundant variables.

#### Use System.lineSeparator() insted `\n`
[explanation](https://www.geeksforgeeks.org/system-lineseparator-method-in-java-with-examples/)
