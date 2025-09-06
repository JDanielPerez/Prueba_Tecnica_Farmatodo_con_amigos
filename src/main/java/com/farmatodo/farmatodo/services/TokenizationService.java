package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.dtos.TokenizeRequestDto;
import com.farmatodo.farmatodo.models.entities.PaymentMethod;
import com.farmatodo.farmatodo.repositories.PaymentMethodRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TokenizationService {

    private String Jwtsecret;
    private Long Jwtexpiration;

    @Autowired
    private  PaymentMethodRepository paymentMethodRepository;


    public void createToken(TokenizeRequestDto tokenizeRequest){

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
