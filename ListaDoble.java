
/**
 * Write a description of class lisya here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaDoble 
{
    Node topForward;
    Node topBackward;

    // Inserta un nuevo nodo como el primer nodo de la lista
    public boolean insertaPrimerNodo(String dato) 
    {
        if (topForward == null)
        { // La lista está vacía
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;

            topBackward = topForward; // Se inicializa topBackward ya que solo hay un nodo

            return true;
        } else 
        {
            return false;
        }
    }

    // Imprime los valores de los nodos en la lista desde el principio hasta el final
    public void imprimir()
    {
        System.out.print("[X]");

        for (Node temp = this.topForward; temp != null; temp = temp.next)
        {
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    // Devuelve una representación en cadena de la lista desde el principio hasta el final
    public String toString() 
    {
        String cadAux = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next) 
        {
            cadAux += " <- [ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n";

        return cadAux;
    }

    // Inserta un nuevo nodo antes del primer nodo existente
    public void insertaAntesPrimerNodo(String nombre)
    {
        Node temp;
        temp = new Node();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    // Inserta un nuevo nodo al final de la lista
    public void insertaAlFinal(String nombre)
    {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;

        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    // Inserta un nuevo nodo con un valor específico entre dos nodos existentes
    public boolean insertaEntreNodos(String nombre, String buscado)
    {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        while ((temp2 != null) && temp2.name.equals(buscado) == false) 
        {
            temp2 = temp2.next;
        }

        if (temp2 != null)
        { // Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;

            return true;
        } 
        else
            return false;
    }

    // Borra el primer nodo de la lista
    public void borrarPrimerNodo() 
    {
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    // Borra el último nodo de la lista
    public void borrarUltimoNodo()
    {
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }

    // Borra cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado)
    {
        Node temp = this.topForward;

        while ((temp != null) && temp.name.equals(buscado) == false)
        {
            temp = temp.next;
        }

        if (temp != null)
        { // Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;

            return true;
        } 
        else
            return false;
    }

    // Buscar un nodo por el valor de su campo clave y devolver una referencia
    public Node BuscarNodoPorValor(String valorBuscado)
    {
        Node temp = this.topForward;

        while (temp != null && !temp.name.equals(valorBuscado)) 
        {
            temp = temp.next;
        }

        return temp;
    }

    // Buscar un nodo por su campo clave e insertar un nuevo nodo después de él
    public boolean InsertarDespuesDeNodo(String valorBuscado, String nuevoValor) 
    {
        Node temp = BuscarNodoPorValor(valorBuscado);

        if (temp != null) 
        {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;

            nuevoNodo.next = temp.next;
            if (temp.next != null) 
            {
                temp.next.previous = nuevoNodo;
            }

            temp.next = nuevoNodo;
            nuevoNodo.previous = temp;

            return true;
        } 
        else 
        {
            return false; // Nodo buscado no encontrado
        }
    }

    // Intercambiar un nodo por otro buscado
    public boolean IntercambiarNodos(String valorNodo1, String valorNodo2) 
    {
        Node nodo1 = BuscarNodoPorValor(valorNodo1);
        Node nodo2 = BuscarNodoPorValor(valorNodo2);

        if (nodo1 != null && nodo2 != null) 
        {
            // Intercambiar nodos
            Node temp = nodo1.next;
            nodo1.next = nodo2.next;
            nodo2.next = temp;

            temp = nodo1.previous;
            nodo1.previous = nodo2.previous;
            nodo2.previous = temp;

            if (nodo1.previous != null) 
            {
                nodo1.previous.next = nodo1;
            } 
            else 
            {
                this.topForward = nodo1;
            }

            if (nodo2.previous != null) 
            {
                nodo2.previous.next = nodo2;
            }
            else 
            {
                this.topForward = nodo2;
            }

            return true;
        }
        else
        {
            return false; // Al menos uno de los nodos no fue encontrado
        }
    }
}
