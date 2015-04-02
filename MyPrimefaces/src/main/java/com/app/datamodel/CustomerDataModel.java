package com.app.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.app.model.Customer;

public class CustomerDataModel extends ListDataModel<Customer> implements SelectableDataModel<Customer> {

	public CustomerDataModel() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDataModel(List<Customer> data) {  
        super(data);  
    } 

	public Customer getRowData(String rowKey) {
		//In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
        
        @SuppressWarnings("unchecked")
		List<Customer> customers = (List<Customer>) getWrappedData();  
          
        for(Customer customer : customers) {  
            if(customer.getCustomerCode().equals(rowKey))  
                return customer;  
        }  
          
        return null;  
	}

	public Object getRowKey(Customer customer) {
		// TODO Auto-generated method stub
		return customer.getCustomerId();
	}

}
