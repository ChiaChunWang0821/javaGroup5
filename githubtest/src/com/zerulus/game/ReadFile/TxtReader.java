package com.zerulus.game.ReadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtReader {
    private ArrayList<String> arr = new ArrayList<String>();
    private static Scanner input;

    public ArrayList<String> InputTalk(String filename){
        try{
            File f = new File("res/txt/"+filename);
            InputStreamReader read = new InputStreamReader(new FileInputStream(f),"big5");
            BufferedReader reader= new BufferedReader(read);
            String line;
            while((line=reader.readLine())!=null){
                arr.add(line);
            }

        }catch (Exception e){
            System.out.println(e);
            System.out.println("File cannot read....");
        }
        return arr;
    }

    public ArrayList<String> InputRecord(String filename){
        try{
            File f = new File("res/txt/"+filename);
            InputStreamReader read = new InputStreamReader(new FileInputStream(f),"utf-8");
            BufferedReader reader= new BufferedReader(read);
            String line;
            while((line=reader.readLine())!=null){
                arr.add(line);
            }

        }catch (Exception e){
            System.out.println(e);
            System.out.println("File cannot read....");
        }
        return arr;
    }

}
