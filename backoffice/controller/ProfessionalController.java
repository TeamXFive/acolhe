package backoffice.controller;

import backoffice.model.Professional;
import backoffice.service.ProfessionalService;

import java.util.List;

public class ProfessionalController {
    
    private final ProfessionalService oProfessionalService = new ProfessionalService();
    
    public void gerenciarProfissionais (List<Professional> professionals) {
        oProfessionalService.gerenciarProfissionais(professionals);
    }
}
