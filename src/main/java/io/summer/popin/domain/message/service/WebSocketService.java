package io.summer.popin.domain.message.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@ServerEndpoint(value="/message")
@Slf4j
public class WebSocketService {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
    @OnMessage
    public void onMessage(String msg, Session session) throws Exception{
        log.info("receive message : " + msg);
        for(Session s : clients) {
            log.info("send data : " + msg);
            s.getBasicRemote().sendText(msg);
        }
    }

    @OnOpen
    public void onOpen(Session s) {
        if(!clients.contains(s)) {
            clients.add(s);
            log.info("session open : " + s);
        }else {
            log.info("이미 연결된 session");
        }
    }

    @OnClose
    public void onClose(Session s) {
        log.info("session close : " + s);
        clients.remove(s);
    }

    @Component
    public class WebSocketConfig {

        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            return new ServerEndpointExporter();
        }
    }

}
