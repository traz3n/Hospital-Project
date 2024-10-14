package hospitalGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField searchTF;
	public static AccountCreateLogin newacc = new AccountCreateLogin();
	
	private JTable table1;
	DefaultTableModel dtm1 = new DefaultTableModel();
	final Object[] rowfields1 = new Object [7];
	
	PatientCreation Patient = new PatientCreation();
	
	public static int PatientIndex;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//program start prompt
				Object[] options = {"Yes", "No", "Cancel"};
			    int accountprompt = JOptionPane.showOptionDialog(null, "Do you want to change your username and password?", "", 
			    		JOptionPane.YES_NO_OPTION,
			    		JOptionPane.QUESTION_MESSAGE,
			    		null, 
			    		options, 
			    		options[0]);
			    
			    
			    if(accountprompt == 0) {
			    	changeAccount();
			    	login();
			    	
			    }
			    if(accountprompt == 1) {
			    	login();
			    	
			    }

			}
		});

	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 764, 370);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveSelectedRow();
			}
		});
		
		scrollPane.setViewportView(table1);
		Object [] columns1 = {"Patient Number", "First Name", "Last Name", "Age", "Date of Birth", "Mobile Number", "Email"};
		dtm1.setColumnIdentifiers(columns1);
		table1.setModel(dtm1);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(365, 37, 66, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientCreation patient = new PatientCreation();
				patient.setVisible(true);
				dispose();	
			}
		});
		btnNewButton.setFont(new Font("Unispace", Font.BOLD, 13));
		btnNewButton.setBounds(10, 31, 150, 60);
		contentPane.add(btnNewButton);
		
		JButton btnAddVisit = new JButton("Edit Patient");
		btnAddVisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientEdit patient = new PatientEdit();
				patient.setVisible(true);
				dispose();
			}
		});
		btnAddVisit.setFont(new Font("Unispace", Font.BOLD, 13));
		btnAddVisit.setBounds(187, 31, 150, 60);
		contentPane.add(btnAddVisit);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}
		});
		btnNewButton_1.setFont(new Font("Unispace", Font.BOLD, 13));
		btnNewButton_1.setBounds(624, 31, 150, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPatientTable = new JLabel("Patient Table");
		lblPatientTable.setFont(new Font("Unispace", Font.BOLD, 24));
		lblPatientTable.setBounds(294, 117, 202, 40);
		contentPane.add(lblPatientTable);
		
		searchTF = new JTextField();
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel searchtable1 = (DefaultTableModel)table1.getModel();
				String search = searchTF.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(searchtable1);
				table1.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
				
			}
		});
		searchTF.setBounds(458, 31, 150, 40);
		contentPane.add(searchTF);
		searchTF.setColumns(10);
		
		JLabel lblSearchPatient = new JLabel("Search Patient");
		lblSearchPatient.setFont(new Font("Unispace", Font.BOLD, 14));
		lblSearchPatient.setBounds(484, 66, 126, 40);
		contentPane.add(lblSearchPatient);
		
		getLoadPatientIndex();
		loadTable();
		
	}
	
	public static void login() {

		//login
		while(true) {
			JTextField enterusername = new JTextField();
			JTextField enterpassword = new JPasswordField();
			Object[] message2 = {
					"Username:", enterusername,
					"Password:", enterpassword
			};

			int option2 = JOptionPane.showConfirmDialog(null, message2, "Login", JOptionPane.OK_CANCEL_OPTION);

				if (option2 == JOptionPane.OK_OPTION) {
					if (enterusername.getText().equals(newacc.getUsername()) && enterpassword.getText().equals(newacc.getPassword())) {
						JOptionPane.showMessageDialog(null, "Login Successful");
						
						try {
							Home frame = new Home();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Login Failed");
						break;
					}
				} else {
					break;
				}
			
			}
	}
	
	public static void changeAccount() {
		//change account
		JTextField changeusername = new JTextField();
		JTextField changepassword = new JPasswordField();
		Object[] message1 = {
				"Set Username:", changeusername,
				"Set Password:", changepassword
		};

		
		int option1 = JOptionPane.showConfirmDialog(null, message1, "Change your username and password", JOptionPane.OK_CANCEL_OPTION);
		
		if(option1 == JOptionPane.OK_OPTION) {
		
		newacc.setUsername(changeusername.getText());
		newacc.setPassword(changepassword.getText());
		JOptionPane.showMessageDialog(null, "Please use these credentials to login.");
			
		}
		
		else {
			
		}
	}
	
	public int getLoadPatientIndex() {
		try {
			File f1 = new File("PatientIndex");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			PatientIndex=Integer.parseInt(r.readLine());
			r.close();
		}
		catch(Exception e) {
		}
		return PatientIndex;
		
	}
	
	public void loadTable() {	
		
		for(int i = 0; i<getLoadPatientIndex(); i++) {
			try{
				File f1 = new File("patientinfo"+(i+1));
				FileReader in1 = new FileReader (f1);
				BufferedReader r1 = new BufferedReader(in1);	
				for(int x=0; x<7; x++) {
					rowfields1[x] = r1.readLine();
				}
				
				dtm1.addRow(rowfields1);
				r1.close();
			}
			catch(Exception e){

			}
		}
		
			
		}
	
	public void saveSelectedRow() {
		
		int selectedrow1 = table1.getSelectedRow();
		
		try{
			File f = new File("selectedrownum"); 
			FileOutputStream in = new FileOutputStream(f);
			PrintWriter w = new PrintWriter(in); 
			w.println(selectedrow1);
			w.close();
		}
		catch (Exception e){
		}
		
	}
	
}
