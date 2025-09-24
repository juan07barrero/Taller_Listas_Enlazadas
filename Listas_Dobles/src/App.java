public class App {
    public static void main(String[] args) throws Exception {
        ListaDoble<String> lista = new ListaDoble<>();

        lista.insertarAlFinal("Uno");
        lista.insertarAlFinal("Dos");
        lista.insertarAlPrincipio("Cero");

        System.out.println("Tamaño actual: " + lista.getTamaño()); // 3

        lista.imprimirDeIzquierdaADerecha(); // Cero Uno Dos

        lista.eliminarNodo("Dos");
        System.out.println("Tamaño después de eliminar: " + lista.getTamaño()); // 2

        lista.limpiarLista();
        System.out.println("Tamaño después de limpiar: " + lista.getTamaño()); // 0
    }
}
