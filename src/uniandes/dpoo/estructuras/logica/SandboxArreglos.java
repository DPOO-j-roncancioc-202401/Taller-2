package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        int [] copiaEnteros = new int [this.arregloEnteros.length];
        
        for (int i = 0; i < this.arregloEnteros.length; i++) {
        	
        	copiaEnteros [i] = this.arregloEnteros [i];
        }
            
    	return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        String [] copiaCadenas = new String [this.arregloCadenas.length];
    	
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		
    		copiaCadenas [i] = arregloCadenas [i];
    	}
    	
    	return copiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        int cantidadEnteros = 0;
        
        for (int i = 0; i < arregloEnteros.length; i++) {
        	
        	cantidadEnteros += 1;
        }
    	
    	return cantidadEnteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        int cantidadCadenas = 0;
        
        for (int i = 0; i < arregloCadenas.length; i++) {
        	
        	cantidadCadenas += 1;
        }
    	
    	return cantidadCadenas;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int [] nuevoArreglo = new int [(this.arregloEnteros.length)+1];
		
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		nuevoArreglo [i] = this.arregloEnteros [i];
    	}
    	
    	nuevoArreglo [this.arregloEnteros.length] = entero;
    	
    	this.arregloEnteros = nuevoArreglo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        String [] nuevoArreglo = new String [(this.arregloCadenas.length)+1];
		
    	for (int i = 0; i < this.arregloCadenas.length; i++) {
    		
    		nuevoArreglo [i] = this.arregloCadenas [i];
    	}
    	
    	nuevoArreglo [this.arregloCadenas.length] = cadena;
    	
    	this.arregloCadenas = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int apariciones = contarApariciones (valor); 
    	
    	int [] nuevoArreglo = new int [this.arregloEnteros.length -apariciones];
    	
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		if (this.arregloEnteros [i] == valor) {
    			
    			this.arregloEnteros [i] = -0;
    		}
    	}
    	
    	int f = 0;
    	
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		if (this.arregloEnteros [i] != -0) {
    			
    			nuevoArreglo [f] = this.arregloEnteros [i];
    			f ++;
    		}
    	}
    	this.arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int apariciones = contarApariciones (cadena);
    	
    	String[] nuevoArreglo = new String [this.arregloCadenas.length -apariciones];
    	
    	for (int i = 0; i < this.arregloCadenas.length; i++) {
    		
    		if (this.arregloCadenas [i] == cadena) {
    			
    			this.arregloCadenas [i] = "delete";
    		}
    	}
    	
    	int f = 0;
    	
    	for (int i = 0; i < this.arregloCadenas.length; i++) {
    		
    		if (this.arregloCadenas [i] != "delete") {
    			
    			nuevoArreglo [f] = this.arregloCadenas [i];
    		}
    	}
    	
    	this.arregloCadenas = nuevoArreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int []arregloexpandidoE = new int[this.arregloEnteros.length+1];
    	if (posicion < 0)
    	{
    		posicion = 0;
    	}
    	else if(posicion>this.arregloEnteros.length )
    	{
    		posicion = this.arregloEnteros.length;
    	}
        for (int i = 0, j = 0; i < arregloexpandidoE.length; i++) {
            if (i == posicion)
            {
                arregloexpandidoE[i] = entero;
            } else {
                arregloexpandidoE[i] = this.arregloEnteros[j];
                j++;
            }
        } 
        this.arregloEnteros = arregloexpandidoE;

    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion >= 0 || posicion < this.arregloEnteros.length) {
    		
    		for (int i = posicion; i < (this.arregloEnteros.length -1); i++) {
        		
        		this.arregloEnteros [i] = this.arregloEnteros[i+1];
        	}
        	
        	int nuevoTamaño = this.arregloEnteros.length -1;
        	
        	int [] nuevoArreglo = new int [nuevoTamaño];
        	
        	for (int i = 0; i < (this.arregloEnteros.length -1); i++) {
        		
        		nuevoArreglo [i] = this.arregloEnteros [i];
        	}
        	this.arregloEnteros = nuevoArreglo;	
    	}
    	
        else if (posicion < 0 || posicion >= this.arregloEnteros.length){}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		double valor = valores [i];
    		int nuevoValor = (int) valor;
    		this.arregloEnteros [i] = nuevoValor;
    	}
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		int valor = this.arregloEnteros [i];
    		int nuevoValor = Math.abs(valor);
    		this.arregloEnteros [i] = nuevoValor;
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(this.arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	String [] nuevoArregloCad = new String [this.arregloCadenas.length];
    	
    	Arrays.sort(this.arregloCadenas, String.CASE_INSENSITIVE_ORDER);
    	for (int i = 0; i <this.arregloCadenas.length; i++) {
    		
    		nuevoArregloCad [i] = this.arregloCadenas [i];
    	}
    	this.arregloCadenas = nuevoArregloCad; 
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int apariciones = 0;
        
        for (int i = 0; i < this.arregloEnteros.length; i++) {
        	
        	if (this.arregloEnteros [i] == valor) {
        		
        		apariciones += 1;
        	}
        }
    	
    	return apariciones;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int apariciones = 0; 
        
        for (int i = 0; i < this.arregloCadenas.length; i++) {
        	
        	if (this.arregloCadenas [i].toUpperCase() == cadena || this.arregloCadenas [i].toLowerCase() == cadena) {
        		
        		apariciones += 1;
        		
        	}
        }
    	
    	return apariciones;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {   
        int apariciones = 0;
        
        for (int i = 0; i < this.arregloEnteros.length; i++) {
        	
        	if (this.arregloEnteros [i] == valor) {
        		
        		apariciones ++;
        	}
        }
        
        int [] enterosEncontrados = new int [apariciones];
    	
        int f = 0;
        
        for (int i = 0; i < this.arregloEnteros.length; i++) { 
        	
        	if (this.arregloEnteros [i] == valor) {
        		
        		enterosEncontrados [f] = this.arregloEnteros [i];
        		f ++;
        	}
        }
        
    	return enterosEncontrados;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    { 
    	int [] rangoEnteros = new int [0];
    	
    	if (this.arregloEnteros.length > 0) {
    		
    		int [] rangoEntero = new int [2];
            
            int mayorValor = 0;
            
            for (int i = 0; i < this.arregloEnteros.length; i++) {
            	
            	if (this.arregloEnteros [i] > mayorValor) {
            		
            		mayorValor = this.arregloEnteros [i];
            	}
            }
            
            int menorValor = this.arregloEnteros[0]; 
            
            for (int i = 0; i < this.arregloEnteros.length; i++) {
            	
            	if (this.arregloEnteros [i] < menorValor) {
            		
            		menorValor = this.arregloEnteros [i];
            	}
            }
            rangoEntero [0] = menorValor;
            rangoEntero [1] = mayorValor;
            
            rangoEnteros = rangoEntero;
    	}
    	else if (this.arregloEnteros.length <= 0) {}
        
        return rangoEnteros;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap <Integer, Integer> nuevoHistograma = new HashMap <>();
        for (int i : this.arregloEnteros) {
        	
        	if (nuevoHistograma.containsKey(i) == true) {
        		
        		nuevoHistograma.put(i,  nuevoHistograma.get(i) + 1);
        	}
        	else {
        		nuevoHistograma.put(i,  1);
        	}
        }
        
    	return nuevoHistograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        int enterosRepetidos = 0; 
        
        HashMap <Integer, Integer> nuevoHistograma = calcularHistograma ();
        
        Object [] keys = nuevoHistograma.keySet().toArray();
        for (Object key: keys) {
        	
        	if (nuevoHistograma.get(key) > 1) {
        		
        		enterosRepetidos ++;
        	}
        }
        
        return enterosRepetidos; 
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        return false;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        
    	Boolean [] arregloBools = new Boolean [this.arregloEnteros.length];
    	
    	for (int i = 0; i < this.arregloEnteros.length; i++) {
    		
    		if (Arrays.asList(this.arregloEnteros).contains(otroArreglo[i])) {
    			
    			arregloBools [i] = true;
    		}
    		else {
    			
    			arregloBools [i] = false;
    		}
    	}
    	
    	Boolean resultado = false;
    	
    	for (int i = 0; i < arregloBools.length; i++) {
    		
    		if (arregloBools [i] == true) {
    			
    			resultado = true;
    		}
    		else {
    			
    			resultado = false;
    		}
    	}
    	
    	return resultado;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	/** 
    	 * 1. Crear arreglo de tamaño Cantidad
    	 * 2. ciclo while e if para determinar valores dentro del rango
    	 * 3. cambiar arregloEnteros por el nuevo arreglo
    	 */
    	
    	int [] enterosGenerados = new int [cantidad];
    	
    	int i = 0;
    	
    	int nuevoGenerado = 0;  
    	
    	while (i < cantidad) {
    		
    		nuevoGenerado = (int) (Math.random() *10);
    		
    		if (nuevoGenerado > minimo && nuevoGenerado < maximo) {
    			
    			enterosGenerados [i] = nuevoGenerado;
    			i ++;
    		}
    	}
    }

}
