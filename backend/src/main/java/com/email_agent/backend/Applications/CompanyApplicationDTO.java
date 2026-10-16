package com.email_agent.backend.Applications;

import java.time.LocalDate;

public record CompanyApplicationDTO(
    Long id,
    String companyName, 
    String status,
    String role,
    String interviewer, 
    LocalDate interviewDate) {}
