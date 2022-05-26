package com.launchdarkly.sdk.server.interfaces;

import com.launchdarkly.sdk.server.Components;

/**
 * The most basic properties of the SDK client that are available to all SDK component factories.
 * 
 * @since 5.0.0
 */
public final class BasicConfiguration {
  private final String sdkKey;
  private final boolean offline;
  private final int threadPriority;
  private final ApplicationInfo applicationInfo;
  private final ServiceEndpoints serviceEndpoints;

  /**
   * Constructs an instance.
   *
   * @param sdkKey the SDK key
   * @param offline true if the SDK was configured to be completely offline
   * @param threadPriority the thread priority that should be used for any worker threads created by SDK components
   * @param applicationInfo metadata about the application using this SDK
   * @param serviceEndpoints the SDK's service URIs
   */
  public BasicConfiguration(String sdkKey, boolean offline, int threadPriority, ApplicationInfo applicationInfo, ServiceEndpoints serviceEndpoints) {
    this.sdkKey = sdkKey;
    this.offline = offline;
    this.threadPriority = threadPriority;
    this.applicationInfo = applicationInfo;
    this.serviceEndpoints = serviceEndpoints != null ? serviceEndpoints : Components.serviceEndpoints().createServiceEndpoints();
  }

  /**
   * Constructs an instance.
   *
   * @param sdkKey the SDK key
   * @param offline true if the SDK was configured to be completely offline
   * @param threadPriority the thread priority that should be used for any worker threads created by SDK components
   * @param applicationInfo metadata about the application using this SDK
   * @deprecated Use {@link BasicConfiguration#BasicConfiguration(String, boolean, int, ApplicationInfo, ServiceEndpoints)}
   */
  @Deprecated
  public BasicConfiguration(String sdkKey, boolean offline, int threadPriority, ApplicationInfo applicationInfo) {
    this(sdkKey, offline, threadPriority, applicationInfo, null);
  }

  /**
   * Constructs an instance.
   *
   * @param sdkKey the SDK key
   * @param offline true if the SDK was configured to be completely offline
   * @param threadPriority the thread priority that should be used for any worker threads created by SDK components
   * @deprecated Use {@link BasicConfiguration#BasicConfiguration(String, boolean, int, ApplicationInfo, ServiceEndpoints)}
   */
  @Deprecated
  public BasicConfiguration(String sdkKey, boolean offline, int threadPriority) {
    this(sdkKey, offline, threadPriority, null, null);
  }

  /**
   * Returns the configured SDK key.
   * 
   * @return the SDK key
   */
  public String getSdkKey() {
    return sdkKey;
  }

  /**
   * Returns true if the client was configured to be completely offline.
   * 
   * @return true if offline
   * @see com.launchdarkly.sdk.server.LDConfig.Builder#offline(boolean)
   */
  public boolean isOffline() {
    return offline;
  }
  
  /**
   * The thread priority that should be used for any worker threads created by SDK components.
   * 
   * @return the thread priority
   * @see com.launchdarkly.sdk.server.LDConfig.Builder#threadPriority(int)
   */
  public int getThreadPriority() {
    return threadPriority;
  }

  /**
   * The metadata about the application using this SDK.
   *
   * @return the application info
   * @see com.launchdarkly.sdk.server.LDConfig.Builder#applicationInfo(com.launchdarkly.sdk.server.integrations.ApplicationInfoBuilder)
   */
  public ApplicationInfo getApplicationInfo() {
    return applicationInfo;
  }

  /**
   * Returns the base service URIs used by SDK components.
   *
   * @return the service endpoints
   * @see com.launchdarkly.sdk.server.LDConfig.Builder#serviceEndpoints(com.launchdarkly.sdk.server.integrations.ServiceEndpointsBuilder)
   */
  public ServiceEndpoints getServiceEndpoints() {
    return serviceEndpoints;
  }
}
