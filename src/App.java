public class App {

    //Array for 2D face centric representation in its goal state
    static String[][] cube = {
        {"r", "r", "r", "r", "r", "r", "r", "r", "r"},
        {"b", "b", "b", "b", "b", "b", "b", "b", "b"},
        {"o", "o", "o", "o", "o", "o", "o", "o", "o"},
        {"g", "g", "g", "g", "g", "g", "g", "g", "g"},
        {"y", "y", "y", "y", "y", "y", "y", "y", "y"},
        {"w", "w", "w", "w", "w", "w", "w", "w", "w"}
    };

    //Prints cube from a 2D array representation
    static void printCube(String[][] cube) {
        int three = 0;
        for(int i = 0; i < cube.length; i++) {
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

    /*
    Function for interpreting the UP move of the cube for 2D array
    From goal state, 'u' should produce:
    ggg     rrr     bbb     ooo     yyy     www
    rrr     bbb     ooo     ggg     yyy     www
    rrr     bbb     ooo     ggg     yyy     www
    or
    gggrrrrrr
    rrrbbbbbb
    bbboooooo
    ooogggggg
    yyyyyyyyy
    wwwwwwwww
    Remember to implement face rotations too. important for yellow in this case.
    (r-0, b-1, o-2, g-3, y-4, w-5) indexes for colors
    */
    static void u(String[][] cube) {
        
        //hard coded yellow face rotation
        //make this a loop
        //TODO
        String temp = "";

        temp = cube[4][0];
        cube[4][0] = cube[4][0];
        cube[4][6] = cube[4][6];
        cube[4][8] = cube[4][8];
        cube[4][2] = temp;

        temp = cube[4][1];
        cube[4][1] = cube[4][3];
        cube[4][3] = cube[4][7];
        cube[4][7] = cube[4][5];
        cube[4][1] = temp;


        //Edge sliding hard coded
        //try making this a loop too
        //TODO
        String temp1 = "";
        String temp2 = "";
        String temp3 = "";

        temp1 = cube[0][0];
        temp2 = cube[0][1];
        temp3 = cube[0][2];
        cube[0][0] = cube[3][0];
        cube[0][1] = cube[3][1];
        cube[0][2] = cube[3][2];

        cube[3][0] = cube[2][0];
        cube[3][1] = cube[2][1];
        cube[3][2] = cube[2][2];

        cube[2][0] = cube[1][0];
        cube[2][1] = cube[1][1];
        cube[2][2] = cube[1][2];

        cube[1][0] = temp1;
        cube[1][1] = temp2;
        cube[1][2] = temp3;
    }

    public static void main(String[] args) throws Exception {

        printCube(cube);
        u(cube);
        printCube(cube);
    }
}
