/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.provider.selenium.webdriver;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.LocationContext;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByTagName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cognifide.qa.bb.frame.FrameSwitcher;

import io.appium.java_client.DeviceActionShortcuts;
import io.appium.java_client.FindsByAccessibilityId;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.FindsByIosUIAutomation;
import io.appium.java_client.HasAppStrings;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.InteractsWithFiles;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.ScrollsTo;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.HasNetworkConnection;
import io.appium.java_client.android.PushesFiles;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.GetsNamedTextField;
import io.appium.java_client.ios.IOSDeviceActionShortcuts;

/**
 * This class is a "simple" extension of Selenium's EventFiringWebDriver that additionally implements several
 * useful interfaces.
 */
public class WebDriverWrapper extends EventFiringWebDriver implements FindsById, FindsByClassName,
    FindsByLinkText, FindsByName, FindsByCssSelector, FindsByTagName, FindsByXPath, HasCapabilities,
    MobileDriver, Rotatable, FindsByAccessibilityId, LocationContext, TouchShortcuts,
    InteractsWithApps, ScrollsTo, AndroidDeviceActionShortcuts, HasAppStrings, HasNetworkConnection,
    PushesFiles, StartsActivity, FindsByAndroidUIAutomator, IOSDeviceActionShortcuts,
    GetsNamedTextField, FindsByIosUIAutomation {

  private final FrameSwitcher frameSwitcher;

  /**
   * Constructs WebDriverWrapper.
   *
   * @param driver        instance of WebDriver.
   * @param frameSwitcher instance of FrameSwitcher.
   */
  public WebDriverWrapper(WebDriver driver, FrameSwitcher frameSwitcher) {
    super(driver);
    this.frameSwitcher = frameSwitcher;
  }

  /**
   * @return The capabilities of the current driver.
   */
  @Override
  public Capabilities getCapabilities() {
    return ((HasCapabilities) super.getWrappedDriver()).getCapabilities();
  }

  /**
   * Finds element by xpath.
   */
  @Override
  public WebElement findElementByXPath(String xPath) {
    return ((FindsByXPath) super.getWrappedDriver()).findElementByXPath(xPath);
  }

  /**
   * Finds elements by xpath.
   */
  @Override
  public List<WebElement> findElementsByXPath(String xPath) {
    return ((FindsByXPath) super.getWrappedDriver()).findElementsByXPath(xPath);
  }

  /**
   * Finds element by tag name.
   */
  @Override
  public WebElement findElementByTagName(String tagName) {
    return ((FindsByTagName) super.getWrappedDriver()).findElementByTagName(tagName);
  }

  /**
   * Finds elements by tag name.
   */
  @Override
  public List<WebElement> findElementsByTagName(String tagName) {
    return ((FindsByTagName) super.getWrappedDriver()).findElementsByTagName(tagName);
  }

  /**
   * Finds element by css selector.
   */
  @Override
  public WebElement findElementByCssSelector(String cssSelector) {
    return ((FindsByCssSelector) super.getWrappedDriver()).findElementByCssSelector(cssSelector);
  }

  /**
   * Finds elements by css selector.
   */
  @Override
  public List<WebElement> findElementsByCssSelector(String cssSelector) {
    return ((FindsByCssSelector) super.getWrappedDriver()).findElementsByCssSelector(cssSelector);
  }

  /**
   * Finds element by name.
   */
  @Override
  public WebElement findElementByName(String name) {
    return ((FindsByName) super.getWrappedDriver()).findElementByName(name);
  }

  /**
   * Finds elements by name.
   */
  @Override
  public List<WebElement> findElementsByName(String name) {
    return ((FindsByName) super.getWrappedDriver()).findElementsByName(name);
  }

  /**
   * Finds element by link text.
   */
  @Override
  public WebElement findElementByLinkText(String linkText) {
    return ((FindsByLinkText) super.getWrappedDriver()).findElementByLinkText(linkText);
  }

  /**
   * Finds elements by link text.
   */
  @Override
  public List<WebElement> findElementsByLinkText(String linkText) {
    return ((FindsByLinkText) super.getWrappedDriver()).findElementsByLinkText(linkText);
  }

  /**
   * Finds element by partial link text.
   */
  @Override
  public WebElement findElementByPartialLinkText(String partialLinkText) {
    return ((FindsByLinkText) super.getWrappedDriver())
        .findElementByPartialLinkText(partialLinkText);
  }

  /**
   * Finds elements by partial link text.
   */
  @Override
  public List<WebElement> findElementsByPartialLinkText(String partialLinkText) {
    return ((FindsByLinkText) super.getWrappedDriver())
        .findElementsByPartialLinkText(partialLinkText);
  }

  /**
   * Finds element by class name.
   */
  @Override
  public WebElement findElementByClassName(String className) {
    return ((FindsByClassName) super.getWrappedDriver()).findElementByClassName(className);
  }

  /**
   * Finds elements by class name.
   */
  @Override
  public List<WebElement> findElementsByClassName(String className) {
    return ((FindsByClassName) super.getWrappedDriver()).findElementsByClassName(className);
  }

  /**
   * Finds element by id.
   */
  @Override
  public WebElement findElementById(String id) {
    return ((FindsById) super.getWrappedDriver()).findElementById(id);
  }

  /**
   * Finds elements by id.
   */
  @Override
  public List<WebElement> findElementsById(String id) {
    return ((FindsById) super.getWrappedDriver()).findElementsById(id);
  }

  @Override
  public TouchAction performTouchAction(TouchAction touchAction) {
    return ((PerformsTouchActions) super.getWrappedDriver()).performTouchAction(touchAction);
  }

  @Override
  public void performMultiTouchAction(MultiTouchAction multiAction) {
    ((PerformsTouchActions) super.getWrappedDriver()).performMultiTouchAction(multiAction);
  }

  @Override
  public MobileElement scrollTo(String text) {
    return ((ScrollsTo) super.getWrappedDriver()).scrollTo(text);
  }

  @Override
  public MobileElement scrollToExact(String text) {
    return ((ScrollsTo) super.getWrappedDriver()).scrollToExact(text);
  }

  @Override
  public void launchApp() {
    ((InteractsWithApps) super.getWrappedDriver()).launchApp();
  }

  @Override
  public void installApp(String appPath) {
    ((InteractsWithApps) super.getWrappedDriver()).installApp(appPath);
  }

  @Override
  public boolean isAppInstalled(String bundleId) {
    return ((InteractsWithApps) super.getWrappedDriver()).isAppInstalled(bundleId);
  }

  @Override
  public void resetApp() {
    ((InteractsWithApps) super.getWrappedDriver()).resetApp();
  }

  @Override
  public void runAppInBackground(int seconds) {
    ((InteractsWithApps) super.getWrappedDriver()).runAppInBackground(seconds);
  }

  @Override
  public void removeApp(String bundleId) {
    ((InteractsWithApps) super.getWrappedDriver()).removeApp(bundleId);
  }

  @Override
  public void closeApp() {
    ((InteractsWithApps) super.getWrappedDriver()).closeApp();
  }

  @Override
  public byte[] pullFile(String remotePath) {
    return ((InteractsWithFiles) super.getWrappedDriver()).pullFile(remotePath);
  }

  @Override
  public byte[] pullFolder(String remotePath) {
    return ((InteractsWithFiles) super.getWrappedDriver()).pullFolder(remotePath);
  }

  @Override
  public void zoom(int x, int y) {
    ((TouchShortcuts) super.getWrappedDriver()).zoom(x, y);
  }

  @Override
  public void zoom(WebElement el) {
    ((TouchShortcuts) super.getWrappedDriver()).zoom(el);
  }

  @Override
  public void tap(int fingers, int x, int y, int duration) {
    ((TouchShortcuts) super.getWrappedDriver()).tap(fingers, x, y, duration);
  }

  @Override
  public void tap(int fingers, WebElement element, int duration) {
    ((TouchShortcuts) super.getWrappedDriver()).tap(fingers, element, duration);
  }

  @Override
  public void swipe(int startx, int starty, int endx, int endy, int duration) {
    ((TouchShortcuts) super.getWrappedDriver()).swipe(startx, starty, endx, endy, duration);
  }

  @Override
  public void pinch(int x, int y) {
    ((TouchShortcuts) super.getWrappedDriver()).pinch(x, y);
  }

  @Override
  public void pinch(WebElement el) {
    ((TouchShortcuts) super.getWrappedDriver()).pinch(el);
  }

  @Override
  public void hideKeyboard() {
    ((DeviceActionShortcuts) super.getWrappedDriver()).hideKeyboard();
  }

  @Override
  public void sendKeyEvent(int key) {
    ((DeviceActionShortcuts) super.getWrappedDriver()).sendKeyEvent(key);
  }

  @Override
  public Location location() {
    return ((LocationContext) super.getWrappedDriver()).location();
  }

  @Override
  public void setLocation(Location arg0) {
    ((LocationContext) super.getWrappedDriver()).setLocation(arg0);
  }

  @Override
  public WebElement findElementByAccessibilityId(String using) {
    return ((FindsByAccessibilityId) super.getWrappedDriver()).findElementByAccessibilityId(using);
  }

  @Override
  public List<WebElement> findElementsByAccessibilityId(String using) {
    return ((FindsByAccessibilityId) super.getWrappedDriver()).findElementsByAccessibilityId(using);
  }

  @Override
  public ScreenOrientation getOrientation() {
    return ((Rotatable) super.getWrappedDriver()).getOrientation();
  }

  @Override
  public void rotate(ScreenOrientation arg0) {
    ((Rotatable) super.getWrappedDriver()).rotate(arg0);
  }

  @Override
  public WebDriver context(String arg0) {
    return ((ContextAware) super.getWrappedDriver()).context(arg0);
  }

  @Override
  public String getContext() {
    return ((ContextAware) super.getWrappedDriver()).getContext();
  }

  @Override
  public Set<String> getContextHandles() {
    return ((ContextAware) super.getWrappedDriver()).getContextHandles();
  }

  @Override
  public Response execute(String driverCommand, Map<String, ?> parameters) {
    return ((MobileDriver) super.getWrappedDriver()).execute(driverCommand, parameters);
  }

  @Override
  public WebElement findElementByIosUIAutomation(String using) {
    return ((FindsByIosUIAutomation) super.getWrappedDriver()).findElementByIosUIAutomation(using);
  }

  @Override
  public List<WebElement> findElementsByIosUIAutomation(String using) {
    return ((FindsByIosUIAutomation) super.getWrappedDriver()).findElementsByIosUIAutomation(using);
  }

  @Override
  public WebElement getNamedTextField(String name) {
    return ((GetsNamedTextField) super.getWrappedDriver()).getNamedTextField(name);
  }

  @Override
  public void hideKeyboard(String keyName) {
    ((IOSDeviceActionShortcuts) super.getWrappedDriver()).hideKeyboard(keyName);
  }

  @Override
  public void hideKeyboard(String strategy, String keyName) {
    ((IOSDeviceActionShortcuts) super.getWrappedDriver()).hideKeyboard(strategy, keyName);
  }

  @Override
  public void shake() {
    ((IOSDeviceActionShortcuts) super.getWrappedDriver()).shake();
  }

  @Override
  public WebElement findElementByAndroidUIAutomator(String using) {
    return ((FindsByAndroidUIAutomator) super.getWrappedDriver())
        .findElementByAndroidUIAutomator(using);
  }

  @Override
  public List<WebElement> findElementsByAndroidUIAutomator(String using) {
    return ((FindsByAndroidUIAutomator) super.getWrappedDriver())
        .findElementsByAndroidUIAutomator(using);
  }

  @Override
  public void startActivity(String appPackage, String appActivity, String appWaitPackage,
      String appWaitActivity) {
    ((StartsActivity) super.getWrappedDriver())
        .startActivity(appPackage, appActivity, appWaitPackage, appWaitActivity);
  }

  @Override
  public void startActivity(String appPackage, String appActivity) {
    ((StartsActivity) super.getWrappedDriver()).startActivity(appPackage, appActivity);
  }

  @Override
  public void pushFile(String remotePath, byte[] base64Data) {
    ((PushesFiles) super.getWrappedDriver()).pushFile(remotePath, base64Data);
  }

  @Override
  public NetworkConnectionSetting getNetworkConnection() {
    return ((HasNetworkConnection) super.getWrappedDriver()).getNetworkConnection();
  }

  @Override
  public void setNetworkConnection(NetworkConnectionSetting connection) {
    ((HasNetworkConnection) super.getWrappedDriver()).setNetworkConnection(connection);
  }

  @Override
  public String getAppStrings() {
    return ((HasAppStrings) super.getWrappedDriver()).getAppStrings();
  }

  @Override
  public String getAppStrings(String language) {
    return ((HasAppStrings) super.getWrappedDriver()).getAppStrings(language);
  }

  @Override
  public void sendKeyEvent(int key, Integer metastate) {
    ((AndroidDeviceActionShortcuts) super.getWrappedDriver()).sendKeyEvent(key, metastate);
  }

  @Override
  public TargetLocator switchTo() {
    return new BobcatTargetLocator(super.getWrappedDriver().switchTo(), frameSwitcher);
  }
}
