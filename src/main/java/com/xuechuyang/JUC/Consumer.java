package com.xuechuyang.JUC;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Consumer{

    private java.util.concurrent.BlockingQueue<Message> messageQueue;

    private ExecutorService executorService;

    private CountDownLatch countDownLatch;

    private static final int threadNums = 5;

    public Consumer(int messageCount) {
        messageQueue = new LinkedBlockingQueue<>();
        executorService = Executors.newFixedThreadPool(threadNums);
        countDownLatch = new CountDownLatch(messageCount);
    }

    public void put(Message message){
        try{
            messageQueue.put(message);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String processMessages(){
        StringBuilder result = new StringBuilder();
        while(!messageQueue.isEmpty()){
            Message message = null;
            try{
                message = messageQueue.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(Objects.nonNull(message)){
                final Message unProcessedMessage = message;
                executorService.execute(() -> {
                    String processedMessage = process(unProcessedMessage);
                    result.append(processedMessage);
                    countDownLatch.countDown();
                });
            }
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void shutDown(){
        executorService.shutdown();
    }

    public String process(Message message){
        return "Process: " + message.getContent() + "\n";
    }

    public static void main(String[] args) {
        int messageCount = 10;
        Consumer messageProcessor = new Consumer(messageCount);

        // 模拟向消息队列中提交消息
        for (int i = 1; i <= messageCount; i++) {
            Message message = new Message("Message " + i);
            messageProcessor.put(message);
        }

        // 处理消息并获取结果
        String result = messageProcessor.processMessages();
        System.out.println(result);

        // 关闭消息处理器
        messageProcessor.shutDown();
    }
}


class Message{
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
