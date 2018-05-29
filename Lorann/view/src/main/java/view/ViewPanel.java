package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPanel extends JPanel implements Observer {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ViewFrame               viewFrame;
    
    public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
        viewFrame.getModel().getObservable().addObserver(this);
    }
    
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }
    
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }
    
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }
    
    protected void paintComponent(final Graphics graphics) {
        JPanel pan = new JPanel();
        String level = new String(this.getViewFrame().getModel().getMap());
        pan.setBackground(Color.BLACK);
        this.setBackground(Color.BLACK);
        System.out.println(level);
        int i;
        
        for (i = 0; i != 240; i++)
        {
            char caracter = (!level.equals("")) ? level.charAt(i) : ' ';
            switch (caracter)
            {
            case 'A':
                Icon laurann = new ImageIcon("");
                JLabel l = new JLabel();
                l.setIcon(laurann);
                pan.add(l);
                break;
            case 'B':
                Icon fireball = new ImageIcon("");
                JLabel f1 = new JLabel();
                f1.setIcon(fireball);
                pan.add(f1);
                break;
            case 'C':
                Icon energy_ball = new ImageIcon("");
                JLabel c = new JLabel();
                c.setIcon(energy_ball);
                pan.add(c);
                break;
            case 'D':
                Icon gate_closed = new ImageIcon("");
                JLabel gc = new JLabel();
                gc.setIcon(gate_closed);
                pan.add(gc);
                break;
            case 'E':
                Icon gate_open = new ImageIcon("");
                JLabel go = new JLabel();
                go.setIcon(gate_open);
                pan.add(go);
                break;
            case 'F':
                Icon bone = new ImageIcon("");
                JLabel bo = new JLabel();
                bo.setIcon(bone);
                pan.add(bo);
                break;
            case 'G':
                Icon horizontal_bone = new ImageIcon("");
                JLabel hb = new JLabel();
                hb.setIcon(horizontal_bone);
                pan.add(hb);
                break;
            case 'H':
                Icon vertical_bone = new ImageIcon("");
                JLabel vb = new JLabel();
                vb.setIcon(vertical_bone);
                pan.add(vb);
                break;
            case 'I':
                Icon monster_1 = new ImageIcon("");
                JLabel m1 = new JLabel();
                m1.setIcon(monster_1);
                pan.add(m1);
                break;
            case 'J':
                Icon monster_2 = new ImageIcon("");
                JLabel m2 = new JLabel();
                m2.setIcon(monster_2);
                pan.add(m2);
                break;
            case 'K':
                Icon monster_3 = new ImageIcon("");
                JLabel m3 = new JLabel();
                m3.setIcon(monster_3);
                pan.add(m3);
                break;
            case 'L':
                Icon monster_4 = new ImageIcon("");
                JLabel m4 = new JLabel();
                m4.setIcon(monster_4);
                pan.add(m4);
                break;
            case 'M':
                Icon purse = new ImageIcon("");
                JLabel p = new JLabel();
                p.setIcon(purse);
                pan.add(p);
                break;
            case 'N':
                Icon empty = new ImageIcon("");
                JLabel empt = new JLabel();
                empt.setIcon(empty);
                pan.add(empt);
                break;
            }
        }
        this.add(pan);
    }
}
