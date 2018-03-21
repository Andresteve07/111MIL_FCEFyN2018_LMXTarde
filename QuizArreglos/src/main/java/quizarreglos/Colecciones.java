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
public class Colecciones {
    public static char[] apilar(char[] palabraOriginal,char letra){

    char[] apilado=new char[(palabraOriginal.length)+1];
    int i=0;
    
    for(i=0;i<palabraOriginal.length;i++){
        apilado[i]=palabraOriginal[i];
    }
     apilado[i]=letra;
    
    return apilado;
    
    }
    public static char[] desapilar(char[] palabraOriginal){

        char[] desapilado=new char[(palabraOriginal.length)-1];
    int i=0;
    
    for(i=0;i<palabraOriginal.length-1;i++){
        desapilado[i]=palabraOriginal[i];
    }

        return desapilado;
    }
    public static char[] encolar(char[] palabraOriginal,char letra){
        
        char[] encolado=new char[(palabraOriginal.length)+1];
        int i=0;
    
    encolado[0]=letra;
    
    for(i=0;i<palabraOriginal.length;i++){
        encolado[i+1]=palabraOriginal[i];
    }

        return encolado;
    }
    public static char[] desencolar(char[] palabraOriginal){
        char[] desencolaOK={'b','c','d'};
        char[] desencolado=new char[(palabraOriginal.length)-1];
        int i=0;

         for(i=0;i<palabraOriginal.length-1;i++){
        desencolado[i]=palabraOriginal[i];
    }
        return desencolado;
    }
    
}
