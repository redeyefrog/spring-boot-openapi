# Open API

#### *Plugin*
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>${openapi.version}</version>
</dependency>
```
This will automatically deploy swagger-ui to a spring-boot application:
* Documentation will be available in HTML format, using the official [swagger-ui jars](https://github.com/swagger-api/swagger-ui.git)
* The Swagger UI page will then be available at `http://server:port/context-path/swagger-ui.html` and the OpenAPI description will be available at the following url for json format: `http://server:port/context-path/v3/api-docs`
  * server: The server name or IP
  * port: The server port
  * context-path: The context path of the application
* Documentation can be available in yaml format as well, on the following path : /v3/api-docs.yaml

#### *No Configuration*
* add Properties and add ``@OpenAPIDefinition`` to Controller
```yaml
springdoc:
  group-configs:
    -
      group: GROUP1
      packages-to-scan: com.package1
      paths-to-match: /**
    -
      group: GROUP2
      packages-to-scan: com.package2
      paths-to-match: /v1/**
```

#### *Configuration*
```java
@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi groupedOpenApi() {
    return GroupedOpenApi.builder()
            .group("GroupName")
            .packagesToScan("com.package1")
            .pathsToMatch("/**")
            .build();
  }

  @Bean
  public OpenAPI openApi() {
    Info info = new Info().title("Open API Title")
            .description("Description API")
            .version("v1.0");

    return new OpenAPI()
            .info(info);
  }
}
```

## Reference
* [Swagger](https://swagger.io "The Best APIs are Built with Swagger Tools | Swagger")
* [springdoc-openapi](https://springdoc.org/ "OpenAPI 3 Library for spring-boot")
