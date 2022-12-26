package org.example.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Entity.ChatMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubService implements MessageListener {

    public static List<String >messageList = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            ChatMessage chatMessage = mapper.readValue(message.getBody(), ChatMessage.class);
            messageList.add(message.toString());

            System.out.println("받은메세지 = " + message);
            System.out.println("chatMessage.getSender() = " + chatMessage.getSender());
            System.out.println("chatMessage.getContext() = " + chatMessage.getContext());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
