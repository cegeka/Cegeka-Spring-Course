package com.cegeka.springcourse.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;

public class SyncAndAsyncEventMulticaster implements ApplicationEventMulticaster {

    private ApplicationEventMulticaster syncEventMulticaster;
    private ApplicationEventMulticaster asyncEventMulticaster;

    public SyncAndAsyncEventMulticaster(ApplicationEventMulticaster syncEventMulticaster, ApplicationEventMulticaster asyncEventMulticaster) {
        this.syncEventMulticaster = syncEventMulticaster;
        this.asyncEventMulticaster = asyncEventMulticaster;
    }

    @Override
    public void addApplicationListener(ApplicationListener listener) {
        if (listener.getClass().getAnnotation(AsyncListener.class) != null) {
            asyncEventMulticaster.addApplicationListener(listener);
        } else {
            syncEventMulticaster.addApplicationListener(listener);
        }
    }

    @Override
    public void addApplicationListenerBean(String listenerBeanName) {
        // do nothing
    }

    @Override
    public void removeApplicationListener(ApplicationListener listener) {
        syncEventMulticaster.removeApplicationListener(listener);
        asyncEventMulticaster.removeApplicationListener(listener);
    }

    @Override
    public void removeApplicationListenerBean(String listenerBeanName) {
        // do nothing
    }

    @Override
    public void removeAllListeners() {
        syncEventMulticaster.removeAllListeners();
        asyncEventMulticaster.removeAllListeners();
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        syncEventMulticaster.multicastEvent(event);
        asyncEventMulticaster.multicastEvent(event);
    }

    @Override
    public void multicastEvent(ApplicationEvent event, ResolvableType eventType) {
        syncEventMulticaster.multicastEvent(event);
        asyncEventMulticaster.multicastEvent(event);
    }

}
