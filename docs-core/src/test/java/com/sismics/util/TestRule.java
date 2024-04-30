package com.sismics.util.css;

import org.junit.Test;
import static org.junit.Assert.*;
import com.sismics.util.css.Rule;


public class TestRule {

    @Test
    public void testToString() {
        // Create a Rule object
        Rule rule = new Rule("color", "red");

        // Verify the toString method
        assertEquals("color: red", rule.toString());
    }

    @Test
    public void testToStringWithDifferentPropertyAndValue() {
        // Create a Rule object with different property and value
        Rule rule = new Rule("font-size", "12px");

        // Verify the toString method with different property and value
        assertEquals("font-size: 12px", rule.toString());
    }

    @Test
    public void testToStringWithEmptyValue() {
        // Create a Rule object with empty value
        Rule rule = new Rule("display", "");

        // Verify the toString method with empty value
        assertEquals("display: ", rule.toString());
    }

    @Test
    public void testToStringWithNullValue() {
        // Create a Rule object with null value
        Rule rule = new Rule("border", null);

        // Verify the toString method with null value
        assertEquals("border: null", rule.toString());
    }

    @Test
    public void testToStringWithWhitespace() {
        // Create a Rule object with leading and trailing whitespace
        Rule rule = new Rule("   padding   ", "   10px   ");

        // Verify the toString method with leading and trailing whitespace
        assertEquals("padding: 10px", rule.toString());
    }

    @Test
    public void testToStringWithLongPropertyAndValue() {
        // Create a Rule object with very long property and value strings
        Rule rule = new Rule("ThisIsAVeryLongPropertyNameThatExceedsTheLimitForNormalCSSRules", "ThisIsAVeryLongValueThatExceedsTheLimitForNormalCSSValues");

        // Verify the toString method with very long property and value strings
        assertEquals("ThisIsAVeryLongPropertyNameThatExceedsTheLimitForNormalCSSRules: ThisIsAVeryLongValueThatExceedsTheLimitForNormalCSSValues", rule.toString());
    }

    @Test
    public void testToStringWithLeadingTrailingWhitespace() {
        // Create a Rule object with leading and trailing whitespace in property and value
        Rule rule = new Rule(" margin ", " 10px ");

        // Verify the toString method with leading and trailing whitespace
        assertEquals("margin: 10px", rule.toString());
    }

    @Test
    public void testToStringWithSpecialCharacters() {
        // Create a Rule object with special characters in property and value
        Rule rule = new Rule("background-color", "#ff0000");

        // Verify the toString method with special characters in property and value
        assertEquals("background-color: #ff0000", rule.toString());
    }

    @Test
    public void testToStringWithUnicodeCharacters() {
        // Create a Rule object with Unicode characters in property and value
        Rule rule = new Rule("font-family", "Arial™");

        // Verify the toString method with Unicode characters in property and value
        assertEquals("font-family: Arial™", rule.toString());
    }

    @Test
    public void testToStringWithEscapeCharacters() {
        // Create a Rule object with escape characters in property and value
        Rule rule = new Rule("content", "\"Quoted text\"");

        // Verify the toString method with escape characters in property and value
        assertEquals("content: \"Quoted text\"", rule.toString());
    }

    @Test
    public void testToStringWithMixedCases() {
        // Create a Rule object with mixed cases in property and value
        Rule rule = new Rule("bOrDeR-sTyLe", "dotted");

        // Verify the toString method with mixed cases in property and value
        assertEquals("border-style: dotted", rule.toString());
    }

    @Test
    public void testToStringWithNonASCIICharacters() {
        // Create a Rule object with non-ASCII characters in property and value
        Rule rule = new Rule("font-family", "Helvetica Neue®");

        // Verify the toString method with non-ASCII characters in property and value
        assertEquals("font-family: Helvetica Neue®", rule.toString());
    }

    @Test
    public void testToStringWithIntegerValue() {
        // Create a Rule object with an integer value
        Rule rule = new Rule("line-height", "1");

        // Verify the toString method with an integer value
        assertEquals("line-height: 1", rule.toString());
    }
}
