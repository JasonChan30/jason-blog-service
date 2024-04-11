package com.jasonblog.api;

import org.springframework.boot.web.server.Cookie;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class LoginController {

    @GetMapping("/hello")
    public void redirect(@RequestParam String code){

        RestClient defaultClient = RestClient.create();

        String url = "https://github.com/login/oauth/access_token?" +
                "client_id=dad55f84b25a8e199b25&" +
                "client_secret=731b1d994cecd30caa840050ec4342f68ced106a&" +
                "code="+ code;
//                "redirect_uri=http://localhost:3000" + "&" +

        String result = defaultClient.post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
        System.out.println(result);

    }
}
