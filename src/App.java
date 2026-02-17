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

    static void rotateFace(String[][] cube, int face) {
        //Helper function for rotating a face of the cube during a turn

        String temp = "";

        temp = cube[face][0];
        cube[face][0] = cube[face][6];
        cube[face][6] = cube[face][8];
        cube[face][8] = cube[face][2];
        cube[face][2] = temp;

        temp = cube[face][1];
        cube[face][1] = cube[face][3];
        cube[face][3] = cube[face][7];
        cube[face][7] = cube[face][5];
        cube[face][1] = temp;
    }

    static void u(String[][] cube) {
        /*
            Function for U turn
            From goal state, 'U' should produce:
            ggg     rrr     bbb     ooo     yyy     www
            rrr     bbb     ooo     ggg     yyy     www
            rrr     bbb     ooo     ggg     yyy     www
            Remember to implement face rotations too. important for yellow in this case.
            (r-0, b-1, o-2, g-3, y-4, w-5) indexes for colors
        */

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

        //Yellow face rotation
        rotateFace(cube, 4);

        for(int i = 0; i < 3; i++) { //loop equivalent edge slide
            String temp = cube[0][i];
            cube[0][i] = cube[3][i];
            cube[3][i] = cube[2][i];
            cube[2][i] = cube[1][i];
            cube[1][i] = temp;
        }
    }

    static void d(String[][] cube) {
        /*
            Function for  D turn
            expected result of 'D' from goal state:
            rrr     bbb     ooo     ggg     yyy     www
            rrr     bbb     ooo     ggg     yyy     www
            bbb     ooo     ggg     rrr     yyy     www
        */

        //white face rotation
        //might want to make a function for face rotation
        rotateFace(cube, 5);

        //D edge slide
        for(int i = 0; i < 3; i++) {
            String temp = cube[0][6+i];
            cube[0][6+i] = cube[1][6+i];
            cube[1][6+i] = cube[2][6+i];
            cube[2][6+i] = cube[3][6+i];
            cube[3][6+i] = temp;
        }

    }

    static void r(String[][] cube) {
        /*
            Function for R turn
            expected result of 'R' from goal state:
            rrr     bbw     ooo     ygg     yyy     wwg
            rrr     bbw     ooo     ygg     yyy     wwg
            rrr     bbw     ooo     ygg     yyy     wwg
        */

        //Red face rotation
        rotateFace(cube, 0);

        //R edge slide
    }

    static void l(String[][] cube) {
        /*
            Function for L turn
            expected result of 'L' from goal state:
            rrr     ybb     ooo     ggw     gyy     bww
            rrr     ybb     ooo     ggw     gyy     bww
            rrr     ybb     ooo     ggw     gyy     bww
        */

        //Orange face rotation
        rotateFace(cube, 2);

        //L edge slide
    }

    static void f(String[][] cube) {
        /*
            Function for F turn
            expected result of 'F' from goal state:
            yrr     bbb     oow     ggg     yyy     rww
            yrr     bbb     oow     ggg     yyy     rww
            yrr     bbb     oow     ggg     ooo     rww
        */

        //Blue face rotation
        rotateFace(cube, 1);

        //F edge slide
    }

    static void b(String[][] cube) {
        /*
            Function for B turn
            expected result of 'B' from goal state:
            rrw     bbb     yoo     ggg     rrr     wwo
            rrw     bbb     yoo     ggg     yyy     wwo
            rrw     bbb     yoo     ggg     yyy     wwo
        */

        //Green face rotation
        rotateFace(cube, 3);

        //B edge slide
    }

    public static void main(String[] args) throws Exception {

        r(cube);
        printCube(cube);

    }
}
