import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    public static Input I = new Input();
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {


        String testin =
                "........\n" +
                "..S..#..\n" +
                ".....#X.\n" +
                "........\n";


        Lee L = new Lee();
        I.PickInput();
        System.out.println("The shortest maze path through your maze is:");
        if(matrix.size()>0)
        {
            System.out.println(L.alg(matrix, I.SourceChords, I.TargetChords));
        }
        else{
            Main.main(null);
        }
/*
        InputParser MH = new InputParser("S","X");
        //ArrayList<ArrayList<Integer>> mat = MH.InputToMatrix(testin,"\n");
        Lee z = new Lee();
        //ArrayList<String> x =z.alg(mat,MH.SourceChords,MH.TargetChords);
        //System.out.println(x);
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
