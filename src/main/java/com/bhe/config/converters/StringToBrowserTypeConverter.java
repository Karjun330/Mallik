package com.bhe.config.converters;

import com.bhe.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {
        return BrowserType.valueOf(browserName.toUpperCase());
    }
}
