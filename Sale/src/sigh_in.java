import javax.swing.*;

import java.awt.event.*;

public class sigh_in {
    public static void main(String[] args) {
        final JFrame f = new JFrame("后台管理员登录");

        JLabel label = new JLabel();
        label.setBounds(20, 150, 200, 50);
        final JPasswordField value = new JPasswordField();
        value.setBounds(100, 75, 100, 30);
        final JLabel l1 = new JLabel("账号:");
        l1.setBounds(20, 20, 80, 30);
        final JLabel l2 = new JLabel("密码:");
        l2.setBounds(20, 75, 80, 30);
        JButton b = new JButton("登录");
        b.setBounds(100, 180, 100, 30);
        final JTextField text = new JTextField();
        text.setBounds(100, 20, 100, 30);
    	b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        if ((text.getText().trim().equals("lll") && new String(value.getPassword()).trim().equals("111"))) {
        	 backstage.main(null);
        	 f.dispose();
        }
       
			}
			});

        f.add(value);
        f.add(l1);
        f.add(label);
        f.add(l2);
        f.add(b);
        f.add(text);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }
}