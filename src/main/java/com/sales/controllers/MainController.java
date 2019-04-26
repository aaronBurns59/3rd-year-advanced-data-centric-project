package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.services.BookService;
import com.sales.services.CustomerService;
import com.sales.services.LoanService;

@Controller
public class MainController
{
	
//BOOK//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	BookService bs;
	
	// Get Method for reading books DB to display to the showBooks page
	@RequestMapping(value = "/showBooks", method = RequestMethod.GET)
	public String getBooks(Model m)
	{
		ArrayList<Book> books =  bs.findBooks();
		m.addAttribute("books", books);
		return "showBooks";
	}// getBooks
	
	// Get Method for reading data from the books DB in order to change using the addBook page
	@RequestMapping(value = "/addBook", method=RequestMethod.GET)
	public String addBookGet(@ModelAttribute("bookAdd") Book b, HttpServletRequest h)
	{
		return "addBook";
	}// addBookGet
	
	// Post method used for writing new entries to the DB
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String addBookPost(@Valid @ModelAttribute("bookAdd")  Book book, BindingResult res, Model m)
	{
		if(res.hasErrors())
		{
			return "addBook";
		}// if
		
		bs.saveBook(book);
		return "redirect:showBooks";
	}// addBookPost
//CUSTOMER////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value="/showCustomers", method=RequestMethod.GET)
	public String getCustomers(Model m)
	{
		ArrayList<Customer> customers = cs.findCustomers();
		m.addAttribute("customers", customers);
		return "showCustomers";
	}// getCustomers
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)
	public String addCustomerGet(@ModelAttribute("customerAdd") Customer c, HttpServletRequest h)
	{
		return "addCustomer";
	}// addCustomerGet
	
	@RequestMapping(value = "/addCustomer", method=RequestMethod.POST)
	public String addCustomerPost(@Valid @ModelAttribute("customerAdd") Customer customer, BindingResult res, Model m)
	{
		if(res.hasErrors())
		{
			return "addCustomer";
		}// if
		cs.saveCustomer(customer);
		return "redirect:showCustomers";
	}// addCustomerPost
//LOAN//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	LoanService ls;
	
	@RequestMapping(value="/showLoans", method=RequestMethod.GET)
	public String getLoans(Model m)
	{
		ArrayList<Loan> loans = ls.findLoans();
		m.addAttribute("loans", loans);
		return "showLoans";
	}//getLoans
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// MainContoller
