package eTicaretDemoo.core;

import java.util.ArrayList;
import java.util.List;

import eTicaretDemoo.business.abstracts.VerificationService;

public class GoogleLoginAdapter implements VerificationService{
List<String> verificatedEmails= new ArrayList<String>();

@Override
public void verifyMail(String email) {
	verificatedEmails.add(email);
	System.out.println(email+"ba�ar�yla do�ruland�");
	
}

@Override
public void sendToVerifyMail(String email) {

	System.out.println(email+ "kullan�c�s�na do�rulama mail'i g�nderildi");
	
}

@Override
public boolean checkVerifyAccount(String email) {
	if(verificatedEmails.contains(email));
	System.out.println(email+"ba�ar�yla do�ruladn�.");
	return false;
}

}
