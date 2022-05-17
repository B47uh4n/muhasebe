package dbTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class giris extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JTextField txt_ad;
	private JTextField txt_sifre;
	static String ad;
	static String sifre;
	JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public giris() {
		setTitle("Giriþ yap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 72, 103, 31);
		contentPane.add(lblNewLabel);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(159, 72, 150, 31);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(46, 125, 36, 22);
		contentPane.add(lblNewLabel_1);
		
		txt_sifre = new JTextField(); // password ile alinabilir
		txt_sifre.setColumns(10);
		txt_sifre.setBounds(159, 116, 150, 31);
		contentPane.add(txt_sifre);
		txt_sifre.addKeyListener(this);
		
		//giris buton
		btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ad = txt_ad.getText();
				sifre = txt_sifre.getText(); // getpassword ile al burayi
				String sql_sorgu = "SELECT count(idkul) as giris FROM deneme.kul where kul_ad='"+ ad + "' and sifre='" + sifre + "'";
				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							ekran ekr = new ekran();
							ekr.setVisible(true);
							setVisible(false);
							//bu ekr ekranýnda yetkisi olan yerleri görsün
						} else { btnNewButton.setText("Hatalý giriþ");
						         btnNewButton.setBackground(Color.RED);}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		} } );
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(159, 169, 150, 31);
		contentPane.add(btnNewButton);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			
			ad = txt_ad.getText();
			sifre = txt_sifre.getText(); // getpassword ile al burayi
			String sql_sorgu = "SELECT count(idkul) as giris FROM deneme.kul where kul_ad='"+ ad + "' and sifre='" + sifre + "'";
			ResultSet myRs = baglanti.yap();
			myRs = baglanti.sorgula(sql_sorgu);
			
			try {
				while(myRs.next()) {
					if(myRs.getInt("giris")==1) {
						ekran ekr = new ekran();
						ekr.setVisible(true);
						setVisible(false);
						//bu ekr ekranýnda yetkisi olan yerleri görsün
					} else { btnNewButton.setText("Hatalý giriþ");
					         btnNewButton.setBackground(Color.RED);}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
