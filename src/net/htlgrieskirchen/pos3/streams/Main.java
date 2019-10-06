/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author fabia
 */
public class Main {
    static int[] arr;
    static String[] sarr;
    static List<Weapon> weapons;
    public static void main(String[] args){
        Main main = new Main();
        Streams streams = new Streams();
        arr = new int[10000];
        arr = main.generateNumbers();
//        System.out.println(streams.average(arr));

        sarr = new String[10];
        sarr = main.generateString();
//        System.out.println(streams.upperCase(sarr));

        weapons = main.readCSV("weapons.csv");
//        System.out.println(weapons);
    }
    
    public int[] generateNumbers(){
        for(int i = 0; i < 10000; i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        return arr;
    }
    
    public String[] generateString(){
        final String letters = "abcdefghijklmnopqrstuvwxyz";
        final int letlength = letters.length();
        String rdnString = "";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                rdnString = rdnString + letters.charAt((int)(Math.random()*letlength));
            }
            sarr[i] = rdnString;
            rdnString = "";
        }
        return sarr;
    }
    
    public List<Weapon> readCSV(String path) {
        try (FileReader r = new FileReader(path); BufferedReader br = new BufferedReader(r)) {
            weapons = br.lines().skip(1).map(StringToWeapon).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e);
        }
        return weapons;
    }

    private final Function<String, Weapon> StringToWeapon = (line) -> {
        String[] parts = line.split(";");
        Weapon weapon = new Weapon(parts[0],CombatType.valueOf(parts[1]),DamageType.valueOf(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]));
        return weapon;
    };
}
