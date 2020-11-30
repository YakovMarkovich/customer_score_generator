package main.java.m2m.service;

import m2m.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableBinding(Source.class)
public class Generator {
    private final int MAX_NUMBER_CUSTOMERS = 10;
    private final int MAX_SCORE = 100;
    @Autowired
    Source source;
    Random generator = new Random();

    @InboundChannelAdapter(Source.OUTPUT)
    Message<Model.Customer> sendCustomerData() throws InterruptedException {
        Model.Customer customer = getRandomCustomer();
        Thread.sleep(1000);
        Message<Model.Customer> message = new GenericMessage<>(customer);
        source.output().send(message);
        return message;
    }

    private Model.Customer getRandomCustomer() {
        long id = getRandomNumber(1, MAX_NUMBER_CUSTOMERS);
        int score = getRandomNumber(1, MAX_SCORE);
        Model.Customer customer = Model.Customer.newBuilder().setId(id).setScore(score).build();
        return customer;
    }
    private int getRandomNumber(int min, int max) {
        return generator.ints(1, min, max+1).findFirst().getAsInt();
    }
}
