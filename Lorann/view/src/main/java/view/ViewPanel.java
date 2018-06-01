package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.IElement;

class ViewPanel extends JPanel implements Observer {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ViewFrame               viewFrame;
    private IElement[][]            tileMap;
    
    public ViewPanel(final ViewFrame viewFrame) {
        this.setViewFrame(viewFrame);
    }
    
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }
    
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }
    
    public void update(IElement[][] tileMap) {
        this.tileMap = tileMap;
        this.setSize(this.tileMap[0].length, this.tileMap.length);
        this.repaint();
    }
    
    public void setSize(int width, int height) {
        super.setSize((width*32) + this.getInsets().left + this.getInsets().right, (height*32) + this.getInsets().top + this.getInsets().bottom +40);
        this.viewFrame.setSize(width*32, height*32 + 40);
    }
    
    protected void PaintComponent(final Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics.setColor(Color.yellow);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        
        int scoreIndex = 0;
        
        String[][] scores = null;
        if(this.tileMap != null) {
            for(int i = 0; i < this.tileMap.length; i++) {
                for(int j = 0; i < this.tileMap[0].length; j++) {
                    BufferedImage image = tileMap[i][j].getImage();
                    if(image != null)
                        graphics.drawImage(image, j*32, i*32, null);
                    else if(tileMap[i][j].getClass().getSimpleName().contains("Title")) {
                        graphics.drawString("HIGHSCORE", j*32, i*32 + 20);
                    } else if(tileMap[i][j].getClass().getSimpleName().contains("Score")) {
                        if(scores == null)
                            scores = this.viewFrame.getController().getScores();
                        
                        if(scoreIndex < scores[0].length) {
                            graphics.drawString(String.format("%s %s", scores[0][scoreIndex], scores[1][scoreIndex]), j*32 + 5, i*32 + 20);
                            scoreIndex++;
                        }
                    }
                }
            }
        }
        graphics.drawString(String.format("SCORE : %d    LEVEL : %d", this.viewFrame.getController().getScore(), this.viewFrame.getController().getLevel()), 10, this.getHeight() - 20);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
