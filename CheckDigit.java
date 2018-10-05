/*
チェックディジット

クレジットカード番号は16桁の番号で表すことができますが、この番号は以下の性質を持っています。

一番右の桁を1桁目として、

・偶数桁の数字をそれぞれ2倍し総和をとったものをeven
（ただし、2倍したあと2桁の数字になるものは、1の位と10の位の数を足して1桁の数字にしたあと、総和をとる）
・奇数桁の数字の総和をとったものをodd
とすると、even + odd は10 で必ず割り切れます。

1桁目がX と書かれた16桁の番号が複数与えられるので、それぞれに対し、上記性質をみたすようにX に入る数字を求めてください。

入力される値
    入力は以下のフォーマットで与えられます。

        n　　　#入力されるクレジットカードの総数
        a_1　　#1番目のクレジットカード番号
        a_2　　#....
        a_3　　#....
        ...
        a_n　　#n番目のクレジットカード番号

期待する出力
    それぞれのa_i に対し、X に入る数字を一行に出力してください。出力は全部でn 行になります。


入力例1

1
846087729128569X

出力例1

7

入力例2

4
628381026148991X
511070105176715X
273492510450813X
670891979616350X

出力例2

5
9
7
2

入力例3

5
091180422478189X
774123801013511X
973736969204716X
793180803472918X
358682935182058X

出力例3

1
4
0
1
2

*/

import java.util.*;


public class Main {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N;
        int N1;
        int N2;
        int NSum = 0;
        int X = 0;
        
        for(int i=0; i<n; i++){
            String cardNumber = sc.next();
            NSum = 0;
            for(int j=0; j<15; j++){
                N = Integer.parseInt(String.valueOf(cardNumber.charAt(j)));
                if(j%2==0){
                    N = N * 2;
                    if(N > 9){
                        N1 = N - 10;
                        N2 = N / 10;
                        N = N1 + N2;
                    }
                }
                NSum += N;
            }
            X = (10 - NSum % 10) % 10;
            System.out.println(X);
        }
    }
}