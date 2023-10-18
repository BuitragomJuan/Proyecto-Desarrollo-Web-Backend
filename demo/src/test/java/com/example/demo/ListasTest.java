package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.Listas;
import com.example.demo.model.ListasRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ListasTest {

    @Autowired
    private ListasRepository lRepository;

    @Test
    @Order(1)
    public void testCreate(){

        Listas lista = new Listas();
        lista.setId("0001");
        lista.setGenero("pop");
        
        lRepository.save(lista);

        Listas createdList = lRepository.findById(lista.getId()).orElse(null);
        assertNotNull(createdList);
        assertEquals("0001", createdList.getId());
    }

    @Test
    @Order(2)
    public void testDBC() {

        Listas lista = lRepository.findById("0001").orElse(null);
        assertNotNull(lista);
    }

    @Test
    @Order(4)
    public void testDelete(){

        String ID1 = "0001";
        String ID2 = "0002";

        lRepository.deleteById(ID1);
        lRepository.deleteById(ID2);

        Listas deletedList1 = lRepository.findById(ID1).orElse(null);
        Listas deletedList2 = lRepository.findById(ID2).orElse(null);

        assertNull(deletedList1);
        assertNull(deletedList2);
        
    }


    @Test
    @Order(3)
    public void testUpdate(){


        Listas lista = new Listas();
        lista.setId("0002");
        lista.setGenero("rock");
    
        lRepository.save(lista);
        
        lista.setGenero("alternative");

        lRepository.save(lista);

        Listas updatedLista = lRepository.findById(lista.getId()).orElse(null);

        assertNotNull(updatedLista);
        assertEquals("alternative", updatedLista.getGenero());
    }

}
