package pkg111mil_ruleta;

import java.util.Random;

public class Main extends MetodosSteve {
    
    public static void main(String[] args) {
        int[] apuestas=new int[37];
        int bola;
        int ganancia;
        char operacion='a';
        int fichas;
        int fichasJuego;
        imprimir("ingrese dinero para jugar:");
        fichas=tomarInt();
        do{
            
            imprimirPanio();
            do{
                imprimir("ingrese cantidad de fichas a apostar, tienes disponibles "+fichas+" para apostar:");
                fichasJuego=tomarInt();
                
            }while(fichasJuego<=0 || fichasJuego>fichas);
            fichas=fichas-fichasJuego;
            apuestas=menuPrincipal( fichasJuego);
            imprimir("si desea realizar otra apuesta ingrese: j, si no ingrese c para continuar con el juego, recuerde que solo puede apostar si aun le queda credito en fichas!");
            operacion = tomarChar();
            }while(menuApuesta(operacion,fichas)==true);
        bola=girarRuleta();
        imprimir("salio el numero: "+bola);ganancia=calculoGanancia(apuestas, bola);
        fichas=fichas+ganancia;
        if(apuestas[bola]!=0){
            imprimir("ganaste "+ganancia+" fichas ahora tienes "+fichas+" fichas de credito");
        }else{
            imprimir("perdiste mejor suerte la proxima!");
        }
       
    }

