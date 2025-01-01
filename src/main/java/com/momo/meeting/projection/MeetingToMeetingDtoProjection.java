package com.momo.meeting.projection;

import java.time.LocalDateTime;

public interface MeetingToMeetingDtoProjection {

  Long getId();

  String getTitle();

  Long getLocationId();

  Double getLatitude();

  Double getLongitude();

  String getAddress();

  LocalDateTime getMeetingDateTime();

  Integer getMaxCount();

  Integer getApprovedCount();

  String getCategory();

  String getThumbnailUrl();

  Double getDistance();
}