package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: jinyuan
 * @since: 2019/11/1 16:36
 */
/*判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:
输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true

示例 2:
输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false

解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

说明:
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。
*/
public class IsValidSudoku_36 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku = isValidSudoku(board);
        System.out.println("validSudoku = " + validSudoku);
    }

    public static boolean isValidSudoku(char[][] board) {
        // 官方题解
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];  // 行
        HashMap<Integer, Integer> [] columns = new HashMap[9];  // 列
        HashMap<Integer, Integer> [] boxes = new HashMap[9];    // 每9格
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    /*public static boolean isValidSudoku(char[][] board) {
        // 先检查每一行及每一列 是否存在重复数字
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> columnSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }

                if (board[j][i] != '.' && columnSet.contains(board[j][i])) {
                    return false;
                } else {
                    columnSet.add(board[j][i]);
                }
            }
        }

        // 再检查每9格内是否有重复数字
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                // 得到每大格的第一个点位置
                HashSet<Character> nineSet = new HashSet<>();
                for (int m = 0; m <3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i+m][j+n] != '.' && nineSet.contains(board[i+m][j+n])) {
                            return false;
                        } else {
                            nineSet.add(board[i+m][j+n]);
                        }
                    }
                }
            }
        }
        return true;
    }*/
}
