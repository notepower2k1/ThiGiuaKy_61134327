package Bai3_61134327;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtDiem;
	private JTextField txtNamSinh;
	JScrollPane scrollPane_1;
	JLabel lblMaSV;
	JLabel lblHo;
	JLabel lblTen;
	JLabel lblDiem;
	JLabel lblNamSinh;
	JButton btnAdd;
	JButton btnRemove;
	JButton btnUpdate;
	JButton btnSearch;
	JLabel lblstt;
	DefaultTableModel data;
	Vector<Object> hangX;
	private JButton btnShow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 232, 778, 201);
		contentPane.add(scrollPane_1);
		table = new JTable();
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				
				String ma = data.getValueAt(table.getSelectedRow(),0).toString();
				String ho = data.getValueAt(table.getSelectedRow(),1).toString();
				String ten = data.getValueAt(table.getSelectedRow(),2).toString();
				String namsinh = data.getValueAt(table.getSelectedRow(),3).toString();
				String diem = data.getValueAt(table.getSelectedRow(),4).toString();

				txtMaSV.setText(ma);
				txtHo.setText(ho);
				txtTen.setText(ten);
				txtDiem.setText(diem);
				txtNamSinh.setText(namsinh);
				lblstt.setText("");
				}
				catch(Exception ex) {
					lblstt.setText("Empty");
				}
							}
			@Override
			public void mousePressed(MouseEvent e) {
					
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);
		
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		
		scrollPane_1.setViewportView(table);
		
		
		
		lblMaSV = new JLabel("Mã sinh viên");
		lblMaSV.setBounds(122, 32, 97, 13);
		contentPane.add(lblMaSV);
		
		lblHo = new JLabel("Họ sinh viên");
		lblHo.setBounds(122, 65, 85, 13);
		contentPane.add(lblHo);
		
		lblTen = new JLabel("Tên sinh viên");
		lblTen.setBounds(122, 99, 85, 13);
		contentPane.add(lblTen);
		
		txtMaSV = new JTextField();
		txtMaSV.setBounds(229, 29, 140, 19);
		contentPane.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtHo = new JTextField();
		txtHo.setBounds(229, 62, 140, 19);
		contentPane.add(txtHo);
		txtHo.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setBounds(229, 96, 140, 19);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtDiem = new JTextField();
		txtDiem.setBounds(229, 135, 140, 19);
		contentPane.add(txtDiem);
		txtDiem.setColumns(10);
		
		lblDiem = new JLabel("Điểm");
		lblDiem.setBounds(122, 138, 71, 13);
		contentPane.add(lblDiem);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setBounds(229, 175, 140, 19);
		contentPane.add(txtNamSinh);
		txtNamSinh.setColumns(10);
		
		lblNamSinh = new JLabel("Năm sinh");
		lblNamSinh.setBounds(122, 178, 71, 13);
		contentPane.add(lblNamSinh);
		
		setDefaulValue();

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	
				String Ma = txtMaSV.getText();
				boolean isExist = false;
				
					for(int i = 0 ; i < table.getRowCount();i++) {
					
					String value = data.getValueAt(i, 0).toString();
						
					if(Ma.equals(value)) {
						isExist = true;
						break;
					}
				}

				if(isExist == true) {
					lblstt.setText("Ma sinh vien: " + Ma + " is Existed");
				}
				else {
					String Ho = txtHo.getText();
					String Ten = txtTen.getText();
					String nam = txtNamSinh.getText();
					Double diem = Double.parseDouble(txtDiem.getText());
					
					SinhVien p = new SinhVien(Ma,Ho,Ten,LocalDate.parse(nam),diem);

					//Tao dong them vao bang
					Vector<Object> hangX = new Vector<>();
					
					hangX.addElement(Ma);
					hangX.addElement(Ho);
					hangX.addElement(Ten);
					hangX.addElement(nam);
					hangX.addElement(diem);

					data.addRow(hangX);
					
					table.updateUI();
					reset();
				}
				
				}
				catch(Exception ex) {
					lblstt.setText("TextField is Empty!!!");
				}
			}
		});
		btnAdd.setBounds(459, 57, 85, 21);
		contentPane.add(btnAdd);
		
		btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			
				String Ma = txtMaSV.getText();
				
				if(Ma=="")
				{
					int position = table.getSelectedRow();
					int count = table.getSelectedRowCount();
					if(count == 1)
					{
						data.removeRow(position);
						reset();
					}
					else {
						if(table.getRowCount() ==0) {
							lblstt.setText("Empty!");
						}
						else {
							lblstt.setText("Please select row for delete");
						}
					}
				}
				else {					
					for(int i = 0 ; i < table.getRowCount();i++) {
					
					String value = data.getValueAt(i, 0).toString();
						
					if(Ma.equals(value)) {
						data.removeRow(i);
						break;
					}
					reset();
						}
				}
				
			
			}
		});
		btnRemove.setBounds(583, 57, 85, 21);
		contentPane.add(btnRemove);
		
		btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Ma = txtMaSV.getText();
				boolean isExist = false;
				String ho = "";
				String ten = "";
				String namsinh = "";
				String diem = "";
					for(int i = 0 ; i < table.getRowCount();i++) {
					
					String value = data.getValueAt(i, 0).toString();
					
					if(Ma.equals(value)) {
						isExist = true;
						
						 ho = data.getValueAt(i,1).toString();
						 ten = data.getValueAt(i,2).toString();
						 namsinh = data.getValueAt(i,3).toString();
						 diem = data.getValueAt(i,4).toString();
						
						
						break;
					}
				}
				if(isExist == true) {
					JOptionPane.showMessageDialog(MainGUI.this, "Mã sinh viên: " + Ma + "\nHọ và tên: " + ho + " " + ten + "\nNăm sinh: " + namsinh + "\nĐiểm: " + diem , "Kết quả tìm kiếm: ", JOptionPane.INFORMATION_MESSAGE);

				}
				else {
					lblstt.setText("Không tồn tại");
				}
					
			}
		});
		btnSearch.setBounds(583, 99, 85, 21);
		contentPane.add(btnSearch);
		
		btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int count = table.getSelectedRowCount();
			
			if(count ==1) {
				String Ma = txtMaSV.getText();
				String Ho = txtHo.getText();
				String Ten = txtTen.getText();
				String nam = txtNamSinh.getText();
				Double diem = Double.parseDouble(txtDiem.getText());

				data.setValueAt(Ma,table.getSelectedRow(),0);
				data.setValueAt(Ho,table.getSelectedRow(),1);
				data.setValueAt(Ten,table.getSelectedRow(),2);
				data.setValueAt(nam,table.getSelectedRow(),3);
				data.setValueAt(diem,table.getSelectedRow(),4);
				
				lblstt.setText("Update successfully");
				reset();
			}
			else {
				if(table.getRowCount()==0) {
					lblstt.setText("Empty!");
				}
				else {
					lblstt.setText("Please select row for delete");
				}

			}
			
			
			
				
		}
		});
		btnUpdate.setBounds(459, 99, 85, 21);
		contentPane.add(btnUpdate);
		
		
		lblstt = new JLabel("");
		lblstt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblstt.setForeground(Color.RED);
		lblstt.setBounds(459, 178, 273, 38);
		contentPane.add(lblstt);
		
		btnShow = new JButton("Hiển thị lại toàn bộ danh sách");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaulValue();
				reset();
			}
		});
		btnShow.setBounds(459, 136, 209, 32);
		contentPane.add(btnShow);
		
	}

		
	

	protected void reset() {
		txtMaSV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtNamSinh.setText("");
		txtDiem.setText("");


		
	}
	void setDefaulValue() {
		
		data = new DefaultTableModel();
		data.addColumn("Mã sinh viên");
		data.addColumn("Họ");
		data.addColumn("Tên");
		data.addColumn("Năm sinh");
		data.addColumn("Điểm");
		//sv1
		Vector<Object> hangX = new Vector<>();
		SinhVien p = new SinhVien("SV001","Nguyễn Văn","Thạch",LocalDate.of(2000,01,06),10.0);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);	
		//sv2
		hangX = new Vector<>();
		p = new SinhVien("SV002","Lệ Thị","Hồng",LocalDate.of(2000,05,06),8.5);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);
		//sv3
		hangX = new Vector<>();
		p = new SinhVien("SV003","Cao Thái","Sơn",LocalDate.of(2000,12,30),7.4);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);	
		//sv4
		hangX = new Vector<>();
		p = new SinhVien("SV004","Hà Huy","Tập",LocalDate.of(2000,11,20),4.6);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);		
		//sv5
		hangX = new Vector<>();
		p = new SinhVien("SV005","Nguyễn Thị","Hiền",LocalDate.of(2001,04,05),9.5);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);	
		//sv6
		hangX = new Vector<>();
		p = new SinhVien("SV006","Trần Thì","Diễm",LocalDate.of(2001,06,06),4.5);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);	
		//sv7
		hangX = new Vector<>();
		p = new SinhVien("SV007","Lý Thùy","Trang",LocalDate.of(2001,10,23),7.5);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);
		//sv8
		hangX = new Vector<>();
		p = new SinhVien("SV008","Cao Hải","Duy",LocalDate.of(2002,01,31),5.5);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);
		//sv9
		hangX = new Vector<>();
		p = new SinhVien("SV009","Lê Thị","Vân",LocalDate.of(2002,03,06),8.1);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);
		//sv10
		hangX = new Vector<>();
		p = new SinhVien("SV010","Nguyễn Văn","Hùng",LocalDate.of(2002,04,23),6.7);
		hangX.add(p.getMaSV());
		hangX.add(p.getHo());
		hangX.add(p.getTen());
		hangX.add(p.getNamSinh());
		hangX.add(p.getDiem());
		data.addRow(hangX);
			
		
		table.setModel(data);
	}
}
