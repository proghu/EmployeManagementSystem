package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.Payroll;
import com.Employee_Management_Backend.Exceptions.ResourceNotFoundException;

public interface PayrollService {
	
		Payroll createPayroll(Payroll payroll);
	    Payroll getPayrollById(int payrollId);
	    List<Payroll> getAllPayrolls();
	    Payroll updatePayroll(int payrollId, Payroll payrollDetails);
	    void deletePayroll(int payrollId);

}
