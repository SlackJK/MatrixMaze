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
    public Input(String Source, String Target) {
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
    private ArrayList<ArrayList<Integer>> ParseFileInput() throws IOException, URISyntaxException, InterruptedException
    {

        CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        jarDir = jarFile.getParentFile().getPath();
        String FilePath;
        if(os.contains("Windows")){
            FilePath = jarDir+"\\"+FileName;
            CreateTXT(FilePath);
        }
        else{
            FilePath = jarDir+"/"+FileName;
            CreateTXT(FilePath);
        }
        UI.FileInputInRequest(FilePath);
        return super.InputToMatrix(WaitForFileInput(FilePath),"\n");
    }
    private ArrayList<ArrayList<Integer>> ParseConsoleInput()
    {
        return super.InputToMatrix(UI.ConsoleInputInRequest(),"\n");
    }
    private static String WaitForFileInput(String FilePath) throws InterruptedException
    {
        String Input = "";
        while(Input.length()<1)
        {
            Input = TXTtoString(FilePath);
            TimeUnit.MILLISECONDS.sleep(100);
        }
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
}
