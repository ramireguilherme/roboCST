package br.unicamp.cst.core.entities;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class RawMemoryTest {


    @Test
    public void getAllOfTypeTest(){
        RawMemory rawMemory = new RawMemory();
        List<Memory> testList = Arrays.asList(new MemoryObject(), new MemoryObject(), new MemoryObject(), new MemoryObject());
        testList.get(0).setType("TYPE");
        testList.get(1).setType("TYPE");
        rawMemory.setAllMemoryObjects(testList);

        assertEquals(2, rawMemory.getAllOfType("TYPE").size());
        assertEquals(testList.subList(0,2), rawMemory.getAllOfType("TYPE"));

    }

    @Test
    public void printContentTest(){
        RawMemory rawMemory = new RawMemory();
        MemoryObject mem = new MemoryObject();
        mem.setType("TYPE");
        mem.setIdmemoryobject(100L);
        rawMemory.addMemory(mem);
        String expectedMessage = "MemoryObject [idmemoryobject=" + 100L + ", timestamp=" + mem.getTimestamp() + ", evaluation="
                + 0.0 + ", I=" + null + ", name=" + "TYPE" + "]";

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        rawMemory.printContent();
        assertTrue(outputStreamCaptor.toString().trim().contains(expectedMessage));
    }

    @Test
    public void createAndDestroyMemoryObjectTest(){
        RawMemory rawMemory = new RawMemory();
        rawMemory.createMemoryObject("TYPE");

        assertEquals(1, rawMemory.size());
        rawMemory.destroyMemoryObject(rawMemory.getAllMemoryObjects().get(0));

        assertEquals(0, rawMemory.size());
    }

    @Test
    public void shutdownTest(){
        RawMemory rawMemory = new RawMemory();
        List<Memory> testList = Arrays.asList(new MemoryObject(), new MemoryObject(), new MemoryObject(), new MemoryObject());
        rawMemory.setAllMemoryObjects(testList);

        assertEquals(4, rawMemory.size());

        rawMemory.shutDown();
        assertEquals(0, rawMemory.size());
    }

}
