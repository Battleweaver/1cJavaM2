package lessson13;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Prog {
	
	public static void main(String[] args) {
	
		MyFrame window = new MyFrame();
		
	}

}

class MyFrame extends JFrame {
	
	public MyFrame() {
		setBounds(0, 0, 800, 600);
		setTitle("Работа с мышью");
		Panel pan = new Panel();
		Container con = getContentPane();
		con.add(pan);
		
		setVisible(true);
	}
	
}

class Panel extends JPanel {
	Color [] arrayColor;
	static int tCol;
	static int mX;
	static int mY;
	static boolean flag;
	
	
	public Panel() {
		
		addMouseListener(new MyMouse1());
		addMouseMotionListener(new MyMouse2());
		
		setFocusable(true);
		
		
	}
	
	public void paintComponent(Graphics gr) {
		
		arrayColor = new Color [7];
		arrayColor[0] = Color.BLACK;
		arrayColor[1] = Color.GREEN;
		arrayColor[2] = Color.BLUE;
		arrayColor[3] = Color.RED;
		arrayColor[4] = Color.YELLOW;
		arrayColor[5] = Color.WHITE;
		arrayColor[6] = Color.ORANGE;
		
		for (int i = 0; i < arrayColor.length; i++) {
			gr.setColor(arrayColor[i]);
			gr.fillRect(i*100, 0, 100, 50);
			
			if (flag) {
				gr.setColor(arrayColor[tCol]);
				gr.fillRect(mX, mY, 3, 3);
				
			}
		}
		
		
	}
	
	
}

class MyMouse1 implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int tX = e.getX();
		int tY = e.getY();
		
		int col = e.getClickCount();
		int btn = e.getButton();
		
		if ((tX > 0) && (tX < 700) && (tY > 0) && (tY < 50)) {
			if (col == 1) {
				if (btn == 1) {
					Panel.tCol = tX / 100;
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class MyMouse2 implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int tX = e.getX();
		int tY = e.getY();
		
		if (tY >50) {
			Panel.mX = tX;
			Panel.mY = tY;
			Panel.flag = true;
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		int tX = e.getX();
		int tY = e.getY();
		
		if ((tX > 0) && (tX < 700) && (tY > 0) && (tY < 50)) {
			setCursor(new Cursor (Cursor.HAND_CURSOR));
			
		} else {
			
			setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
			
		}
		
	}
	
}