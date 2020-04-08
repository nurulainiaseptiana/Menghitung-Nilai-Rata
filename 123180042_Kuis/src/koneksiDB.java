import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class koneksiDB 
{
    public Connection getKoneksi() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost/datamahasiswa"; 
        //datamahasiswa merupakan nama database jadi bisa dirubah sesuai dengan nama database yg akan digunakan
        Connection con = DriverManager.getConnection(url, "root", "");
        //root merupakan username dan "" password
        
        return con;
    }
}
//berisi kode untuk mengkoneksikan database dengan program java