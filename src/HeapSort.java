import java.util.Arrays;

public class HeapSort {
    
    private static int mayorIndice;
    private static int[] heap;
    
    public static int[] ordenar(int[] heapDesordenado){
        heap = heapDesordenado;
        mayorIndice = heap.length-1;
        while(mayorIndice > 0){
        	System.out.println(Arrays.toString(heap));
           	heapify();
            swap();
        }
        return heap;
    }
    
    private static boolean esHeap() {
    	 for (int indexPadre=0; indexPadre<heap.length-1; indexPadre++){
    		 int indiceMayorHijos = obtenerIndiceMayorDeLosHijos(indexPadre);
             if (heap[indexPadre]<heap[indiceMayorHijos]){
                 return false;
             }
         }
    	 return true;
    }
    
    private static void heapify() {
    	while(!esHeap()) {
    		downHeap();
    	}
    }
    
    //recorrer el array verificando que cada nodo padre sea mayor que sus hijos, en caso de que así sea se intercambian
    private static void downHeap(){
        for (int indexPadre=0; indexPadre<heap.length-1; indexPadre++){
        	int indiceMayorHijos = obtenerIndiceMayorDeLosHijos(indexPadre);
            if (heap[indexPadre]<heap[indiceMayorHijos]){
                permutar(indexPadre,indiceMayorHijos);
            }
        }
       
    }
    
    private static void permutar(int indicePadre, int indiceHijoMayor){ 
    	System.out.println("intercambio " + heap[indicePadre] + " por " + heap[indiceHijoMayor]);
    	int valorPadre = heap[indicePadre];
        heap[indicePadre] = heap[indiceHijoMayor];
        heap[indiceHijoMayor] = valorPadre;
        
    }
    
    private static int obtenerIndiceMayorDeLosHijos(int indexPadre){    
        if(tieneAmbosHijos(indexPadre)){
            int hijoIzquierdo = heap[(2*indexPadre)+ 1];
            int hijoDerecho = heap[(2*indexPadre)+ 2];
            
            if(hijoIzquierdo > hijoDerecho){
                return (2*indexPadre)+ 1;
            }
                return (2*indexPadre)+ 2;
        }else if(tieneHijoIzquierdo(indexPadre)){
            return (2*indexPadre)+ 1;
        }
        return indexPadre; 
    }
    
    
    private static boolean tieneAmbosHijos(int indexPadre) {
        return mayorIndice >= (2*indexPadre)+ 1 && mayorIndice >= (2*indexPadre)+ 2;
    }
    
    private static boolean tieneHijoIzquierdo(int indexPadre) {
        return mayorIndice >= (2*indexPadre)+ 1 && mayorIndice <= (2*indexPadre)+ 2;
    }

    private static void reducirIndice(){
        mayorIndice--;
    }
    
    private static void swap(){
    	System.out.println("SWAP: Intercambio  "+ heap[0] + " por " + heap[mayorIndice]);
        int primerValor = heap[0];
        heap[0] = heap[mayorIndice];
        heap[mayorIndice] = primerValor;
        reducirIndice();
        
    }
    
    public static void main(String[] args) {
        int[] array = {2,1,5,3,6,0,4,8};
        int[] resultado = ordenar(array);
        for(int i = 0; i<resultado.length;i++){
            System.out.println(resultado[i]);
        }
    }
    
}

//[2,1,5,3,6,0,4,8]

//		2
//	  1      5
//	3   6  0   4
//8



