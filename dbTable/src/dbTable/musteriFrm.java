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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class musteriFrm extends JFrame {

	private JPanel contentPane;
    private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"No","Ad","Soyad","Tel no","Bakiye"};
	Object[] satirlar = new Object[5];
	private JTextField txt_no;
	private JTextField txt_ad;
	private JTextField txt_soyad;
	private JTextField txt_tel;
	private JTextField txt_bakiye;
	private JTextField txt_adsorgu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musteriFrm frame = new musteriFrm();
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
	public musteriFrm() {
		setTitle("Müsteri Veritabaný");
		setDefaultCloseOperation();
		setBounds(100, 100, 920, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
				
				ResultSet myRs = baglanti.musteri();
				
				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("idmus");
						satirlar[1] = myRs.getString("mus_ad");
						satirlar[2] = myRs.getString("mus_soyad");
						satirlar[3] = myRs.getString("mus_tel");
						satirlar[4] = myRs.getString("mus_bakiye");
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
		txt_no.setEditable(false);
		txt_no.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_no.setBounds(665, 35, 213, 33);
		contentPane.add(txt_no);
		txt_no.setColumns(10);
		
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
		
		txt_tel = new JTextField();
		txt_tel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_tel.setBounds(665, 227, 213, 33);
		contentPane.add(txt_tel);
		txt_tel.setColumns(10);
		
		txt_bakiye = new JTextField();
		txt_bakiye.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_bakiye.setBounds(665, 284, 213, 33);
		contentPane.add(txt_bakiye);
		txt_bakiye.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String no,ad,soyad,tel,bakiye,sql_sorgu;
				no = txt_no.getText();
				ad = txt_ad.getText();
				soyad = txt_soyad.getText();
				tel = txt_tel.getText();
				bakiye = txt_bakiye.getText();
				
				
				sql_sorgu = "INSERT INTO musteri (mus_ad,mus_soyad,mus_tel,mus_bakiye) VALUES ('" + ad + "','" + soyad + "','" + tel + "'," + 
				bakiye + ")" ;   
				baglanti.ekle(sql_sorgu);
				
			}
		});
		btnKaydet.setBounds(582, 358, 95, 25);
		contentPane.add(btnKaydet);
		
		JLabel lblNewLabel = new JLabel("Numara");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(582, 34, 63, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblAd = new JLabel("Ad");
		lblAd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAd.setBounds(582, 100, 73, 33);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoyad.setBounds(582, 165, 63, 33);
		contentPane.add(lblSoyad);
		
		// veritabani guncelleme
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no,ad,soyad,tel,bakiye,sql_sorgu;
				no = txt_no.getText();
				ad = txt_ad.getText();
				soyad = txt_soyad.getText();
				tel = txt_tel.getText();
				bakiye = txt_bakiye.getText();
				
				sql_sorgu = "UPDATE musteri SET idmus="+no+","+
				            "mus_ad='"+ad+"',mus_soyad='"+soyad+"',mus_tel='"+tel+
				            "',mus_bakiye=" + bakiye + " WHERE idmus="+no;
				
				baglanti.update(sql_sorgu);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(783, 358, 95, 25);
		contentPane.add(btnUpdate);
		
		// veritabanindan kayit silme
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no,sql_sorgu;
				no = txt_no.getText();
				sql_sorgu = "DELETE FROM musteri WHERE idmus=" +no;
				baglanti.sil(sql_sorgu);
			}
		});
		btnSil.setForeground(Color.BLACK);
		btnSil.setBackground(Color.RED);
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSil.setBounds(686, 393, 87, 25);
		contentPane.add(btnSil);
		
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Soyad", "Numara","Tel No","Bakiye"}));
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
					sql_sorgu = "select * from musteri where mus_ad like '"+ alan + "%'";
				} else if(secilen == 1) {
					sql_sorgu = "select * from musteri where mus_soyad like '"+ alan + "%'";
				} else if(secilen == 2) {
					sql_sorgu = "select * from musteri where idmus = "+ Integer.parseInt(alan);
				} else if(secilen == 3) {
					sql_sorgu = "select * from musteri where mus_tel like '"+ alan + "%'";
				} else if(secilen == 4) {
					sql_sorgu = "select * from musteri where mus_bakiye = "+ Integer.parseInt(alan);
				}
				
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("idmus");
						satirlar[1] = myRs.getString("mus_ad");
						satirlar[2] = myRs.getString("mus_soyad");
						satirlar[3] = myRs.getString("mus_tel");
						satirlar[4] = myRs.getString("mus_bakiye");
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
		
		JLabel lblNewLabel_2 = new JLabel("Telefon");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(582, 233, 63, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Bakiye");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(582, 284, 63, 33);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_no.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
				txt_ad.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
				txt_soyad.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				txt_tel.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
				txt_bakiye.setText((String) modelim.getValueAt(table.getSelectedRow(), 4));
				
			}	
		});
		

		//contentPane.add(table);
	}


	private void setDefaultCloseOperation() {
		this.dispose();
		
	}

}
