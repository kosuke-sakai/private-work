import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int[][] t = new int[H][W];
        int[] s = new int[N];
        int l = 0;
        
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                t[i][j] = sc.nextInt();
            }
        }
        int L = sc.nextInt();
        int[] a = new int[L];
        int[] b = new int[L];
        int[] A = new int[L];
        int[] B = new int[L];
        
        for(int k=0; k<L; k++){
            a[k] = sc.nextInt();
            b[k] = sc.nextInt();
            A[k] = sc.nextInt();
            B[k] = sc.nextInt();
        }
        for(int k=0; k<L; k++){
            int a1 = a[k]-1;
            int b1 = b[k]-1;
            int A1 = A[k]-1;
            int B1 = B[k]-1;
            if(t[a1][b1] == t[A1][B1]){
                s[l] += 2;
            }else{
                if(l==N-1){
                    l = 0;
                }else{
                    l++;
                } 
            }
        }
        for(int m=0; m<N; m++){
            System.out.println(s[m]);
        }
    }
}