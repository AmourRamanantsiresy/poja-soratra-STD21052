package hei.school.soratra.endpoint.rest.controller;


import hei.school.soratra.endpoint.rest.models.FileUrls;
import hei.school.soratra.service.SoratraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/soratra")
public class SoratraController {
    private final SoratraService soratraService;


    @PutMapping("/{id}")
    public void saveOne(@PathVariable("id") String id, @RequestBody String text) throws IOException {
        soratraService.save(id, text);
    }

    @GetMapping("/{id}")
    public FileUrls getOne(@PathVariable("id") String id) {
        return soratraService.getOne(id);
    }

}
