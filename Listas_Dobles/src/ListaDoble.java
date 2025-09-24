public class ListaDoble<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamaño; // NUEVO: tamaño de la lista

    public ListaDoble() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void insertarAlPrincipio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamaño++; // aumentar tamaño
    }

    public void insertarAlFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamaño++; // aumentar tamaño
    }

    public void eliminarNodo(T dato) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    cabeza = actual.getSiguiente();
                }

                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    cola = actual.getAnterior();
                }

                tamaño--; // disminuir tamaño
                System.out.println("Nodo " + dato + " eliminado.");
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("Nodo " + dato + " no encontrado.");
    }

    public boolean buscarNodo(T dato) {
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void imprimirDeIzquierdaADerecha() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void imprimirDeDerechaAIzquierda() {
        if (cola == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoDoble<T> actual = cola;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getAnterior();
        }
        System.out.println();
    }

    public void limpiarLista() {
        cabeza = null;
        cola = null;
        tamaño = 0; // reiniciar tamaño
        System.out.println("La lista ha sido limpiada.");
    }

    // Getter para el tamaño
    public int getTamaño() {
        return tamaño;
    }

    // Getters opcionales para acceso externo si se requiere
    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    public NodoDoble<T> getCola() {
        return cola;
    }
}

