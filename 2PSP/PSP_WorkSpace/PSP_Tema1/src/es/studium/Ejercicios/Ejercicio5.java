package es.studium.Ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio5 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JScrollPane scroll;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Ejercicio5 frame = new Ejercicio5();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ejercicio5()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        scroll = new JScrollPane();
        scroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(scroll);
        scroll.setLayout(null);

        textField = new JTextField();
        textField.setBounds(46, 25, 232, 20);
        scroll.add(textField);
        textField.setColumns(10);

        JTextArea textArea = new JTextArea();

        JScrollPane scrollTextArea = new JScrollPane(textArea);
        scrollTextArea.setBounds(46, 56, 346, 194);
        scroll.add(scrollTextArea);

        JButton btnNewButton = new JButton("Leer directorio");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(ejercicio5(textField.getText()));
            }
        });
        btnNewButton.setBounds(308, 24, 89, 23);
        scroll.add(btnNewButton);
    }

    public String ejercicio5(String pathname)
    {
        File filePathname = new File(pathname);
        File[] files = filePathname.listFiles();
        String res = "";
        if(files != null)
        {
            for (File element : files)
            {
                if(res.isEmpty())
                {
                    res = element.getName();
                }
                else
                {
                    res = res + "\n" + element.getName();
                }
            }
        }
        return res;
    }
}
