package hospitalGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class PatientCreation extends JFrame{

	private JPanel contentPane;
	private JTextField patientnumberTF;
	private JTextField firstnameTF;
	private JTextField lastnameTF;
	private JTextField ageTF;
	private JTextField dateofbirthTF;
	private JTextField mobilenumberTF;
	private JTextField visitdateTF;
	private JTextField roomnumberTF;
	private JTextField pastillnessesTF;
	private JTextField symptomreviewTF;
	private JTextField currentdiagnosisTF;
	private JTextField notesTF;
	private JTextField emailTF;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientCreation frame = new PatientCreation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			}
		});
	}

	public PatientCreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient #:");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 150, 40);
		contentPane.add(lblNewLabel);
		
		patientnumberTF = new JTextField();
		patientnumberTF.setBounds(127, 13, 150, 40);
		contentPane.add(patientnumberTF);
		patientnumberTF.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Home Home = new Home();
				Home.setVisible(true);
				writeSavePatientIndex();
				dispose();
				
			}
		});
		
		btnHome.setFont(new Font("Unispace", Font.BOLD, 13));
		btnHome.setBounds(635, 13, 139, 39);
		contentPane.add(btnHome);
		
		JLabel lblCurrentVisit = new JLabel("Current Visit");
		lblCurrentVisit.setFont(new Font("Unispace", Font.BOLD, 24));
		lblCurrentVisit.setBounds(34, 178, 202, 40);
		contentPane.add(lblCurrentVisit);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 59, 150, 40);
		contentPane.add(lblFirstName);
		
		firstnameTF = new JTextField();
		firstnameTF.setColumns(10);
		firstnameTF.setBounds(127, 59, 150, 40);
		contentPane.add(firstnameTF);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 105, 150, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age:");
		lblNewLabel_1_2.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(355, 13, 80, 40);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date of Birth:");
		lblNewLabel_1_3.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(310, 59, 150, 40);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mobile Number:");
		lblNewLabel_1_4.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(310, 105, 150, 40);
		contentPane.add(lblNewLabel_1_4);
		
		lastnameTF = new JTextField();
		lastnameTF.setColumns(10);
		lastnameTF.setBounds(127, 105, 150, 40);
		contentPane.add(lastnameTF);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(459, 13, 150, 40);
		contentPane.add(ageTF);
		
		dateofbirthTF = new JTextField();
		dateofbirthTF.setColumns(10);
		dateofbirthTF.setBounds(459, 59, 150, 40);
		contentPane.add(dateofbirthTF);
		
		mobilenumberTF = new JTextField();
		mobilenumberTF.setColumns(10);
		mobilenumberTF.setBounds(459, 106, 150, 40);
		contentPane.add(mobilenumberTF);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.PatientIndex++;
				writeSavePatientIndex();
				infoSave();
	
			}
		});
		
		
		btnSave.setFont(new Font("Unispace", Font.BOLD, 13));
		btnSave.setBounds(635, 61, 139, 39);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel_1 = new JLabel("Visit Date:");
		lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(51, 229, 118, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Past Illnesses:");
		lblNewLabel_2.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 281, 150, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Symptom Review:");
		lblNewLabel_3.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 410, 150, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Room #:");
		lblNewLabel_4.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(488, 229, 70, 40);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Current Diagnosis:");
		lblNewLabel_5.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(379, 281, 186, 40);
		contentPane.add(lblNewLabel_5);
		
		visitdateTF = new JTextField();
		visitdateTF.setColumns(10);
		visitdateTF.setBounds(170, 229, 199, 40);
		contentPane.add(visitdateTF);
		
		roomnumberTF = new JTextField();
		roomnumberTF.setColumns(10);
		roomnumberTF.setBounds(565, 231, 209, 40);
		contentPane.add(roomnumberTF);
		
		JLabel lblNewLabel_3_1 = new JLabel("Notes:");
		lblNewLabel_3_1.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(499, 410, 65, 40);
		contentPane.add(lblNewLabel_3_1);
		
		pastillnessesTF = new JTextField();
		pastillnessesTF.setColumns(10);
		pastillnessesTF.setBounds(167, 281, 202, 130);
		contentPane.add(pastillnessesTF);
		
		symptomreviewTF = new JTextField();
		symptomreviewTF.setColumns(10);
		symptomreviewTF.setBounds(167, 419, 202, 131);
		contentPane.add(symptomreviewTF);
		
		currentdiagnosisTF = new JTextField();
		currentdiagnosisTF.setColumns(10);
		currentdiagnosisTF.setBounds(565, 281, 209, 130);
		contentPane.add(currentdiagnosisTF);
		
		notesTF = new JTextField();
		notesTF.setColumns(10);
		notesTF.setBounds(565, 419, 209, 131);
		contentPane.add(notesTF);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email:");
		lblNewLabel_1_4_1.setFont(new Font("Unispace", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(390, 150, 70, 40);
		contentPane.add(lblNewLabel_1_4_1);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(459, 152, 150, 40);
		contentPane.add(emailTF);
	}
	
	public void infoSave() {
		
		try{
			
			File f = new File("patientinfo"+getLoadPatientIndex()); 

			FileOutputStream in = new FileOutputStream(f);

			PrintWriter w = new PrintWriter(in); 

			String patientnumber = patientnumberTF.getText();
			String firstname = firstnameTF.getText();
			String lastname = lastnameTF.getText();
			String age = ageTF.getText();
			String dateofbirth = dateofbirthTF.getText();
			String mobilenumber = mobilenumberTF.getText();
			String email = emailTF.getText();
			String visitdate = visitdateTF.getText();
			String roomnumber = roomnumberTF.getText();
			String pastillnesses = pastillnessesTF.getText();
			String currentdiagnosis = currentdiagnosisTF.getText();
			String symptomreview = symptomreviewTF.getText();
			String notes = notesTF.getText();

			
			w.println(patientnumber);
			w.println(firstname);
			w.println(lastname);
			w.println(age);
			w.println(dateofbirth);
			w.println(mobilenumber);
			w.println(email);
			w.println(visitdate);
			w.println(roomnumber);
			w.println(pastillnesses);
			w.println(currentdiagnosis);
			w.println(symptomreview);
			w.println(notes);
			
			w.close();
			
		}
		
		catch (Exception e){
		}
		
		
	}

	public void writeSavePatientIndex() {
		
		try {
			File f = new File("PatientIndex"); 
			FileOutputStream in = new FileOutputStream(f);
			PrintWriter w = new PrintWriter(in); 
			w.println(Home.PatientIndex);
			w.close();
		}
		catch(Exception e) {
			
		}
		
	}
	
	public int getLoadPatientIndex() {
		try {
			File f1 = new File("PatientIndex");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			Home.PatientIndex=Integer.parseInt(r.readLine());
			r.close();
		}
		catch(Exception e) {
		}
		return Home.PatientIndex;
		
	}
	
}
