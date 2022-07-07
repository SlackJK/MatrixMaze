import java.util.ArrayDeque;
import java.util.Queue;

public class Lee
{
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public int alg(int matrix[][],Chords Spoint,Chords target)
    {
        int McolL = matrix.length;
        int MrowL = matrix[0].length;
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
    private static boolean ValidityCheck(int[][] matrix, boolean[][] visited, int row, int col)
    {
        return (row >= 0) && (row < matrix.length) && (col >= 0) && (col < matrix[0].length) && matrix[row][col] == 1 && !visited[row][col];
    }
}
