package com;

import com.model.ServerUrl;
import com.repository.ServerUrlRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server-url")
public class ServerUrlController {
    @Autowired
    private ServerUrlRepository urlRepository;

    @GetMapping
    public ServerUrl get() {
        return urlRepository.findById(1L).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @PostMapping
    public String save(@RequestBody Req req) {
        if (!req.getPassword().equals("P@ssw0rdD")) return "{\"message\":\"Unauthorized Access\"}";
        urlRepository.save(ServerUrl.builder().id(1L).url(req.getUrl()).build());
        return "{\"message\":\"Success\"}";
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Req {
        private String url;
        private String password;
    }
}
