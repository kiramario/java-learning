package org.example.demo.service;

import org.example.demo.dto.QandA;

import java.util.List;
import java.util.Map;

public interface IDemoService {

    String addDocument(QandA qa);

    Map<String, QandA> getList(String searchText);

    String updateDocument(String id, QandA qa);

    int createIndex(String index);
}
