package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelRysunek extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    int x = -50, y = -50, x2 = -50, y2 = -50;
    Color newColor;
    JToolBar toolBar = new JToolBar();
    ImageIcon iconColor = new ImageIcon(getClass().getClassLoader().getResource("farba.png"));
    ImageIcon iconZamknij = new ImageIcon(getClass().getClassLoader().getResource("zamknij.png"));

    JButton buttonKolor = new JButton(iconColor);
    JButton buttonZamknij = new JButton(iconZamknij);

    PanelRysunek() {
        setBackground(Color.green);
        setLayout(new BorderLayout());

        addMouseListener(this);
        addMouseMotionListener(this);

        add(toolBar, BorderLayout.NORTH);
        toolBar.add(buttonKolor);
        buttonKolor.addActionListener(this);

        toolBar.add(buttonZamknij);
        buttonZamknij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr = JOptionPane.showConfirmDialog(PanelRysunek.this, "Czy chcesz wyłączyć aplikację?", "Pytanie", JOptionPane.YES_NO_OPTION);
                if (nr == 0)
                    System.exit(0);
            }
        });

    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        setBackground(Color.cyan);
        g2.setColor(newColor);
        BasicStroke basicStroke = new BasicStroke(30, BasicStroke.CAP_ROUND, BasicStroke.CAP_SQUARE);
        g2.setStroke(basicStroke);
        g2.drawLine(x, y, x2, y2);
        x = x2;
        y = y2;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g2 = getGraphics();
        g2.drawLine(x, y, e.getX(), e.getY());
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        newColor = JColorChooser.showDialog(PanelRysunek.this, "Wybierz kolor", this.getBackground());

    }
}
