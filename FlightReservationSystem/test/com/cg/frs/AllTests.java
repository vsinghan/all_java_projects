package com.cg.frs;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ AgeTest.class, MobileNoTest.class, NameTest.class })
public class AllTests {

}
