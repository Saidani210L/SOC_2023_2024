package com.project.soc.controller;

import com.project.soc.model.Incident;
import com.project.soc.service.incident.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incident")
@CrossOrigin
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @GetMapping("get_all")
    public List<Incident> getAllIncidents(){
        return incidentService.getAllIncidents();
    }

    @GetMapping("{incidentId}")
    public Incident getAllIncidents(@PathVariable(name = "incidentId") long incidentId){
        return incidentService.getOneIncident(incidentId);
    }

    @PostMapping("new")
    public Incident saveIncident(@RequestBody Incident incident){
        return incidentService.saveIncident(incident);
    }

    @PutMapping("update/{incidentId}")
    public Incident updateIncident(@RequestBody Incident newIncident,
                                   @PathVariable(name = "incidentId") long incidentId){
        return incidentService.updateIncident(newIncident, incidentId);
    }

    @DeleteMapping("delete/{incidentId}")
    public void deleteIncident(@PathVariable(name = "incidentId") long incidentId){
        incidentService.deleteIncident(incidentId);
    }
}
