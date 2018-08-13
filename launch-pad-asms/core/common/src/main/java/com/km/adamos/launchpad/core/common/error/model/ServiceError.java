package com.km.adamos.launchpad.core.common.error.model;

import java.util.Objects;

public class ServiceError {

  public enum ErrorCode {

    invalid, invalidSystemConfiguration, error

  }

  public static class ErrorContent<ContentType> {

    public ContentType content;

    public ErrorContent(ContentType content) {
      this.content = content;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ErrorContent<?> that = (ErrorContent<?>) o;
      return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

      return Objects.hash(content);
    }

    public ContentType getContent() {
      return content;
    }

    public String createErrorMessage() {
      return content.toString();
    }

  }

  protected final static String errorMessage = "ServiceError: %s --> %s";

  public ErrorCode errorCode;
  public ErrorContent errorContent;
  public String message;

  public ServiceError(ErrorCode errorCode, ErrorContent errorContent) {
    this.errorCode = errorCode;
    this.errorContent = errorContent;
    this.message = createErrorMessage();
  }

  public ServiceError(ErrorCode errorCode) {
    this(errorCode, null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ServiceError that = (ServiceError) o;
    return errorCode == that.errorCode &&
      Objects.equals(errorContent, that.errorContent);
  }

  @Override
  public int hashCode() {

    return Objects.hash(errorCode, errorContent);
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  public ErrorContent getErrorContent() {
    return errorContent;
  }

  public String getMessage() {
    return message;
  }

  private String createErrorMessage() {
    return errorContent != null ?
      String.format(errorMessage, errorCode.toString(), errorContent.createErrorMessage()) :
      String.format(errorMessage, errorCode.toString(), "");
  }
}
