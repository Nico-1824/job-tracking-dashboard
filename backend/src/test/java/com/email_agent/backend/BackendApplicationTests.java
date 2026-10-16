package com.email_agent.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.email_agent.backend.Applications.*;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BackendApplicationTests {

	@Mock
	private CompanyApplicationRepository repo;

	@InjectMocks
	CompanyApplicationService service;

	@Test
	void gettingApplications() {

		CompanyApplicationEntity application = new CompanyApplicationEntity("Acme", "pending");

		when(repo.findAll())
			.thenReturn(List.of(application));

		List<CompanyApplicationDTO> result = service.findAll();
		assertEquals(1, result.size());
		assertEquals("Acme", result.get(0).companyName());

	}

}
