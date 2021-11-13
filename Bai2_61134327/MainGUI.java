package Bai2_61134327;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainGUI {

	private JFrame frame;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtKQ;
	private JButton btnC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txta = new JTextField();
		txta.setBounds(149, 47, 96, 19);
		frame.getContentPane().add(txta);
		txta.setColumns(10);
		
		txtb = new JTextField();
		txtb.setBounds(149, 88, 96, 19);
		frame.getContentPane().add(txtb);
		txtb.setColumns(10);
		
		txtKQ = new JTextField();
		txtKQ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtKQ.setBounds(33, 175, 430, 50);
		frame.getContentPane().add(txtKQ);
		txtKQ.setColumns(10);
		
		JButton btnTinh = new JButton("Tính");
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				
				double a = Double.parseDouble(txta.getText());
				double b = Double.parseDouble(txtb.getText());

				
				if(a ==0) {
					
					if(b == 0)
					{
						txtKQ.setText("Phương trình có vô số nghiệm");
					}
					else {
						txtKQ.setText("Phương trình vô nghiệm");
					}
					
				}
				else {
					txtKQ.setText("Phương trình có nghiệm duy nhất là: " + (-b/a) );
				}
					}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "Kiểu dữ liệu a , b không hợp lệ","Warning!!!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnTinh.setBounds(89, 132, 85, 21);
		frame.getContentPane().add(btnTinh);
		
		JLabel lblNewLabel = new JLabel("Nhập số a");
		lblNewLabel.setBounds(78, 50, 96, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập số b");
		lblNewLabel_1.setBounds(78, 91, 96, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnC = new JButton("Xóa");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txta.setText("");
				txtb.setText("");

				txtKQ.setText("");

			}
		});
		btnC.setBounds(201, 132, 85, 21);
		frame.getContentPane().add(btnC);
	}
}
