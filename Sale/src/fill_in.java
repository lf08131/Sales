import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fill_in {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con;
		String sql;
		Statement stmt;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection(url, "system", "system");
			stmt = con.createStatement();

			final JFrame f = new JFrame("");
			JLabel l1 = new JLabel("姓名:");
			l1.setBounds(120, 70, 80, 30);
			JLabel l2 = new JLabel("电话号:");
			l2.setBounds(120, 125, 80, 30);
			JLabel l3 = new JLabel("邮编:");
			l3.setBounds(120, 180, 80, 30);
			JLabel l4 = new JLabel("地址:");
			l4.setBounds(120, 235, 80, 30);
			JButton b = new JButton("确认支付");
			b.setBounds(200, 320, 100, 30);

			int c = 0;
			sql = "SELECT SUM(tatal) from aaa";

			stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(sql);

			while (rs1.next()) {
				c = rs1.getInt(1);

			}

		
			JLabel labe6 = new JLabel("" + c);
			labe6.setBounds(120, 300, 200, 50);
			final JTextField text = new JTextField(10);
			final JTextField text2 = new JTextField(10);
			final JTextField text3 = new JTextField(10);
			final JTextField text4 = new JTextField(10);
			text.setBounds(200, 70, 100, 30);
			text2.setBounds(200, 135, 100, 30);
			text3.setBounds(200, 180, 100, 30);
			text4.setBounds(200, 235, 100, 30);
			f.add(l1);
			f.add(l2);
			f.add(l3);
			f.add(l4);
			f.add(b);

			f.add(text);
			f.add(text2);
			f.add(text3);
			f.add(text4);
			f.add(labe6);
		
			String c1 = text.getText();
			String c2 = text2.getText();
			String c3 = text3.getText();
			String c4 = text4.getText();

			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
					Connection con;
					String sql;
					Statement stmt;
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
					} catch (java.lang.ClassNotFoundException e) {
						System.err.print("ClassNotFoundException: ");
						System.err.println(e.getMessage());
					}
					try {
						con = DriverManager.getConnection(url, "system",
								"system");
						stmt = con.createStatement();
						if (ee.getActionCommand() == "确认支付") {
							order.main(null);
							String ccc = "30000"
									+ (int) (1 + Math.random()
											* (10000 - 1 + 1));
							sql = "insert into  CUSTOMER_INFORMATION values('"
									+ ccc + "','" + text.getText() + "','"
									+ text.getText() + "','" + text2.getText()
									+ "','" + text3.getText() + "','"
									+ text4.getText() + "')";

							stmt.executeUpdate(sql);
							f.dispose();
						}
						stmt.close();
						con.close();
					} catch (SQLException ex) {
						System.err.println("SQLException: " + ex.getMessage());
					}
				}
			});
			JButton bb = new JButton("返回");
			bb.setBounds(0, 0, 61, 20);
			f.add(bb);
			bb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					homepage.main(null);
					f.dispose();
				}
			});

			f.setSize(500, 500);
			f.setLocationRelativeTo(null);
			f.setLayout(null);
			f.setVisible(true);

			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}