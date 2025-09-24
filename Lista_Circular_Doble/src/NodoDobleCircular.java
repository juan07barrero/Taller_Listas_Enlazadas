public class NodoDobleCircular<T> {
    private T dato;
    private NodoDobleCircular<T> siguiente;
    private NodoDobleCircular<T> anterior;

    public NodoDobleCircular(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y Setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDobleCircular<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDobleCircular<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDobleCircular<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDobleCircular<T> anterior) {
        this.anterior = anterior;
    }
}

