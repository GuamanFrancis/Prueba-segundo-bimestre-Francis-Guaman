import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;

public class Registrar_productos extends JFrame{
    private JPanel panelproductos;
    private JButton siguienteButton;
    private JButton volverButton;
    private JTextField codigo;
    private JTextField nom;
    private JTextField des;
    private JTextField pre;
    private JTextField can;
    private JTextField cate;

    public Registrar_productos(){
        super("Panel de registro de productos");
        setContentPane(panelproductos);

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Registrarproductos();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());

                }


            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_opciones ventana = new Menu_opciones();
                ventana.ingresar();
                dispose();

            }
        });

    }

    public void ingresar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public Connection conexion()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/productos_cp";
        String user = "root";
        String pass = "12345";

        return DriverManager.getConnection(url,user,pass);

    }

    public void Registrarproductos()throws SQLException{
        Connection conectar=conexion();
        String cod = codigo.getText();
        String nombre = nom.getText();
        String descripcion = des.getText();
        Double precio = Double.parseDouble(pre.getText());
        String cantidad = can.getText();
        String cateogira = cate.getText();
        String sql = "INSERT  INTO producto(codigo_producto,nombre,description,precio,cantidad,cateogira)values(?,?,?,?,?,?,)";
        PreparedStatement stmt = conectar.prepareStatement(sql);
        stmt.setString(1,cod);
        stmt.setString(2,nombre);
        stmt.setString(3,descripcion);
        stmt.setDouble(4,precio);
        stmt.setInt(5,Integer.parseInt(cantidad));
        stmt.setString(6,cateogira);

        int columnas = stmt.executeUpdate();

        if (columnas>0){
            JOptionPane.showMessageDialog(null,"Datos ingresados exitosamente");

        }else{
            JOptionPane.showMessageDialog(null,"Datos no ingresados");

        }

/*
        String nombre = nom.getText();
        String edad = eda.getText();
        Double nota1= Double.parseDouble(primeranota.getText());
        Double nota2= Double.parseDouble(segundanota.getText());
        Connection connection=conexion();
        String sql = "INSERT INTO estudiantes(nombre,edad,nota1,nota2)values(?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,nombre);
        pstmt.setInt(2, Integer.parseInt(edad));
        pstmt.setDouble(3,nota1);
        pstmt.setDouble(4,nota2);
        int rowsAffected = pstmt.executeUpdate();
        if ((rowsAffected>0 )){
            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        }*/








    }
}







/*


String nombre =nombreabuscar.getText();
//connection puede variar para las diferentes funciones
Connection connection = conectar();
String sql="select * from estudiantes where nombre_apellido=?";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.setString(1,nombre);
ResultSet RS = pstmt.executeQuery();

StringBuilder datos = new StringBuilder("");
if (RS.next()) {
        datos.append("Nombre: ").append(RS.getString("nombre_apellido")).append("
                                                                                        ");
                                                                                datos.append("Direccion: ").append(RS.getString("direccion")).append("
                                                                                                                                                             ");
                                                                                                                                                     datos.append("edad: ").append(RS.getString("edad")).append("

                                                                                                                                                                                                                        ");
                                                                                                                                                                                                                datos.append("Nombre: ").append(RS.getString("nombre_apellido")).append("
                                                                                                                                                                                                                                                                                                ");
                                                                                                                                                                                                                                                                                        datos.append("Direccion: ").append(RS.getString("direccion")).append("
                                                                                                                                                                                                                                                                                                                                                                     ");
                                                                                                                                                                                                                                                                                                                                                             datos.append("edad: ").append(RS.getString("edad")).append("

                                                                                                                                                                                                                                                                                                                                                                                                                                ");
                                                                                                                                                                                                                                                                                                                                                                                                                                } else {
    datos.append("No se encontraron resultados para el correo ingresado.");
}

datos.append("");
mostrar_datos.setText(datos.toString());

        09:53
public void verificardatos()throws SQLException{

    Connection connection = conectar();
    String user = usua.getText();
    String pass = new String(contra.getText());

    String sql = "SELECT * FROM usuariosadministrador WHERE nombre = ? AND cedula = ?";

    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1, user);
    stmt.setString(2, pass);

    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        Menu_de_administrador menu =new Menu_de_administrador();
        menu.ingresar();
        dispose();

    } else {

        JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos.");
    }

*/
