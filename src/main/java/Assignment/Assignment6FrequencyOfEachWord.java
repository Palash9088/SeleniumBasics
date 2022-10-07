package Assignment;//import java.util.*;

import java.util.*;

public class Assignment6FrequencyOfEachWord {
    void frequencyOf(String words)
    {
        String[] wordsArray = words.split(" ");

        Map<String, Integer> wordMap= new HashMap<>();

        for(String word : wordsArray)
        {
            if(wordMap.containsKey(word))
                wordMap.replace(word,wordMap.get(word)+1);
            else
                wordMap.put(word,1);
        }
        System.out.println(wordMap);
    }
    void charFrequency(String arr)
    {
        String withoutSpace = arr.replace(" ","");
        char[] arr1 = withoutSpace.toCharArray();

        Map<Character, Integer> charMap= new HashMap<>();

        for(char chars : arr1)
        {
            if(charMap.containsKey(chars))
                charMap.put(chars,charMap.get(chars)+1);
            else
                charMap.put(chars,1);
        }
        System.out.println(charMap);
    }
    void intFrequency(int[] arr)
    {
        Map<Integer, Integer> intMap = new HashMap<>();
        for(int a : arr)
        {
            if(intMap.containsKey(a))
                intMap.put(a,intMap.get(a)+1);
            else
                intMap.put(a,1);
        }

        for (Map.Entry<Integer,Integer> entry : intMap.entrySet())
        {
            System.out.print("Key is " + intMap.keySet() + " " +  "Value is " + intMap.values());
            break;
        }
    }

    public static void main(String[] args) {
        Assignment6FrequencyOfEachWord fr = new Assignment6FrequencyOfEachWord();
       String words = "Hi Hello GM GM Hello Hi Hi Hello Hi";
        int[] arr = {1,4,3,4,3,2,4,1,4};
        fr.frequencyOf(words);
        fr.charFrequency(words);
        fr.intFrequency(arr);
    }
}
