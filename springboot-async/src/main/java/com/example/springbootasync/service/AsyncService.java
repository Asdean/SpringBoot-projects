package com.example.springbootasync.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public interface AsyncService {

    // public Future<String> sendSMS ();

    public Object sendSMS();

   // public void sendSMS(List<String> list, CountDownLatch countDownLatch);
}
