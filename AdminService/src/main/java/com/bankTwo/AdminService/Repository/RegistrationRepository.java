package com.bankTwo.AdminService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bankTwo.AdminService.Model.Register;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Register, Long> {
	Register findByAccountNumber(String accountNumber);

	Register findByPhoneNumber(String phoneNumber);

	Register findByAccountNumberAndPassword(String accountNumber, String password);

	Register findByPhoneNumberAndPassword(String phoneNumber, String password);
}
