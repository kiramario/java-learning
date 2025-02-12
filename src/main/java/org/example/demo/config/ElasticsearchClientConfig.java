package org.example.demo.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import jakarta.annotation.Resource;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author CoderJia
 * @create 2024/11/3 下午 02:31
 * @Description
 **/
public class ElasticsearchClientConfig {

    @Resource
    private ElasticsearchProperties elasticsearchProperties;

    @Value("${spring.elasticsearch.apiKey}")
    private int apiKey;


//    TODO: need close connection through bean destory method
//    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Bean
    public ElasticsearchClient elasticsearchClient() {

//        RestClient restClient = RestClient
//                .builder(HttpHost.create(serverUrl))
//                .setDefaultHeaders(new Header[]{
//                        new BasicHeader("Authorization", "ApiKey " + apiKey)
//                })
//                .build();
//
//        // Create the transport with a Jackson mapper
//        ElasticsearchTransport transport = new RestClientTransport(
//                restClient, new JacksonJsonpMapper());
//
//        // And create the API client
//        ElasticsearchClient esClient = new ElasticsearchClient(transport);
//


        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(elasticsearchProperties.getUsername(), elasticsearchProperties.getPassword()));

        RestClient restClient = RestClient.builder(HttpHost.create(elasticsearchProperties.getUris().get(0)))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();

        RestClientTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }
}