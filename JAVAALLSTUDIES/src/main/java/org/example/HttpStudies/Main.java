package org.example.HttpStudies;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.HttpStudies.Class.Address;
import org.example.HttpStudies.Class.AddressRecord;
import org.example.HttpStudies.Class.ZipCodeSearch;
import org.example.HttpStudies.Utilities.FileJson;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        //para pegar arquivo json e transforma e infos para objeto
        AddressRecord record = gson.fromJson(ZipCodeSearch.Search("12345678"), AddressRecord.class);

        Address address = new Address(record);
     File file = FileJson.CreateFiles("DIRETORIO","PASTAJOSN","JOSN.json");
        FileJson.CreateJson(file,address);
        System.out.println(address);

    }
}
