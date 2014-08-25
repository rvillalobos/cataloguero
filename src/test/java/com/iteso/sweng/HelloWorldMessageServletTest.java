package com.iteso.sweng;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloWorldMessageServletTest {

    @Test
    public void shouldSendMessageToHelloPage() throws ServletException, IOException {
        HelloWorldMessageServlet servlet = new HelloWorldMessageServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);


        when(request.getRequestDispatcher("/hello.jsp")).thenReturn(requestDispatcher);


        servlet.doGet(request, response);

        verify(request).setAttribute("message", "Hello World");

        verify(requestDispatcher).forward(request, response);
    }
}
