import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Input extends InputParser
{
    private static int InputType;
    public static String FileName = "MazeSolverTXTInput.txt";
    public static String jarDir;
    public static String os = System.getProperty("os.name");
    public Input() {
        super("S", "X");
        InputType = UI.StartMessages();
    }
    public void PickInput() throws IOException, URISyntaxException, InterruptedException
    {
        if(InputType==0)
        {
            ParseFileInput();
            return;
        }
       ParseConsoleInput();

    }
    private void ParseFileInput() throws IOException, URISyntaxException, InterruptedException
    {
        ArrayList<ArrayList<Integer>> Out = new ArrayList<>();


        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        jarDir = jarFile.getParentFile().getPath();

        String FilePath;

        if(os.contains("Windows"))
        {
            FilePath = jarDir+"\\"+FileName;
            CreateTXT(FilePath);
        }
        else
        {
            FilePath = jarDir+"/"+FileName;
            CreateTXT(FilePath);
        }

        UI.FileInputInRequest(FilePath);

        try
        {
           Out = super.InputToMatrix(WaitForFileInput(FilePath).replace("\r",""),"\n");
        }
        catch (Exception e)
        {
            UI.InputValidityCheckFailure("Maze contains illegal characters");
        }
        if(Out.size()>0)
            InputValidityCheck(Out);

    }
    private void ParseConsoleInput() throws IOException, URISyntaxException, InterruptedException
    {
        ArrayList<ArrayList<Integer>> Out = new ArrayList<>();
        try
        {
            Out = super.InputToMatrix(UI.ConsoleInputInRequest(),"\n");
        }
        catch (Exception e)
        {
            UI.InputValidityCheckFailure("Maze contains illegal characters");
        }
        if(Out.size()>0)
            InputValidityCheck(Out);
    }
    private static String WaitForFileInput(String FilePath) throws InterruptedException
    {
        String Input = "";
        while(Input.length()<1)
        {
            Input = TXTtoString(FilePath);
            TimeUnit.MILLISECONDS.sleep(100);
        }
        System.out.println("Your input:");
        System.out.println(Input);
        return Input;
    }
    private static void CreateTXT(String File) throws IOException //Old project copypaste
    {
        try {

            File myObj = new File(File);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static String TXTtoString(String File)//Old project copypaste
    {
        String Out ="";
        try(BufferedReader br = new BufferedReader(new FileReader(File)))
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            Out = everything;
            //System.out.println(Out);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return Out;
    }
    private static void InputValidityCheck(ArrayList<ArrayList<Integer>> In) throws IOException, URISyntaxException, InterruptedException
    {
        int MinSize = 0;
        int MaxSize = 0;
        int CurSize;
        for (int i = 0; i < In.size(); i++)
        {
            CurSize = In.get(i).size();
            if(i==0){
                MinSize = CurSize;
                MaxSize = CurSize;
            }
            if(MaxSize>CurSize)
                MaxSize = CurSize;
            if(MinSize<CurSize)
                MinSize = CurSize;
            if(MinSize!=MaxSize)
            {
                UI.InputValidityCheckFailure("Matrix Maze is not square.");
                return;
            }
        }
        Main.matrix = In;
    }
}
