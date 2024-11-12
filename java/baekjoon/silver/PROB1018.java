package silver;

import java.io.*;
import java.util.*;

public class PROB1018 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int min = 9999999;
    static int[][] chessBoard;
    static int[][] whiteBaseBoard;
    static int[][] blackBaseBoard;

    static final int WHITE = 0;
    static final int BLACK = 1;

    public static void main(String[] args) throws IOException {
        init();
        drawChessBoard();
        findMinValue();

        System.out.println(min);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chessBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                if (temp[j].equals("W"))
                    chessBoard[i][j] = WHITE;
                else
                    chessBoard[i][j] = BLACK;
            }
        }
    }

    public static void drawChessBoard() {
        whiteBaseBoard = new int[N][M];
        blackBaseBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    whiteBaseBoard[i][j] = WHITE;
                    blackBaseBoard[i][j] = BLACK;
                } else {
                    whiteBaseBoard[i][j] = BLACK;
                    blackBaseBoard[i][j] = WHITE;
                }
            }
        }
    }

    public static void findMinValue() {
        int xMax = N - 7;
        int yMax = M - 7;

        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                int sumBaseWhite = 0;
                int sumBaseBlack = 0;

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (chessBoard[i + k][j + l] != whiteBaseBoard[k][l]) {
                            sumBaseWhite++;
                        }

                        if (chessBoard[i + k][j + l] != blackBaseBoard[k][l]) {
                            sumBaseBlack++;
                        }
                    }
                }

                int temp = Math.min(sumBaseWhite, sumBaseBlack);
                min = Math.min(min, temp);
            }
        }
    }
}
