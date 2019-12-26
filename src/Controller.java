import java.awt.*;
import java.beans.PropertyChangeSupport;

public class Controller extends Frame {
	public Board board;
	public View view;
	public MouseController mouseController;
	public PropertyChangeSupport support;
	
	public Controller(int size) {
		this.board = new Board(size);
		
		this.mouseController = new MouseController(this);
	}
	
	public void shoot(int x, int y) {
	
	}
}
