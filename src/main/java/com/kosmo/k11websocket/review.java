package com.kosmo.k11websocket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
@ServerEndpoint
	: 웹소켓 서버의 요청명을 지정한다.
	주소는 ws://localhost:8081/k11websocket/Echoserver.do
	이와 같이 설정한다. http대신 웹소켓이라는 의미로 ws를 사용한다.
 */
// @Controller
// @ServerEndpoint("/EchoServer.do)
public class review {

	/*
	- 해당 List컬렉션은 클라이언트가 접속할때마다 세션 ID를 저장하는	
		용도로 사용한다.
	- 접속한 웹브라우저가 웹소켓을 지원해야 하며, 웹브라우저를 닫으면
		OnClose가 호출된다.
	 */
	private static final List<Session> sessionList = 
			new ArrayList<Session>();
	
	private static final Logger logger=
			LoggerFactory.getLogger(review.class);
	
	
	public review() {
		System.out.println("웹소켓(서버) 객체 생성");
	}
	
	// 클라이언트가 접속했을때 호출됨
	@OnOpen
	public void onOpen(Session session) {
		
		logger.info("Open session id : "+session.getId());
		
		try {
			final Basic basic = session.getBasicRemote();
			logger.info("새로운 session getBasicRemote="+basic);
			basic.sendText("대화방에 연결되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sessionList.add(session);
		
		
	}
	
	
	private void sendAllSessionToMessage(Session self, String messge) {
		
		try {
		
			for(Session session : review.sessionList) {
				if(!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(messge);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
		
		
		
	}
	
	
	@OnMessage
	public void onMessage(String message, Session session) {
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
