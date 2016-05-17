package io.eventuate.javaclient.restclient;

import io.eventuate.javaclient.commonimpl.EventTypeAndData;

import java.util.List;

public class CreateEntityRequest {

  private String entityTypeName;
  private List<EventTypeAndData> events;
  private String entityId;

  public CreateEntityRequest(String entityTypeName, List<EventTypeAndData> events) {
    this.entityTypeName = entityTypeName;
    this.events = events;
  }


  public String getEntityTypeName() {
    return entityTypeName;
  }

  public List<EventTypeAndData> getEvents() {
    return events;
  }

  public String getEntityId() {
    return entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
  }
}
