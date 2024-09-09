import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircularButtonExample extends JFrame {
    public CircularButtonExample() {
        // Thiết lập JFrame
        setTitle("Circular Button Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Tạo nút hình tròn
        CircularButton circularButton = new CircularButton("Click Me!");

        // Thêm hành động cho nút
        circularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Nút hình tròn được nhấn!");
            }
        });

        // Thêm nút vào JFrame
        add(circularButton);

        // Hiển thị JFrame
        setVisible(true);
    }
}

class CircularButton extends JButton {
    public CircularButton(String label) {
        super(label);
        setPreferredSize(new Dimension(100, 100));
        setContentAreaFilled(false); // Tắt việc tô màu nền mặc định
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY); // Màu khi nút bị nhấn
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getSize().width / 2;
        int centerX = radius;
        int centerY = radius;
        return ((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)) <= radius * radius;
    }
}
