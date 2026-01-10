package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();;

        for(int i=1; i<6; i++){
            System.out.println(" ");
           String nameOfFIle = "test" + i;
           String[] words = fileWork.readFromFile(nameOfFIle);
            System.out.println("Test " + i );
            if (words.length == 0) {
                System.out.println("PLik jest pusty lub nie zawiera słów na 'w'");
                System.out.println(" ");
            } else {
            for(String word : words) {
                System.out.println(word);
            }
            }
      }
    }
}
