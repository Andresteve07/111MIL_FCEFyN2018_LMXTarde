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
public class ColeccionesTests extends TestCase{
    
    public ColeccionesTests() {
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
public void apilarTest(){
    boolean ok=true;
    char[] apilaTest={'a','b','c','d'};
    char nuevo='e';
    char[] apilarOK={'a','b','c','d','e'};
    char[] apilarDevuelto=Colecciones.apilar(apilaTest,nuevo);
    
    for (int i = 0; i < apilaTest.length; i++) {
        if(apilarDevuelto[i]!=apilarOK[i]){
            ok=false;
        }
    }
    assertEquals(ok, true);
}

public void desapilarTest(){
    boolean ok=true;
    char[] desapilaTest={'a','b','c','d'};
    char[] desapilarOK={'a','b','c'};
    char[] desapilarDevuelto=Colecciones.desapilar(desapilaTest);
    
    for (int i = 0; i < desapilaTest.length; i++) {
        if(desapilarDevuelto[i]!=desapilarOK[i]){
            ok=false;
        }
    }
    assertEquals(ok, true);
}

public void encolarTest(){
    boolean ok=true;
    char[] encolaTest={'a','b','c','d'};
    char nuevo='e';
    char[] encolaOK={'e','a','b','c','d'};
    char[] encolaDevuelto=Colecciones.encolar(encolaTest,nuevo);
    
    for (int i = 0; i < encolaTest.length; i++) {
        if(encolaDevuelto[i]!=encolaOK[i]){
            ok=false;
        }
    }
    assertEquals(ok, true);
}

public void desencolarTest(){
    boolean ok=true;
    char[] desencolaTest={'a','b','c','d'};
    char[] desencolaOK={'b','c','d'};
    char[] desencolaDevuelto=Colecciones.desencolar(desencolaTest);
    
    for (int i = 0; i < desencolaTest.length; i++) {
        if(desencolaDevuelto[i]!=desencolaOK[i]){
            ok=false;
        }
    }
    assertEquals(ok, true);
}

}

