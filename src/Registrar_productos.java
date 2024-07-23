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
        setSize(500,400);
        setLocationRelativeTo(null);
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









    }
}








