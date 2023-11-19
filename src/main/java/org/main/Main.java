package org.main;
import java.time.LocalDate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\proshka\\notepadJson\\notepadJsonData\\data.json";
        List<notepadik> notik = new ArrayList<>();

        Scanner askAction = new Scanner(System.in);
        int doThis;

        do {
            System.out.println("1 - New note\n2 - Choice note\n3 - Read info \n4 - Change text\n" +
                    "5 - Change name\n6 - Exit");
            doThis = askAction.nextInt();

            switch (doThis) {
                case 1 -> {
                    String newNames;
                    String newText;
                    int numSymbols;

                    Scanner askData = new Scanner(System.in);

                    System.out.print("Enter name:   ");
                    newNames = askData.nextLine();

                    System.out.print("Enter text:    ");
                    newText = askData.nextLine();

                        notik = readDataFromFile(filePath);


                    numSymbols = newText.length();


                    notepadik newNotepadik = new notepadik (newNames, newText, numSymbols);
                    notik.add(newNotepadik);
                    addDataToFile(filePath, notik);


                }
                case 2 -> {
                    notik  = readDataFromFile(filePath);

                    for (int i = 0; i < notik.size(); i++) {
                        System.out.print(i + "   ") ;
                        System.out.println( notik.get(i).getNoteName());
                        System.out.println();
                    }
                    Scanner choiceNote = new Scanner(System.in);
                    int actionToNote;
                    System.out.println("Choice note");
                    actionToNote = choiceNote.nextInt();
                    int actionText;

                    System.out.println("1 - Read text\n2 - Change text\n3 - Cnange name ");
                    actionText = askAction.nextInt();
                        switch(actionText) {
                            case 1 -> {
                                notik = readDataFromFile(filePath);
                                for (int i = 0; i < notik.size(); i++) {
                                    System.out.println(notik.get(i).getText());

                                }
                            }
                            case 2 -> {
                                notik = readDataFromFile(filePath);
                                Scanner changikTx = new Scanner(System.in);
                                String newTx;
                                System.out.println("write new text");
                                newTx = changikTx.nextLine();
                                notik.get(actionToNote).setText(newTx);
                                addDataToFile(filePath, notik);

                            }
                            case 3 -> {
                                notik = readDataFromFile(filePath);
                                Scanner changeNm = new Scanner(System.in);
                                String newNm;
                                System.out.println("write new name");
                                newNm = changeNm.nextLine();
                                notik.get(actionToNote).setNoteName(newNm);
                                addDataToFile(filePath, notik);
                             }



                        }

                }




            }

        }while(doThis!= 6);

    }
    public static void addDataToFile (String filePath, List<notepadik> data){
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
            System.out.println("Data added to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<notepadik> readDataFromFile(String filePath) {
        List<notepadik> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<notepadik>>(){}.getType();
            people = gson.fromJson(reader,listType);


        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return people;

    }
}
