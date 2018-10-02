import java.util.*;

/*
入力は以下のフォーマットで与えられます。
H W N
t_{1,1} t_{1,2} ... t_{1,W}
t_{2,1} t_{2,2} ... t_{2,W}
...
t_{H,1} t_{H,2} ... t_{H,W}
L
a_1 b_1 A_1 B_1
a_2 b_2 A_2 B_2
...
a_L b_L A_L B_L

1行目には3つの整数 H, W, Nが入力されます。 H と W はそれぞれ並べられたトランプの縦方向の枚数と横方向の枚数で、 N はプレイヤーの数を表します。
続く H 行には、配置されたトランプに書かれた数字が入力されます。 t_{i,j} は i 行 j 列に置かれたトランプに書かれた数字を表します。
次の行には、記録の長さ L が与えられます。
続く L 行には、捲られたトランプの記録が時系列順で与えられます。 これは、a_i 行 b_i 列のトランプと A_i 行 B_i 列のトランプが捲られたことを表します。

出力は以下の形式で出力されます。
s_1
s_2
...
s_N

s_i は i 番目のプレイヤーが取り除いたトランプの枚数を表します。
*/

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
