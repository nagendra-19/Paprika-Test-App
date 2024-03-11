package com.upwork.paprika.controller;

import com.upwork.paprika.clients.PaprikaDataClient;
import com.upwork.paprika.model.ClientResponse;
import com.upwork.paprika.model.JobResponse;
import com.upwork.paprika.model.JobRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaprikaController {


    private final PaprikaDataClient paprikaDataClient;

    public PaprikaController(PaprikaDataClient paprikaDataClient) {
        this.paprikaDataClient = paprikaDataClient;
    }

    @GetMapping("/clients")
    public ClientResponse getClients() {
        return paprikaDataClient.getAllClients();
    }

    @GetMapping("/getJob")
    public ClientResponse getClients(@RequestParam("JO_MN") String jobCode) {
        return paprikaDataClient.getJobById(jobCode);
    }

    @GetMapping("/getSystemCodes")
    public ClientResponse getSystemCodes() {
        return paprikaDataClient.getSystemCodes();
    }

    @PostMapping("/saveJob")
    public ClientResponse saveJob(@RequestBody JobRequest job) {
        return paprikaDataClient.saveJob(job);
    }

    @PostMapping("/updateJob")
    public ClientResponse updateJob(@RequestBody JobResponse job) {
        return paprikaDataClient.updateJob(job);
    }
}