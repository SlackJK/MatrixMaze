import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
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
        String MethodIn = ".S..\n..#.\n..#.\n..#X\n";
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
    @Test
    void VerifyChordOutput4x4Grid()
    {
        String MethodIn =
                ".S..\n"+
                "..#.\n"+
                "..#.\n"+
                "..#X\n";
        MainHelp MH = new MainHelp("S","X");
        ArrayList<ArrayList<Integer>> MethodOut = MH.InputToMatrix(MethodIn,"\n");
        Chords TrueSource = new Chords(0,1);
        Chords TrueTarget = new Chords(3,3);
        System.out.println("x="+MH.SourceChords.x+",y="+MH.SourceChords.y);
        assertEquals(TrueSource.x,MH.SourceChords.x);
        assertEquals(TrueSource.y,MH.SourceChords.y);

        assertEquals(TrueTarget.x,MH.TargetChords.x);
        assertEquals(TrueTarget.y,MH.TargetChords.y);
    }
    @Test
    void TestLeeAlgorithm4x4Grid()
    {
        String MethodIn = ".S..\n..#.\n..#.\n..#X\n";
        MainHelp MH = new MainHelp("S","X");
        ArrayList<ArrayList<Integer>> MethodPrep = MH.InputToMatrix(MethodIn,"\n");
        Lee L = new Lee();
        ArrayList<String> MethodOut = L.alg(MethodPrep,MH.SourceChords,MH.TargetChords);
        ArrayList<String> TrueOut = new ArrayList<>(Arrays.asList("r","r","d","d","d"));
        assertEquals(TrueOut,MethodOut);
    }


}