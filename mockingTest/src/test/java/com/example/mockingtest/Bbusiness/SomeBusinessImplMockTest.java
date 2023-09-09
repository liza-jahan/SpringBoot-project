package com.example.mockingtest.Bbusiness;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private  DataService dataServiceMock;
    @InjectMocks
    private  SomeBusinessImpl someBusiness;




    @Test
    void findTheGreatestFromAllData_basicScenario() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 15, 5});
        assertEquals(25, someBusiness.findTheGreatestFromAllData());

    }

    @Test
    void findTheGreatestFromAllData_OneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(35, someBusiness.findTheGreatestFromAllData());

    }


    @Test
    void findTheGreatestFromAllData_EmptyArray() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(Integer.MIN_VALUE, someBusiness.findTheGreatestFromAllData());

    }





}