    /**
     * Ofrece la posibilidad de jugar o salir
     * si inicia el juego toma la cantidad de dinero para 
     * cambiar por fichas(credito)
     * @return credito en cantidad de fichas.
     */
    public static int [] menuPrincipal( int fichasJuego){
        int[] apuesta=new int[37];
        char jugada;
        int numeroJuego, numerojuego2;
        imprimir("ingrese la apuesta q desea hacer:");
        imprimir("p- para apuesta pleno:");
        imprimir("d- para apuesta doble:");
        imprimir("c- para apuesta calle:");
        imprimir("e- para apuesta esquina:");
        imprimir("l- para apuesta linea:");
        imprimir("D- para apuesta docena:");
        imprimir("M- para apuesta mitad:");
        imprimir("C- para apuesta columna:");
        imprimir("P- para apuesta par impar");
        jugada=tomarChar();
        while(jugada!='p'&&jugada!='d'&&jugada!='c'&&jugada!='e'&&jugada!='l'&&jugada!='D'&&jugada!='M'&&jugada!='C'&&jugada!='P'){
            imprimir("ingresaste una opcion invalida, intenta de nuevo:");
            imprimir("ingrese la apuesta q desea hacer:");
            imprimir("p- para apuesta pleno:");
            imprimir("d- para apuesta doble:");
            imprimir("c- para apuesta calle:");
            imprimir("e- para apuesta esquina:");
            imprimir("l- para apuesta linea:");
            imprimir("D- para apuesta docena:");
            imprimir("M- para apuesta mitad:");
            imprimir("C- para apuesta columna:");
            imprimir("P- para apuesta par impar");
            jugada=tomarChar();
        }
//apuesta pleno:
        if(jugada=='p'){
            do{
                imprimir("ingrese numero a jugar del 0 al 36:");
                numeroJuego=tomarInt();
            }while(numeroJuego<=0 || numeroJuego>36 );
            apuesta=apuestaPleno(numeroJuego, fichasJuego);
//apuesta doble:
        }else if(jugada=='d'){
            do{
            imprimir("ingrese numero a jugar:");
            numeroJuego=tomarInt();
            }while(numeroJuego<=0 || numeroJuego>36 );
            do{
                imprimir("ingrese el 2 numero a jugar:");
                numerojuego2=tomarInt(); 
            }while(numerojuego2<=0 || numerojuego2>36 && numerojuego2==numeroJuego);
            apuesta=apuestaDoble(numeroJuego, numerojuego2, fichasJuego);
//apuesta calle:
        }else if(jugada=='c'){
            do{
                imprimir("ingrese numero de calle a jugar del 1 al 12:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>12);
            apuesta=apuestaCalle(numeroJuego, fichasJuego);
//apuesta esquina:
        }else if(jugada=='e'){
            do{
                imprimir("ingrese numero de esquina a jugar del 1 la 14:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>14);
            apuesta=apuestaEsquina(numeroJuego, fichasJuego);
//apuesta linea: 
        }else if(jugada=='l'){
            do{
                imprimir("ingrese numero de linea a jugar del 1 al 11:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>11);
            apuesta=apuestaLinea(numeroJuego, fichasJuego);
//apuesta docena:
        }else if(jugada=='D'){
            do{
                imprimir("ingrese numero de docena a jugar del 1 al 3:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>3);
            apuesta=apuestaDocena(numeroJuego, fichasJuego);
//apuesta mitad:
        }else if(jugada=='M'){
            do{
                imprimir("ingrese numero de mitad a jugar 1 o 2:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>2);
            apuesta=apuestaMitad(numeroJuego, fichasJuego);
//apuesta columna:
        }else if(jugada=='C'){
            do{
                imprimir("ingrese numero de columna a jugar 1, 2 o 3:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>3);
            apuesta=apuestaColumna(numeroJuego, fichasJuego);
//apuesta par/impar:
        }else if(jugada=='P'){
            do{
                imprimir("ingrese numero de juego 1 para impar o 2 para par:");
                numeroJuego=tomarInt();
            }while(numeroJuego<1 || numeroJuego>2);
            if(numeroJuego==1){
                apuesta=apuestaParImpar(true, fichasJuego);
            }else{
                apuesta=apuestaParImpar(false, fichasJuego);
            }
        }
        return apuesta;
    }
    
    /**
     * Gestiona las opciones de apuestas y gira la ruleta.
     * Imprimir las siguientes opciones:
     * p -> apuestaPleno
     * d -> apuestaDoble
     * c -> apuestaCalle
     * e -> apuestaEsquina
     * l -> apuestaLinea
     * D -> apuestaDocena
     * M -> apuestaMitad
     * C -> apuestaColumna
     * P -> apuestaParImpar
     * @return 
     */
    public static boolean menuApuesta(char cadena,int fichas ){ 
        while(cadena!='j'&&cadena!='c'){
            imprimir("opcion erronea ingrese j para realizar mas apuestas o c para continuar con el juego por favor, recuerde que solo puede apostar si aun le queda credito en fichas!:");
            cadena=tomarChar();
        }
        if(cadena=='j'&& fichas>0){
            return true;
        }else{
           return false;
        
        }
 
        
    }
    
    public static int girarRuleta(){
        Random rn = new Random();
        int bola = rn.nextInt(37);
        return bola;
    }
    
    public static int[] apuestaPleno(int numero, int cantFichas){
       int [] arregloPleno = new int[37];
        for (int i=0;i<37;i++){
            if(numero==0){
                arregloPleno[0]=cantFichas*36;
            }
            else{
            if(numero==i){
                arregloPleno[i]=cantFichas*36;
            }
            }        
        }
        return arregloPleno;
    }
    
    public static int[] apuestaDoble(int numero1, int numero2, int cantFichas){

        boolean parEsValido=false;
        int i=0;
        int[][] tablero = {{1,2,3,100},{0,2,4,100},{0,1,3,5},{0,2,6,100},{1,5,7,100},
                           {2,4,6,8},{3,5,9,100},{4,8,10,100},{5,7,9,11},{6,8,12,100},
                           {7,11,13,100},{8,10,12,14},{9,11,15,100},{10,14,16,100},{11,13,15,17},
                           {12,14,18,100},{13,17,19,100},{14,16,18,20},{15,17,21,100},
                           {16, 20, 22, 100},{17, 19, 21, 23},{18, 20, 24, 100},{19, 23, 25, 100},
                           {20, 22, 24, 26},{21, 23, 27, 100},{22, 26, 28, 100},{23, 25, 27, 29},
                           {24, 26, 30, 100},{25, 29, 31, 100},{26, 28, 30, 32},{27, 29, 33, 100},
                           {28, 32, 34, 100},{29, 31, 33, 35},{30, 32, 36, 100},{31, 35, 100, 100},
                           {32, 34, 36, 100},{35, 33, 100, 100}};
       
        int[] apuestas = new int [37];
        for(i=0; i<4; i++){
            if(numero2==tablero[numero1][i]){
                parEsValido=true;
                break;
            }
        }
        if(parEsValido){
            apuestas[numero1]=cantFichas*18;
            apuestas[numero2]=cantFichas*18;
            imprimir(apuestas[numero1] + apuestas[numero2]);
        }else{
            imprimir("El par no es valido");
        }
        return apuestas;
    }
    
    public static int[] apuestaEsquina(int esquina, int cantFichas){
        int[] ganancia = new int[37];
        for(int indice=0; indice<ganancia.length; indice++){
            ganancia[indice]=indice;
        }
        if(esquina<12&&esquina>0){
            ganancia[3+3*(esquina-1)]=8*cantFichas;
            ganancia[6+3*(esquina-1)]=8*cantFichas;
            ganancia[2+3*(esquina-1)]=8*cantFichas;
            ganancia[5+3*(esquina-1)]=8*cantFichas;
        }
        else{
            ganancia[2+3*(esquina-12)]=8*cantFichas;
            ganancia[5+3*(esquina-12)]=8*cantFichas;
            ganancia[1+3*(esquina-12)]=8*cantFichas;
            ganancia[4+3*(esquina-12)]=8*cantFichas;
            
        }
        return ganancia;
        }
        
    
    
    /**
     * esta funcion sirve para apostar calles en ruleta.
     * @param calle valor admisible: 1 a 12
     * @param cantFichas
     * @return 
     */
    public static int[] apuestaCalle(int calle, int cantFichas){
        
        int i = 0;
        int apuestas[] = new int[37];
        
      
        int contadorNum[] = new int[13];
        contadorNum[1] = 0;
        for (i = 2 ; i < 13 ; i++) {
            contadorNum[i] = 2*(i - 1);
        }
        
        for (i = calle + contadorNum[calle] ; i <= (calle + contadorNum[calle] + 2) ; i++ ) {
            apuestas[i] = (12 * cantFichas);
        }
        
        return apuestas;
    }
    
    public static int[] apuestaLinea(int linea, int cantFichas){
        int[] tablero = new int[37];
        int posicionFinal=6, posicionInicial=1;
        
        for(int i=1; i<linea; i++){
            posicionInicial = posicionInicial+3;
            posicionFinal = posicionFinal+3;
        }
        
        for(int i=posicionInicial; i<=posicionFinal; i++){
            tablero[i] = 6*cantFichas;
        }
        return tablero;
    }
    
    public static int[] apuestaDocena(int docena, int cantFichas){
        return null;
    }
    
    /**
     * Esta funciopn sirve para calcular las ganacias para una apuesta de mitad.
     * @param mitad
     * @param cantFichas
     * @return 
     */
    public static int[] apuestaMitad(int mitad, int cantFichas)
    {
        int [] tablero=new int[37];
        int mitad1=1;
        int mitad2=2;
        if (mitad==1||mitad==2 ){ 
               
            if(mitad==mitad1){
                for(int i = 1; i <19 ; i++){
                  tablero[i]=cantFichas*2;
                  }
              }
            else if(mitad==mitad2){
                 for(int i = 19; i <37 ; i++){
                    tablero[i]=cantFichas*2;
                    }              
                }
        /*    
        for (int i = 0; i < 37; i++) {
                imprimir(i+ " "+ tablero[i]);  
                }
                */
    } else {
            //imprimir("mitad incorrecta ");
            }
    return tablero;
    }
    
public static int[] apuestaColumna(int columna, int cantFichas)
            
    {
        int []tablero = new int [37];
        int pos;
        
        for(int i=0;i<12;i++)
                {
                   pos=columna;                   
                   
                   tablero[pos]=cantFichas; 
                   
                   columna=pos+3;
                }
        return tablero;
    }
  
    public static int[] apuestaParImpar(boolean paridad, int cantFichas){
        int [] arregloParImpar = new int [37];
            
        if(paridad==true){
                for (int j = 1; j < 37; j++) {
                    if(j%2==0){
                        arregloParImpar[j]=cantFichas*2;
                    }
                    else {
                         arregloParImpar[j]=0;
                    }
                    
                }
            }
        else{
              for (int j = 1; j < 37; j++) {
                    if(j%2==1){
                        arregloParImpar[j]=cantFichas*2;
                    }
                    else {
                         arregloParImpar[j]=0;
                    }
        }
        }
        return arregloParImpar;
    
    }
    
    public static int calculoGanancia(int[] apuestas, int nroSorteado){
        return apuestas[nroSorteado];
    }
    
    public static void imprimirPanio(){
                imprimir ("|    " + " 0 " + "   |");
                imprimir ("------------");
                imprimir ("| 1|" + "| 2|" + "| 3|");
                imprimir ("------------");
                imprimir ("| 4|" + "| 5|" + "| 6|");
                imprimir ("------------");
                imprimir ("| 7|" + "| 8|" + "| 9|");
                imprimir ("------------");
                imprimir ("|10|" + "|11|" + "|12|");
                imprimir ("------------");
                imprimir ("|13|" + "|14|" + "|15|");
                imprimir ("------------");
                imprimir ("|16|" + "|17|" + "|18|");
                imprimir ("------------");
                imprimir ("|19|" + "|20|" + "|21|");
                imprimir ("------------");
                imprimir ("|22|" + "|23|" + "|24|");
                imprimir ("------------");
                imprimir ("|25|" + "|26|" + "|27|");
                imprimir ("------------");
                imprimir ("|28|" + "|29|" + "|30|");
                imprimir ("------------");
                imprimir ("|31|" + "|32|" + "|33|");
                imprimir ("------------");
                imprimir ("|34|" + "|35|" + "|36|");
                imprimir ("------------");
               
                
                
     
    }
}
