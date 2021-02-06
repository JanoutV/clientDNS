package allTests;

import enums.APPLICATION_PROTOCOL;
import enums.Q_COUNT;
import enums.TRANSPORT_PROTOCOL;
import models.MessageParser;
import models.MessageSender;

public class TestMain {

	public static void main(String[] args) {
		Q_COUNT[] a = {Q_COUNT.PTR};
		MessageSender sender;
		MessageParser parser;
		try {
			sender = new MessageSender(true, true,true, "2607:f8b0:4006:804:0:0:0:200e",a ,TRANSPORT_PROTOCOL.UDP,APPLICATION_PROTOCOL.DNS,"8.8.8.8");
			sender.send();
			parser = new MessageParser(sender.getRecieveReply(),sender.getHeader());
			parser.parse();
			
			System.out.println(sender.getAsJsonString());
			System.out.println(parser.getAsJsonString());
			//System.out.println(sender.getTimeElapsed());
			//System.out.println(parser.getAsJson().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}