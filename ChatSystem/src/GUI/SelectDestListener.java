package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import Controller.Controller;

public class SelectDestListener implements MouseListener {
	
	private Controller cont;
	
	public SelectDestListener(Controller cont){
		super();
		this.cont = cont;
	}

	public void mouseClicked(MouseEvent arg0) {
		JList userList = cont.getGui().getConnectedWindow().getUl().getUserList();
		int i = userList.locationToIndex(arg0.getPoint());
		if(i != -1)
			cont.updateUsersDest(i);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
