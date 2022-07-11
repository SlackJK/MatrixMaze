import jdk.nashorn.internal.ir.WhileNode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UI
{
    public static int StartMessages()
    {

        String Options = "Text File Input [0], Console Input[1]";

        Scanner SC = new Scanner(System.in);
        System.out.println("Welcome to the Maze Solver, please pick how you would like to \n" +
                "input your maze by typing the appropriate value for your option of choice: ");
        System.out.println(Options);
        int in = -1;
        while(in != 0 && in != 1)
        {
            try {
                in = Integer.parseInt(SC.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Sorry, your input did not match the available options.\n" +
                        "Please try again by typing the appropriate value for your option of choice");
                System.out.println(Options);
            }
        }
        FormatWarning(in);
        return in;
    }
    private static void FormatWarning(int InputType)
    {
        String WarningMessage = "---WARNING---\nYour input should be of this format to be run through the Maze Solver:\n" +
                "It must contain a start point \"S\", an end point \"X\", traversable blocks \".\", and could contain non-traversable blocks \"#\".\n" +
                "Here is a demonstration sample:";
        String SampleInputConsole =
                ".S..\n"+
                "..#.\n"+
                "..#.\n"+
                "..#X\n";
        String SampleInputFile =
                ".S..\\n"+
                "..#.\\n"+
                "..#.\\n"+
                "..#X\\n";
        if(InputType == 0)
        {
            System.out.println(WarningMessage);
            System.out.println(SampleInputFile);
        }
        else{
            System.out.println(WarningMessage);
            System.out.println(SampleInputConsole);
        }
    }
    public static void FileInputInRequest(String FilePath)
    {
        System.out.println("Please input your data into the file provided for input at this path:\n"+FilePath);
    }
    public static String ConsoleInputInRequest()
    {
        String Out = "";
        System.out.println("Please type or paste in your maze:\n");
        Scanner SC = new Scanner(System.in);
        while(Out.length()<1)
        {
            Out = SC.nextLine();
        }
        return Out;
    }
    public static void InputValidityCheckFailure(String error) throws IOException, URISyntaxException, InterruptedException
    {
        System.out.println("Input failed due to error: " + error);
        TimeUnit.MILLISECONDS.sleep(600);
        Input I = new Input();
        I.PickInput();
    }
}
