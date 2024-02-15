package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        /**
         * 1. Pasar valores del mapa a una lista 
         * 2. ordenar la lista lexicograficamente 
         */
    	
    	List<String> listaValores = new ArrayList<>(mapaCadenas.values());
        listaValores.sort((o1, o2) -> o1.compareTo(o2));
        
        return listaValores;

    	
    }


    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> listaLlaves = new ArrayList<>(mapaCadenas.keySet());
        listaLlaves.sort((o1, o2) -> o1.compareTo(o2));
        
         
        Collections.reverse(listaLlaves);
          
        
        return listaLlaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        return null;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        return null;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> llaves = this.mapaCadenas.keySet();
        List<String> listaLlaves = new ArrayList <>(llaves);
    	
    	for (int i = 0; i < listaLlaves.size(); i++) {
    		
    		listaLlaves.get(i).toUpperCase();
    	}
    	
    	return listaLlaves;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        ArrayList <String> valoresRevisados = new ArrayList <String>();
        List<String> listaValores = new ArrayList<>(mapaCadenas.values());
        
        int cantidadCadenas = 0; 
        
        for (int i = 0; i < listaValores.size(); i++) {
        	
        	if (valoresRevisados.contains(listaValores.get(i))) {        		
        	}
        	else {
        		valoresRevisados.add(listaValores.get(i));
        		cantidadCadenas ++;
        	}
        }
        
    	return cantidadCadenas;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String valor = cadena;
    	StringBuilder stringBuilder = new StringBuilder (cadena);
    	String llave = stringBuilder.reverse().toString();
    	
    	this.mapaCadenas.put(llave, valor);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	this.mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	List<String> listaValores = new ArrayList<>(this.mapaCadenas.values());
    	List<String> listaLlaves = new ArrayList<>(this.mapaCadenas.keySet());
    	
    	if (this.mapaCadenas.size() > 0) {
    		
    		Boolean encontrado = false;
        	
        	int posicion = 0;
        	
        	int i = 0; 
        	
        	while (i < listaValores.size() || encontrado == false) {
        		
        		if (listaValores.get(i) == valor) {
        			
        			posicion = i;
        			encontrado = true;
        		}
        	}
        	
        	this.mapaCadenas.remove(listaLlaves.get(posicion));
    	}
    	else if (this.mapaCadenas.size() <= 0) {}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {

    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	/**
    	 * 1. Extraer lista de llaves.
    	 * 2. Extraer lista de valores: 
    	 * 3. Modificar las llaves por mayusculas.
    	 * 4. Crear nuevo mapa con las llaves modificadas.
    	 * 5. Dar nombre principal al mapa nuevo
    	 */
    	
    	Map<String, String> nuevoMapa = new HashMap<>();
    	
    	for (Map.Entry<String, String> i : this.mapaCadenas.entrySet()) {
    		
    		String llave = i.getKey();
    		String valor = i.getValue();
    		nuevoMapa.put(llave.toUpperCase(), valor);
    	}
    	
    	this.mapaCadenas.clear();
    	this.mapaCadenas = nuevoMapa;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        
        /**
         * 1. Extraer la colleccion de valores del mapa.
         * 2. While para comparar valor por valor usando .contains()
         */
    	
    	List<String> valores = new ArrayList<String>(this.mapaCadenas.values());
    	
        ArrayList<Boolean> valoresTF = new ArrayList<Boolean>();
    	
    	for (int i = 0; i < valores.size(); i++) {
    		
    		if (valores.contains(otroArreglo[i])) {
    			
    			valoresTF.add(true);
    		}
    		else {
    			valoresTF.add(false);
    		}
    	}
    	
    	Boolean respuesta = true;
    	
    	if (valoresTF.contains(false)) {
    		
    		respuesta = false;
    	} 
    	
    	
    	return respuesta;
    }

}
