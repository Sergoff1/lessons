import java.util.*;

public class Level1
{
    public static int ConquestCampaign(int N, int M, int L, int [] battalion)
      {
        int days = 0,conqueredCells = 0, cells = N*M;
        int [][] field = new int[N][M];

        for (int i = 0; i < battalion.length; i += 2) {           //Высадка десанта
            field[battalion[i]-1][battalion[i+1]-1] = 1;
        }

        for (int [] k :field){                                    //Заполнение числа завоёванных клеток
                for(int i: k){     
                    conqueredCells +=i ;
                }
        }

        days++;
        while (conqueredCells < cells){                                //Боевые действия
            conqueredCells = 0;                                        // Обнуляем счётчик территорий, иначе будут считаться и те,что уже захвачены
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
 
                    if (field[i][j] == 1 && i == 0) {             //Захват клеток, у верхней границы
                        if (j == 0) {
                           if (field[i+1][j] == 0) {field[i+1][j] = 2;}
                           if (field[i][j+1] == 0) {field[i][j+1] = 2;}
                        } else if (j == field[i].length - 1) {
                            if (field[i+1][j] == 0) {field[i+1][j] = 2;}
                            if (field[i][j-1] == 0) {field[i][j-1] = 2;} 
                        } else {
                            if (field[i+1][j] == 0) {field[i+1][j] = 2;}
                            if (field[i][j-1] == 0) {field[i][j-1] = 2;} 
                            if (field[i][j+1] == 0) {field[i][j+1] = 2;}
                        }
                    }
                        if (field[i][j] == 1 && i == field.length - 1) {  //Захват клеток, у нижней границы
                            if (j == 0) {
                                if (field[i-1][j] == 0) {field[i-1][j] = 2;}
                                if (field[i][j+1] == 0) {field[i][j+1] = 2;}
                            } else if (j == field[i].length - 1) {
                                if (field[i-1][j] == 0) {field[i-1][j] = 2;}
                                if (field[i][j-1] == 0) {field[i][j-1] = 2;} 
                            } else {
                                if (field[i-1][j] == 0) {field[i-1][j] = 2;}
                                if (field[i][j-1] == 0) {field[i][j-1] = 2;} 
                                if (field[i][j+1] == 0) {field[i][j+1] = 2;}
                            }
                        }

                        if (field[i][j] == 1 && i !=0 && i != field.length - 1) {     //Захват средних клеток
                            if (j == 0) {
                                if (field[i-1][j] == 0) {field[i-1][j] = 2;} 
                                if (field[i+1][j] == 0) {field[i+1][j] = 2;}
                                if (field[i][j+1] == 0) {field[i][j+1] = 2;}
                            } else if (j == field[i].length - 1) {
                                if (field[i-1][j] == 0) {field[i-1][j] = 2;} 
                                if (field[i+1][j] == 0) {field[i+1][j] = 2;}
                                if (field[i][j-1] == 0) {field[i][j-1] = 2;}  
                            } else {
                                if (field[i-1][j] == 0) {field[i-1][j] = 2;} 
                                if (field[i+1][j] == 0) {field[i+1][j] = 2;}
                                if (field[i][j-1] == 0) {field[i][j-1] = 2;} 
                                if (field[i][j+1] == 0) {field[i][j+1] = 2;}
                            }
                        }
                }
            }

                for (int i = 0; i < field.length; i++) {              //Превращение клеток в захваченные
                    for (int j = 0; j < field[i].length; j++) {
                        if (field[i][j] == 2) {
                            field[i][j] = 1;
                        }
                    }
                }
            days++;

            for (int [] k :field){                                    //Заполнение числа завоёванных клеток
                for(int i: k){     
                    conqueredCells +=i ;
                }
            }
        } 
        return days;
      }
}
