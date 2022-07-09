import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Lee
{
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public int alg(ArrayList<ArrayList<Integer>> matrix, Chords Spoint, Chords target)
    {
        int McolL = matrix.size();
        int MrowL = matrix.get(0).size();
        boolean[][] visited = new boolean[McolL][MrowL];
        Queue<Node> q = new ArrayDeque<>();
        visited[Spoint.x][Spoint.y] = true;
        q.add(new Node(Spoint,0));

        while(!q.isEmpty())
        {
            Node node = q.poll();

            Chords curChord = node.ch;
            int distance = node.distance;

            if(curChord.x == target.x && curChord.y == target.y)
                return distance;


            for (int i = 0; i < 4; i++)
            {
                if(ValidityCheck(matrix,visited,curChord.x+row[i], curChord.y+col[i]))
                {
                    visited[curChord.x+row[i]][curChord.y+col[i]] = true;
                    q.add(new Node(new Chords(curChord.x+row[i], curChord.y+col[i]),distance+1));
                }
            }
        }
        return -1;
    }
    private static boolean ValidityCheck(ArrayList<ArrayList<Integer>> matrix, boolean[][] visited, int row, int col)
    {
        return (row >= 0) && (row < matrix.size()) && (col >= 0) && (col < matrix.get(0).size()) && matrix.get(row).get(col) == 1 && !visited[row][col];
    }
}
