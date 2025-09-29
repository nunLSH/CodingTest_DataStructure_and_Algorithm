import java.util.*;
public class Main {
    public static int n, m;
    public static final int MAX = 100;
    public static int[][] board = new int[MAX][MAX];
    public static Queue<Pair> q = new ArrayDeque<>();
    public static boolean[][] visited = new boolean[MAX][MAX];
    public static int[] dx = {0, -1, 0, 1}; // 위 왼 아 오
    public static int[] dy = {-1, 0, 1, 0};
    public static int canEscape = 0;

    public static void BFS() {
        while(!q.isEmpty()){

            Pair curr = q.poll();

            for (int i = 0; i < 4; i++){
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                if (newX == n-1 && newY == m-1){
                    canEscape = 1;
                    return;
                }

                if (canGo(newX, newY) && visited[newX][newY] == false){
                    push(newX, newY);
                }
            }
        }
        return;
    }

    public static boolean canGo(int x, int y){
        if(0 <= x && x < n && 0 <= y && y < m){
            if (board[x][y] == 1)
                return true;
            else 
                return false;
        } else
            return false;
    }

    public static void push(int x, int y){
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                board[i][j] = sc.nextInt();
        }

        push(0,0);
        BFS();

        System.out.println(canEscape);
        
    }
}