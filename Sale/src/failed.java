
import javax.swing.*;

import java.awt.event.*;

public class failed {
	public static void main(String[] args) {
		final JFrame f = new JFrame("");

		JLabel label = new JLabel("Ö§¸¶Ê§°Ü");
		label.setBounds(60, 20, 200, 50);

		f.add(label);
		JButton bb = new JButton("·µ»Ø");
		bb.setBounds(0, 0, 61, 20);
		f.add(bb);
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				homepage.main(null);
				f.dispose();
			}
		});
		f.setSize(200, 150);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
	}
}
