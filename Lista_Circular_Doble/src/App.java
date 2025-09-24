public class App {
    public static void main(String[] args) throws Exception {
        ListaCircularDoble<String> lista = new ListaCircularDoble<>();

        lista.insertar("A");
        lista.insertar("B");
        lista.insertar("C");

        System.out.println("Imprimir hacia adelante:");
        lista.imprimirAdelante(); // A B C

        System.out.println("Imprimir hacia atrás:");
        lista.imprimirAtras(); // C B A

        System.out.println("Tamaño actual: " + lista.getTamaño()); // 3

        lista.eliminar("B");
        lista.imprimirAdelante(); // A C
        System.out.println("Tamaño: " + lista.getTamaño()); // 2

        System.out.println("¿Contiene C? " + lista.buscar("C")); // true
        System.out.println("¿Contiene B? " + lista.buscar("B")); // false

        lista.limpiar();
        lista.imprimirAdelante(); // vacía
        System.out.println("Tamaño: " + lista.getTamaño()); // 0
    }
}
