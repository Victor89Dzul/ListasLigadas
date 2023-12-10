
/**
 * Write a description of class nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
 {
    String name; // Cambiado el nombre del campo de datos a "data"
    Node previous; // Agregado campo enlace a nodo anterior
    Node next; // Campo enlace a nodo siguiente

    public String toString()
    {
        return name;
    }
}
