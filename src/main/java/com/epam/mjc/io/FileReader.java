package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String text = getStringFromFile(file);
        return getProfileInfoFromText(text);
    }

    private String getStringFromFile(File file){
        StringBuilder text = new StringBuilder();
        try (FileInputStream input = new FileInputStream(file.getPath());){
            int c;
            while ((c = input.read()) != -1)
                text.append((char) c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    public static Profile getProfileInfoFromText(String text){
        Profile profile = new Profile();
        if(text.length() >1 ){
            String[] data = text.split("[\\u0020\\n\\r]");
            for (int i = 0; i<data.length; i++){
                if(data[i].isEmpty())
                    continue;
                if(data[i].toLowerCase().contains("name")) {
                    profile.setName(data[i+1]);
                }else if(data[i].toLowerCase().contains("age")){
                    profile.setAge(Integer.valueOf(data[i+1]));
                }else if(data[i].toLowerCase().contains("email")){
                    profile.setEmail(data[i+1]);
                }else if(data[i].toLowerCase().contains("phone")){
                    profile.setPhone(Long.valueOf(data[i+1]));
                }
            }
        }
        return profile;
    }

}
