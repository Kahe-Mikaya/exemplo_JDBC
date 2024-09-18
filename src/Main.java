import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            UsuarioDao dao = new UsuarioDao();
            /*if(dao.adcionarUsuario(new Usuario("mari@gmail.com","maria"))){
                System.out.println("salvo");
            }*/
            System.out.println(dao.buscarPorEmail("joao@gmail.com"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}