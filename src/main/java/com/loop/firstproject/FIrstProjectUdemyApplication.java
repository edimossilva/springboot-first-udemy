package com.loop.firstproject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.loop.firstproject.enterprise.EmployerRepository;
import com.loop.firstproject.enterprise.EnterpriseRepository;
import com.loop.firstproject.enums.ProfileEnum;
import com.loop.firstproject.model.Employer;
import com.loop.firstproject.model.Enterprise;
import com.loop.firstproject.util.PasswordUtils;

@SpringBootApplication
public class FIrstProjectUdemyApplication {

	@Value("${pagination.page_quantity}")
	private int paginationQuantity;

	@Autowired
	EnterpriseRepository enterpriseRepository;

	@Autowired
	EmployerRepository employerRepository;

	public static void main(String[] args) {
		SpringApplication.run(FIrstProjectUdemyApplication.class, args);
		System.out.println("first project");
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			// passwordExample();
			Enterprise enterprise = getEnterprise1();
			enterpriseRepository.save(enterprise);

			Enterprise enterprise2 = getEnterprise2();
			enterpriseRepository.save(enterprise2);

			Employer employer = getEmployer1(enterprise);
			employerRepository.save(employer);

			Employer employer2 = getEmployer2(enterprise);
			employerRepository.save(employer2);

			enterpriseRepository.save(enterprise);

			Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(enterprise.getId());
			optionalEnterprise.get().getEmployers().forEach(System.out::println);
		};
	}

	private Employer getEmployer1(Enterprise enterprise) {
		Employer employer = new Employer();
		employer.setCpf("cpf1");
		employer.setCreationDate(new Date());
		employer.setEmail("email1@gmail.com");
		employer.setEnterprise(enterprise);
		employer.setLunchTimeQuantity(1.1f);
		employer.setName("employer1");
		String password = "password1";
		String encryptedPassword1 = PasswordUtils.generateBCrypt(password);
		employer.setPassword(encryptedPassword1);
		employer.setProfile(ProfileEnum.ADMIN_ROLE);
		employer.setUpdateDate(new Date());
		employer.setValuePerHour(new BigDecimal("10"));
		employer.setWorkTimeQuantity(10.10f);
		return employer;
	}

	private Employer getEmployer2(Enterprise enterprise) {
		Employer employer = new Employer();
		employer.setCpf("cpf2");
		employer.setCreationDate(new Date());
		employer.setEmail("email2@gmail.com");
		employer.setEnterprise(enterprise);
		employer.setLunchTimeQuantity(2.2f);
		employer.setName("employer2");
		String password = "password2";
		String encryptedPassword1 = PasswordUtils.generateBCrypt(password);
		employer.setPassword(encryptedPassword1);
		employer.setProfile(ProfileEnum.USER_ROLE);
		employer.setUpdateDate(new Date());
		employer.setValuePerHour(new BigDecimal("20"));
		employer.setWorkTimeQuantity(20.20f);
		return employer;
	}

	private Enterprise getEnterprise2() {
		Enterprise enterprise;
		enterprise = new Enterprise();
		enterprise.setCnpj("004");
		enterprise.setCreationDate(new Date());
		enterprise.setSocialName("Web Store");
		enterprise.setUpdateDate(new Date());
		return enterprise;
	}

	private Enterprise getEnterprise1() {
		Enterprise enterprise = new Enterprise();
		enterprise.setCnpj("003");
		enterprise.setCreationDate(new Date());
		enterprise.setSocialName("IOT Store");
		enterprise.setUpdateDate(new Date());

		return enterprise;
	}

	public void passwordExample() {
		System.out.println("pages quantity: " + paginationQuantity);
		String password = "myPassword";
		String encryptedPassword1 = PasswordUtils.generateBCrypt(password);
		String encryptedPassword2 = PasswordUtils.generateBCrypt(password);

		System.out.println("encryptedPassword1: " + encryptedPassword1);
		System.out.println("encryptedPassword2: " + encryptedPassword2);

		System.out.println("Attempt 1: " + PasswordUtils.passwordValidate("wrongPassword", encryptedPassword1));
		System.out.println("Attempt 2: " + PasswordUtils.passwordValidate(password, encryptedPassword1));
		System.out.println("Attempt 3: " + PasswordUtils.passwordValidate(password, encryptedPassword2));
	}
}
