package game;

import main.Consts;

import java.util.Scanner;

/**
 * Created by Никита on 09.03.2015.
 */
public class Game {
    public static char[][] field = new char[Consts.length][Consts.length];
    public static boolean turnX = true;
    public static boolean endGame = false;


    public Game(){
        clearField();
        System.out.println("Вводите координаты (x) (y)");
        while (!endGame)
        {
            turn();
        }
    }

    //Ход
    public static void turn()
    {
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);

        if (turnX)
            System.out.println("Ход крестиков");
        else
            System.out.println("Ход ноликов");

        try
        {
               x = scanner.nextInt() - 1;
               y = scanner.nextInt() - 1;
            if (field[y][x] == '-')
            {
                if (turnX)
                    field[y][x] = 'X';
                else
                    field[y][x] = 'O';
            }
            else {
                System.out.println("Поле уже занято");
                turn();
                turnX = !turnX;
            }
        }
        catch (Exception e)
        {
            System.out.println("Произошла ошибка при вводе");
            turn();
            turnX = !turnX;
        }

        endTurn();
    }
   //Конец хода
    public static void endTurn()
    {
        printField();
        if (winX())
        {
            System.out.println("Победа крестиков.");
            endGame = true;
        }
        if (winO())
        {
            System.out.println("Победа ноликов.");
            endGame = true;
        }
        turnX = !turnX;
    }

    public static void printField()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void clearField()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                field[i][j] = '-';
            }
        }
    }

    //Условия победы
    public static boolean winX()
    {
        for (int i=0; i<3; i++)
        {
            if((field[0][i] == 'X') && (field[1][i] == 'X') && (field[2][i] == 'X'))
                return true;
            if((field[i][0] == 'X') && (field[i][1] == 'X') && (field[i][2] == 'X')) {
                return true;
            }
        }
        if((field[0][0] == 'X') && (field[1][1] == 'X') && (field[2][2] == 'X'))
            return true;
        if((field[0][2] == 'X') && (field[1][1] == 'X') && (field[2][0] == 'X'))
            return true;

        return false;
    }

    public static boolean winO()
    {
        for (int i=0; i<3; i++)
        {
            if((field[0][i] == 'O') && (field[1][i] == 'O') && (field[2][i] == 'O'))
                return true;
            if((field[i][0] == 'O') && (field[i][1] == 'O') && (field[i][2] == 'O')) {
                return true;
            }
        }
        if((field[0][0] == 'O') && (field[1][1] == 'O') && (field[2][2] == 'O'))
            return true;
        if((field[0][2] == 'O') && (field[1][1] == 'O') && (field[2][0] == 'O'))
            return true;

        return false;
    }

}
