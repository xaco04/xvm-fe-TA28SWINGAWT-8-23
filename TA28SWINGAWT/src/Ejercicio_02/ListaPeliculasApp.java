/**
 * 
 */
package Ejercicio_02;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaPeliculasApp extends JFrame {

    private JComboBox<String> peliculasComboBox;
    private JTextField peliculaTextField;
    private JButton agregarButton;

    public ListaPeliculasApp() {
        setTitle("Lista de Películas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        peliculasComboBox = new JComboBox<>();
        peliculaTextField = new JTextField(20);
        agregarButton = new JButton("Añadir");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaPelicula = peliculaTextField.getText();
                if (!nuevaPelicula.isEmpty()) {
                    peliculasComboBox.addItem(nuevaPelicula);
                    peliculaTextField.setText("");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Película: "));
        panel.add(peliculaTextField);
        panel.add(agregarButton);
        panel.add(new JLabel("Lista de Películas: "));
        panel.add(peliculasComboBox);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaPeliculasApp().setVisible(true);
            }
        });
    }
}
