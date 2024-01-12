package com.project.soc.service.incident;

import com.project.soc.model.Incident;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidentService {

    public Incident saveIncident(Incident incident);

    public void deleteIncident(long incidentId);

    public Incident updateIncident(Incident newIncident, long incidentId);

    public Incident getOneIncident(long incidentId);

    public List<Incident> getAllIncidents();
}
