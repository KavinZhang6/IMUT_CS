/*
 * 要求:
 * (1) 从1-13的13张牌中国随机抽取n个牌;
 * (2) 使n个牌的和最接近21;
 * (3) 当超过21时游戏结束;
 * (4) 玩两次游戏,比较结果;
*/
import java.util.Scanner;

public class Homework1{
    static String[] card = {
        "2","3","4","5","6",
        "7","8","9","10","Jack",
        "Queen","King","Ace"
    };
    static boolean[] isHere = {
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true
    };
    public static int getCard() {
        int idx = (int)(Math.random()*100)%12;
        while(isHere[idx]!=true){
            idx = (int)(Math.random()*100)%12;
        }
        isHere[idx] = false;
        return idx+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 2, cnt = 0;
        int[] ans = new int[2];
        while((t--)>0){
            int n = sc.nextInt();
            int sum = 0;
            for(int i=0; i<n; i++){
                sum += getCard();
                if(sum>21) break;
            }
            ans[cnt++] = sum;
        }
        System.out.printf("第一次结果:%d\n", ans[0]);
        System.out.printf("第二次结果:%d\n", ans[1]);
        if(Math.abs(ans[0]-21) < Math.abs(ans[1]-21)) System.out.println("第一次更接近");
        else if(Math.abs(ans[0]-21) > Math.abs(ans[1]-21)) System.out.println("第二次更接近");
        else if(Math.abs(ans[0]-21) == Math.abs(ans[1]-21)) System.out.println("两次一样!");
        sc.close();
    }
}