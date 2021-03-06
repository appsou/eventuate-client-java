package io.eventuate.javaclient.spring;

import io.eventuate.EventSubscriber;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * Registers Spring beans annotated with @EventSubscriber as event handlers
 *
 * @see io.eventuate.EventSubscriber
 */
public class EventHandlerBeanPostProcessor implements BeanPostProcessor {

  private EventDispatcherInitializer eventDispatcherInitializer;

  public EventHandlerBeanPostProcessor(EventDispatcherInitializer eventDispatcherInitializer) {
    this.eventDispatcherInitializer = eventDispatcherInitializer;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    EventSubscriber a = AnnotationUtils.findAnnotation(bean.getClass(), EventSubscriber.class);
    if (a != null)
      eventDispatcherInitializer.registerEventHandler(bean, beanName);
    return bean;
  }



  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
