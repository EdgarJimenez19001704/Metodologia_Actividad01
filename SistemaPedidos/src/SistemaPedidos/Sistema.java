package SistemaPedidos;

import java.util.*;

public class Sistema {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Usuario> usuarios = new HashMap<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private Usuario usuarioActual = null;

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> colocarPedido();
                case 2 -> registrarse();
                case 3 -> iniciarSesion();
                case 4 -> {
                    if (usuarioActual != null) {
                        editarPedido();
                    } else {
                        System.out.println("Debe iniciar sesión.");
                    }
                }
                case 5 -> {
                    if (usuarioActual != null) {
                        eliminarPedido();
                    } else {
                        System.out.println("Debe iniciar sesión.");
                    }
                }
                case 6 -> {
                    if (usuarioActual != null) {
                        listarPedidos();
                    } else {
                        System.out.println("Debe iniciar sesión.");
                    }
                }
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Colocar pedido");
        System.out.println("2. Registrarse");
        System.out.println("3. Iniciar sesión");
        System.out.println("4. Editar pedido");
        System.out.println("5. Eliminar pedido");
        System.out.println("6. Listar pedidos");
        System.out.print("Seleccione una opción: ");
    }

    private void registrarse() {
        String Name = Validador.leerTexto(scanner, "Name: ");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        String email = Validador.leerEmail(scanner, "Email: ");
        usuarios.put(username, new Usuario(Name, username, password, email));
        System.out.println("Registro exitoso.");
    }

    private void iniciarSesion() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        Usuario usuario = usuarios.get(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void colocarPedido() {
        Pedido pedido = new Pedido();
        pedido.capturarDatos(scanner);
        pedidos.add(pedido);
        System.out.println("Pedido colocado correctamente.");
    }

    private void editarPedido() {
        System.out.print("ID del pedido a editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedido.capturarDatos(scanner);
                System.out.println("Pedido editado.");
                return;
            }
        }
        System.out.println("Pedido no encontrado.");
    }

    private void eliminarPedido() {
        System.out.print("ID del pedido a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        pedidos.removeIf(pedido -> pedido.getId() == id);
        System.out.println("Pedido eliminado (si existía).");
    }

    private void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}