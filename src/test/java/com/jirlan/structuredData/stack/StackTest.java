package com.jirlan.structuredData.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void shouldBeEmptyStack() {
        var stack = new Stack<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void shouldBeNotEmptyStack() {
        var stack = new Stack<>();
        stack.push(20);

        assertFalse(stack.isEmpty());
    }

    @Test
    public void shouldPopLastItemFromStack() {
        var stack = new Stack<>();
        stack.push(20);
        stack.push(22);
        stack.push(28);
        stack.push(2);
        stack.push(56);

        assertEquals(stack.pop(), 56);
    }

    @Test
    public void shouldPopLastButOneItemFromStack() {
        var stack = new Stack<>();
        stack.push(20);
        stack.push(22);
        stack.push(28);
        stack.push(2);
        stack.push(56);

        stack.pop();

        assertEquals(stack.pop(), 2);
    }

    @Test
    public void shouldReturnLastItemFromStackOnPeekMethod() {
        var stack = new Stack<>();
        stack.push(20);
        stack.push(22);
        stack.push(28);
        stack.push(2);
        stack.push(56);

        assertEquals(stack.peek(), 56);
    }

    @Test
    public void shouldReturnLastItemFromStackWhenTwoCallsOfThePeekMethod() {
        var stack = new Stack<>();
        stack.push(20);
        stack.push(22);
        stack.push(28);
        stack.push(2);
        stack.push(56);

        stack.peek();

        assertEquals(stack.peek(), 56);
    }
}
