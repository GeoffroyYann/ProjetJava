package view;

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
    private ViewPanel       viewPanel;
    
    public ViewFrame(final IModel model) throws HeadlessException{
       this.setModel(model); 
    }
    
    public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
        super(gc);
        this.setModel(model);
    }
    
    public ViewFrame(final IModel model, final String title) throws HeadlessException{
        super(title);
        this.setModel(model);
    }
    
    public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
        super(title, gc);
        this.setModel(model);
    }
    
    private IController getController() {
        return this.controller;
    }
    
    protected void setController(final IController controller) {
        this.controller = controller;
        this.buildViewFrame();
    }
    
    protected IModel getModel() {
        return this.model;
    }
    
    private void setModel(final IModel model) {
        this.model = model;
    }
    
    private void buildViewFrame(final IModel model) {
        this.viewPanel = new ViewPanel(this);
        this.setModel(model);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setContentPane(this.viewPanel);
        this.setSize(400 , 60);
        this.setLocationRelativeTo(null);
    }
    
    public void setSize(int width, int height) {
        super.setSize(width + this.getInsets().left + this.getInsets().right, height + this.getInsets().top + this.getInsets().bottom);
    }
    
    public void printMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void keyTyped(final KeyEvent e) {
        
    }
    
    public void keyPressed(final KeyEvent e) {
        this.getController().orderPerform(View.keyController(e.getKeyCode()));
    }
    
    public String pseudo() {
        return JOptionPane.showInputDialog("Pseudo");
    }
}
