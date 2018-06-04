package controller;

import model.IElement;
import model.IModel;
import view.IView;


public class ControllerTest {
	private IModel model;
	private IView view;
	private IController controller;
	private IElement[][] expectedMap;
	
	public void setUp() throws Exception {
		this.model = new Model();
		this.view = new View(this.model);
		this.controller = new Controller(this.view, this.model);
		this.view.setController(controller);
		
		this.expectedMap = new IElement [][] {
			{model.element('B', new Point()), model.element('V', new Point()), model.element('H', new Point()), model.element('P', new Point()), model.element('L', new Point())},
            {model.element('1', new Point()), model.element('2', new Point()), model.element('3', new Point()), model.element('4', new Point()), model.element(' ', new Point())},
            {model.element('C', new Point()), model.element('O', new Point()), model.element(' ', new Point()), model.element(' ', new Point()), model.element(' ', new Point())}
		}
	    @Test
	    public void TestComputeNextPosUp() throws Exception {
	        this.controller.orderPerform(ControllerOrder.WORKSHOP);
	        Point nextPos = this.controller.computeNextPos(
	                MobileOrder.Up,
	                new Point(5, 5)
	        );
	        assertEquals(
	                new Point(4, 5),
	                nextPos
	        );
	    }

	    @Test
	    public void TestComputeNextPosLeft() throws Exception {
	        this.controller.orderPerform(ControllerOrder.WORKSHOP);
	        Point nextPos = this.controller.computeNextPos(
	                MobileOrder.Left,
	                new Point(5, 5)
	        );
	        assertEquals(
	                new Point(5, 4),
	                nextPos
	        );
	    }

	    @Test
	    public void TestComputeNextPosDown() throws Exception {
	        this.controller.orderPerform(ControllerOrder.WORKSHOP);
	        Point nextPos = this.controller.computeNextPos(
	                MobileOrder.Down,
	                new Point(5, 5)
	        );
	        assertEquals(
	                new Point(6, 5),
	                nextPos
	        );
	    }

	    @Test
	    public void TestComputeNextPosRight() throws Exception {
	        this.controller.orderPerform(ControllerOrder.WORKSHOP);
	        Point nextPos = this.controller.computeNextPos(
	                MobileOrder.Right,
	                new Point(5, 5)
	        );
	        assertEquals(
	                new Point(5, 6),
	                nextPos
	        );
	    }
	}
}