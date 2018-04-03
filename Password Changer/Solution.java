import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static List<String> recursiveScan(String password, Map<Character, char[]> map, 
                                              List<String> list, int idx, String currentPass){
        if(idx < password.length()){
            if(map.containsKey(password.charAt(idx))){
                for(char c : map.get(password.charAt(idx))){
                    recursiveScan(password, map, list, idx + 1, currentPass + c);  
                }
            } else {
                recursiveScan(password, map, list, idx + 1, currentPass + password.charAt(idx));
            }
            
        } else {
            list.add(currentPass);
        }
        return list;
        
    }

   
    public static void main(String[] args) {
        String password = "Soda";
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('a', new char[]{'A', 'a', '@'});
        map.put('s', new char[]{'s', '$', 'S'});
        map.put('o', new char[]{'o', '0', 'O'});
        map.put('d', new char[]{'d', 'D', '!'});
        List<String> list = new ArrayList<String>();
        list = recursiveScan(password.toLowerCase(), map, list, 0, "");
        System.out.println(list.size() + " passwords generated");
        System.out.println(list.toString());
   }
}