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
	//	Point ZPoint = Game.getZOrderCoordinates(zorder);
	    //int sense = Game.getSenseOfZOrder(ZPoint.getX(), ZPoint.getY());
	  //  int[] l = Game.getPointsAroundZPoint(zorder, sense);
		//Game.s(l);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
