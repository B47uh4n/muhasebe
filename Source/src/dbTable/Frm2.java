package dbTable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Frm2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"No","Ad","Soyad","Maaþ","Tel"};
	Object[] satirlar = new Object[5];
	private JTextField txt_no;
	private JTextField txt_ad;
	private JTextField txt_soyad;
	private JTextField txt_maas;
	private JTextField txt_tel;
	private JTextField txt_adsorgu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm2 frame = new Frm2();
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
	public Frm2() {
		setTitle("Personel Veritabaný");
		setDefaultCloseOperation();
		setBounds(100, 100, 958, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 508, 277);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("");
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(134, 251, 242, 144);
		scrollPane.setViewportView(table); //scrollpane ile table baglantisi
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				
				ResultSet myRs = baglanti.yap();
				
				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("idper");
						satirlar[1] = myRs.getString("perad");
						satirlar[2] = myRs.getString("persoyad");
						satirlar[3] = myRs.getString("permaas");
						satirlar[4] = myRs.getString("pertel");
						modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(423, 297, 95, 25);
		contentPane.add(btnNewButton);
		
		txt_no = new JTextField();
		txt_no.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_no.setBounds(665, 35, 213, 33);
		contentPane.add(txt_no);
		txt_no.setColumns(10);
		txt_no.setEditable(false);
		
		txt_ad = new JTextField();
		txt_ad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ad.setBounds(665, 101, 213, 33);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		txt_soyad = new JTextField();
		txt_soyad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_soyad.setBounds(665, 166, 213, 33);
		contentPane.add(txt_soyad);
		txt_soyad.setColumns(10);
		
		txt_maas = new JTextField();
		txt_maas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_maas.setBounds(665, 228, 213, 33);
		contentPane.add(txt_maas);
		txt_maas.setColumns(10);
		
		txt_tel = new JTextField();
		txt_tel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tel.setBounds(665, 295, 213, 33);
		contentPane.add(txt_tel);
		txt_tel.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String no,ad,soyad,maas,tel,sql_sorgu;
				no = txt_no.getText();
				ad = txt_ad.getText();
				soyad = txt_soyad.getText();
				maas = txt_maas.getText();
				tel = txt_tel.getText();
				
				sql_sorgu = "INSERT INTO personel (perad,persoyad,permaas,pertel) VALUES ('" + ad + "'," + "'" + soyad + "'," + maas + ",'" +
				tel + "')" ;   
				//System.out.println(sql_sorgu);
				baglanti.ekle(sql_sorgu);
				
			}
		});
		btnKaydet.setBounds(582, 390, 95, 25);
		contentPane.add(btnKaydet);
		if(giris.ad.equals("calisan")) {btnKaydet.setEnabled(false);}
		
		JLabel lblNewLabel = new JLabel("Numara");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(582, 34, 63, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblAd = new JLabel("Ad");
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAd.setBounds(618, 100, 27, 33);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoyad.setBounds(596, 165, 49, 33);
		contentPane.add(lblSoyad);
		
		// veritabani guncelleme
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no,ad,soyad,maas,tel,sql_sorgu;
				no = txt_no.getText();
				ad = txt_ad.getText();
				soyad = txt_soyad.getText();
				maas = txt_maas.getText();
				tel = txt_tel.getText();
				
				sql_sorgu = "UPDATE personel SET idper="+no+","+
				            "perad='"+ad+"',persoyad='"+soyad+"',permaas=" + maas + ",pertel='" + tel +
				            "' WHERE idper="+no;
				
				baglanti.update(sql_sorgu);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(783, 390, 95, 25);
		contentPane.add(btnUpdate);
		if(giris.ad.equals("calisan")) {btnUpdate.setEnabled(false);}
		
		// veritabanindan kayit silme
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no,sql_sorgu;
				no = txt_no.getText();
				sql_sorgu = "DELETE FROM personel WHERE idper=" +no;
				baglanti.sil(sql_sorgu);
			}
		});
		btnSil.setForeground(Color.BLACK);
		btnSil.setBackground(Color.RED);
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSil.setBounds(689, 427, 87, 25);
		contentPane.add(btnSil);
		if(giris.ad.equals("calisan")) {btnSil.setEnabled(false);}
		
		txt_adsorgu = new JTextField();
		txt_adsorgu.setBounds(22, 393, 107, 25);
		contentPane.add(txt_adsorgu);
		txt_adsorgu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Alan :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 355, 61, 28);
		contentPane.add(lblNewLabel_1);
		
		// sorgulama alan secimi icin combobox
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Soyad", "Numara","Tel No","Maas"}));
		comboBox.setBounds(70, 358, 95, 25);
		contentPane.add(comboBox);
		
		// sorgulamalar
		JButton btnNewButton_1 = new JButton("Sorgula");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				String sql_sorgu = null;
				String alan = txt_adsorgu.getText();
				ResultSet myRs = null;
				
				int secilen = comboBox.getSelectedIndex(); // secilen combobox indexi
				
				// ad indexi icin ad, soyad icin soyad, no icin no sorgulama
				if(secilen == 0) {
					sql_sorgu = "select * from personel where perad like '"+ alan + "%'";
				} else if(secilen == 1) {
					sql_sorgu = "select * from personel where persoyad like '"+ alan + "%'";
				} else if(secilen == 2) {
					sql_sorgu = "select * from personel where idper = "+ Integer.parseInt(alan);
				} else if(secilen == 3) {
					sql_sorgu = "select * from personel where pertel like '"+ alan + "%'";
				} else if(secilen == 4) {
					sql_sorgu = "select * from personel where permaas = "+ Integer.parseInt(alan);
				}
				
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("idper");
						satirlar[1] = myRs.getString("perad");
						satirlar[2] = myRs.getString("persoyad");
						satirlar[3] = myRs.getString("permaas");
						satirlar[4] = myRs.getString("pertel");
						modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				table.setModel(modelim);
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(22, 428, 95, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMaa = new JLabel("Maa\u015F");
		lblMaa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaa.setBounds(596, 228, 49, 33);
		contentPane.add(lblMaa);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefon.setBounds(582, 297, 63, 33);
		contentPane.add(lblTelefon);
		
		
		//print butonu
				JButton btnPrint = new JButton("Yazd\u0131r");
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						PrinterJob job=PrinterJob.getPrinterJob(); job.setJobName("Printer Data"); job.setPrintable(new Printable(){

						    public int print(Graphics pg,PageFormat pf,int pageNum){
						                    
						                        if(pageNum>0){
						                        return Printable.NO_SUCH_PAGE;
						                        }
						                        Graphics2D g2=(Graphics2D)pg;
						                        g2.translate(pf.getImageableX(),pf.getImageableY());
						                        g2.scale(0.24,0.24);
						                        
						                        contentPane.paint(g2);
						                        return Printable.PAGE_EXISTS;
						                    }
						    
						    
						    
						});
						boolean ok=job.printDialog(); if(ok){ try{ job.print(); } catch(PrinterException ex){} }
						
					}
				});
				btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnPrint.setBounds(423, 336, 95, 25);
				contentPane.add(btnPrint);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_no.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
				txt_ad.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				txt_soyad.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				txt_maas.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
				txt_tel.setText((String) modelim.getValueAt(table.getSelectedRow(), 4));
			}	
		});
		
		String k = giris.ad;
		//contentPane.add(table);
	}

	private void setDefaultCloseOperation() {
		this.dispose();
		
	}
}
