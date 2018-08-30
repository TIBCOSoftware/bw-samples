# Sample Java Application

This is a sample Java application which runs a simple JAX-RS based REST Service to provide random credit scores.

## Running the Application

You can run the application using maven.

```bash
mvn clean package exec:java
```

You can also run the application using the sample Dockerfile

``` docker
docker build -t <app-name> .

docker run -P <app-name>
```

The app exposes the service on port **7080** at the endpoint **/creditscore**. The port can be changes in the pom.xml of the application.

If you run this with maven the resulting URL will be 

http://localhost:7080/creditscore

## Running the application in Kubernetes
You can run the application in Kubernetes using the **service-kubernetes.yml** file

---

## Integrating with OpenTracing

This application integrates with OpenTracing and uses the Jaeger Client library. It reads all the Jaeger configuration from the environment variables. Please refer to the Jaeger documentation here for the right environment variables to use -
https://github.com/jaegertracing/jaeger-client-java/tree/master/jaeger-core
