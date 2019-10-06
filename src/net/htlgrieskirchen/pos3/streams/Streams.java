package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Streams {

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(Double.NaN);
    }
    
    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList()); 
   }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).orElseThrow(NoSuchElementException::new);
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).orElseThrow(NoSuchElementException::new);
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(a -> a.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing(Weapon::getName)).orElseThrow(NoSuchElementException::new);
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        List<String> namesList = new LinkedList<>();
        
        return namesList;
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        return null;
        //implement this
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        return 0;
        //implement this
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        return 0;
        //implement this
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return null;
        //implement this
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       //implement this
    }
}
