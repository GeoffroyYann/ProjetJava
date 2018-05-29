package view;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.IController;
import model.IModel;

class ViewFrame extends JFrame implements KeyListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IModel          model;
    private IController     controller;
    
    public ViewFrame(final IModel model) throws HeadlessException{
       this.buildViewFrame(model); 
    }
    
    public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
        super(gc);
        this.buildViewFrame(model);
    }
    
    public ViewFrame(final IModel model, final String title) throws HeadlessException{
        super(title);
        this.buildViewFrame(model);
    }
    
    public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
        super(title, gc);
        this.buildViewFrame(model);
    }
    
    private IController getController() {
        return this.controller;
    }
    
    protected void setController(final IController controller) {
        this.controller = controller;
    }
    
    protected IModel getModel() {
        return this.model;
    }
    
    private void setModel(final IModel model) {
        this.model = model;
    }
    
    private void buildViewFrame(final IModel model) {
        this.setModel(model);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setContentPane(new ViewPanel(this));
        this.setSize(769 , 468);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
    }
    
    public void printMap(final String map) {
        JOptionPane.showMessageDialog(null, map);
    }
    
    public void keyTyped(final KeyEvent e) {
        
    }
    
    public void keyPressed(final KeyEvent e) {
        this.getController().orderPerform(View.keyController(e.getKeyCode()));
    }
    
    public void keyReleased(final KeyEvent e) {
        
    }
}
