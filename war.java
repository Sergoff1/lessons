import java.util.*;

public class Level1
{
    public static int ConquestCampaign(int N, int M, int L, int [] battalion)
      {
        int days = 0,conquered = 0, cells = N*M;
        int [][] field = new int[N][M];
        for (int i = 0; i < battalion.length; i += 2) {           //Высадка десанта
            field[battalion[i]-1][battalion[i+1]-1] = 1;
        }

        for (int [] k :field){                                    //Первичное заполнение числа завоёванных клеток
            for(int i: k){     
                    if (i == 1) {
                        conquered +=1;
                    }
                }
            } 

        days++;
        while (conquered < cells){                                //Боевые действия
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
 
                    if (field[i][j] == 1 && i == 0) {
                        if (j == 0) {
                            field[i+1][j] = 2;
                            field[i][j+1] = 2;
                        } else if (j == field[i].length - 1) {
                            field[i+1][j] = 2;
                            field[i][j-1] = 2;   
                        } else {
                            field[i+1][j] = 2;
                            field[i][j-1] = 2;
                            field[i][j+1] = 2;
                        }
                    }
                        if (field[i][j] == 1 && i == field.length - 1) {
                            if (j == 0) {
                                field[i-1][j] = 2;
                                field[i][j+1] = 2;
                            } else if (j == field[i].length - 1) {
                                field[i-1][j] = 2;
                                field[i][j-1] = 2;   
                            } else {
                                field[i-1][j] = 2;
                                field[i][j-1] = 2;
                                field[i][j+1] = 2;
                            }
                        }

                        if (field[i][j] == 1 && i !=0 && i != field.length - 1) {
                            if (j == 0) {
                                field[i+1][j] = 2;
                                field[i-1][j] = 2;
                                field[i][j+1] = 2;
                            } else if (j == field[i].length - 1) {
                                field[i+1][j] = 2;
                                field[i-1][j] = 2;
                                field[i][j-1] = 2;   
                            } else {
                                field[i+1][j] = 2;
                                field[i-1][j] = 2;
                                field[i][j-1] = 2;
                                field[i][j+1] = 2;
                            }
                        }
                }
            }

            for (int [] k :field){
                for(int i: k){     
                        if (i == 2) {
                            i = 1;
                            conquered +=1;
                        }
                    }
                } 
            days++;
        }
        return days;
      }
}