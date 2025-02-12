package org.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.Resource;
import org.example.demo.dto.QandA;
import org.example.demo.schema.ResponseMessage;
import org.example.demo.service.IDemoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class Demo {
    Logger logger = LoggerFactory.getLogger(Demo.class);


    @Resource(name="DemoService")
    IDemoService service;

    @GetMapping("/get_list/{searchText}")
    public ResponseMessage<Map<String, QandA>> getList(@PathVariable String searchText) {
        Map<String, QandA> get_res = service.getList(searchText);
        return ResponseMessage.success(get_res);
    }

    @GetMapping("/cre_index/{idxName}")
    public ResponseMessage<String> createIndex(@PathVariable String idxName) {
        service.createIndex(idxName);
        ResponseMessage<String> res = ResponseMessage.success("ok");
        return res;
    }

    @PostMapping("/add")
    public ResponseMessage<String> add(@RequestBody QandA qa) {
        logger.info("request body add: " + qa.toString());
        String id = service.addDocument(qa);
        ResponseMessage<String> res = ResponseMessage.success(id);
        return res;
    }

    @PostMapping("/modify")
    public ResponseMessage<String> modify(@RequestBody Map<String, String> json) {
        logger.info("request body modify: " + json.toString());
        QandA qa = new QandA();
        String id = json.getOrDefault("Id", "");
        qa.setCategory(json.getOrDefault("Category", ""));
        qa.setSubCategory(json.getOrDefault("SubCategory", ""));
        qa.setDifficulty(json.getOrDefault("Difficulty", ""));
        qa.setTitle(json.getOrDefault("Title", ""));
        qa.setProblemDescription(json.getOrDefault("ProblemDescription", ""));
        qa.setSampleInput(json.getOrDefault("SampleInput", ""));
        qa.setSampleOutput(json.getOrDefault("SampleOutput", ""));
        qa.setHints(json.getOrDefault("Hints", ""));
        qa.setOptimalSpaceAndTimeComplexity(json.getOrDefault("OptimalSpaceAndTimeComplexity", ""));
        qa.setSolution(json.getOrDefault("Solution", ""));

        String res_id = service.updateDocument(id, qa);
        return ResponseMessage.success(res_id);
    }
}
