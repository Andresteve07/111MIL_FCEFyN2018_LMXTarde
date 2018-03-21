/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizarreglos;

/**
 *
 * @author steve-urbit
 */
public class Ahorcado {
    public static char[] resultadoJugada(char[] palabraOriginal, char letra){
        char[] resultado = new char[palabraOriginal.length];
        for (int i = 0; i < palabraOriginal.length; i++) {
            if(palabraOriginal[i]==letra){
                resultado[i] = letra;
            } else {
                resultado[i] = '_';
            }
        }
        return resultado;
    }
    public static boolean validarJugada(char[] jugadasAnteriores, char[] nuevaJugada){
        int contadorAciertos = 0;
        boolean validaOk = false;
        for (int i = 0; i < nuevaJugada.length; i++) {
            if (jugadasAnteriores[i] == '_' && nuevaJugada[i] != '_' ) {
                validaOk = true;
            }
        }
        return validaOk;
    }
}
