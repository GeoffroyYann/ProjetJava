package controller;

import model.IModel;
import view.IView;


public class Controller implements IController
{
	private IView view;
	private IModel model;
	
	private void setModel(final IModel model) {
		this.model = model;
	}
	private void setView(final IView view) {
		this.view = view;
	}
	
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}
	
	public void control()
	{
		this.view.printMap("Press the key ‘A’, ‘Z’, ‘E’, ‘R’ or ‘T’ to display the map you have chosen. \nUse the key Up, Down, Left, Right to move Lorann. \nUse the space key to throw the fireball. \nNow let’s play.");
	}
	
	public void orderPerform(final ControllerOrder controllerOrder) 
	{
		switch (controllerOrder) {
			case Map1:
				this.model.loadMap("MAP1");
				break;
			case Map2:
				this.model.loadMap("MAP2");
				break;
			case Map3:
				this.model.loadMap("MAP3");
				break;
			case Map4:
				this.model.loadMap("MAP4");
				break;
			case Map5:
				this.model.loadMap("MAP5");
				break;
			case MooveUp:
				break;
			case MooveDown:
				break;
			case MooveRight:
				break;
			case MooveLeft:
				break;
			case Shot:
				break;
			case Error:
				break;
			default:
				break;
		}
	}
}
