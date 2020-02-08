import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class order {
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
			sql = "SELECT SUM(tatal) from aaa";
			stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(sql);
			int c = 0;

			while (rs1.next()) {
				c = rs1.getInt(1);
			}
			sql = "SELECT CUSTOMER_CODE from CUSTOMER_INFORMATION";
			stmt = con.createStatement();
			ResultSet rs2 = stmt.executeQuery(sql);
			String c3 = null;

			while (rs2.next()) {
				c3 = rs2.getString(1);

			}
			int iii = 1;
			sql = "SELECT CUSTOMER_CODE from ORDER_INFORMATION";
			stmt = con.createStatement();
			ResultSet rs3 = stmt.executeQuery(sql);
			while (rs3.next()) {
				iii++;
			}
			final int bbb = iii;

			int ccc = 30000 + (int) (1 + Math.random() * (10000 - 1 + 1));
			String r = ccc + "";
			int ac = 0;
			int aaaa = 0;
			sql = " SELECT * FROM aa";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ac = rs.getInt(1);
			}
			ac++;
			String aac = ac + "";
			sql = "insert into aa values(" + ac + ")";

			stmt.executeUpdate(sql);
			final int ccc1 = ccc;
			final int cc1 = c;
			String a1 = "2019-07-05";
			String a2 = "无特殊要求";
			String a3 = "能";
			String a4 = "2019-07-06";
			String a5 = "未称重";
			String a6 = "无";
			// String a7="0";
			sql = "insert into  ORDER_INFORMATION values('" + aac + "','" + a1
					+ "','" + c3 + "','" + a2 + "','" + a3 + "','" + a4 + "','"
					+ a5 + "','" + a6 + "',0)";

			stmt.executeUpdate(sql);
			final JFrame f = new JFrame("订单信息");
			String[] a = new String[8];
			JLabel labe1 = new JLabel("细则编号                 " + r);
			labe1.setBounds(50, 20, 200, 50);
			JLabel labe2 = new JLabel("订单号                     " + ac);
			labe2.setBounds(50, 60, 200, 50);
			JLabel labe4 = new JLabel("运费                          " + a6);
			labe4.setBounds(50, 100, 200, 50);
			JLabel labe5 = new JLabel("总金额                      " + cc1);
			labe5.setBounds(50, 150, 200, 50);
			JButton b = new JButton("确认支付");
			b.setBounds(30, 220, 100, 30);
			JButton cc = new JButton("取消支付");
			cc.setBounds(150, 220, 100, 30);

			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (ccc1 >= cc1) {
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
							Pay.main(null);
							ResultSet rs;
							stmt = con.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_UPDATABLE);

							rs = stmt
									.executeQuery("SELECT ORDER_NUMBER,ORDER_DATE,CUSTOMER_CODE,TRANSPORTATION_REQUIREMENTS,MARK_OF_AVAILABILITY,TRANSPORT_DATE,CARGO_WEIGHT,FREIGHT,PAYMENT_LIST FROM ORDER_INFORMATION");
							rs.absolute(bbb);
							rs.updateInt(9, 1);
							rs.updateRow();
							f.dispose();
							stmt.close();
							con.close();
						} catch (SQLException ex) {
							System.err.println("SQLException: "
									+ ex.getMessage());
						}
					} else
						failed.main(null);
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
			cc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					homepage.main(null);
					f.dispose();
				}
			});
			f.add(labe1);
			f.add(labe2);
			f.add(labe4);
			f.add(labe5);
			f.add(b);
			f.add(cc);
			f.setSize(300, 300);
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