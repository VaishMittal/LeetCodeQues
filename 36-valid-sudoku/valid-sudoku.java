class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] arr = new int[9];
        Arrays.fill(arr, 0);
        int flag = 0;

        //checking each row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int idx = board[i][j] - '1';
                    if (arr[idx] == 0) {
                        arr[idx] += 1;
                    } else {
                        flag = 1;
                        break;
                    }
                } else {
                    continue;
                }
            }
            if (flag == 1) {
                break;
            }
            Arrays.fill(arr, 0);
        }
        if (flag == 1)
            return false;

        //checking each col
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int idx = board[j][i] - '1';
                    if (arr[idx] == 0) {
                        arr[idx] += 1;
                    } else {
                        flag = 1;
                        break;
                    }
                } else {
                    continue;
                }
            }
            if (flag == 1) {
                break;
            }
            Arrays.fill(arr, 0);
        }
        if (flag == 1)
            return false;

 for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Arrays.fill(arr, 0);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[boxRow + i][boxCol + j];
                        if (c != '.') {
                            int idx = c - '1';
                            if (arr[idx] == 0) {
                                arr[idx] = 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }    return true;

    }
}

