
import javax.swing.*;

import java.awt.event.*;

public class Deliver {
	public static void main(String[] args) {
		final JFrame f = new JFrame("");

		JLabel label = new JLabel("货物已发出");
		label.setBounds(60, 30, 200, 50);

		f.add(label);
		JLabel labe2 = new JLabel("打印邮寄成功");
		labe2.setBounds(60, 80, 200, 50);

		f.add(labe2);
		JLabel labe3 = new JLabel("发票已打印");
		labe3.setBounds(60, 130, 200, 50);

		f.add(labe3);
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
