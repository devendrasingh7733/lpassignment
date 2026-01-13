package com.api.lp.utility;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiClient {

	private static Logger logger = LogManager.getLogger(ApiClient.class);

	public static final String API_CALL_ACCOUNT_URL = "https://demo9993930.mockable.io/loanaccount/";
	public static final String API_CALL_TYPE_GET = "GET";

	
	
	public static String apiCall(String reqType, String url, String reqString) {

		String apiResponse = null;

		try {
			if (reqType.equalsIgnoreCase(API_CALL_TYPE_GET)) {

				// Using this only beacause of ssl issue 
				 SSLContext sslContext = SSLContext.getInstance("TLS");
		            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
		                @Override
		                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
		                @Override
		                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
		                @Override
		                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		                    return new java.security.cert.X509Certificate[0];
		                }
		            }}, new java.security.SecureRandom());

		            HttpClient httpClient = HttpClient.newBuilder()
		                    .sslContext(sslContext)
		                    .build();
		            
//				HttpClient httpClient = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
				HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
				apiResponse = response.body();

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return apiResponse;
	}
}
