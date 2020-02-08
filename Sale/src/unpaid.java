import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class unpaid {
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
			final JFrame f = new JFrame("未付款订单");
			sql = " SELECT * FROM ORDER_INFORMATION WHERE PAYMENT_LIST =0";
			ResultSet rs = stmt.executeQuery(sql);
			String[][] a = new String[20][20];
			int i=0;
			int []price = new int [20];
			int aa = 50;
					while (rs.next()) {
						a[0][i] = rs.getString(1);
						a[1][i] = rs.getString(2);
						a[2][i] = rs.getString(3);
						a[3][i] = rs.getString(4);
						a[4][i] = rs.getString(5);
						a[5][i] = rs.getString(6);
						a[6][i] = rs.getString(7);
						a[7][i] = rs.getString(8);
						price[i] = rs.getInt(9);
						i++;
					}
					JLabel[] b2 = new JLabel[i];
					JLabel b1 = new JLabel("订单号                     下单日期                           运输要求                   发货日期                          重量                运费 ");
					b1.setBounds(40,aa-20,1800,30);
					f.add(b1);
					f.add(b1);
					for (int b = 0; b < i; b++) {
						
						b2[b] = new JLabel(a[0][b]+""+a[1][b]+""+a[3][b]+"  "+a[5][b]+"  "+a[6][b]+"  " +a[7][b]);
						
						b2[b].setBounds(40,aa,1800,30);
						
						aa+=70;
					f.add(b2[b]);
					}
					
	JButton bb = new JButton("返回");
	bb.setBounds(0, 0, 61, 20);
	f.add(bb);
	bb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ee) {
					backstage.main(null);
			f.dispose();
		}
	});
	f.setSize(1200, 600);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
		stmt.close();
		con.close();
	} catch (SQLException ex) {
		System.err.println("SQLException: "
				+ ex.getMessage());
	}
	}
}