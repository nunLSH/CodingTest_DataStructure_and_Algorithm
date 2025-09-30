import java.util.*;

public class Main {
    public static int n, k;
    public static final int MAX = 1000;
    public static char[][] board = new char[MAX][MAX];
    public static int dir, x, y;

    // dir
    // 아 오 위 왼 
    // 0 1 2 3
    public static void move(char c){
        if (c == '\\'){
            switch(dir){
                case 0:
                    dir = 1;
                    x += 1;
                    return;
                case 1:
                    dir = 2;
                    y -= 1;
                    return;
                case 2:
                    dir = 3;
                    x -= 1;
                    return;
                default:
                    dir = 0;
                    y += 1;
                    return;
            }
        } else { 
            switch(dir){
                case 0:
                    dir = 3;
                    x -= 1;
                    return;
                case 1:
                    dir = 0;
                    y += 1;
                    return;
                case 2:
                    dir = 1;
                    x += 1;
                    return;
                default:
                    dir = 2;
                    y -= 1;
                    return;
            }
        }
    }

    public static void calcStart(int k){
        switch((k-1) / n){
            case 0:
                x = k - 1;
                y = 0;
                dir = 0; // 아
                return;
            case 1:
                x = n - 1;
                y = k - 1 - n;
                dir = 3; // 왼
                return;
            case 2:
                x = 3 * n - k;
                y = n - 1;
                dir = 2; // 위
                return;
            default:
                x = 0;
                y = 3 * n - k;
                dir = 1;
                return; // 오
        }
    }

    public static boolean inRange(int x, int y){
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        for (int i = 0; i < n; i++){
            String s = sc.next();
            for (int j = 0; j < n; j++){
                board[i][j] = s.charAt(j);
            }
        }
        
        k = sc.nextInt();
        calcStart(k); // 시작점 계산
        
        int cnt = 0; // 튕기는 횟수
        while (inRange(x, y)){
            move(board[x][y]);
            cnt++;
        }
        System.out.print(cnt);
    }
}