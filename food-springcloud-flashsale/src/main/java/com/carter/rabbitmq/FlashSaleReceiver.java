package com.carter.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.carter.service.FlashSaleService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                key = "flashSale.queue"
        )
)
public class FlashSaleReceiver {

    @Autowired
    private FlashSaleService flashSaleServiceImpl;

    @RabbitHandler
    public void process(String data){
        flashSaleServiceImpl.rushFlashSale(data);
    }
}
