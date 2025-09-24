public class App {
    public static void main(String[] args) throws Exception {
        ListaCircular<String> lista = new ListaCircular<>();

        lista.insertar("A");
        lista.insertar("B");
        lista.insertar("C");

        System.out.println("Contenido de la lista:");
        lista.imprimir(); // A B C

        System.out.println("¿Contiene B? " + lista.buscar("B")); // true
        System.out.println("Tamaño: " + lista.getTamaño()); // 3

        lista.eliminar("B");
        lista.imprimir(); // A C
        System.out.println("Tamaño: " + lista.getTamaño()); // 2

        lista.limpiar();
        lista.imprimir(); // Lista vacía
    }
}
