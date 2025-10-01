import java.util.*;
public class Main {
    public static int T, a, b;
    public static final int MAX = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int max = 0;
        int[] arr = new int[MAX+1];
        for (int i = 0; i < T; i++){
            char c = sc.next().charAt(0);
            arr[sc.nextInt()] = c;
        }

        int cnt = 0;
        for (int k = a; k <= b; k++){
            int d1 = MAX;
            int d2 = MAX;
            for (int c = 1; c <= MAX; c++){
                if (arr[c] == 'S'){
                    d1 = Math.min(d1, Math.abs(k - c));
                } else if (arr[c] == 'N'){
                    d2 = Math.min(d2, Math.abs(k - c));
                }
            }

            if (d1 <= d2)
                cnt++;
            
        }
        System.out.println(cnt);
    }
}