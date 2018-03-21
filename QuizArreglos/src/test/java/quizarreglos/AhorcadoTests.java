/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizarreglos;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

/**
 *
 * @author steve-urbit
 */
public class AhorcadoTests extends TestCase{
    
    public AhorcadoTests() {
        // we do not want the users to print something
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException { }
        }));
        System.setErr(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException { }
        }));
    }
    
    public void testJugada(){
        char[] palabraOriginal = {'H','O','L','O'};
        char[] resultadoEsperado = {'_','O','_','O'};
        char[] resultadoReal = Ahorcado.resultadoJugada(palabraOriginal, 'O');
        boolean sonIguales = true;
        for (int i = 0; i < resultadoReal.length; i++) {
            if(resultadoEsperado[i] != resultadoReal[i]){
                sonIguales = false;
                break;
            }
            assertTrue(sonIguales);
        }
    }
    
    public void testValidarJugadaCuandoLePega(){
        char[] jugadaAnterior = {'_','_','_','_'};
        char[] jugadaNueva = {'_','O','_','O'};
        assertTrue(Ahorcado.validarJugada(jugadaAnterior, jugadaNueva));
    }
    
    public void testValidarJugadaCuandoNoLePega(){
        char[] jugadaAnterior = {'_','0','_','0'};
        char[] jugadaNueva = {'_','O','_','O'};
        assertTrue(!Ahorcado.validarJugada(jugadaAnterior, jugadaNueva));
    }
    
    /*
    public void testValidarJugadaCuandoFallaDistLength(){
        char[] jugadaAnterior = {'_','_','_','_'};
        char[] jugadaNueva = {'_','O','_','O','_'};
        assertTrue(!Ahorcado.validarJugada(jugadaAnterior, jugadaNueva));
    }
    */
}
