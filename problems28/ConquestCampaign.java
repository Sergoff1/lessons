import java.util.*;

public class ConquestCampaign
{
    public static int getDaysForConquest(int N, int M, int L, int [] battalion)
      {
        int conqueredCells = 0;
        int [][] battleField = new int[N][M];

        for (int i = 0; i < battalion.length; i += 2) {           //Высадка десанта
            battleField[battalion[i]-1][battalion[i+1]-1] = 1;
        }

        for (int [] k :battleField){                                    //Заполнение числа завоёванных клеток
                for(int i: k){     
                    conqueredCells +=i ;
                }
        }

        int days = 1;
        while (conqueredCells < N*M){                                  //Боевые действия
            conqueredCells = 0;                                        // Обнуляем счётчик территорий, иначе будут считаться и те,что уже захвачены
            for (int i = 0; i < battleField.length; i++) {
                for (int j = 0; j < battleField[i].length; j++) {

                    boolean isTopRow = ( battleField[i][j] == 1 && i == 0 );
                    if (isTopRow) {             //Захват клеток, у верхней границы
                        if (j == 0) {
                           if (battleField[i+1][j] == 0) {battleField[i+1][j] = 2;}
                           if (battleField[i][j+1] == 0) {battleField[i][j+1] = 2;}
                        } else if (j == battleField[i].length - 1) {
                            if (battleField[i+1][j] == 0) {battleField[i+1][j] = 2;}
                            if (battleField[i][j-1] == 0) {battleField[i][j-1] = 2;} 
                        } else {
                            if (battleField[i+1][j] == 0) {battleField[i+1][j] = 2;}
                            if (battleField[i][j-1] == 0) {battleField[i][j-1] = 2;} 
                            if (battleField[i][j+1] == 0) {battleField[i][j+1] = 2;}
                        }
                    }

                    boolean isBottomRow = ( battleField[i][j] == 1 && i == battleField.length - 1 );
                    if (isBottomRow) {  //Захват клеток, у нижней границы
                        if (j == 0) {
                            if (battleField[i-1][j] == 0) {battleField[i-1][j] = 2;}
                            if (battleField[i][j+1] == 0) {battleField[i][j+1] = 2;}
                        } else if (j == battleField[i].length - 1) {
                            if (battleField[i-1][j] == 0) {battleField[i-1][j] = 2;}
                            if (battleField[i][j-1] == 0) {battleField[i][j-1] = 2;} 
                        } else {
                            if (battleField[i-1][j] == 0) {battleField[i-1][j] = 2;}
                            if (battleField[i][j-1] == 0) {battleField[i][j-1] = 2;} 
                            if (battleField[i][j+1] == 0) {battleField[i][j+1] = 2;}
                        }
                    }

                    boolean isMiddleRow = ( battleField[i][j] == 1 && i !=0 && i != battleField.length - 1 );
                    if (isMiddleRow) {     //Захват средних клеток
                        if (j == 0) {
                            if (battleField[i-1][j] == 0) {battleField[i-1][j] = 2;} 
                            if (battleField[i+1][j] == 0) {battleField[i+1][j] = 2;}
                            if (battleField[i][j+1] == 0) {battleField[i][j+1] = 2;}
                        } else if (j == battleField[i].length - 1) {
                            if (battleField[i-1][j] == 0) {battleField[i-1][j] = 2;} 
                            if (battleField[i+1][j] == 0) {battleField[i+1][j] = 2;}
                            if (battleField[i][j-1] == 0) {battleField[i][j-1] = 2;}  
                        } else {
                            if (battleField[i-1][j] == 0) {battleField[i-1][j] = 2;} 
                            if (battleField[i+1][j] == 0) {battleField[i+1][j] = 2;}
                            if (battleField[i][j-1] == 0) {battleField[i][j-1] = 2;} 
                            if (battleField[i][j+1] == 0) {battleField[i][j+1] = 2;}
                        }
                    }
                }
            }

            for (int i = 0; i < battleField.length; i++) {              //Превращение клеток в захваченные
                for (int j = 0; j < battleField[i].length; j++) {
                    if (battleField[i][j] == 2) {
                        battleField[i][j] = 1;
                    }
                }
            }
            days++;

            for (int [] k :battleField){                                    //Заполнение числа завоёванных клеток
                for(int i: k){     
                    conqueredCells +=i ;
                }
            }
        } 
        return days;
      }
}
