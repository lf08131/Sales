import javax.swing.*;

import java.awt.event.*;

public class Pay {
	public static void main(String[] args) {
		final JFrame f = new JFrame("");

		JLabel label = new JLabel("֧���ɹ�");
		label.setBounds(60, 60, 200, 50);

		f.add(label);

		JButton bb = new JButton("����");
		bb.setBounds(0, 0, 61, 20);
		f.add(bb);
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				homepage.main(null);
				f.dispose();
			}
		});
		f.setSize(200, 200);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
	}
}
