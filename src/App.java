public class App {

    //Array for face centric representation
    static String[][] cube = {
        {"r", "r", "r", "r", "r", "r", "r", "r", "r"},
        {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
        {"o", "o", "o", "o", "o", "o", "o", "o", "o"},
        {"g", "g", "g", "g", "g", "g", "g", "g", "g"},
        {"y", "y", "y", "y", "y", "y", "y", "y", "y"},
        {"w", "w", "w", "w", "w", "w", "w", "w", "w"}
    };

    static void printCube(String[][] cube) {
        int three = 0;
        for(int i = 0; i< cube.length; i++) {
            for(int j = 0; j < cube[0].length; j++) {
                System.out.print(cube[i][j]);
                three++;
                if(three == 3) {
                    System.out.println();
                    three = 0;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        printCube(cube);

    }
}
