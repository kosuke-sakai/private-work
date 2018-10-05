/*
数独

あなたは算数の授業で魔方陣を勉強しました。

ここで、N 行 N 列の魔方陣とは、 1 から N^2 までの数字を N 行 N 列に並べたもので、各行、各列、および 2 つの対角線それぞれについて、そこに並んだ数の総和がいずれも等しくなるようなものを言います。

算数の授業で魔方陣に興味を持ったあなたはオリジナルの魔方陣を作って満足していましたが、誤ってこの魔方陣にコーヒーをこぼしてしまったため、魔方陣の中の 2 つの数字が見えなくなってしまいました。

優秀なプログラマーであるあなたは、2 つの見えなくなってしまった数を補うことで、この魔方陣を修復しようと考えました。魔方陣の行数・列数を表す N、および見えている数字の情報が与えられるので、魔方陣を修復してください。

この例では 3 行 3 列の魔方陣を作りましたが、3 行目の 2 列目と 3 行目の 3 列目が見えなくなってしまいました。魔方陣の中で見えていない数字は 4, 9 の二種類です。

3 行目の 2 列目が 4 で、3 行目の 3 列目が 9 である可能性と3 行目の 2 列目が 9 で、3 行目の 3 列目が 4 である可能性との 2 つの可能性が考えられます。前者は正しい魔方陣となりますが、後者は正しい魔方陣とはなりません。よって、答えとしては図 1 の魔方陣を出力します。なお、正しい魔方陣が一通りであることは保証されています。

入力される値

    入力は以下のフォーマットで与えられます。

    N
    m_{1, 1} m_{1, 2} ... m_{1, N}
    m_{2, 1} m_{2, 2} ... m_{2, N}
    ...
    m_{N, 1} m_{N, 2} ... m_{N, N}

        ・1 行目に作った魔方陣の大きさ N が与えられます。
        ・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には N 個の整数が半角スペース区切りで与えられます。i 行目の j 番目 (1 ≦ i ≦ N) の整数 m_{i, j} は作った魔方陣の i 行 j 列目の数を表します。ただし、コーヒーをこぼして見えなくなった部分は 0 になっています。
        
期待する出力

    修復した魔方陣を出力してください。答えとしてあり得る魔方陣は一通りであることが保証されています。
    

入力例1

3
6 1 8
7 5 3
2 0 0

出力例1

6 1 8
7 5 3
2 9 4

入力例2

5
1 15 8 24 0
19 3 21 12 10
13 0 20 6 4
25 9 2 18 11
7 16 14 5 23

出力例2

1 15 8 24 17
19 3 21 12 10
13 22 20 6 4
25 9 2 18 11
7 16 14 5 23

*/
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] m = new int[N][N];
        int[] sumTate = new int[N];
        int[] sumYoko = new int[N];
        int[] sumNaname = new int[2];
        int max = sumTate[0];
        int[] sumNuke = new int[3];
        int[] nuke = new int[3];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                m[i][j] = sc.nextInt();
            }
            for(int j=0; j<N; j++){
                sumTate[j] += m[i][j];
                sumYoko[i] += m[i][j];
            }
            max = Math.max(max, sumYoko[i]);
        }
        for(int i=0; i<N; i++){
            sumNaname[0] += m[i][i];
            sumNaname[1] += m[N-i-1][i];
            if(sumYoko[i]!=max){
                if(sumNuke[0]==0){
                    sumNuke[0] = sumYoko[i];
                }else if(sumYoko[i]!=sumNuke[0]){
                    if(sumNuke[1]==0){
                        sumNuke[1] = sumYoko[i];
                    }else if(sumYoko[i]!=sumNuke[1]){
                        sumNuke[2] = sumYoko[i];
                    }
                }
            }
            for(int j=0; j<N; j++){
                if(sumTate[j]!=max){
                    if(sumNuke[0]==0){
                        sumNuke[0] = sumTate[j];
                    }else if(sumTate[j]!=sumNuke[0]){
                        if(sumNuke[1]==0){
                            sumNuke[1] = sumTate[j];
                        }else if(sumTate[j]!=sumNuke[1]){
                            sumNuke[2] = sumTate[j];
                        }
                    }
                }
            }
        }
        for(int k=0; k<2; k++){
            if(sumNaname[k]!=max){
                if(sumNuke[0]==0){
                    sumNuke[0] = sumNaname[k];
                }else if(sumNaname[k]!=sumNuke[0]){
                    if(sumNuke[1]==0){
                        sumNuke[1] = sumNaname[k];
                    }else if(sumNaname[k]!=sumNuke[1]){
                        sumNuke[2] = sumNaname[k];
                    }
                }
            }
        }
        nuke[0] = max - sumNuke[0];
        nuke[1] = max - sumNuke[1];
        nuke[2] = max - sumNuke[2];
        Arrays.sort(nuke);
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(m[i][j]==0){
                    if(max-sumTate[j]==nuke[0] || max-sumYoko[i]==nuke[0]){
                        m[i][j] = nuke[0];
                    }else{
                        m[i][j] = nuke[1];
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(m[i][j]);
                if(j!=N-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}