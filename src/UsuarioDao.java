import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public boolean adcionarUsuario(Usuario usuario) throws SQLException, IOException, ClassNotFoundException {
        try(Connection connection = new ConFactory().getConnection()){
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO usuario (email, nome) Values(?,?)");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getNome());
            return  stmt.executeUpdate() > 0;
        }
    }
    public List<Usuario> listarUsuarios() throws  SQLException,IOException,ClassNotFoundException{
        try(Connection connection = new ConFactory().getConnection()){
            PreparedStatement smt = connection.prepareStatement("SELECT * FROM usuario ORDER BY nome"
            );
            ResultSet rs = smt.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()){
                String email = rs.getString("email");
                String nome = rs.getString("nome");
                usuarios.add(new Usuario(email,nome));

            }
            return usuarios;
        }
    }
    public Usuario buscarPorEmail(String email) throws  SQLException,IOException,ClassNotFoundException{
        try(Connection connection = new ConFactory().getConnection()){
            PreparedStatement smt = connection.prepareStatement("SELECT * FROM usuario where email = ? "
            );
            smt.setString(1, email);
            ResultSet rs = smt.executeQuery();
            Usuario usuario;
            while (rs.next()){
                String email1 = rs.getString("email");
                String nome = rs.getString("nome");
                usuario = new Usuario(email1,nome);
                return usuario;

            }

        }
        return null;
    }
}
