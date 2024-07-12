import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame{
    private JTextField usu;
    private JTextField contra;
    private JPanel panellogin;
    private JButton ingresarButton;


    public login() {
        super("Pantalla de login");
        setContentPane(panellogin);


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    validardatos();

                }catch (SQLException ex){
                    System.out.println(ex.getMessage());

                }
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

    public void validardatos()throws SQLException{
        Connection conectar = conexion();
        String usuario = usu.getText();
        String password = contra.getText();

        //String password = new String(contra.getText());

        String sql = "SELECT * FROM usuario WHERE username = ? AND password =?";

        PreparedStatement stmt = conectar.prepareStatement(sql);
        stmt.setString(1,usuario);
        stmt.setString(2,password);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()){

            Menu_opciones menu = new Menu_opciones();
            menu.ingresar();
            dispose();




        }else{

            JOptionPane.showMessageDialog(null,"Nombre de usuario o contraseña es incorrecto");

        }







    }
}



