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
        if(c == '\\') {
            switch(dir) {
                case 0: dir = 3; x -= 1; return; // 아래 → 왼쪽
                case 1: dir = 2; y -= 1; return; // 오른쪽 → 위
                case 2: dir = 1; x += 1; return; // 위 → 오른쪽
                case 3: dir = 0; y += 1; return; // 왼쪽 → 아래
            }
        } else { // c == '/'
            switch(dir) {
                case 0: dir = 1; x += 1; return; // 아래 → 오른쪽
                case 1: dir = 0; y += 1; return; // 오른쪽 → 아래
                case 2: dir = 3; x -= 1; return; // 위 → 왼쪽
                case 3: dir = 2; y -= 1; return; // 왼쪽 → 위
            }
        }
    }

    public static void calcStart(int k){
        k--; // 0-index로 변환
        if(k < n){ // 아래
            y = 0;
            x = k;
            dir = 0;
        } else if(k < 2*n){ // 오른쪽
            y = k - n;
            x = n - 1;
            dir = 3;
        } else if(k < 3*n){ // 위
            y = n - 1;
            x = n - 1 - (k - 2*n);
            dir = 2;
        } else { // 왼쪽
            y = n - 1 - (k - 3*n);
            x = 0;
            dir = 1;
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
        while(inRange(x, y)){
            move(board[y][x]);
            cnt++;
        }
        System.out.print(cnt);
    }
}