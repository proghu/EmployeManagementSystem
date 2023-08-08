package com.Employee_Management_Backend.Services;

import java.util.List;

import com.Employee_Management_Backend.Entity.SalaryBonusEntity;

public interface SalaryBonusService {
	
	 List<SalaryBonusEntity> getAllSalaryBonuses();
	 SalaryBonusEntity getSalaryBonusById(int salaryId);
	 SalaryBonusEntity createSalaryBonus(SalaryBonusEntity salaryBonus);
	 SalaryBonusEntity updateSalaryBonus(int salaryId, SalaryBonusEntity salaryBonus);
	    void deleteSalaryBonus(int salaryId);

}
