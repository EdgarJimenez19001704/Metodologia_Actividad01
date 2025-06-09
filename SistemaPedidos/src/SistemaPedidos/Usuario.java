package SistemaPedidos;

public class Usuario {
    private String name;
    private String username;
    private String password;
    private String email;

    public Usuario(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}