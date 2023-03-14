package org.javarush.oleksandr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListTest {
    @Mock
    ArrayList<Integer> mockList;

    @Spy
    ArrayList<Integer> spyList;



    @Test
    void mockList_test(){
        mockList.add(1);
        mockList.get(0);
        mockList.size();

        InOrder inOrder = inOrder(mockList);

        inOrder.verify(mockList).add(anyInt());
        inOrder.verify(mockList).get(anyInt());
        inOrder.verify(mockList).size();

    }


    @Test
    void spyList_test(){
        spyList.add(1);
        spyList.add(2);
        spyList.add(3);

        assertEquals(3, spyList.size());
    }



    @Test
    void staticTest(){
        MockedStatic<TestClass> mockedStatic = mockStatic(TestClass.class);

        mockedStatic.when(TestClass::staticMethod).thenReturn(123);

        assertEquals(123, TestClass.staticMethod());
    }
}
