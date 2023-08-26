/**
 * 
 */
package Ejercicio_03;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniEncuestaApp extends JFrame {

    private JRadioButton windowsRadioButton, linuxRadioButton, macRadioButton;
    private JCheckBox programacionCheckBox, disenoCheckBox, administracionCheckBox;
    private JSlider horasSlider;
    private JButton mostrarButton;

    public MiniEncuestaApp() {
        setTitle("Mini Encuesta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        windowsRadioButton = new JRadioButton("Windows");
        linuxRadioButton = new JRadioButton("Linux");
        macRadioButton = new JRadioButton("Mac");

        ButtonGroup sistemaOperativoGroup = new ButtonGroup();
        sistemaOperativoGroup.add(windowsRadioButton);
        sistemaOperativoGroup.add(linuxRadioButton);
        sistemaOperativoGroup.add(macRadioButton);

        programacionCheckBox = new JCheckBox("Programación");
        disenoCheckBox = new JCheckBox("Diseño gráfico");
        administracionCheckBox = new JCheckBox("Administración");

        horasSlider = new JSlider(0, 10);
        horasSlider.setMajorTickSpacing(1);
        horasSlider.setPaintTicks(true);
        horasSlider.setPaintLabels(true);

        mostrarButton = new JButton("Mostrar Datos");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sistemaOperativo = "";
                if (windowsRadioButton.isSelected()) {
                    sistemaOperativo = "Windows";
                } else if (linuxRadioButton.isSelected()) {
                    sistemaOperativo = "Linux";
                } else if (macRadioButton.isSelected()) {
                    sistemaOperativo = "Mac";
                }

                StringBuilder especialidades = new StringBuilder();
                if (programacionCheckBox.isSelected()) {
                    especialidades.append("Programación, ");
                }
                if (disenoCheckBox.isSelected()) {
                    especialidades.append("Diseño gráfico, ");
                }
                if (administracionCheckBox.isSelected()) {
                    especialidades.append("Administración, ");
                }

                int horasDedicadas = horasSlider.getValue();

                String resultado = "Sistema Operativo: " + sistemaOperativo + "\n" +
                                  "Especialidades: " + (especialidades.length() > 0 ? especialidades.substring(0, especialidades.length() - 2) : "Ninguna") + "\n" +
                                  "Horas dedicadas: " + horasDedicadas;

                JOptionPane.showMessageDialog(null, resultado);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel("Elige un sistema operativo:"));
        panel.add(windowsRadioButton);
        panel.add(linuxRadioButton);
        panel.add(macRadioButton);
        panel.add(new JLabel("Elige tu especialidad/es:"));
        panel.add(programacionCheckBox);
        panel.add(disenoCheckBox);
        panel.add(administracionCheckBox);
        panel.add(new JLabel("Horas dedicadas en el ordenador:"));
        panel.add(horasSlider);
        panel.add(mostrarButton);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MiniEncuestaApp().setVisible(true);
            }
        });
    }
}
