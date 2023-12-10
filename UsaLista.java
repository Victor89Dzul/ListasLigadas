
/**
 * Write a description of class u here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsaLista
 {
    public static void main(String[] args) throws Exception 
    {
        // Crear una instancia de ListaSimple
        ListaSimple lista = new ListaSimple();

        // Insertar algunos nodos para demostrar las operaciones
        lista.insertaPrimerNodo("A");
        lista.insertaAlFinal("B");
        lista.insertaAlFinal("C");
        lista.insertaAlFinal("D");

        // Imprimir la lista antes de realizar las operaciones
        System.out.println("Lista original:");
        lista.imprimir();

        // 1. Buscar un nodo por su campo clave
        Node nodoEncontrado = lista.BuscarNodoPorValor("B");
        System.out.println("Nodo encontrado: " + nodoEncontrado);

        // 2. Buscar un nodo por su campo clave e insertar un nuevo nodo después de él
        lista.insertarDespuesDeNodo("C", "F");
        System.out.println("\nLista después de insertar nuevo nodo:");
        lista.imprimir();

        // 3. Intercambiar un nodo por otro buscado
        lista.intercambiarNodos("A", "D");
        System.out.println("\nLista después de intercambiar nodos:");
        lista.imprimir();
    }
}
