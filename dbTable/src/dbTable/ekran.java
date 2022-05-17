package dbTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ekran extends JFrame {

	private JPanel contentPane;
	JLabel lbl_kullanici;
	private JButton btn_Urun;
	private JButton btn_müs;
	String s1 = "admin";
	String s2 = "stok";
	String s3 = "calisan";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekran frame = new ekran();
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
	 public ekran() {
		setTitle("Muhasebe");
		setDefaultCloseOperation();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		s1 = "admin";
		s2 = "stok";
		s3 = "calisan";
		
		lbl_kullanici = new JLabel("New label");
		lbl_kullanici.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_kullanici.setBounds(331, 217, 95, 36);
		contentPane.add(lbl_kullanici);
		lbl_kullanici.setText(giris.ad);
		
		// personel veritabani butonu
		JButton btn_veri = new JButton("Personel Veritabani");
		btn_veri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Frm2 vt = new Frm2();
				vt.setVisible(true);

			}
		});
		btn_veri.setEnabled(false);
		btn_veri.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_veri.setBounds(200, 24, 210, 36);
		contentPane.add(btn_veri);
		
		//urun veritabani butonu
		btn_Urun = new JButton("\u00DCr\u00FCn Veritabani");
		btn_Urun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				urunFrm uvt = new urunFrm();
				uvt.setVisible(true);
			}
		});
		btn_Urun.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Urun.setEnabled(false);
		btn_Urun.setBounds(200, 78, 210, 36);
		contentPane.add(btn_Urun);
		
		btn_müs = new JButton("M\u00FC\u015Fteri Veritabani");
		btn_müs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				musteriFrm mvt = new musteriFrm();
				mvt.setVisible(true);
			}
		});
		btn_müs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_müs.setEnabled(false);
		btn_müs.setBounds(200, 134, 210, 36);
		contentPane.add(btn_müs);
		
		// erisim izinleri
		if(giris.ad.equals(s1)) {
			btn_veri.setEnabled(true);
			btn_Urun.setEnabled(true);
			btn_müs.setEnabled(true);
		} else if(giris.ad.equals(s2)) {
			btn_Urun.setEnabled(true);
		} else if(giris.ad.equals(s3)) {
			btn_Urun.setEnabled(true);
			btn_veri.setEnabled(true);
			btn_müs.setEnabled(true);
		}
	}

	private void setDefaultCloseOperation() {
		this.dispose();
		
	}
}
