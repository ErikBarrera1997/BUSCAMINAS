package field;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mechanics.Game;
import mechanics.Score;

class Listener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		Component source = (Component) e.getSource(); 
		int zorder= Game.getZOrderFromCoordinates(source.getX(), source.getY()) -1;
		Game.dig(mechanics.Control.getPanel(), zorder); 
		System.out.println(Score.getDiscover());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 
		
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

}
