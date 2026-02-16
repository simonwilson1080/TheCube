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

    //Array for move focused design
    static String[][] cubeM = {
        {"w", "w", "w", "b", "b", "b", "g", "g", "g", "y", "y", "y"},
        {"w", "w", "w", "b", "b", "b", "g", "g", "g", "y", "y", "y"},
        {"o", "o", "o", "w", "w", "w", "r", "r", "r", "y", "y", "y"},
        {"o", "o", "o", "w", "w", "w", "r", "r", "r", "y", "y", "y"},
        {"o", "o", "o", "b", "b", "b", "r", "r", "r", "g", "g", "g"},
        {"o", "o", "o", "b", "b", "b", "r", "r", "r", "g", "g", "g"}
    };


    //Prints cube from a 2D face centric array representation
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

    static void u(String[][] cube) {
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

        //hard coded yellow face rotation
        //make this a loop
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

        /*
        'U' edge slide hard coded

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
        */

        for(int i = 0; i < 3; i++) { //loop equivalent
            temp = cube[0][i];
            cube[0][i] = cube[3][i];
            cube[3][i] = cube[2][i];
            cube[2][i] = cube[1][i];
            cube[1][i] = temp;
        }
    }

    static void d(String[][] cube) {
        //TODO
        //expected result of 'd' from goal state:
        /*
        rrr     bbb     ooo     ggg     yyy     www
        rrr     bbb     ooo     ggg     yyy     www
        bbb     ooo     ggg     rrr     yyy     www
        */
        //white face rotation
        //might want to make a function for face rotation to pass in the index for which face to rotate
        String temp = "";
        temp = cube[5][0];
        cube[5][0] = cube[5][0];
        cube[5][6] = cube[5][6];
        cube[5][8] = cube[5][8];
        cube[5][2] = temp;

        temp = cube[5][1];
        cube[5][1] = cube[5][3];
        cube[5][3] = cube[5][7];
        cube[5][7] = cube[5][5];
        cube[5][1] = temp;

        //D edge slide
        for(int i = 0; i < 3; i++) {
            temp = cube[0][6+i];
            cube[0][6+i] = cube[1][6+i];
            cube[1][6+i] = cube[2][6+i];
            cube[2][6+i] = cube[3][6+i];
            cube[3][6+i] = temp;
        }

    }

    public static void main(String[] args) throws Exception {

        printCube(cube);
        d(cube);
        printCube(cube);
        //printCubeM(cubeM);
    }
}
