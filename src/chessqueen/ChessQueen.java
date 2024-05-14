package chessqueen;

import java.util.InputMismatchException;
import java.util.Scanner;

//Falta corregir ejecución


public class ChessQueen {

    public static void main(String[] args) {
      
        final char VACIO= 'X';
        final char REINA = 'O';

        char [][] matriz= new char [8][8];
    
        rellenarMatriz(matriz, VACIO);
        
        int posActualREINAX = generateRandomNumber(0, matriz.length-1);//fila
        int posActualREINAY = generateRandomNumber(0, matriz[0].length-1);//columna
        
        int posAntiguaREINAX, dirX = 0;
        int posAntiguaREINAY, dirY = 0;
        
      
        matriz[posActualREINAX][posActualREINAY]= REINA;

        Scanner sc = new Scanner (System.in);
        boolean salir = false;
        int opcion; //guarda opcion elegida x usuario
    
     
        while (!salir){
            
            mostrarMatriz(matriz);
            
            System.out.println("¿Dónde quieres moverte?");
            System.out.println("1. Mover arriba");
            System.out.println("2. Mover arriba-derecha");
            System.out.println("3. Mover derecha");
            System.out.println("4. Mover abajo-derecha");
            System.out.println("5. Mover abajo");
            System.out.println("6. Mover abajo-izquierda");
            System.out.println("7. Mover izquierda");
            System.out.println("8. Mover arriba-izquierda");
            System.out.println("9. Salir");

            try {
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();
            
                posAntiguaREINAX = posActualREINAX;
                posAntiguaREINAY = posActualREINAY;

                switch (opcion) {
                    case 1:
                        dirX = -1;
                        dirY = 0;
                        break;

                    case 2:
                        dirX = -1;
                        dirY = 1;
                        break;

                    case 3:
                        dirX = 0;
                        dirY = 1;
                        break;

                    case 4:
                        dirX = 1;
                        dirY = 1;
                        break;
                    case 5:
                        dirX = 0;
                        dirY = -1;
                        break;
                    case 6:
                        dirX = 1;
                        dirY = -1;
                        break;
                    case 7:
                        dirX = 0;
                        dirY = -1;
                        break;
                    case 8:
                        dirX = -1;
                        dirY = -1;
                        break;

                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                        
                }
                int nuevaPosREINAX = posActualREINAX + dirX;
                int nuevaPosREINAY = posActualREINAY + dirY;
                
                while (estaLimiteMatriz (matriz.length, matriz[0].length, 
                                        nuevaPosREINAX, nuevaPosREINAY)){
                    posActualREINAX += dirX;
                    posActualREINAY += dirY;
                }

                if (estaLimiteMatriz(matriz.length, matriz[0].length, nuevaPosREINAX, nuevaPosREINAY)) {
                    matriz[posActualREINAX][posActualREINAY] = VACIO;
                    posActualREINAX = nuevaPosREINAX;
                    posActualREINAY = nuevaPosREINAY;
                    matriz[posActualREINAX][posActualREINAY] = REINA;
                } else {
                    System.out.println("Te sales del tablero");
                }
                
                /*if (estaLimiteMatriz(matriz.length, matriz[0].length, 
                                    posActualAlfilX+dirX, posActualAlfilY+dirY)) {
                matriz[posAntiguaAlfilX][posAntiguaAlfilY]= VACIO;
                matriz[posActualAlfilX][posActualAlfilY]= ALFIL;
                
                
                }else{
                    System.out.println("Te sales del tablero");
                    posActualAlfilX = posAntiguaAlfilX;
                    posActualAlfilY = posAntiguaAlfilY;
                }*/
                
            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sc.next();
            }
        }
    }
    public static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void rellenarMatriz(char[][] matriz, char simbolo){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = 'X';
                }
            }
    } 
    
    public static boolean estaLimiteMatriz(int longitudFilas, int longitudColumnas, int x, int y) {
    
        return x>= 0 && x< longitudFilas && y>=0 && y <longitudColumnas;//Acá 0 es la primera columna del array
    }
    
     public static int generateRandomNumber(int minimo, int maximo) {
        return (int) ((Math.random() * (maximo - minimo + 1)) + (minimo));
    }

}