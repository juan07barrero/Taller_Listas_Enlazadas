package LISTASIMPLE;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> firstNodo;
    private int size = 0;

    // ----- Métodos de utilidad -----
    public void borrarLista() {
        size = 0;
        firstNodo = null;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < size;
    }

    public boolean estaVacia() {
        return firstNodo == null;
    }

    public int getSize() {
        return size;
    }

    // ----- Métodos de inserción -----
    public void agregarInicio(T value) {
        Nodo<T> newNodo = new Nodo<>(value);
        newNodo.setSiguiente(firstNodo);
        firstNodo = newNodo;
        size++;
    }

    public void agregarFinal(T value) {
        Nodo<T> newNodo = new Nodo<>(value);
        if (estaVacia()) {
            firstNodo = newNodo;
        } else {
            Nodo<T> aux = firstNodo;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(newNodo);
        }
        size++;
    }

    public void agregar(int index, T value) {
        if (index < 0 || index > size) {
            System.out.println("Índice fuera de rango");
            return;
        }

        Nodo<T> newNodo = new Nodo<>(value);

        if (index == 0) {
            newNodo.setSiguiente(firstNodo);
            firstNodo = newNodo;
        } else {
            Nodo<T> aux = firstNodo;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getSiguiente();
            }
            newNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(newNodo);
        }
        size++;
    }

    // ----- Métodos de obtención -----
    public T obtenerValorNodo(int indice) {
        if (!indiceValido(indice)) {
            return null;
        }
        Nodo<T> aux = firstNodo;
        for (int i = 0; i < indice; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getValor();
    }

    public Nodo<T> obtenerNodo(int indice) {
        if (!indiceValido(indice)) {
            return null;
        }
        Nodo<T> aux = firstNodo;
        for (int i = 0; i < indice; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    public int obtenerPosicionNodo(T valor) {
        Nodo<T> aux = firstNodo;
        int index = 0;
        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return index;
            }
            aux = aux.getSiguiente();
            index++;
        }
        return -1;
    }

    // ----- Métodos de eliminación -----
    public void eliminarPrimero() {
        if (!estaVacia()) {
            firstNodo = firstNodo.getSiguiente();
            size--;
        }
    }

    public void eliminarUltimo() {
        if (estaVacia()) return;

        if (size == 1) {
            firstNodo = null;
        } else {
            Nodo<T> aux = firstNodo;
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
        size--;
    }

    public void eliminar(T valor) {
        if (estaVacia()) return;

        if (firstNodo.getValor().equals(valor)) {
            eliminarPrimero();
            return;
        }

        Nodo<T> aux = firstNodo;
        while (aux.getSiguiente() != null && !aux.getSiguiente().getValor().equals(valor)) {
            aux = aux.getSiguiente();
        }

        if (aux.getSiguiente() != null) {
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            size--;
        }
    }

    // ----- Métodos de modificación -----
    public void modificarNodo(int indice, T nuevoValor) {
        if (!indiceValido(indice)) {
            System.out.println("Índice fuera de rango");
            return;
        }
        Nodo<T> nodo = obtenerNodo(indice);
        nodo.setValor(nuevoValor);
    }

    // ----- Ordenar (burbuja simple) -----
    public void ordenarLista() {
        if (size <= 1) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo<T> aux = firstNodo;
            while (aux.getSiguiente() != null) {
                if (aux.getValor().compareTo(aux.getSiguiente().getValor()) > 0) {
                    T temp = aux.getValor();
                    aux.setValor(aux.getSiguiente().getValor());
                    aux.getSiguiente().setValor(temp);
                    swapped = true;
                }
                aux = aux.getSiguiente();
            }
        } while (swapped);
    }

    // ----- Mostrar -----
    public void imprimirLista() {
        Nodo<T> aux = firstNodo;
        while (aux != null) {
            System.out.print(aux.getValor() + " -> ");
            aux = aux.getSiguiente();
        }
        System.out.println("null");
    }

    // ----- Iterador -----
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> current = firstNodo;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T valor = current.getValor();
                current = current.getSiguiente();
                return valor;
            }
        };
    }

        // Invertir contenido recursivamente
        public void invertirLista() {
            if (firstNodo == null || firstNodo.getSiguiente() == null) {
                return; // no hacer nada si está vacía o con un solo elemento
            }
            firstNodo = invertirRecursivo(firstNodo);
        }
    
        // Función recursiva que devuelve el nuevo head
        private Nodo<T> invertirRecursivo(Nodo<T> nodo) {
            if (nodo.getSiguiente() == null) {
                return nodo; // caso base: último nodo será la nueva cabeza
            }
            Nodo<T> nuevoHead = invertirRecursivo(nodo.getSiguiente());
            nodo.getSiguiente().setSiguiente(nodo);
            nodo.setSiguiente(null);
            return nuevoHead;
        }
    
}
