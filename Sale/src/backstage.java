import javax.swing.*;

import java.awt.event.*;

public class backstage {
	public static void main(String[] args) {
		final JFrame f = new JFrame("��̨����");
		JButton b2 = new JButton("��֧������");
		b2.setBounds(70, 50, 150, 30);
		JButton b3 = new JButton("δ֧������");
		b3.setBounds(70, 100, 150, 30);
		JButton b4 = new JButton("�Ѵ�����");
		b4.setBounds(70, 150, 150, 30);
		JButton b5 = new JButton("�����");
		b5.setBounds(70, 200, 150, 30);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		JButton bb = new JButton("����");
		bb.setBounds(0, 0, 61, 20);
		f.add(bb);
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				homepage.main(null);
				f.dispose();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paid.main(null);
				f.dispose();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unpaid.main(null);
				f.dispose();
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finished.main(null);
				f.dispose();
			}
			
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked.main(null);
				f.dispose();
			}
		});

		f.setSize(300, 350);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
	}
}
