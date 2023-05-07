package nmfc.clients;

import java.awt.*;
import javax.swing.*;

class Toast extends JFrame {

	//String of toast
	String s;

	// JWindow
	JWindow w;

	Toast(String s, int x, int y,int size1,int size2)
	{
		w = new JWindow();

		// make the background transparent
		w.setBackground(new Color(133,254,161,100));

		// create a panel
		JLabel p = new JLabel();

		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.setFont(new Font("Verdana",Font.BOLD,18));
		p.setText(s);
		p.setBackground(new Color(133,254,161,90));
		p.setForeground(new Color(0,0,0));
		w.setLayout(new FlowLayout(FlowLayout.CENTER));
		w.add(p);
		w.setLocation(x, y);
		w.setSize(size1,size2);
	}

	// function to pop up the toast
	void showtoast()
	{
		try {
			w.setOpacity(1);
			w.setVisible(true);

			// wait for some time
			Thread.sleep(2000);

			// make the message disappear slowly
			for (double d = 1.0; d > 0.2; d -= 0.1) {
				Thread.sleep(100);
				w.setOpacity((float)d);
			}

			// set the visibility to false
			w.setVisible(false);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
