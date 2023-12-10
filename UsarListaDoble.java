
/**
 * Write a description of class hj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsarListaDoble
{
    public static void main(String[] args) throws Exception 
    {
        // Crear una instancia de ListaDoble
        ListaDoble lista = new ListaDoble();

        // Insertar nodos en la lista
        lista.insertaPrimerNodo("A");
        lista.insertaAlFinal("B");
        lista.insertaAlFinal("C");
        lista.insertaAlFinal("D");

        // Imprimir la lista inicial
        System.out.println("Lista inicial:");
        lista.imprimir();

        // Buscar un nodo por su valor
        Node nodoEncontrado = lista.BuscarNodoPorValor("A");
        System.out.println("Nodo encontrado: " + nodoEncontrado.name);

        // Insertar un nuevo nodo después de un nodo específico
        String nuevoValor = "E";
        String nodoAntes = "D";
        if (lista.InsertarDespuesDeNodo(nodoAntes, nuevoValor)) 
        {
            System.out.println("Nuevo nodo insertado después de " + nodoAntes + ":");
            lista.imprimir();
        }
        else 
        {
            System.out.println("No se pudo insertar. Nodo antes de " + nodoAntes + " no encontrado.");
        }

        // Intercambiar dos nodos
        String nodo1 = "A";
        String nodo2 = "C";
        if (lista.IntercambiarNodos(nodo1, nodo2)) 
        {
            System.out.println("Nodos intercambiados:");
            lista.imprimir();
        } 
        else
        {
            System.out.println("No se pudo intercambiar. Al menos uno de los nodos no encontrado.");
        }
    }
}
