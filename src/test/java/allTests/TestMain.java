package allTests;
import java.util.concurrent.TimeUnit;
import enums.APPLICATION_PROTOCOL;
import enums.IP_PROTOCOL;
import enums.Q_COUNT;
import enums.RESPONSE_MDNS_TYPE;
import enums.TRANSPORT_PROTOCOL;
import models.DomainConvert;
import models.Header;
import models.MessageParser;
import models.MessageSender;
import models.Request;
import models.TCPConnection;

public class TestMain {

	public static void main(String[] args) {
		Q_COUNT[] a = {Q_COUNT.SRV};
		MessageSender sender;
		MessageParser parser;
		TRANSPORT_PROTOCOL protocol = TRANSPORT_PROTOCOL.TCP;
		try {
		
		sender = new MessageSender(false,"macMartin.local",a,IP_PROTOCOL.IPv4,RESPONSE_MDNS_TYPE.RESPONSE_UNICAST);
		sender.send();
		parser = new MessageParser(sender.getRecieveReply(), sender.getHeader(), null);
		parser.parseMDNS();
		System.out.println(parser.getAsJsonString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}