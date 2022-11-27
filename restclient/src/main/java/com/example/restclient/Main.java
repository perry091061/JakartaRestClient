package com.example.restclient;

import com.example.restclient.authenticator.Authenticator;
import com.example.restclient.entities.Joke;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.core.Response;

public class Main {

	public static void main(String[] args) {

		String url = "https://official-joke-api.appspot.com/jokes";

		Client client = ClientBuilder.newClient().register(new Authenticator("user", "password"));

		WebTarget target = client.target(url).path("/random");

		Builder request = target.request();

		Response response = request.get();

		Joke joke = request.get(Joke.class);

		System.out.println(response.getStatus());
		System.out.println(joke);

	}

}
