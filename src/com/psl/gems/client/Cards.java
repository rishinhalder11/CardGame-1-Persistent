package com.psl.gems.client;

public class Cards {
	private String suit;
    private String rank;
    

    public Cards() {
		super();
	}

	public Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

	@Override
	public String toString() {
		return suit+"-"+rank;     //Cards [suit=" + suit + ", rank=" + rank + "]
	}
    public int suitWeight(String suitType)
    {
//    	String suitType="";
//    	for(int i=0;i<deck.length;i++)
//    	{
//    		suitType=deck[i].getSuit();
    		switch(suitType)
    		{
    			case "CLUB":
    				return 0;
    			case "DIAMOND":
    				return 1;
    			case "HEART":
    				return 2;
    			case "SPADE":
    				return 3;
    			default:
    				return -1;
    		}
    		
//    	}
    }
    public int rankWeight(String rankType)   //Cards deck[]
    {
//    	String rankType="";
//    	for(int i=0;i<deck.length;i++)
//    	{
//    		rankType=deck[i].getRank();
    		switch(rankType)
    		{
    			case "TWO":
    				return 0;
    			case "THREE":  
    				return 1;
    			case "FOUR":
    				return 2;
    			case "FIVE":
    				return 3;
     			case "SIX":
    				return 4;
     			case "SEVEN":
    				return 5;
    			case "EIGHT":
    				return 6;
    			case "NINE":
    				return 7;
    			case "TEN":
    				return 8;    
    			case "JACK":
    				return 9;
    			case "QUEEN":
    				return 10;
     			case "KING":
    				return 11;
    			case "ACE":
    				return 12;
    			default:
    				return -1;
    		}
    		
    	//}
    }
        
}
