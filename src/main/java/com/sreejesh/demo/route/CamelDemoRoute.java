package com.sreejesh.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@ConfigurationProperties(prefix="camel-demo-route")
@Data
@EqualsAndHashCode(callSuper=true)
//@EnableEncryptableProperties

public class CamelDemoRoute extends RouteBuilder {

	// The value of this property is injected from application.properties based on the profile chosen.
	private String injectedName;
	private String injectedSecret;
	
	@Override
	public void configure() throws Exception {

		// @formatter:off
		
		errorHandler(deadLetterChannel("seda:errorQueue").maximumRedeliveries(5).redeliveryDelay(1000));

	
		from("timer://myTimer?repeatCount=1")
		.routeId("jasypt-timer-route")
		.log("\n\n***** injectedName: "+injectedName+" *****\n\n")
		.log("\n\n***** Decrypted injectedSecret: "+injectedSecret+" *****\n\n")
		;
		
		//Error Handling route!
		
		from("seda:errorQueue")
		.routeId("ErrorHandlingRoute")
		.log("***** error body: ${body} *****")
		.log("***** Exception Caught: ${exception} *****");
		
		
		// @formatter:on

	}

}
