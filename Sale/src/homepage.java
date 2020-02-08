import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class homepage {

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
				a[0][i] = rs.getString(1);
				a[1][i] = rs.getString(2);
				a[2][i] = rs.getString(3);
				num[i] = rs.getInt(4);
				price[i] = rs.getInt(5);
				i++;
			}
			final JFrame f = new JFrame("阿迷shop");
			JLabel label = new JLabel("挑选您需要的物品");
			label.setBounds(20, 0, 200, 50);
			JButton b = new JButton("进入后台");
			b.setBounds(400, 30, 100, 30);
			JButton c = new JButton("确认支付");
			c.setBounds(10, 400, 100, 30);
			JButton button2 = new JButton("确认");
			button2.setBounds(400, 400, 100, 30);
			f.add(label);
			f.add(b);
			f.add(c);
			f.add(button2);
			JLabel[] labe1 = new JLabel[i];
			JLabel[] labe2 = new JLabel[i];
			JLabel[] labe3 = new JLabel[i];
			JLabel[] labe4 = new JLabel[i];
			int aa = 50;
			sql = "UPDATE aaa  SET tatal =0";
			stmt.executeUpdate(sql);
			for (int j = 0; j < i; j++) {
				labe1[j] = new JLabel("商品：" + a[2][j]);
				labe1[j].setBounds(50, aa, 200, 50);
				labe2[j] = new JLabel("单价：" + price[j]);
				labe2[j].setBounds(50, aa + 15, 200, 50);
				final JTextField[] text = new JTextField[i];
				text[j] = new JTextField();
				text[j].setBounds(200, 30 + aa, 100, 20);
				f.add(labe1[j]);
				f.add(labe2[j]);
				f.add(text[j]);
				aa += 70;
				final int bbb = j;
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
						Connection con;
						String sql;
						Statement stmt;
						try {
							Class.forName("oracle.jdbc.driver.OracleDriver");
						} catch (java.lang.ClassNotFoundException ee) {
							System.err.print("ClassNotFoundException: ");
							System.err.println(ee.getMessage());
						}
						try {
							con = DriverManager.getConnection(url, "system",
									"system");
							stmt = con.createStatement();
							if (e.getActionCommand() == "确认") {

								if (text[bbb].getText().isEmpty()
										|| text[bbb].getText().equals("")) {

								} else {
									int aaaa = Integer.parseInt(text[bbb]
											.getText());
									int countol = aaaa * price[bbb];
									num[bbb] -= aaaa;
									ResultSet rs;
									stmt = con.createStatement(
											ResultSet.TYPE_SCROLL_INSENSITIVE,
											ResultSet.CONCUR_UPDATABLE);

									rs = stmt
											.executeQuery("SELECT PRODUCT_CLASSIFICATION_NUMBER,MANUFACTURER_CODE,COMMODIT_DESCRIPTION,num,UNIT_PRICE FROM TNVENTORY_COMMODITY");
									rs.absolute(bbb + 1);
									rs.updateInt(4, num[bbb]);
									rs.updateRow();

									sql = "insert into aaa values(" + countol
											+ ")";
									
									stmt.executeUpdate(sql);

								}
							}

							stmt.close();
							con.close();
						} catch (SQLException ex) {
							System.err.println("SQLException: "
									+ ex.getMessage());
						}
					}

					private String Format(String string) {
						// TODO 自动生成的方法存根
						return null;
					}
				});

			}
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sigh_in.main(null);
					f.dispose();
				}
			});
			c.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					fill_in.main(null);
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