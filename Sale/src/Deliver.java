
import javax.swing.*;

import java.awt.event.*;

public class Deliver {
	public static void main(String[] args) {
		final JFrame f = new JFrame("");

		JLabel label = new JLabel("�����ѷ���");
		label.setBounds(60, 30, 200, 50);

		f.add(label);
		JLabel labe2 = new JLabel("��ӡ�ʼĳɹ�");
		labe2.setBounds(60, 80, 200, 50);

		f.add(labe2);
		JLabel labe3 = new JLabel("��Ʊ�Ѵ�ӡ");
		labe3.setBounds(60, 130, 200, 50);

		f.add(labe3);
		JButton bb = new JButton("����");
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
