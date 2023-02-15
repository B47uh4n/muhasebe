package dbTable;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.Color;

public class fisFrm extends JFrame {

	private JPanel contentPane;
	private JTextField adTxt;
	private JTextField fytTxt;
	private JTextField mktrTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fisFrm frame = new fisFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public fisFrm() throws ParseException {
		setTitle("Fatura sistemi");
		setDefaultCloseOperation();
		setBounds(100, 100, 922, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCr\u00FCn Fiyat");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(49, 134, 87, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblrnAd = new JLabel("\u00DCr\u00FCn Ad");
		lblrnAd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblrnAd.setBounds(49, 56, 87, 34);
		contentPane.add(lblrnAd);
		
		adTxt = new JTextField();
		adTxt.setBounds(171, 56, 148, 30);
		contentPane.add(adTxt);
		adTxt.setColumns(10);
		
		
		
	   
	    
		
		fytTxt = new JTextField();
		fytTxt.setColumns(10);
		fytTxt.setBounds(171, 134, 148, 30);
		fytTxt.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // if it's not a number, ignore the event
		        }
		     }
		});
		contentPane.add(fytTxt);
		
		JLabel lblrnMiktar = new JLabel("\u00DCr\u00FCn Miktar");
		lblrnMiktar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblrnMiktar.setBounds(49, 212, 101, 34);
		contentPane.add(lblrnMiktar);
		
		mktrTxt = new JTextField();
		mktrTxt.setColumns(10);
		mktrTxt.setBounds(171, 212, 148, 30);
		mktrTxt.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // if it's not a number, ignore the event
		        }
		     }
		});
		contentPane.add(mktrTxt);
		
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setFont(new Font("Monospaced", Font.PLAIN, 15));
		area.setTabSize(10);
		area.setBounds(434, 56, 425, 344);
		contentPane.add(area);
		
		JButton btnFis = new JButton("Olu\u015Ftur");
		btnFis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int toplam = Integer.parseInt(fytTxt.getText()) * Integer.parseInt(mktrTxt.getText());
				
				area.setText("************************************************\n");
				area.setText(area.getText() + "*                Fatura Sistemi                *\n");
				area.setText(area.getText() + "************************************************\n");
				
				java.util.Date date = new java.util.Date();
				area.setText(area.getText() + "\n" + date + "\n\n"); 
				area.setText(area.getText() + "Ürün Adý : " + adTxt.getText() + "\n" ); 
				area.setText(area.getText() + "Ürün Fiyat : " + fytTxt.getText() + "\n" ); 
				area.setText(area.getText() + "Ürün Miktar : " + mktrTxt.getText() + "\n\n" ); 
				
				//burada ekle butonu acilip surekli daha cok urun eklenebilir
				
				area.setText(area.getText() + "                           +\n");
				area.setText(area.getText() + "----------------------------\n");
				
				area.setText(area.getText() + "Toplam Fiyat : " + toplam); 
				
			}
		});
		btnFis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFis.setBounds(218, 366, 101, 34);
		contentPane.add(btnFis);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				adTxt.setText("");
				fytTxt.setText("");
				mktrTxt.setText("");
				
				
				
			}
		});
		btnTemizle.setForeground(Color.RED);
		btnTemizle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTemizle.setBounds(49, 366, 101, 34);
		contentPane.add(btnTemizle);
		
		JButton btnYazdr = new JButton("Yazd\u0131r");
		btnYazdr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					area.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnYazdr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnYazdr.setBounds(434, 415, 101, 34);
		contentPane.add(btnYazdr);
	}

	private void setDefaultCloseOperation() {
		this.dispose();
		
		
	}
}
