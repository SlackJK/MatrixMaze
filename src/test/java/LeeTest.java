import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LeeTest
{
    @Test
    void TestWholeMatrixGenerator4x4Grid()
    {
        String MethodIn = "....\n..#.\n..#.\n..#.\n";
        MainHelp MH = new MainHelp("S","X");
        ArrayList<ArrayList<Integer>> MethodOut = MH.InputToMatrix(MethodIn,"\n");
        ArrayList<ArrayList<Integer>> TestOut = new ArrayList<ArrayList<Integer>>(){{
            add((ArrayList<Integer>) Arrays.stream(new int[] {1,1,1,1}).boxed().collect(Collectors.toList()));
            add((ArrayList<Integer>) Arrays.stream(new int[] {1,1,0,1}).boxed().collect(Collectors.toList()));
            add((ArrayList<Integer>) Arrays.stream(new int[] {1,1,0,1}).boxed().collect(Collectors.toList()));
            add((ArrayList<Integer>) Arrays.stream(new int[] {1,1,0,1}).boxed().collect(Collectors.toList()));
        }};
        for (int i = 0; i < 4; i++)
        {
            assertEquals(TestOut.get(i), MethodOut.get(i));
        }

    }
    void TestOneLineOfMatrixGen()
    {
        //assertLinesMatch();
    }
    @Test
    void TestLeeAlgorithm4x4Grid()
    {

    }


}