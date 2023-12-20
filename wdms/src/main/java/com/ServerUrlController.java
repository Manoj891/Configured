package com;

import com.model.ServerUrl;
import com.model.ServerUrlReq;
import com.repository.ServerUrlRepository;
import com.services.IclockTransactionServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server-url")
public class ServerUrlController {
    @Autowired
    private ServerUrlRepository urlRepository;
    @Autowired
    private IclockTransactionServicesImp servicesImp;

    @GetMapping
    public ServerUrl get() {
        return urlRepository.findById(1L).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @PostMapping
    public String save(@RequestBody ServerUrlReq req) {
        if (!req.getPassword().equals("P@ssw0rdD")) return "{\"message\":\"Unauthorized Access\"}";
        urlRepository.save(ServerUrl.builder().id(1L).url(req.getUrl()).build());
        servicesImp.init();
        return "{\"message\":\"Success\"}";
    }


}
