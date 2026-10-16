CREATE TABLE company_applications (
    id                 UUID PRIMARY KEY,
    company_name       VARCHAR(255) NOT NULL,
    application_status VARCHAR(100) NOT NULL,
    role               VARCHAR(255) NOT NULL,    
    interviewer        VARCHAR(255),
    interview_date     DATE
);