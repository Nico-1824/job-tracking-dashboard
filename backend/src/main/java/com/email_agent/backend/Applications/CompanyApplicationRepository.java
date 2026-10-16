package com.email_agent.backend.Applications;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyApplicationRepository
        extends JpaRepository<CompanyApplicationEntity, Long> {

}
