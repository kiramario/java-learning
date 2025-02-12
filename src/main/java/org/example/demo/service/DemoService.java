package org.example.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import jakarta.annotation.Resource;
import org.example.demo.dto.QandA;
import org.example.demo.repository.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service("DemoService")
public class DemoService implements IDemoService {
    Logger logger = LoggerFactory.getLogger(DemoService.class);

    // FIXME: the hard code `index` q and a
    private String ES_INDEX = "qaa";

    @Resource
    private ElasticsearchClient esClient;

    @Autowired
    DemoRepository repo;

    // FIXME: index already exist
    @Override
    public int createIndex(String idxName) {

        // Use the client...
        try {
            esClient.indices().create(c -> c
                    .index(idxName)
            );
        } catch (Exception e) {
            throw new RuntimeException("create Index error: " + e.getMessage());
        }

        // Close the client, also closing the underlying transport object and network connections.
        // TODO: do this in bean destory method
//        try {
//            esClient.close();
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            e.printStackTrace();
//            throw new RuntimeException(e.getCause().getMessage());
//        }
        return 0;
    }

    @Override
    public String addDocument(QandA qa) {
        IndexResponse response = null;
        try {
            response = esClient.index(i -> i
                    .index(ES_INDEX)
                    .id(String.valueOf(qa.hashCode()))
                    .document(qa)
            );
        } catch (IOException e) {
            logger.error("[do not care]: " + e.getMessage());
        } catch (Exception e) {
            // TODO: extract code snipper
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }

        System.out.println("Indexed with version " + response.version());
        return response.id();
    }

    @Override
    // TODO: make filed more extensive
    public Map<String, QandA> getList(String searchText) {
        logger.info("searchText: " + searchText);
        // Use the client...
        SearchResponse<QandA> response = null;
        try {
            response = esClient.search(searchRequestBuilder -> {
                searchRequestBuilder.index(ES_INDEX);
                if (!searchText.equals("all")) {
                    searchRequestBuilder.query(q ->
                            q.match(mq ->
                                    mq.field("Category").query(searchText)
                            )
                    );
                }
                return searchRequestBuilder;
            },
                    QandA.class
            );
        } catch (IOException e) {
            logger.error("[do not care]: " + e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }

        Map<String, QandA> res = new HashMap<>();
        if (response != null) {
            HitsMetadata<QandA> hit_res = response.hits();

            hit_res.hits().forEach((hit) -> {
                res.put(hit.id(), hit.source());
            });
        }

        logger.info("hits_value: " + res.toString());

        // Close the client, also closing the underlying transport object and network connections.
        // TODO: do this in bean destory method
//        try {
//            esClient.close();
//        } catch (Exception e) {
//            System.out.println(e.getCause());
//            throw new RuntimeException(e.getMessage());
//        }

        return res;
    }

    @Override
    public String updateDocument(String id, QandA qa) {
        try {
            UpdateResponse<QandA> response = esClient.update(u -> u
                            .index(ES_INDEX)
                            .id(id)
                            .doc(qa)  // 用于更新已存在文档的字段
                            .upsert(qa), // 如果文档不存在，则插入
                    QandA.class);
        } catch (IOException e) {
            logger.error("[do not care]: " + e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
        return id;
    }
}
