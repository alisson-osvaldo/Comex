package br.com.comex.main;

import javax.xml.ws.Endpoint;

import br.com.comex.ws.ComexWS;

public class MainComexWS {
	
	public static void main(String[] args) {
		
		ComexWS service = new ComexWS();
		String url = "http://0.0.0.0:8080/ComexWS";
		
		System.out.println("Service rodando " + url + "?wsdl");
		
		Endpoint.publish(url, service);
	}

}
