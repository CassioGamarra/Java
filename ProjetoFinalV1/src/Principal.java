import database.ConectarBD;
import database.Database;
import gui.FrameInicio;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Principal {

    public static void main(String[] args) throws SQLException {
        new FrameInicio().setVisible(true);
    } 
}
