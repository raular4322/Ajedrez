import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends Canvas implements PropertyChangeListener {
	private Board board;
	private Graphics2D g2d;
	
	public View(Board board) {
		this.board = board;
	}
	
	public void paint(Graphics g) {
		this.g2d = (Graphics2D) g;
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, board.getSize() * GameValues.CELLFULLSIZE, board.getSize() * GameValues.CELLFULLSIZE);
		
		for (int i = 0; i < board.getSize(); i++) {
			for (int j = 0; j < board.getSize(); j++) {
				Color cellColor;
				
				if (i % 2 == 0 && j % 2 == 0) {
					cellColor = Color.BLACK;
				} else cellColor = Color.LIGHT_GRAY;
				
				g2d.setColor(cellColor);
				g2d.fillRect(j * GameValues.CELLFULLSIZE, i * GameValues.CELLFULLSIZE, GameValues.CELLSIZE, GameValues.CELLSIZE);
				if (board.getPosition(i, j).getPiece() != null) {
					g2d.drawString(board.getPosition(i, j).getPiece().getSymbol(), j * GameValues.PIECESIZE, i * GameValues.PIECESIZE);
				}
			}
		}
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}
