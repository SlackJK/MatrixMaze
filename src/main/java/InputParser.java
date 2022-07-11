import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser
{
    public Chords SourceChords;
    public Chords TargetChords;
    private int i =0;
    private String Source;
    private String Target;
    public InputParser(String Source, String Target)
    {
        this.Source = Source;
        this.Target = Target;
    }
    public   ArrayList<ArrayList<Integer>>InputToMatrix(String Input, String delim) throws IOException, URISyntaxException, InterruptedException {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        Input = Input.replace(" ","");
        while(Input.contains(delim))
        {
            out.add(RowCreator(Input.substring(0,Input.indexOf(delim))));
            Input = Input.substring(Input.indexOf(delim)+delim.length());
            i = i +1;
        }
        if(out.size() == 0)
        {
            System.out.println("Input has failed.");
        }
        return out;
    }
    private  ArrayList<Integer> RowCreator(String In)
    {
        In = In.replace(".","1");
        In = In.replace("#","0");
        if(In.contains(Source))
        {
            SourceChords = new Chords(i,In.indexOf(Source));
            In = In.replace(Source,"1");
        }
        if(In.contains(Target))
        {
            TargetChords = new Chords(i,In.indexOf(Target));
            In = In.replace(Target,"1");
        }
        int[] x = Stream.of(In.split("")).mapToInt(Integer::parseInt).toArray();
        return (ArrayList<Integer>) Arrays.stream(x).boxed().collect(Collectors.toList()) ;
    }

}
