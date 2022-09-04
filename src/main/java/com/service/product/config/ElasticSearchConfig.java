//package com.service.product.config;
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.ElasticsearchTransport;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//@Configuration
//@PropertySource(value = "classpath:application-dev.yml")
//@EnableElasticsearchRepositories(basePackages = "com.service.product.repository")
//public class ElasticSearchConfig {
//
//    @Value("elasticsearch.host")
//    private String host;
//    @Value("elasticsearch.port")
//    private String port;
//    @Value("elasticsearch.cluster")
//    private String cluster;
//    @Value("elasticsearch.usearname")
//    private String username;
//    @Value("elasticsearch.password")
//    private String password;
//
//    @Bean
//    public ElasticsearchClient client(){
//        ClientConfiguration configuration = ClientConfiguration.builder()
//                .connectedTo(host+port)
//                .withBasicAuth(username,password)
//                .build();
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(username,password));
//        RestClient httpClient = RestClient
//                .builder(new HttpHost(host,9200))
//                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//                    @Override
//                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
//                        return httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//                    }
//                }).build();
//
//
//        ElasticsearchTransport transport = new RestClientTransport(httpClient,new JacksonJsonpMapper());
//
//        ElasticsearchClient elasticsearchClient = new ElasticsearchClient(transport);
//
//        return elasticsearchClient;
//    }
//}
