package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoupaTest {

    @Test
    void getRoupa() {
        Roupa roupa = RoupaFactory.fabricarRoupa("XS", "vestido", true, false);

        Roupa roupa1 = RoupaFactory.fabricarRoupa("M", "camisa", false, true);

        Roupa roupa2 = RoupaFactory.fabricarRoupa("p", "blusa", true, false);

        Roupa roupa3 = RoupaFactory.fabricarRoupa("p", "blusa", true, false);

        assertEquals("XS", roupa.getTamanho());
        assertEquals("M", roupa1.getTamanho());
        assertEquals("p", roupa2.getTamanho());
        assertEquals("blusa", roupa2.getTipo());
        assertEquals("vestido", roupa.getTipo());
        assertEquals("blusa", roupa3.getTipo());

    }

    @Test
    void tamanhoFabrica() {
        Roupa roupa = RoupaFactory.fabricarRoupa("XS", "vestido", true, false);

        Roupa roupa1 = RoupaFactory.fabricarRoupa("M", "camisa", false, true);

        Roupa roupa2 = RoupaFactory.fabricarRoupa("p", "blusa", true, false);

        Roupa roupa3 = RoupaFactory.fabricarRoupa("p", "blusa", true, false);


        assertEquals(3, RoupaFactory.getTamanho());
        assertEquals(4, RoupaFactory.getContPedidos());
    }

}