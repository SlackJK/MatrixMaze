import java.util.ArrayList;

public class MainHelp
{
    public static Chords Chord(ArrayList<ArrayList<String>> in, String what)
    {
        for (int i = 0; i < in.size(); i++)
        {
            for (int j = 0; j < in.get(0).size(); j++)
            {
                if(in.get(i).get(j).contains(what))
                {
                    return new Chords(j,i);
                }
            }
        }
        return null;
    }
}
