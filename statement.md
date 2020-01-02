# Introduction
Bulls and Cows is a classical brain teasing game. The beauty of this game lies in its simplicity and the fact that all you need to play it is pen and paper. 

# How to Play
Bulls and Cows is a 2 player game. One player thinks of a number, while the other player tries to guess it. 
- The number to be guessed must be a 4 digit number, using only digits from 1 - 9, atmost 1. e.g. 1234 is valid, 0123 is not valid, 9877 is not valid, 9876 is valid.
- For every guess that the player makes, he gets 2 values - the number of bulls and the number of cows. 1 bull means the guess contains and the target number have 1 digit in common, and in the correct position. 1 cow means the guess and the target have 1 digit in common, but not in correct position. e.g. Let the target be 1234. Guessing 4321 will give 0 bulls and 4 cows. 3241 will give 1 bull and 3 cows. 4 bulls means you have won the game!
- The player gets 7 chances to correctly guess the entire number.

P.S. If you still have doubts about the rules, check it over here: https://en.wikipedia.org/wiki/Bulls_and_Cows

#Play it yourself
```java runnable

```
#Solving Bulls and Cows
```java runnable
import java.util.*;
class Main {
    static ArrayList<String> possib = new ArrayList<String>();
    public static void main(String args[]) {
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
```

# Advanced usage

If you want a more complex example (external libraries, viewers...), use the [Advanced Java template](https://tech.io/select-repo/385)
