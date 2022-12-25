import java.util.Scanner;

public class Lab2 {
    public static int NumOfStr(int matrix[][], int N, int M){
        int number = 0;
        int max = 1;
        for(int i = 0; i < N; i++){
            int count  = 1;
            for(int j = 0; j < M - 1; j++){
                if(matrix[i][j] == matrix[i][j+1]){
                    count++;
                }
                else{
                    if(count > max){
                        max = count;
                        number = i;
                    }
                    count = 1;
                }
            }
            if(count != 1){
                if(count > max){
                    max = count;
                    number = i;
                }
            }
        }
        if(max == 1){
            return -1;
        }
        return number;
    }
    public static int NumOfLocalMin(int matrix[][], int N,int M){
        int mycounter = 0;
        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < M - 1; j++){
                if(matrix[i][j] < matrix[i][j-1] && matrix[i][j] < matrix[i][j+1] &&
                        matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i + 1][j]){
                    mycounter++;
                }
            }
        }
        return mycounter;
    }
    public static void TheGreatestInHighestLeft(int matrix[][], int N, int M){
        int max = matrix[0][0];
        int max_i = 0, max_j = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        int temp;
        for(int i = 0; i < N; i++){
            for(int j = max_j; j > 0; j--){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][j - 1];
                matrix[i][j - 1] = temp;
            }
        }
        for(int j = 0; j < M; j++){
            for(int i = max_i; i > 0; i--){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i - 1][j];
                matrix[i - 1][j] = temp;
            }
        }
    }
    public static void OutputMatrix(int matrix[][], int N, int M){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\t");
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N, M; // N - строк M - столбцов
        N = in.nextInt();
        M = in.nextInt();
        int[][] matrix = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        OutputMatrix(matrix, N, M);
        if(NumOfStr(matrix, N, M) == -1){
            System.out.println("There is no sequences.");
        }
        else {
           System.out.println("Number of string with the longest sequence:" + NumOfStr(matrix, N, M));
        }
        System.out.println("Number of local minimums:" + NumOfLocalMin(matrix,N, M));
        System.out.println("Matrix with the greatest element in the highest left corner:");
        TheGreatestInHighestLeft(matrix, N, M);
        OutputMatrix(matrix, N, M);
    }
}