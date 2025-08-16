import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDo implements ActionListener {

    int x_offset = 300;
    int y_offset = 100;
    int frame_width = 1400;
    int frame_height = 800;
    int times_pressed;
    JFrame frame;
    JButton button_tmp;
    JPanel panel;

    public ToDo () {


        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);

        button_tmp = new JButton();
        button_tmp.setText("press for new panel");
        button_tmp.addActionListener(this);
        button_tmp.setBounds(x_offset + 50, y_offset + 100, 100, 100);

        frame.add(button_tmp);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(button_tmp, BorderLayout.SOUTH);
        frame.setBounds(x_offset, y_offset, frame_width, frame_height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("ToDo");

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_tmp) {
            JTextField textField = new JTextField("Textfield " + panel.getComponentCount());
            panel.add(textField);
            panel.revalidate();
            panel.repaint();
        }
    }
}