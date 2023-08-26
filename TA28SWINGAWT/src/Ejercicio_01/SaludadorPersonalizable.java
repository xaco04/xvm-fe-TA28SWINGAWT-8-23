/**
 * 
 */
package Ejercicio_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaludadorPersonalizable extends JFrame {

    private JTextField textField;
    private JButton button;

    public SaludadorPersonalizable() {
        setTitle("Saludador Personalizable");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        button = new JButton("Saludar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                JOptionPane.showMessageDialog(null, "¡Hola " + nombre + "!");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escribe tu nombre: "));
        panel.add(textField);
        panel.add(button);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SaludadorPersonalizable().setVisible(true);
            }
        });
    }
}
