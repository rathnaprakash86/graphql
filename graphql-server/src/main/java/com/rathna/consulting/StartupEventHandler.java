package com.rathna.consulting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class StartupEventHandler {

	@Autowired
	Environment env;


	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Active Profiles are {}", String.join(",", env.getActiveProfiles()));
	}


}
