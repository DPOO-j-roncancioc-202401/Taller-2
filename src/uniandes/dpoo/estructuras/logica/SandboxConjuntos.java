package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 *
 * Todos los métodos deben operar sobre el atributo arbolCadenas que se declara como un NavigableSet.
 * 
 * El objetivo de usar el tipo NavigableSet es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (TreeSet).
 * 
 * A diferencia de un Set, en un NavigableSet existe una noción de orden que en este caso corresponde al órden lexicográfico.
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxConjuntos
{
    /**
     * Un conjunto (set) de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Por defecto, los elementos del conjunto están ordenados lexicográficamente.
     */
    private NavigableSet<String> arbolCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente
     * @return Una lista con las cadenas ordenadas
     */
    public List<String> getCadenasComoLista( )
    {
        ArrayList <String> listaCadenas = new ArrayList<String>();
        List<String> listaArbol = new ArrayList<String>(this.arbolCadenas);
    	
    	for (int i = 0; i < this.arbolCadenas.size(); i++) {
        	
    		listaCadenas.add(listaArbol.get(i));
        }

    	return listaCadenas;
    }

    /**
     * Retorna una lista con las cadenas del conjunto, ordenadas lexicográficamente de mayor a menor.
     * @return Una lista con las cadenas ordenadas de mayor a menor
     */
    public List<String> getCadenasComoListaInvertida( )
    {
        ArrayList <String> listaCadenas = new ArrayList<String>();
        List<String> listaArbol = new ArrayList<String>(this.arbolCadenas);
        
        for (int i = 0; i < this.arbolCadenas.size(); i++) {
        	
        	listaCadenas.add(listaArbol.get(i));
        }
        
        Collections.reverse(listaCadenas);
    	
    	return listaCadenas;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor en el conjunto de cadenas.
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La primera cadena del conjunto, o null si está vacío.
     */
    public String getPrimera( )
    {
        String menorElemento = null;
    	
    	if (this.arbolCadenas.size() > 0) {
        	
        	menorElemento = this.arbolCadenas.first();
        }
    	else {
    		
    		menorElemento = null;
    	}
    	
    	return menorElemento;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor en el conjunto de cadenas
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La última cadena del conjunto, o null si está vacío.
     */
    public String getUltima( )
    {
    	String mayorElemento = null;
    	
    	if (this.arbolCadenas.size() > 0) {
    		
    		mayorElemento = this.arbolCadenas.last();
    	}
    	else {
    		
    		mayorElemento = null;
    	}
    	
        return mayorElemento;
    }

    /**
     * Retorna una colección con las cadenas que hacen parte del conjunto de cadenas y son mayores o iguales a la cadena que se recibe por parámetro
     * @param cadena
     * @return Una colección de cadenas mayores a la cadena dada. Si la cadena hace parte del conjunto, debe hacer parte de la colección retornada.
     */
    public Collection<String> getSiguientes( String cadena )
    {
        SortedSet<String> collection = this.arbolCadenas.headSet(cadena);
    	
    	return collection;
    }

    /**
     * Retorna la cantidad de valores en el conjunto de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        int tamaño = this.arbolCadenas.size();
    	
    	return tamaño;
    }

    /**
     * Agrega un nuevo valor al conjunto de cadenas.
     * 
     * Este método podría o no aumentar el tamaño del conjunto, dependiendo de si el número está repetido o no.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	this.arbolCadenas.add(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	this.arbolCadenas.remove(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas, independientemente de las mayúsculas o minúsculas
     * @param cadena La cadena que se va eliminar, sin tener en cuenta las mayúsculas o minúsculas
     */
    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
    	this.arbolCadenas.remove(cadena.toUpperCase());
    	this.arbolCadenas.remove(cadena);
    }

    /**
     * Elimina la primera cadena del conjunto
     */
    public void eliminarPrimera( )
    {
    	String primeraCadena = this.arbolCadenas.first();
    	this.arbolCadenas.remove(primeraCadena);
    }

    /**
     * Reinicia el conjunto de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
    	
    	for (int i = 0; i < objetos.size(); i++) {
    		
    		objetos.get(i).toString();
    	}
    }

    /**
     * Modifica el conjunto de cadenas para que todas las cadenas estén en mayúsculas.
     * 
     * Note que esta operación podría modificar el órden de los elementos dentro del conjunto.
     */
    public void volverMayusculas( )
    {
        List<String> listaArbol = new ArrayList<String>(this.arbolCadenas);
    	
    	for (int i = 0; i < this.arbolCadenas.size(); i++) {
    		
    		listaArbol.get(i).toUpperCase();
    	}
    }

    /**
     * Construye un árbol de cadenas donde todas las cadenas están organizadas de MAYOR a MENOR.
     */
    public TreeSet<String> invertirCadenas( )
    {
    	Set<String> arbolCreado = new TreeSet<String>();
    	
    	return (TreeSet<String>) arbolCreado;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del conjunto de cadenas
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro del conjunto
     */
    public boolean compararElementos( String[] otroArreglo )
    {
        
    	List<String> listaArbol = new ArrayList<String>(this.arbolCadenas);
    	
        ArrayList<Boolean> valoresTF = new ArrayList<Boolean>();
    	
    	for (int i = 0; i < listaArbol.size(); i++) {
    		
    		if (listaArbol.contains(otroArreglo[i])) {
    			
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
