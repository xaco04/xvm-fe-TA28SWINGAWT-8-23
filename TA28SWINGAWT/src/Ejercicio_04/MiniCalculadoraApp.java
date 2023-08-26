/**
 * 
 */
package Ejercicio_04;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniCalculadoraApp extends JFrame {

    private JTextField operando1TextField, operando2TextField, resultadoTextField;
    private JButton sumaButton, restaButton, multiplicacionButton, divisionButton, salirButton, aboutButton;

    public MiniCalculadoraApp() {
        setTitle("Mini Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        operando1TextField = new JTextField(10);
        operando2TextField = new JTextField(10);
        resultadoTextField = new JTextField(10);
        resultadoTextField.setEditable(false);

        sumaButton = new JButton("+");
        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion("+");
            }
        });

        restaButton = new JButton("-");
        restaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion("-");
            }
        });

        multiplicacionButton = new JButton("*");
        multiplicacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion("*");
            }
        });

        divisionButton = new JButton("/");
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion("/");
            }
        });

        salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Mini Calculadora\nAutor: Xavier Jordi Vico Martí");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(new JLabel("Operando 1:"));
        panel.add(operando1TextField);
        panel.add(new JLabel("Operando 2:"));
        panel.add(operando2TextField);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoTextField);
        panel.add(new JLabel());
        panel.add(sumaButton);
        panel.add(new JLabel());
        panel.add(restaButton);
        panel.add(new JLabel());
        panel.add(multiplicacionButton);
        panel.add(new JLabel());
        panel.add(divisionButton);
        panel.add(salirButton);
        panel.add(aboutButton);

        getContentPane().add(panel);
    }

    private void calcularOperacion(String operador) {
        try {
            double operando1 = Double.parseDouble(operando1TextField.getText());
            double operando2 = Double.parseDouble(operando2TextField.getText());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = operando1 + operando2;
                    break;
                case "-":
                    resultado = operando1 - operando2;
                    break;
                case "*":
                    resultado = operando1 * operando2;
                    break;
                case "/":
                    resultado = operando1 / operando2;
                    break;
            }

            resultadoTextField.setText(Double.toString(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos en los operandos.");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Error en la operación: División por cero.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MiniCalculadoraApp().setVisible(true);
            }
        });
    }
}
