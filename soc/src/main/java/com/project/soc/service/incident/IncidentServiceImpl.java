package com.project.soc.service.incident;

import com.project.soc.model.Incident;
import com.project.soc.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService{

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public Incident saveIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public void deleteIncident(long incidentId) {
        incidentRepository.deleteById(incidentId);
    }

    @Override
    public Incident updateIncident(Incident newIncident, long incidentId) {
        Optional<Incident> incident = incidentRepository.findById(incidentId);
        if(incident.isEmpty()){
            return null;
        }
        Incident currentIncident = incident.get();
        currentIncident.setTitle(newIncident.getTitle());
        currentIncident.setDescription(newIncident.getDescription());
        currentIncident.setIncidentDateTime(newIncident.getIncidentDateTime());
        return incidentRepository.save(currentIncident);
    }

    @Override
    public Incident getOneIncident(long incidentId) {
        Optional<Incident> incident = incidentRepository.findById(incidentId);
        return incident.orElse(null);
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }
}
