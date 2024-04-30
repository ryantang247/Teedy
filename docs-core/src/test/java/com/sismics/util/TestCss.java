package com.sismics.util;

import org.junit.Test;

import com.sismics.util.css.Selector;
import static org.junit.Assert.*;

/**
 * Test of CSS utilities.
 * 
 * @author bgamard
 */
public class TestCss {
    @Test
    public void testBuildCss() {
        Selector selector = new Selector(".test")
            .rule("background-color", "yellow")
            .rule("font-family", "Comic Sans");
        System.out.println(selector);
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        // Attempt to create a Selector object with a null name
        Selector selector = new Selector(null);
    }

    @Test
    public void testMultipleRules() {
        // Create a Selector object
        Selector selector = new Selector("h1");

        // Add multiple rules to the selector
        selector.rule("font-size", "24px")
                .rule("color", "blue")
                .rule("text-decoration", "underline");

        // Verify the string representation of the selector
        assertEquals("h1 {\n  font-size: 24px;\n  color: blue;\n  text-decoration: underline;\n}\n", selector.toString());
    }

    @Test
    public void testToString() {
        // Create a Selector object with a single rule
        Selector selector = new Selector("p").rule("font-weight", "bold");

        // Verify the string representation of the selector
        assertEquals("p {\n  font-weight: bold;\n}\n", selector.toString());
    }


    @Test
    public void testToStringWithEmptyRuleList() {
        // Create a Selector object with an empty ruleList
        Selector selector = new Selector("body");

        // Verify the string representation of the selector
        assertEquals("body {\n}\n", selector.toString());
    }

    @Test
    public void testToStringWithOneRule() {
        // Create a Selector object with one rule
        Selector selector = new Selector("body").rule("color", "red");

        // Verify the string representation of the selector
        assertEquals("body {\n  color: red;\n}\n", selector.toString());
    }

    @Test
    public void testToStringWithMultipleRules() {
        // Create a Selector object with multiple rules
        Selector selector = new Selector("body")
                .rule("color", "red")
                .rule("font-size", "16px");

        // Verify the string representation of the selector
        assertEquals("body {\n  color: red;\n  font-size: 16px;\n}\n", selector.toString());
    }

    @Test
    public void testToStringWithEmptyName() {
        // Create a Selector object with an empty name
        Selector selector = new Selector("").rule("color", "red");

        // Verify the string representation of the selector
        assertEquals(" {\n  color: red;\n}\n", selector.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testToStringWithNullName() {
        // Attempt to create a Selector object with a null name
        Selector selector = new Selector(null).rule("color", "red");
    }
}
