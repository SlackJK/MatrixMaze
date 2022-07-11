import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    public static Input I = new Input();
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        Lee L = new Lee();
        I.PickInput();
        System.out.println("The shortest maze path through your maze is:");
        if(matrix.size()>0)
        {
            long StartTime = System.nanoTime();
            System.out.println(L.alg(matrix, I.SourceChords, I.TargetChords));
            long EndTime = System.nanoTime();
            System.out.println("Path found in: "+(EndTime-StartTime)+" nanoseconds or "+((EndTime-StartTime)/1000000)+" milliseconds");
        }
        else{
            Main.main(null);
        }

    }
}
