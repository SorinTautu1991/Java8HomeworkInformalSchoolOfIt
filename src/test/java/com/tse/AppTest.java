package com.tse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void createFileAndWriteFile(){
        App app = new App();
        assertTrue(app.resolve("inputFile", 3, "outputFile"));
    }


}
