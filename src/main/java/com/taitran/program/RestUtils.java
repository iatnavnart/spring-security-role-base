package com.taitran.program;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * The Class RestUtils.
 */
public final class RestUtils implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  private static RestTemplate restTemplate = new RestTemplate();

  private RestUtils() {

  }

  /**
   * Call rest.
   *
   * @param <T>           the generic type
   * @param url           the url
   * @param method        the method
   * @param body          the body
   * @param headers       the headers
   * @param responseClass the response class
   * @return the response entity
   */
  private static <T> ResponseEntity<T> callRest(final String url, final HttpMethod method, final T body,
      final HttpHeaders headers, final ParameterizedTypeReference<T> responseClass) {
    return restTemplate.exchange(url, method, addRequestBody(body, headers), responseClass);
  }

  /**
   * Adds the request body.
   *
   * @param <T>     the generic type
   * @param body    the body
   * @param headers the headers
   * @return the http entity
   */
  private static <T> HttpEntity<T> addRequestBody(final T body, final HttpHeaders headers) {
    if (Objects.nonNull(body)) {
      return new HttpEntity<>(body, headers);
    }
    return new HttpEntity<>(headers);
  }

  /**
   * Gets the.
   *
   * @param <T>           the generic type
   * @param url           the url
   * @param headers       the headers
   * @param responseClass the response class
   * @return the response entity
   */
  public static <T> ResponseEntity<T> get(final String url, final HttpHeaders headers,
      final ParameterizedTypeReference<T> responseClass) {
    return callRest(url, HttpMethod.GET, null, headers, responseClass);
  }

  /**
   * Post.
   *
   * @param <T>           the generic type
   * @param url           the url
   * @param headers       the headers
   * @param body          the body
   * @param responseClass the response class
   * @return the response entity
   */
  public static <T> ResponseEntity<T> post(final String url, final HttpHeaders headers, final T body,
      final ParameterizedTypeReference<T> responseClass) {
    return callRest(url, HttpMethod.POST, body, headers, responseClass);
  }

  
  public static HttpHeaders httpHeadersApplicationJSON() {
    final HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    headers.set(HttpHeaders.CACHE_CONTROL, "no-cache");
    headers.set(HttpHeaders.CACHE_CONTROL, "no-cache");
    return headers;
  }

}
