import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {


        String testin =
                "..............\n" +
                "..S..#....#...\n" +
                "..X..#....#...\n" +
                "..........#...\n";
;
        MainHelp MH = new MainHelp("S","X");
        ArrayList<ArrayList<Integer>> mat = MH.InputToMatrix(testin,"\n");
        Lee z = new Lee();
        ArrayList<String> x =z.alg(mat,MH.SourceChords,MH.TargetChords);
        System.out.println(x);
        /*
        Chords S = new MainHelp().Chord(test2d,"S");
        Chords T = new MainHelp().Chord(test2d,"X");
        System.out.println(test2d);
        test2d.get(S.y).set(0,"0");
        test2d.get(T.y).set(T.x,"0");
        //String temp[][] = test2d.stream().map(l -> l.stream().toArray(Integer[]::new)).toArray(String[][]::new);
        int matrix[][] = test2d.stream().map(l -> l.stream().mapToInt(Integer::parseInt)).toArray(int[][]::new);
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.println(matrix[i][j]);
            }
            System.out.println("\n");
        }

         */
    }
}
