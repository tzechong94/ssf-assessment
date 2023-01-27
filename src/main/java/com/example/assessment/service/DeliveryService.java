package com.example.assessment.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.assessment.model.JsonModel;

@Qualifier("deliveryService")
@Service
public class DeliveryService {
    

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void saveOrder(final JsonModel json) {
        redisTemplate.opsForList()
        .leftPush("orderId", json.getOrderId());
        redisTemplate.opsForHash()
        .put("ordersDetails", json.getOrderId(), json);
    }

    public JsonModel findById(final String orderId) throws IOException {
        JsonModel modelString = (JsonModel)redisTemplate.opsForHash()
            .get("ordersDetails", orderId);
        return modelString;
    }


}
