package com.app.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.datamodel.CustomerDataModel;
import com.app.datamodel.CustomerLazyDataModel;
import com.app.model.Customer;
import com.app.service.CustomerService;
import com.app.utility.GenerateCode;
import com.app.utility.JsfUtil;
import com.app.utility.LabelValueBean;
import com.app.utility.ResourceHelper;

@ManagedBean(name="customerBean")
@SessionScoped
@Component
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = -3407113696786816900L;

	private static final Logger log = Logger.getLogger(CustomerBean.class);

	private Customer current = new Customer();
	private Customer detailCustomer = new Customer();

	private String searchColumn;
	private String searchValue;

	private int first;
	private int pageSize;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private GenerateCode generateCode;

	private CustomerDataModel customerDataModel;
	private Customer[] selectedCustomers;

	private LazyDataModel<Customer> lazyDataModel;

	private List<Customer> filteredCustomers;

	public LazyDataModel<Customer> getLazyDataModel() {
		if (lazyDataModel == null) {
			lazyDataModel = new CustomerLazyDataModel(getCustomerList());
		}
		return lazyDataModel;
	}
	
	public CustomerDataModel getModel() {
		customerDataModel = new CustomerDataModel(getCustomerList());
		return customerDataModel;
	}
	

	/**
	 * get all customer data from database
	 */
	public List<Customer> getCustomerList() {
		List<Object> columnList = null;
		List<Object> valueList = null;
		List<Customer> customers = new ArrayList<Customer>();

		if (searchValue != null && !searchValue.trim().equals("")) {
			columnList = new ArrayList<Object>();
			valueList = new ArrayList<Object>();
			columnList.add(searchColumn);
			valueList.add(searchValue);
		}
		customers = customerService.searchCustomer(columnList, valueList,
				first, pageSize);
		

		return customers;
	}

	/**
	 * Methode button search
	 */
	public void search() {
		getModel();
		//getLazyDataModel();
	}

	public List<LabelValueBean> getColumnList() {
		List<LabelValueBean> columnList = new ArrayList<LabelValueBean>();
		columnList.add(new LabelValueBean(ResourceHelper
				.getResources("label.customerCode"), "code"));
		columnList.add(new LabelValueBean(ResourceHelper
				.getResources("label.customerName"), "name"));
		return columnList;
	}

	public List<LabelValueBean> getGradeList() {
		List<LabelValueBean> gradeList = new ArrayList<LabelValueBean>();
		gradeList.add(new LabelValueBean(ResourceHelper
				.getResources("label.gradeA"), "A"));
		gradeList.add(new LabelValueBean(ResourceHelper
				.getResources("label.gradeB"), "B"));
		gradeList.add(new LabelValueBean(ResourceHelper
				.getResources("label.gradeC"), "C"));
		gradeList.add(new LabelValueBean(ResourceHelper
				.getResources("label.gradeD"), "D"));
		return gradeList;
	}

	/**
	 * Method when click add button in list view
	 */
	public void prepareAdd() {
		current = new Customer();
		current.setCustomerCode(generateCode.generateCustomerCode());
	}

	public String goInputPage() {
		return "/pages/master/customerInput";
	}

	public String goListPage() {
		return "/pages/master/customerList";
	}

	/**
	 * Method pada saat update screen
	 */
	public void prepareUpdate() {
		log.info("prepare for update customer...");
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String id = params.get("customerIdParam");
		log.info("ID==" + id);
		Customer customer = customerService.searchCustomerById(new Long(id));
		current.setCustomerId(customer.getCustomerId());
		current.setCustomerCode(customer.getCustomerCode());
		current.setCustomerName(customer.getCustomerName());
		current.setTermOfPayment(customer.getTermOfPayment());
		current.setCustomerGrade(customer.getCustomerGrade() != null ? customer.getCustomerGrade() : "");
		current.setAddress(customer.getAddress());
		log.info("prepare for update customer end...");
	}
	

	public void saveOrUpdate() {
		try {
			log.info("IDS====" + current.getCustomerId());
			log.info("IDS====" + this.current.getCustomerCode());
			log.info("Name====" + this.current.getCustomerName());
			if (current.getCustomerId() == null || current.getCustomerId() == 0) {
				log.info("Save Start >>>");
					
				current.setCustomerId(null);
				current.setCustomerCode(generateCode.generateCustomerCode());
				current.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				for(int i=0; i<1000; i++){
						customerService.save(current);
					
				}
				log.info("Save End >>>");
			} else {
				log.info("Update Start >>>");
				Customer customer = customerService.searchCustomerById(current
						.getCustomerId());
				current.setCustomerCode(customer.getCustomerCode());
				current.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				customerService.update(current);
				log.info("Update End >>>");
			}
			current = new Customer();
			search();
		} catch (Exception e) {
			current = new Customer();
			JsfUtil.addErrorMessage(ResourceHelper.getResources("error.save"));
			e.printStackTrace();
			log.error(e.toString(), e);
		}
	}

	/**
	 * Delete
	 */
	public void delete() {
		try {
			Map<String, String> params = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap();
			String id = params.get("customerIdParam");
			Customer customer = customerService
					.searchCustomerById(new Long(id));
			customerService.delete(customer);
			current = new Customer();
		} catch (Exception e) {
			current = new Customer();
			e.printStackTrace();
		}
	}

	public void deleteSelected() {
		try {
			List<Customer> customers = new ArrayList<Customer>();
			if(selectedCustomers!=null){
				for(int i =0; i<selectedCustomers.length; i++){
					Customer customer = (Customer)selectedCustomers[i];
					customers.add(customer);
				}
			}
			//customerService.deleteAll(customers);
			current = new Customer();
		} catch (Exception e) {
			current = new Customer();
			e.printStackTrace();
		}
	}

	public Customer[] getSelectedCustomers() {
		return selectedCustomers;
	}

	public void setSelectedCustomers(Customer[] selectedCustomers) {
		this.selectedCustomers = selectedCustomers;
	}

	

	public String getSearchColumn() {
		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}


	public List<Customer> getFilteredCustomers() {
		return filteredCustomers;
	}

	public void setFilteredCustomers(List<Customer> filteredCustomers) {
		this.filteredCustomers = filteredCustomers;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Customer getCurrent() {
		return current;
	}

	public void setCurrent(Customer current) {
		this.current = current;
	}

	public Customer getDetailCustomer() {
		return detailCustomer;
	}

	public void setDetailCustomer(Customer detailCustomer) {
		this.detailCustomer = detailCustomer;
	}

}
