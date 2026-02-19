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
            rrr     bbw     ooo     ygg     yyb     wwg
            rrr     bbw     ooo     ygg     yyb     wwg
            rrr     bbw     ooo     ygg     yyb     wwg
        */

        //Red face rotation
        rotateFace(cube, 0);

        //R edge slide
        //If I make this a loop, I might need to isolate green and yellow.
        String temp1 = "";
        String temp2 = "";
        String temp3 = "";
        temp1 = cube[1][2];
        temp2 = cube[1][5];
        temp3 = cube[1][8];
        //right side of blue face becomes right side of white
        cube[1][2] = cube[5][2];
        cube[1][5] = cube[5][5]; //checked
        cube[1][8] = cube[5][8];
        //right side of white becomes left side of green
        cube[5][2] = cube[3][6];
        cube[5][5] = cube[3][3]; //checked
        cube[5][8] = cube[3][0];
        //left side of green becomes right side of yellow
        cube[3][0] = cube[4][8];
        cube[3][3] = cube[4][5]; //checked
        cube[3][6] = cube[4][2];
        //right side of yellow becomes right side of blue(temp)
        cube[4][2] = temp1;
        cube[4][5] = temp2; //checked
        cube[4][8] = temp3;

        //I'm having to hard code the moves for this turn since I believe that the indexes are
        //slightly different for each face based off of orientation, but I'm not sure.
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
        String temp1 = "";
        String temp2 = "";
        String temp3 = "";
        temp1 = cube[1][0];
        temp2 = cube[1][3];
        temp3 = cube[1][6];
        //left side of blue face becomes left side of yellow
        cube[1][0] = cube[4][0];
        cube[1][3] = cube[4][3]; //checked
        cube[1][6] = cube[4][6];
        //left side of yellow becomes right side of green
        cube[4][0] = cube[3][8];
        cube[4][3] = cube[3][5]; //checked 
        cube[4][6] = cube[3][2];
        //right side of green becomes left side of white
        cube[3][2] = cube[5][6];
        cube[3][5] = cube[5][3]; //checked
        cube[3][8] = cube[5][0];
        //left side of white becomes left side of blue(temp)
        cube[5][0] = temp1;
        cube[5][3] = temp2; //checked
        cube[5][6] = temp3;

        //hmmmmm
    }

    static void f(String[][] cube) {
        /*
            Function for F turn
            expected result of 'F' from goal state:
            yrr     bbb     oow     ggg     yyy     rrr
            yrr     bbb     oow     ggg     yyy     www
            yrr     bbb     oow     ggg     ooo     www
        */

        //Blue face rotation
        rotateFace(cube, 1);

        //F edge slide
        String temp1 = "";
        String temp2 = "";
        String temp3 = "";
        temp1 = cube[0][0];
        temp2 = cube[0][3];
        temp3 = cube[0][6];
        //left side of red face becomes bottom side of yellow
        cube[0][0] = cube[4][6];
        cube[0][3] = cube[4][7]; //checked
        cube[0][6] = cube[4][8];
        //bottom side of yellow becomes right side of orange
        cube[4][6] = cube[2][8];
        cube[4][7] = cube[2][5]; //checked switch [2][2] and [2][8]
        cube[4][8] = cube[2][2];
        //right side of orange becomes top side of white
        cube[2][2] = cube[5][0];
        cube[2][5] = cube[5][1]; //checked
        cube[2][8] = cube[5][2];
        //top side of white becomes left side of red(temp)
        cube[5][0] = temp3;
        cube[5][1] = temp2;
        cube[5][2] = temp1;
        //Just realized I've been doing this wrong.
        //temp1 should be assigned to cube[5][2], not [5][0] and so on.
        //I will place a comment next to assignments to mark revisited code.
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

        f(cube);
        printCube(cube);

        //TODO
        /*
            Make switch statement to handle command line input.
            Loop until user inputs something that breaks the loop.
            Output cube after each turn / after a set of turns.
        */

    }
}
