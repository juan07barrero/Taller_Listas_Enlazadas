public class ListaCircularDoble<T> {
    private NodoDobleCircular<T> cabeza;
    private int tamaño;

    public ListaCircularDoble() {
        cabeza = null;
        tamaño = 0;
    }

    // Insertar al final
    public void insertar(T dato) {
        NodoDobleCircular<T> nuevo = new NodoDobleCircular<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDobleCircular<T> cola = cabeza.getAnterior();

            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
        }

        tamaño++;
    }

    // Eliminar un nodo con cierto dato
    public void eliminar(T dato) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDobleCircular<T> actual = cabeza;
        boolean encontrado = false;

        do {
            if (actual.getDato().equals(dato)) {
                encontrado = true;
                break;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("Nodo " + dato + " no encontrado.");
            return;
        }

        if (actual.getSiguiente() == actual) {
            // Solo un nodo
            cabeza = null;
        } else {
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());

            if (actual == cabeza) {
                cabeza = actual.getSiguiente();
            }
        }

        tamaño--;
        System.out.println("Nodo " + dato + " eliminado.");
    }

    // Buscar un nodo
    public boolean buscar(T dato) {
        if (cabeza == null) return false;

        NodoDobleCircular<T> actual = cabeza;

        do {
            if (actual.getDato().equals(dato)) return true;
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        return false;
    }

    // Imprimir hacia adelante
    public void imprimirAdelante() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDobleCircular<T> actual = cabeza;

        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        System.out.println();
    }

    // Imprimir hacia atrás
    public void imprimirAtras() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDobleCircular<T> actual = cabeza.getAnterior();

        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getAnterior();
        } while (actual != cabeza.getAnterior());

        System.out.println();
    }

    // Limpiar la lista
    public void limpiar() {
        cabeza = null;
        tamaño = 0;
        System.out.println("La lista ha sido limpiada.");
    }

    // Getter del tamaño
    public int getTamaño() {
        return tamaño;
    }

    // Getter de la cabeza (opcional)
    public NodoDobleCircular<T> getCabeza() {
        return cabeza;
    }
}
