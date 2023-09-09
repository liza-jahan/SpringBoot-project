package com.example.mockingtest.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simpleTest() {
        // Create a mock List
        List<String> listMock = mock(List.class);

        // Define the behavior of the size method on the mock
        when(listMock.size()).thenReturn(4);

        // Perform the test
        assertEquals(4, listMock.size());
    }

    @Test
    void multipleReturn() {
        // Create a mock List
        List<String> listMock = mock(List.class);

        // Define the behavior of the size method on the mock
        when(listMock.size()).thenReturn(4).thenReturn(2);

        // Perform the test
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
    }



    @Test
    void parameters() {
        // Create a mock List
        List<String> listMock = mock(List.class);

        // Define the behavior of the size method on the mock
        when(listMock.get(0)).thenReturn("SomeString");

        // Perform the test
        assertEquals("SomeString", listMock.size());
       // assertEquals(2, listMock.size());
    }




    @Test
    void genericParameters() {
        // Create a mock List
        List<String> listMock = mock(List.class);

        // Define the behavior of the size method on the mock
        when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");

        // Perform the test
        assertEquals("SomeOtherString", listMock.size());
        // assertEquals(2, listMock.size());
    }
}

