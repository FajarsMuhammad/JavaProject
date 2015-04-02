/**
 * 
 */
package com.app.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.service.CustomerService;

/**
 *
 * @author  fajar
 * @version 1.0
 * @created 25 Okt 2011
 *
 */

@Component("generateCode")
public class GenerateCode {

	@Autowired
	private CustomerService customerService;
	
	public GenerateCode() {
	}


	public String generateCustomerCode(){
		String keygen = "C00001";
        String code = null;
        Integer countCode = new Integer(0);
        List<Customer> codeList = customerService.generateCode(keygen.substring(0,1));
        if(codeList.isEmpty()){
            code = keygen;
        }else{
            String temp = null;
            Customer customer = (Customer)codeList.get(0);
            temp = customer.getCustomerCode().substring(2);
            countCode = Integer.parseInt(temp) + 1;
            code = customer.getCustomerCode().substring(0,(customer.getCustomerCode().length() - String.valueOf(countCode).length())) + String.valueOf(countCode);
        }
        return code;
	}




}
