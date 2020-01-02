import java.util.*;
class Main {
    static ArrayList<String> possib = new ArrayList<String>();
    public static void main(String args[]) {
        System.out.println("COWS AND BULLS SOLVER:");
        init();
        Scanner in = new Scanner(System.in);
        while (possib.size() > 1) {
            String guess = possib.get((int)(Math.random() * possib.size()));
            System.out.print(guess+" ");
            int bulls = in.nextInt();
            int cows = in.nextInt();
            for (int j = 0; j < possib.size(); j++)
                if (!check(possib.get(j),guess,cows,bulls)) {
                    possib.remove(j);
                    j--;
                }
        }
        for (int j = 0; j < possib.size(); j++)
            System.out.println(possib.get(j));
    }
    
    static void init() {
        for (int a = 1; a <= 9; a++) { 
            for (int b = 1; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 1; c <= 9; c++) {
                    if (c == b || c == a) continue;
                    for (int d = 1; d <= 9; d++) {
                        if (d == a || d == b || d == c) continue;
                        String cnt = ""+a+b+c+d;
                        possib.add(cnt);
                    }
                }
            }
        }
    }
    
    static boolean check(String ans,String guess,int cows,int bulls) {
        for (int i = 0; i < guess.length(); i++) {
            int ind = ans.indexOf(guess.charAt(i));
            if (ind == i) bulls--;
            else if (ind >= 0) cows--;
        }
        return (cows == 0) && (bulls == 0);
    }
}
