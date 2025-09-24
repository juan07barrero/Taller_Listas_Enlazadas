public class ListaCircular<T> {
    private NodoCircular<T> inicio;
    private int tamaño;

    public ListaCircular() {
        inicio = null;
        tamaño = 0;
    }

    // Insertar al final
    public void insertar(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);

        if (inicio == null) {
            inicio = nuevo;
            inicio.setSiguiente(inicio); // se apunta a sí mismo
        } else {
            NodoCircular<T> actual = inicio;
            while (actual.getSiguiente() != inicio) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
        }

        tamaño++;
    }

    // Eliminar un nodo con cierto dato
    public void eliminar(T dato) {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoCircular<T> actual = inicio;
        NodoCircular<T> anterior = null;

        do {
            if (actual.getDato().equals(dato)) {
                if (anterior != null) {
                    anterior.setSiguiente(actual.getSiguiente());
                    // Si estamos eliminando el nodo "inicio"
                    if (actual == inicio) {
                        inicio = actual.getSiguiente();
                    }
                } else {
                    // Caso especial: eliminar el único nodo
                    if (inicio.getSiguiente() == inicio) {
                        inicio = null;
                    } else {
                        // Encontrar último nodo para mantener la circularidad
                        NodoCircular<T> ultimo = inicio;
                        while (ultimo.getSiguiente() != inicio) {
                            ultimo = ultimo.getSiguiente();
                        }
                        inicio = actual.getSiguiente();
                        ultimo.setSiguiente(inicio);
                    }
                }
                tamaño--;
                System.out.println("Nodo " + dato + " eliminado.");
                return;
            }

            anterior = actual;
            actual = actual.getSiguiente();

        } while (actual != inicio);

        System.out.println("Nodo " + dato + " no encontrado.");
    }

    // Buscar un nodo
    public boolean buscar(T dato) {
        if (inicio == null) return false;

        NodoCircular<T> actual = inicio;
        do {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != inicio);

        return false;
    }

    // Imprimir lista
    public void imprimir() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoCircular<T> actual = inicio;
        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        } while (actual != inicio);

        System.out.println();
    }

    // Limpiar lista
    public void limpiar() {
        inicio = null;
        tamaño = 0;
        System.out.println("La lista ha sido limpiada.");
    }

    // Getter del tamaño
    public int getTamaño() {
        return tamaño;
    }

    // Getter del nodo inicio (opcional)
    public NodoCircular<T> getInicio() {
        return inicio;
    }
}

