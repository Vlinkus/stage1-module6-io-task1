package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        FileInputStream input = null;
        String text = "";
        Profile profile = new Profile();
        try {
            input = new FileInputStream(file.getPath());
            int c;
            while ((c = input.read()) != -1)
                text += (char) c;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        if(text.length() >1 ){
            String[] data = text.split("[\\u0020\\n\\r]");
            for (int i = 0; i<data.length; i++){
                if(data[i].isEmpty()) {
                    continue;
                }
                if(data[i].toLowerCase().contains("name")) {
                    profile.setName(data[++i]);
                }else if(data[i].toLowerCase().contains("age")){
                    profile.setAge(Integer.valueOf(data[++i]));
                }else if(data[i].toLowerCase().contains("email")){
                    profile.setEmail(data[++i]);
                }else if(data[i].toLowerCase().contains("phone")){
                    System.out.println(data[i]+" phone "+data[i]);
                    profile.setPhone(Long.valueOf(data[++i]));
                }
            }
        }
        return profile;
    }

}
