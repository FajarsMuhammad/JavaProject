package com.app.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerLazyDataModel extends LazyDataModel<Customer> {

	private Logger log = Logger.getLogger(CustomerLazyDataModel.class);
	private static final long serialVersionUID = 1L;
	private List<Customer> customers;
	@Autowired
	private CustomerService customerService;

	public CustomerLazyDataModel(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		log.info("first=" + first + ", pagesize=" + pageSize + ", sortfield="
				+ sortField + " sortorder=" + sortOrder + " filter:" + filters);

		List<Customer> data = new ArrayList<Customer>();
		data.addAll(customers);

		// rowCount
		int dataSize = data.size();
		// this.setRowCount(customerService.getCountAllCustomer());
		this.setRowCount(dataSize);
		// paginate
		if (dataSize > pageSize) {
			try {
				return data.subList(first, first + pageSize);
			} catch (IndexOutOfBoundsException e) {
				return data.subList(first, first + (dataSize % pageSize));
			}
		} else {
			return data;
		}
	}

	@Override
	public Object getRowKey(Customer customer) {
		return customer.getCustomerId();
	}

	@Override
	public Customer getRowData(String customerId) {
		Integer id = Integer.valueOf(customerId);
		for (Customer customer : customers) {
			if (id.equals(customer.getCustomerId())) {
				return customer;
			}
		}

		return null;
	}

	@Override
	public void setRowIndex(final int rowIndex) {
		if (rowIndex == -1 || getPageSize() == 0) {
			super.setRowIndex(-1);
		} else {
			super.setRowIndex(rowIndex % getPageSize());
		}
	}

}
