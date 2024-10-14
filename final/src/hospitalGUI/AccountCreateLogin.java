package hospitalGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class AccountCreateLogin extends Home{
	
	private String accountUsername;
	private String accountPassword;
	
	public void setUsername(String accountUsername) {
		this.accountUsername=accountUsername;
		try{
			File f = new File("accountusername"); 
			FileOutputStream in = new FileOutputStream(f);
			PrintWriter w = new PrintWriter(in); 
			w.println(accountUsername);
			w.close();
		}
		catch (Exception e){
		}
	}
	
	public String getUsername() {
		try {
			File f1 = new File("accountusername");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			accountUsername=r.readLine();
			r.close();
		}
		catch(Exception e) {
		}
		return accountUsername;
	}
	
	public void setPassword(String accountPassword) {
		this.accountPassword=accountPassword;
		try{
			File f = new File("accountpassword"); 
			FileOutputStream in = new FileOutputStream(f);
			PrintWriter w = new PrintWriter(in); 
			w.println(accountPassword);
			w.close();
		}
		catch (Exception e){
		}
	}
	
	public String getPassword() {
		try {
			File f1 = new File("accountpassword");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			accountPassword=r.readLine();
			r.close();
		}
		catch(Exception e) {
		}
		return accountPassword;
	}
	
}
