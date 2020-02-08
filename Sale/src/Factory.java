import javax.swing.*;

import java.awt.event.*;

public class Factory {
	public static void main(String[] args) {
		final JFrame f = new JFrame("");

		JLabel label = new JLabel("已联系厂家");
		label.setBounds(60, 60, 200, 50);

		f.add(label);
		JLabel labe2 = new JLabel("货物近日到库");
		labe2.setBounds(60, 120, 200, 50);

		f.add(labe2);

		JButton bb = new JButton("返回");
		bb.setBounds(0, 0, 61, 20);
		f.add(bb);
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				backstage.main(null);
				f.dispose();
			}
		});
		f.setSize(200, 250);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
	}
}
