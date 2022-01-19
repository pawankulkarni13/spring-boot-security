package com.stark.springbootsecurity;

import com.stark.springbootsecurity.controller.WelcomeResource;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
//@WebMvcTest(WelcomeResource.class)
public class SpringBootSecurityApplicationTests {

//	@Autowired
//	private TestRestTemplate template;

	@Test
	public void loadWelcomePage() throws Exception {
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials
				= new UsernamePasswordCredentials("user", "pass");
		provider.setCredentials(AuthScope.ANY, credentials);

		HttpClient httpClient = HttpClientBuilder.create()
				.setDefaultCredentialsProvider(provider)
				.build();

		HttpGet request = new HttpGet("http://localhost:8080/");
		try {

			String response = new String(httpClient.execute(request).getEntity().getContent().readAllBytes());
			System.out.println(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//todo add more tests
//	@Test
//	@WithMockUser(value = "spring")
//	public void accessUserPage() throws Exception {
//		CredentialsProvider provider = new BasicCredentialsProvider();
//		UsernamePasswordCredentials credentials
//				= new UsernamePasswordCredentials("pawan", "pawan");
//		provider.setCredentials(AuthScope.ANY, credentials);
//
//		HttpClient httpClient = HttpClientBuilder.create()
//				.setDefaultCredentialsProvider(provider)
//				.build();
//
//		HttpGet request = new HttpGet("http://localhost:8080/user");
//		try {
//
//			String response = new String(httpClient.execute(request).getEntity().getContent().readAllBytes());
//			System.out.println(response);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
