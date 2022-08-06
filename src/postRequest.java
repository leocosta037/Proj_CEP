//Adaptado de "https://simplificandoredes.com/http-requisicoes-get-post-api-java/"

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class postRequest {

    private static postRequest instancia_request = new postRequest();
    
	private postRequest() {
		super();
	}

    public String requisicao(String cep){
    	
    	String URL_POST = "https://viacep.com.br/ws/" + cep + "/json/";
    	
    	
        // cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        System.out.println(request.bodyPublisher());
        return "OK";
    }
    
	public static postRequest getRequest() {
		return instancia_request;
	}
}