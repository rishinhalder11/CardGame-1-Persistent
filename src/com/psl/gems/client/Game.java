package com.psl.gems.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class Game {
	private Cards arr1[]=new Cards[3];
	private Cards arr2[]=new Cards[3];
	Cards card=new Cards();
	public void shuffle(Cards deck[], String suits[],String ranks[])
    {
         
		int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = new Cards(suits[i], ranks[j]);
                index++;
            }
        }

        // shuffle the deck of cards
        Collections.shuffle(Arrays.asList(deck));
    }
	public void register(Player p)
	{
		System.out.println(p.getName());
	}
	public void play(Cards deck[],ArrayList<Player>player)
	{
		//System.out.println("Play");
		HashMap<String,Cards[]> participant=new HashMap<>();
		
		
//		for(Player p:player)
//		{
//			participant.put(p.getName(),deck);
//			//System.out.println(participant);
//		}
		int j=0;
		
		for(int i=0;i<3;i++)
		{
			
			if(j%2==0) {
				arr1[i]=deck[j];
				j++;
			}
				arr2[i]=deck[j];
				j++;
		}
		
		participant.put("Rishin",arr1);
		participant.put("Sayantani",arr2);
		//System.out.println(participant.get("Rishin")[0]);
		for(int i=0;i<3;i++)
		{
			
				System.out.print(arr1[i].getSuit()+"   ");
			System.out.print(arr1[i].getRank());
			System.out.println();
		}
		for(int i=0;i<3;i++)
		{
			
				System.out.print(arr2[i].getSuit()+"   ");
			System.out.print(arr2[i].getRank());
			System.out.println();
		}
		//System.out.println(participant);
		for(String key:participant.keySet())
		{
			Cards[] values = participant.get(key); 
			//System.out.print(values);
		    //System.out.println();
		}
//		for(int k=0;k<values.length;j++)
//	    {
//	    	System.out.print(values);
//	    }
//		
		//System.out.println(participant);
	}
	private int rankW=0,suitW=0;
	private int result1[]=new int[3];
	private int result2[]=new int[3];
	public void getWeight()
	{
		for(int i=0;i<arr1.length;i++)
		{
			rankW=card.rankWeight(arr1[i].getRank());
			suitW=card.suitWeight(arr1[i].getSuit());
			result1[i]=calculate(rankW,suitW);
			//return result;
			//System.out.print(suitW+"   ");
			//System.out.println();
			//System.out.print(rankW);
			//System.out.println();
			System.out.print(result1[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<arr2.length;i++)
		{
			rankW=card.rankWeight(arr2[i].getRank());
			suitW=card.suitWeight(arr2[i].getSuit());
			result2[i]=calculate(rankW,suitW);
			//return result;
//			System.out.print(rankW);
//			System.out.println();
//			System.out.print(suitW);
//			System.out.println();
			System.out.print(result2[i]+"  ");
		}
		System.out.println();
	}
	public int calculate(int rankW,int suitW)
	{
		return (rankW*4)+suitW;
	}
	int maxIndex1= 0,maxval1=0;
	int maxIndex2= 0,maxval2=0;
	public void winner()
	{
//		Arrays.sort(result1);
//		Arrays.sort(result2);
		
		//int maxIndex1= 0,maxval1=0;
	    for (int i = 0; i < result1.length; i++) {
	        if (result1[i] > maxval1) 
	        {
	        	maxval1=result1[i];
	            maxIndex1 = i;
	        }
	    }
	    //System.out.println(maxIndex1);
	    System.out.println("Highest Card is "+arr1[maxIndex1]);
	    
	    //int maxIndex2= 0,maxval2=0;
	    for (int i = 0; i < result2.length; i++) {
	        if (result2[i] > maxval2) 
	        {
	        	maxval2=result2[i];
	            maxIndex2 = i;
	        }
	    }
	    //System.out.println(maxIndex2);
	    System.out.println("Highest Card is "+arr2[maxIndex2]);
	    
//	    for(int i=0;i<result1.length;i++)
//		{
//			if(result1[i]>max1)
//				max1=result1[i];
//		}
//		for(int i=0;i<result2.length;i++)
//		{
//			if(result2[i]>max2)
//				max2=result2[i];
//		}
		//System.out.println(max1); //result1[result1.length-1]
		//System.out.println(max2);  //result2[result2.length-1]
		if(maxval1>maxval2)
			System.out.println("Winner is Rishin");
		else
			System.out.println("Winner is Sayantani");
	}
	public Cards[] getArr1()
	{
		return arr1;
	}
	public Cards getHigh1()
	{
		return arr1[maxIndex1];
	}
	public Cards[] getArr2()
	{
		return arr2;
	}
	public Cards getHigh2() {
		// TODO Auto-generated method stub
		return arr2[maxIndex2];
	}
	public String winName()
	{
		if(maxval1>maxval2)
			return "Rishin";
		else
			return "Sayantani";
	}
	public int pointsEarned()
	{
		if(maxval1>maxval2)
			return maxval1;
		else
			return maxval2;
	}
}
