package com.yurialves.keycloakapiconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@EnableWebFluxSecurity
public class WebClientOauthConfig {

    @Bean
    WebClient webClient(ReactiveClientRegistrationRepository clientRegistration,
                        ReactiveOAuth2AuthorizedClientService clientService) {

        ServerOAuth2AuthorizedClientExchangeFilterFunction oauthFilter =
                new ServerOAuth2AuthorizedClientExchangeFilterFunction(
                        new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
                                clientRegistration, clientService));

        oauthFilter.setDefaultClientRegistrationId("clientes");

        return WebClient.builder()
                .filter(oauthFilter)
                .build();
    }
}
