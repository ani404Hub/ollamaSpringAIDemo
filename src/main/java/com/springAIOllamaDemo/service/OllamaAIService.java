package com.springAIOllamaDemo.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OllamaAIService {
    @Autowired
    private OllamaChatModel chatModel;
    public String generatedResponse(String promptMsg){
        if(!promptMsg.isBlank()){
            ChatResponse response = chatModel.call(new Prompt(promptMsg, OllamaOptions.create().withModel("deepseek-r1:14b")));      //Ollama llama2 7B ChatModel call
            return response.getResult().getOutput().getContent();                                                           //can also call other Ollama model like LLava
        }
        else
            return "Have a great Day! Please enter text prompt to get responses";
    }
}
