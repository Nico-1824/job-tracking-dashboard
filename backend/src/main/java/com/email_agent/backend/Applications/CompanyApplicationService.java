package com.email_agent.backend.Applications;
import java.util.List;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CompanyApplicationService {
    private final CompanyApplicationRepository repo;

    public CompanyApplicationService(CompanyApplicationRepository repo) {  // constructor injection
        this.repo = repo;
    }

    public List<CompanyApplicationDTO> findAll() {

        try {
            List<CompanyApplicationDTO> db_results = repo.findAll().stream()
                .map(a -> new CompanyApplicationDTO(a.getId(), a.getCompanyName(),
                    a.getApplicationStatus(), a.getRole(), a.getInterviewer(), a.getInterviewDate()))
                .toList();

            if (db_results.isEmpty()) {
                CompanyApplicationDTO errorDTO = new CompanyApplicationDTO(null, "Error", null, null, null, null);
                return List.of(errorDTO);
            }

            return db_results;
        } catch (Exception e) {
            CompanyApplicationDTO errorDTO = new CompanyApplicationDTO(null, "Error", null, null, null, null);
            System.out.println("Error retriving data from DB");
            return List.of(errorDTO);
        }
    }


    @Transactional 
    public Boolean removeApplication(Long id) {

        try {

            CompanyApplicationEntity app = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Error removing the application with id " + id));
            repo.delete(app);
            return true;

        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
