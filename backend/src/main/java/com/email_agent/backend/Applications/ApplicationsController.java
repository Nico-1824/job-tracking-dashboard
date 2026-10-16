package com.email_agent.backend.Applications;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class ApplicationsController {

    private final CompanyApplicationService companyApplicationService;

    public ApplicationsController(CompanyApplicationService companyApplicationService) {
        this.companyApplicationService = companyApplicationService;
    }
    @GetMapping("/api/v1/get_applications")
    public List<CompanyApplicationDTO> getApplications() {
        return companyApplicationService.findAll();
    }

    @DeleteMapping("/api/v1/remove_application")
    public ResponseEntity<Void> removeApplication(@RequestParam Long id) {
        try {
            companyApplicationService.removeApplication(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error removing application with id: " + id);
            return ResponseEntity.notFound().build();
        }
    }
    

}
