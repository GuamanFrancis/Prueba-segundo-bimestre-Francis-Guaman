import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_opciones extends JFrame{
    private JButton registroButton;
    private JButton busquedaButton;
    private JPanel panelmenu;

    public Menu_opciones() {
        super("Panel de menu");
        setContentPane(panelmenu);


        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrar_productos resgistrar = new Registrar_productos();
                resgistrar.ingresar();
                dispose();

            }
        });
        busquedaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Busqueda_productos busqueda = new Busqueda_productos();
                busqueda.ingresar();
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
}
