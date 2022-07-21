package eTicaretDemoo.business.concretes;

import java.util.List;

import eTicaretDemoo.business.abstracts.CustomerCheckService;
import eTicaretDemoo.business.abstracts.CustomerService;
import eTicaretDemoo.business.abstracts.VerificationService;
import eTicaretDemoo.dataAccess.abstracts.CustomerDao;
import eTicaretDemoo.entities.concretes.Customer;

public class CustomerManager implements CustomerService{
CustomerCheckService customerCheckService;
VerificationService mailVerificationService;
CustomerDao customerDao;

	public CustomerManager(CustomerCheckService customerCheckService, VerificationService mailVerificationService,
		CustomerDao customerDao) {
	super();
	this.customerCheckService = customerCheckService;
	this.mailVerificationService = mailVerificationService;
	this.customerDao = customerDao;
}

	@Override
	public void SingUp(Customer customer) {
		 if(customerCheckService.IsValid(customer)==true) {
			System.out.println(customer.getName()+"Kullan�c� ba�r�yla sisteme kaydedildi."); 
			mailVerificationService.sendToVerifyMail(customer.getEmail());
			customerDao.add(customer);
		
		 }
		
	}

	@Override
	public void SingIn(Customer customer) {
		//bu kodu �al��t�rarak do�rulama mailine t�klam���z gibi d���n�yoruz.
	mailVerificationService.verifyMail(customer.getEmail());
	if(customerDao.getPassword(customer.getPassword())&&customerDao.getEmail(customer.getEmail())
			&& mailVerificationService.checkVerifyAccount(customer.getEmail())==true) {
		System.out.println("Kullan�c� giri�i ba�ar�yla yap�ld�.");
	}else if (mailVerificationService.checkVerifyAccount(customer.getEmail())==false) {
		System.out.println("Mail adresinizi do�rulaman�z gerekiyor. ");
			
	}else {
		System.out.println("Kullan�c� bilgileri yanl��, l�tfen kontrol ediniz.");
	}
		
	}
	
	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
