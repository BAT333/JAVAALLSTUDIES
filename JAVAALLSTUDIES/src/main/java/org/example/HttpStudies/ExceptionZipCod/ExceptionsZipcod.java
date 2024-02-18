package org.example.HttpStudies.ExceptionZipCod;

public class ExceptionsZipcod extends RuntimeException{
    private String Message;

    public ExceptionsZipcod(String Message){

     this.Message = Message;
    }
    @Override
    public String getMessage() {
        return this.Message;
    }
}
