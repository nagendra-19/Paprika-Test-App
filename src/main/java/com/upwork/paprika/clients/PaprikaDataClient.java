package com.upwork.paprika.clients;

import com.upwork.paprika.config.OAuthFeignConfig;
import com.upwork.paprika.model.ClientResponse;
import com.upwork.paprika.model.JobResponse;
import com.upwork.paprika.model.JobRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "i2-testing.paprika-software-api", url = "https://i2-testing.paprika-software.com/exam/api/v1/", configuration = OAuthFeignConfig.class)
public interface PaprikaDataClient {

    @RequestMapping(method = RequestMethod.GET, value = "/clients/list")
    ClientResponse getAllClients();
    @RequestMapping(method = RequestMethod.GET, value = "/jobs/getjob")
    ClientResponse getJobById(@RequestParam(value = "JO_MN") String jobCode);

    @RequestMapping(method = RequestMethod.GET, value = "/test/getSystemCodes")
    ClientResponse getSystemCodes();

    @RequestMapping(method = RequestMethod.POST, value = "/jobs/createJob")
    ClientResponse saveJob(@RequestBody JobRequest job);

    @RequestMapping(method = RequestMethod.POST, value = "jobs/updateJob")
    ClientResponse updateJob(@RequestBody JobRequest job);

}