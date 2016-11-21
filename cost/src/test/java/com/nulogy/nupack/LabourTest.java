package com.nulogy.nupack;

import org.testng.annotations.Test;

import com.nulogy.nupack.object.BaseLabour;
import com.nulogy.nupack.object.Labour;
import com.nulogy.nupack.object.ValidationException;

@Test(description = "Test Labour class exceptions")
public class LabourTest {
    
    @Test(description = "Test Labour constructor exceptions", expectedExceptions = {ValidationException.class}, expectedExceptionsMessageRegExp = "Number of people cannot be less than 0")
    public void testConstructorException() {
        new BaseLabour(-1);
    }
    
    @Test(description = "Test Labour setter exceptions", expectedExceptions = {ValidationException.class}, expectedExceptionsMessageRegExp = "Number of people cannot be less than 0")
    public void testSetterException() {
        Labour labour = new BaseLabour();
        labour.setNumberOfPeople(-1);
    }
}
