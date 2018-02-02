package com.ddsis.tcpserver.main;

import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.util.TestingUtilities;

/**
 * 
 * @author jozambrano
 * 
 *
 */
public class Main {
	
	private final static Logger logger = Logger.getLogger(Main.class);

	private Main() {}

	/**
	 * Se carga  el contexto de "Spring Integration Application"
	 *
	 * @param args - argumentos de la línea de comandos
	 */
	public static void main(final String[] args) {		
		
		logger.info("\n========================================================="
				+ "\n                                                         "
				+ "\n    Bienvenido al Servidor DDSis                         "
				+ "\n                                                         "
				+ "\n=========================================================");
		final GenericXmlApplicationContext context = Main.setupContext();		
		final AbstractServerConnectionFactory crLfServer = context.getBean(AbstractServerConnectionFactory.class);
		
		
		context.getBean(AbstractServerConnectionFactory.class);
		
		TestingUtilities.waitListening(crLfServer, 10000L);
		logger.info("Esperando conexiones en el puerto:"+crLfServer.getPort()+"\n\n");		
		while (true) {
		
		}

	}
	
	/**
	 * Se carga el archivo de configuración
	 * @return
	 */
	public static GenericXmlApplicationContext setupContext() {
		final GenericXmlApplicationContext context = new GenericXmlApplicationContext();
	
		context.load("classpath:META-INF/spring/integration/tcpServer-context.xml");
		context.registerShutdownHook();
		context.refresh();

		return context;
	}

}
