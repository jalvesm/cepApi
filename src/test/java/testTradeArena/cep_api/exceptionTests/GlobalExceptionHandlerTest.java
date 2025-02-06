package testTradeArena.cep_api.exceptionTests;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.NoHandlerFoundException;
import testTradeArena.cep_api.exception.GlobalExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleNoHandlerFoundException_ShouldReturnNotFound() throws Exception {
        NoHandlerFoundException ex = mock(NoHandlerFoundException.class);
        when(ex.getMessage()).thenReturn("No handler found");

        ResponseEntity<Object> response = globalExceptionHandler.handleNoHandlerFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
        assertNotNull(responseBody);
        assertEquals("Cep não encontrado. Verifique a URL e tente novamente.", responseBody.get("message"));
        assertEquals("Not Found", responseBody.get("error"));  // Ajuste aqui
    }
}
