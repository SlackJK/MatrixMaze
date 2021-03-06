import java.util.*;

public class Lee
{
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public ArrayList<String> alg(ArrayList<ArrayList<Integer>> matrix, Chords Spoint, Chords target)
    {
        int McolL = matrix.size();
        int MrowL = matrix.get(0).size();
        Node StartNode = new Node(Spoint,0);

        boolean[][] visited = new boolean[McolL][MrowL];
        Queue<Node> q = new ArrayDeque<>();

        visited[Spoint.y][Spoint.x] = true;
        q.add(StartNode);

        ArrayList<String> out = new ArrayList<>();
        HashMap<Node,Node> HPath = new HashMap<>();
        HPath.put(StartNode,null);
        Node node = null;
        Chords curChord = new Chords(-1,-1);
        int distance = -1;

        while(!q.isEmpty() && !(curChord.y == target.y && curChord.x == target.x))
        {
            node = q.poll();

            curChord = node.ch;
            distance = node.distance;

            for (int i = 0; i < 4; i++)
            {
                if(ValidityCheck(matrix,visited,curChord.y+row[i], curChord.x+col[i]))
                {
                    visited[curChord.y+row[i]][curChord.x+col[i]] = true;
                    Node tempnode = new Node(new Chords(curChord.y+row[i], curChord.x+col[i]),distance+1);
                    q.add(tempnode);
                    HPath.put(tempnode,node);
                    out.add(row[i]+"/"+col[i]);
                }
            }
        }
        ArrayList<Node> path = new ArrayList<>();
        path.add(0,node);
        while (!NodeCompare(node,StartNode)) {
            node = HPath.get(node);
            path.add(0,node); // addFirst is used to get the correct order
        }

        return GetDirection(path);
    }
    private static boolean ValidityCheck(ArrayList<ArrayList<Integer>> matrix, boolean[][] visited, int row, int col)
    {
        return (row >= 0) && (row < matrix.size()) && (col >= 0) && (col < matrix.get(0).size()) && matrix.get(row).get(col) == 1 && !visited[row][col];
    }
    private static ArrayList<String> DirectionTranslator(ArrayList<String> In)
    {
        ArrayList<String> DirMap = new ArrayList<>(Arrays.asList("-1/0","0/-1","0/1","1/0"));
        ArrayList<String> DirDict = new ArrayList<>(Arrays.asList("d","r","l","u"));
        ArrayList<String> Out = new ArrayList<>();
        for (String x: In)
        {
            for (int i = 0; i < DirMap.size(); i++)
            {
                if(DirMap.get(i).equals(x))
                {
                    Out.add(DirDict.get(i));
                }
            }
        }
        return Out;
    }
    private static ArrayList<String> GetDirection(ArrayList<Node> In)
    {
        ArrayList<String> Out = new ArrayList<>();
        if(In.size()>0)
        {
            for (int i = 1; i < In.size(); i++)
            {
                int y = In.get(i-1).ch.y - In.get(i).ch.y;
                int x = In.get(i-1).ch.x - In.get(i).ch.x;
                Out.add(y+"/"+x);
            }
            //return DirectionTranslator(Out);
        }

        return DirectionTranslator(Out);
    }
    private static boolean NodeCompare(Node n1,Node n2)
    {
        if(n1.ch.equals(n2.ch) && n1.distance == n2.distance)
        {
            return true;
        }
        return false;
    }
}