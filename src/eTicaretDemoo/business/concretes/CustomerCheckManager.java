package eTicaretDemoo.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eTicaretDemoo.business.abstracts.CustomerCheckService;
import eTicaretDemoo.entities.concretes.Customer;

public class CustomerCheckManager implements CustomerCheckService {


	
	List<String> listOfEmail=new ArrayList<String>();
	
	
	@Override
	public boolean CheckFirstName(Customer customer) {

		if (customer.getName().isEmpty()) {
			System.out.println("�sim alan� bo� b�rak�lamaz.");
			return false;
		}else {
			if(customer.getName().length()<3) {
				System.out.println("�sim 2 karakterden daha k���k olamaz");
			    return false;
			}
		}
		return true;
	}

	@Override
	public boolean CheckLastName(Customer customer) {
		if (customer.getLastName().isEmpty()) {
			System.out.println("Soyisim alan� bo� b�rak�lamaz.");
			return false;
		}
		else if (customer.getLastName().length()<3) {
				System.out.println("�sim 2 karakterden daha k���k olamaz.");
			    return false;		    
			}
		else {
		return true;}
	}

	@Override
	public boolean CheckPassword(Customer customer) {
		if (customer.getPassword().isEmpty()) {
			System.out.println("�ifre alan� bo� b�rak�lamaz.");
			return false;
		}
		else {
			if (customer.getPassword().length()<6) {
				System.out.println("�ifre en az 6 karakterden olu�mal�d�r.");
		        return false;	
			}
		}
		return true;
	}

	@Override
	public boolean CheckEmail(Customer customer) {
		String regex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        if(customer.getEmail().isEmpty()) {
        	System.out.println("Email alan� bo� b�rak�lamaz");
        	return false;
        	
        }else {
        	if (pattern.matcher(customer.getEmail()).find()==false) {
System.out.println("B�yle bir email adresi bulunmamaktad�r.");
return false;
			}
        }
			
		return true;
	}

	//@Override
	//public boolean uniqueEmail(Customer customer) {
		// if(listOfEmail.contains(customer.getEmail())) {
			// System.out.println("Bu mail adresi ile sisteme daha�nce kay�t olunmu�, farkl� bir mail adresi deneyiniz.");
	       //  return false; }
		// else if( listOfEmail.add(customer.getEmail())){
		
			// return true;
		// }
		 //else {
			// return false;
		// }
	
	//}
	

	@Override
	public boolean uniqueEmail(Customer customer) {
		boolean result=true;
		if (listOfEmail.contains(customer.getEmail())) {
			System.out.println("Bu mail adresi ile sisteme daha �nce kay�t olunmu�, farkl� bir mail adresi deneyiniz.");
			result=false;
		}else{
			result=true;
			listOfEmail.add(customer.getEmail());
		}		
		return result;
	}
	
	@Override
	public boolean IsValid(Customer customer) {
		if (CheckFirstName(customer)&&CheckLastName(customer)&&CheckEmail(customer)&&CheckPassword(customer)&&uniqueEmail(customer)==true) {
			return true;
		}
		return false;
	}



}
