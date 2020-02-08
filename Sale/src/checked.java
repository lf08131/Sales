import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class checked {
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

			sql = " SELECT * FROM TNVENTORY_COMMODITY";
			ResultSet rs = stmt.executeQuery(sql);
			String[][] a = new String[6][6];
			final int[] price = new int[6];
			final int[] num = new int[6];
			int i = 0;
			while (rs.next()) {
				a[0][i] = rs.getString(1); // 取出当前行第1列数据
				a[1][i] = rs.getString(2); // 取出当前行第2列数据
				a[2][i] = rs.getString(3);
				num[i] = rs.getInt(4);
				price[i] = rs.getInt(5);
				i++;
			}
			final JFrame f = new JFrame("");

			JButton bb = new JButton("返回");
			JLabel[] labe1 = new JLabel[i];
			JLabel[] labe2 = new JLabel[i];
			JButton[] b2 = new JButton[i];
			int aa = 50;
			for (int j = 0; j < i; j++) {
				labe1[j] = new JLabel("商品：" + a[2][j]);
				labe1[j].setBounds(50, aa, 200, 50);
				labe2[j] = new JLabel("单价：" + num[j]);
				labe2[j].setBounds(50, aa + 15, 200, 50);
				if (num[j] <= 100) {
					b2[j] = new JButton("联系厂家");
					b2[j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ee) {
							Factory.main(null);
						
							f.dispose();
						}
					});
					b2[j].setBounds(250, aa + 15, 100, 30);

					f.add(b2[j]);
				}
				f.add(labe1[j]);
				f.add(labe2[j]);
				aa += 70;
			}
			bb.setBounds(0, 0, 61, 20);
			f.add(bb);
			bb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ee) {
					backstage.main(null);
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