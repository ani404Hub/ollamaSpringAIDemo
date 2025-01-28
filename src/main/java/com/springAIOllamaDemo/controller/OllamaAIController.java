package com.springAIOllamaDemo.controller;

import com.springAIOllamaDemo.service.OllamaAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin                                                                          //CORS allow others to fetch response from other ports
public class OllamaAIController {
    @Autowired
    private OllamaAIService aiService;

    @GetMapping("/api/generate")
    public String generate(@RequestParam(value = ("promptTxt")) String promptTxt){     //Default value is api/generate?promptTxt=
        return aiService.generatedResponse(promptTxt);
    }
}
