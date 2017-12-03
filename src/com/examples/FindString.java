package com.examples;
	// package whatever; // don't place package name!
	/*
	 Given a string S with K distinct characters. Find the length of the smallest substring which contains
	 all the characters. All characters are lowercase letters from ‘a’ to ‘z’

	Input:
	K : 2
	abbaba

	Output:
	2

	Input:
	K:4
	dcaabbcd   // Pick last 5, or first 5 as they contain 4 distinct characters (dcaab)


	Output:
	5

	Input:
	3
	aacaabab   // caab and length is 4, contains 3 distinct characters

	Output:
	4

	K:3 (abc)
	caaaaaaaaaab


	12

	*/


	// cab


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindString {
	    public static void main (String[] args) throws java.lang.Exception
	    {
	        //System.out.println("Hello Java");
	        getString(args[0], args[1]);  
	    
	    }
	    
	    public static void getString(String myString, String strToFind){
	        /*
	        Store in a list = myString
	        Store 3 leters in a variable or Map to check if found
	        for loop to the list and if letter found same on check on StoreLetter and mark it as found
	          continue iteration for next letter
	          do the same starting from next position on the string.
	        complete iteration
	        */
	        List<String> myList = new ArrayList();

	        ///String myLetter = "abaacccd";
	        String mySubstring = "";
	        boolean MarkAasFound = false;
	        boolean MarkBasFound = false;
	        boolean MarkCasFound = false;
	        String myLetter ="";
	        int CurrLenght = myString.length()+1;
	        int iposition = myString.length()+1;
	        int eposition = myString.length()+1;
	        
	        for(int x=0;x<myString.length();x++){
	            //a
	            //ab
	        		MarkAasFound = false;
	        		MarkBasFound = false;
	        		MarkCasFound = false;
	              for(int y=x+1;y<myString.length();y++){  // y = x+1   
	                  //a
	                  //ab
	                mySubstring = myString.substring(x+1,y+1);     //a x=1, y=2 // x=0, y=2
	                myLetter = myString.substring(y,y+1);   //a 
	                switch(myLetter){
	                    case "a": MarkAasFound = true;break;
	                    case "b": MarkBasFound = true;break;
	                    case "c": MarkCasFound = true;break;
	                }
	                //System.out.println(mySubstring);
	                if(MarkAasFound && MarkBasFound && MarkCasFound && CurrLenght > mySubstring.length()){
	                		CurrLenght=mySubstring.length();
	                		iposition = x+1;
	                		eposition = y+1;
	                }
	            }
	              //System.out.println(CurrLenght);
	        }
	        System.out.println("String["+myString+"] - String to search[abc] - Initial position ["+iposition+"] - End position["+eposition+"]");
	    }
	}