package eTicaretDemoo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretDemoo.dataAccess.abstracts.CustomerDao;
import eTicaretDemoo.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao{
 List<Customer> customers=new ArrayList<Customer>();
	
	@Override
	public void add(Customer customer) {
		customers.add(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEmail(String email) {
		for(Customer customer:customers) {
			if(customer.getEmail()==email) {
				return true;}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
          for(Customer customer:customers) {
        	  if(customer.getPassword()==password)
        	  { return true;}
        				 
          }
		return false;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
