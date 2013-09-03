package com.freitas.server.ws;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freitas.exception.BaseException;
import com.freitas.exception.RestError;
import com.freitas.model.Customer;
import com.freitas.server.ws.service.CustomerService;


@Controller
@RequestMapping("/ws")
public class MainController {
	
	private static Logger log = Logger.getLogger(MainController.class);
	private static WSValidator validator = new WSValidator();
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public @ResponseBody Customer saveCustomer(@RequestBody Customer customer) {
		
		log.debug("Enter saveCustomer in TestMgmtController with " + customer.getName());
		
		validator.validateCustomer(customer);
		return customerService.saveCustomer(customer);
	}
	
	
	@RequestMapping(value="/customer", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomerByName(@RequestParam("name") String name) {
		
		log.debug("Enter getCustomerByName in MainController with " + name);
		
		validator.validateString(name, "Name");
		return customerService.getCustomerByName(name);
	}
	
	
	@RequestMapping(value="/customer/{name}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteCustomer(@PathVariable String name) {
		
		log.debug("Enter getTest in MainController");
		
		validator.validateString(name, "Name");
		return customerService.deleteCustomerByName(name);
	}
	
	
	@ExceptionHandler(BaseException.class)
	public @ResponseBody RestError handleCustomException (BaseException ex, HttpServletResponse response) {
		response.setHeader("Content-Type", "application/json");
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return ex.transformException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}

}
