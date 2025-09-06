package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.dto.TokenizeRequest;
import com.farmatodo.farmatodo.model.entity.PaymentMethod;
import com.farmatodo.farmatodo.repository.PaymentMethodRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TokenizationService {

    private String Jwtsecret;
    private Long Jwtexpiration;

    @Autowired
    private  PaymentMethodRepository paymentMethodRepository;


    public void createToken(TokenizeRequest tokenizeRequest){

        Map<String, Object> payload = new HashMap<>();
        payload.put("cardNumber", tokenizeRequest.getCardNumber());
        payload.put("cvc", tokenizeRequest.getCvc());
        payload.put("expirationMonth", tokenizeRequest.getExpirationMonth());
        payload.put("expirationYear", tokenizeRequest.getExpirationYear());
        payload.put("ownerCardName", tokenizeRequest.getOwnerCardName());

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + Jwtexpiration);

        Key secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(Jwtsecret));

        String token = Jwts.builder()
                .setClaims(payload)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(secretKey , SignatureAlgorithm.HS256)
                .compact();

        // falta configurar el parametro para esta vuelta

        if(new Random().nextInt(100) < 10){
            PaymentMethod paymentMethod = new PaymentMethod(token);
            paymentMethodRepository.save(paymentMethod);
        }
        else{
            throw new IllegalArgumentException("El proceso ha fallado");
        }
    }
}
