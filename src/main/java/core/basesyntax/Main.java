package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        String test = "was? Whenever I have gone there, where have been either so many\n";
        //[wall, wave, width, world, www]
        FileWork fileWork = new FileWork();

        String[] res = fileWork.readFromFile(test);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
    }
}
