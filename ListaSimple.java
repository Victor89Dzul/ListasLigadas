
/**
 * Write a description of class lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaSimple {
    Node top;
    // Inserta un nuevo nodo como el primer nodo de la lista
    public boolean insertaPrimerNodo(String dato) 
    {
        if (top == null)
        { // La lista está vacía
            top = new Node();
            top.name = dato;
            top.next = null;
            return true;
        }
        else 
        {
            return false;
        }
    }

    // Inserta un nuevo nodo antes del primer nodo existente
    public void insertaAntesPrimerNodo(String nombre) 
    {
        Node temp;
        temp = new Node();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    // Inserta un nuevo nodo al final de la lista
    public void insertaAlFinal(String nombre) 
    {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;
        Node temp2 = this.top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
        temp2 = null;
    }

    // Inserta un nuevo nodo con un valor específico entre dos nodos existentes
    public boolean insertaEntreNodos(String nombre, String buscado)
    {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.top;

        while ((temp2 != null) && temp2.name.equals(buscado) == false)
        {
            temp2 = temp2.next;
        }

        if (temp2 != null) 
        { // Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;
            temp = null;
            temp2 = null;
            return true;
        }
        else
            return false;
    }

    // Imprime los valores de los nodos en la lista
    public void imprimir() 
    {
        for (Node temp = this.top; temp != null; temp = temp.next)
        {
            System.out.print("[ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    // Devuelve una representación en cadena de la lista
    public String toString() 
    {
        String cadAux = "";
        for (Node temp = this.top; temp != null; temp = temp.next) 
        {
            cadAux += "[ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n";

        return cadAux;
    }

    // Borra el primer nodo de la lista
    public void borrarPrimerNodo() 
    {
        this.top = this.top.next;
    }

    // Borra cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado)
    {
        Node temp = this.top;

        while ((temp != null) && temp.name.equals(buscado) == false) 
        {
            temp = temp.next;
        }

        if (temp != null)
        { // Nodo buscado se encontró
            temp.next = temp.next.next;
            temp = null;
            return true;
        }
        else
            return false;
    }

    // Buscar un nodo por el valor de su campo clave y devolver una referencia
    public Node BuscarNodoPorValor(String valorBuscado)
    {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(valorBuscado)) 
        {
            temp = temp.next;
        }

        return temp;
    }

    // Buscar un nodo por su campo clave e insertar un nuevo nodo después de él
    public boolean insertarDespuesDeNodo(String valorBuscado, String nuevoValor)
    {
        Node temp = BuscarNodoPorValor(valorBuscado);

        if (temp != null)
        {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;
            nuevoNodo.next = temp.next;
            temp.next = nuevoNodo;
            return true;
        } 
        else 
        {
            return false; // Nodo buscado no encontrado
        }
    }

    // Intercambiar un nodo por otro buscado
    public boolean intercambiarNodos(String valorNodo1, String valorNodo2) 
    {
        Node nodo1Prev = null;
        Node nodo1 = this.top;

        while (nodo1 != null && !nodo1.name.equals(valorNodo1))
        {
            nodo1Prev = nodo1;
            nodo1 = nodo1.next;
        }

        Node nodo2Prev = null;
        Node nodo2 = this.top;

        while (nodo2 != null && !nodo2.name.equals(valorNodo2)) 
        {
            nodo2Prev = nodo2;
            nodo2 = nodo2.next;
        }

        if (nodo1 != null && nodo2 != null) 
        {
            if (nodo1Prev != null) 
            {
                nodo1Prev.next = nodo2;
            } 
            else 
            {
                this.top = nodo2;
            }

            if (nodo2Prev != null)
            {
                nodo2Prev.next = nodo1;
            } 
            else 
            {
                this.top = nodo1;
            }

            Node temp = nodo1.next;
            nodo1.next = nodo2.next;
            nodo2.next = temp;

            return true;
        } 
        else
        {
            return false; // Al menos uno de los nodos no fue encontrado
        }
    }
}
