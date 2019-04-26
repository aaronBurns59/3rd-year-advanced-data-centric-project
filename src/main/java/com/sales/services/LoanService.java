package com.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;
import java.util.*;

@Service
public class LoanService
{
	@Autowired
	LoanRepository lr;
	
	public ArrayList<Loan> findLoans()
	{
		return (ArrayList<Loan>) lr.findAll();
	}// findLoans
	
	
}// LoanService
