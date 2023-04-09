package com.hwh.leet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author hwh
 * @create 2023-04-09 16:15
 */
public class d33_Word_Search {
    public static void main(String[] args) {
//        boolean b = exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        boolean b = exist(new char[][]{{'A', 'A'}}, "AAA");
        System.out.println("b = " + b);
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (c == board[i][j]) {
                    if(word.length()==1){
                        return true;
                    }
                    board[i][j]='0';
                    boolean b = Backtracking(board, word.substring(1), i, j, board.length, board[i].length);
                    board[i][j]=c;
                    if(b){
                        return b;
                    }
                }
            }
        }

        return false;
    }

    public static boolean Backtracking(char[][] board, String word, int i, int j, int m, int n) {
        if(word.length()==0){
            return true;
        }
        char c = word.charAt(0);
        String str = word.substring(1);
        int[] iIndex = new int[]{i + 1, i - 1, i, i};
        int[] jIndex = new int[]{j, j, j + 1, j - 1};
        for (int k = 0; k < 4; k++) {
            if (iIndex[k] >= 0 && iIndex[k] < m && jIndex[k] >= 0 && jIndex[k] < n) {
                if (board[iIndex[k]][jIndex[k]] == c && board[iIndex[k]][jIndex[k]] != '0') {
                    board[iIndex[k]][jIndex[k]] = '0';//表示已被检索过了
                    boolean b = Backtracking(board, str, iIndex[k], jIndex[k], m, n);
                    if (b) {
                        return b;
                    }
                    board[iIndex[k]][jIndex[k]] = c;//再恢复
                }
            }
        }
        return false;
    }
}
