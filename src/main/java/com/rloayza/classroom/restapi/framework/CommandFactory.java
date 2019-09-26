package com.rloayza.classroom.restapi.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public Command getCommand(Class<? extends Command> commandClazz) {
        return applicationContext.getBean(commandClazz);
    }
}
