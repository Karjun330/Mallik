//package com.bhe.shadowroot;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.internal.Require;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.openqa.selenium.remote.Dialect.W3C;
//import static org.openqa.selenium.remote.DriverCommand.FIND_ELEMENTS_FROM_SHADOW_ROOT;
//import static org.openqa.selenium.remote.DriverCommand.FIND_ELEMENT_FROM_SHADOW_ROOT;
//
//public class ShadowRoot implements SearchContext, WrapsDriver {
//    private final RemoteWebDriver parent;
//    private final String id;
//
//    ShadowRoot(RemoteWebDriver parent, String id) {
//        this.parent = Require.nonNull("Owning remote webdriver", parent);
//        this.id = Require.nonNull("Shadow root ID", id);
//    }
//
//    @Override
//    public List<WebElement> findElements(By by) {
//        return parent.findElements(
//                this,
//                (using, value) -> FIND_ELEMENTS_FROM_SHADOW_ROOT(id, using, String.valueOf(value)),
//                by);
//    }
//
//    @Override
//    public WebElement findElement(By by) {
//        return parent.findElement(
//                this,
//                (using, value) -> FIND_ELEMENT_FROM_SHADOW_ROOT(id, using, String.valueOf(value)),
//                by);
//    }
//
//    @Override
//    public WebDriver getWrappedDriver() {
//        return parent;
//    }
//
//    public String getId() {
//        return this.id;
//    }
//
////    private Map<String, Object> toJson() {
////        return singletonMap(W3C.getShadowRootElementKey(), id);
////    }
//}
