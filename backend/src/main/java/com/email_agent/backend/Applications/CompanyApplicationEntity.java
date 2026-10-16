package com.email_agent.backend.Applications;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity 
@Table(name = "company_applications")
public class CompanyApplicationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String applicationStatus;

    private String interviewer;
    private LocalDate interviewDate;

    protected CompanyApplicationEntity() {}

    public CompanyApplicationEntity(String companyName, String status) {
        this.companyName = companyName;
        this.applicationStatus = status;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public String getRole() {
        return role;
    }

}
