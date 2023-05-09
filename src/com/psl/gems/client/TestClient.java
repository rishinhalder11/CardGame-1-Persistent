package com.psl.gems.client;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestClient {

	public static void main(String[] args) throws Exception {
		ArrayList<Player> player = new ArrayList<Player>();
		Player p1 = new Player("Rishin");
		Player p2 = new Player("Sayantani");

		player.add(p1);
		player.add(p2);

		String[] suits = { "CLUB", "DIAMOND", "HEART", "SPADE" };
		String[] ranks = { "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN",
				"KING", "ACE" };
		Cards[] deck = new Cards[52];
//        int index = 0;
//
//        for (int i = 0; i < suits.length; i++) {
//            for (int j = 0; j < ranks.length; j++) {
//                deck[index] = new Cards(suits[i], ranks[j]);
//                index++;
//            }
//        }
//        for(int i=0;i<deck.length;i++)
//        {
//        	System.out.println(deck[i]);
//        }
		Game g = new Game();
		g.shuffle(deck, suits, ranks);

		// Printing all shuffled elements of cards
//      for (int i = 0; i < 52; i ++)
//         System.out.print(a[i]+" ");
//      	System.out.println();
//      for(Player p:player)
//      {
//    	  System.out.println(p);
//      }
		if (player.size() == 2) {
			// g.play();
			g.play(deck, player);
			g.getWeight();
			g.winner();
		}
		Cards arr1[] = g.getArr1();
		Cards arr2[] = g.getArr2();
		Cards high1 = g.getHigh1();
		// System.out.println(high1);
		Cards high2 = g.getHigh2();
		// System.out.println(high2);
//      for(Cards c:arr1)
//      {
//    	  System.out.println(c);
//      }
		String htmlFileName = "game.html";
		FileOutputStream fos = new FileOutputStream(htmlFileName);
		PrintWriter pw = new PrintWriter(fos);
		pw.println("<html>");
		pw.println("<head><title>Document</title></head>");
		pw.println("<body>");
		pw.println("<section>");
		String name1 = p1.getName();
		pw.printf("<div id=\"%s\">", name1);// ("<div id="+p1.getName()+">");
		pw.println();
		String w1 = "high1";
		pw.printf("<div class=\"%s\" data-card=\"%s\"/>", w1, high1);
		pw.println();
		String class1 = "p1";
		for (Cards c : arr1) {
			pw.printf("<div class=\"%s\" data-card=\"%s\"/>", class1, c);
			pw.println();
		}
		pw.println("</div>");
		String name2 = p2.getName();
		pw.printf("<div id=\"%s\">", name2);
		pw.println();
		String w2 = "high2";
		pw.printf("<div class=\"%s\" data-card=\"%s\"/>", w2, high2);
		pw.println();
		String class2 = "p2";
		for (Cards c : arr2) {
			pw.printf("<div class=\"%s\" data-card=\"%s\"/>", class2, c);
			pw.println();
		}
		pw.println("</div>");
		String winner = g.winName();
		pw.printf("<div class=\"win\" id=\"%s\"/>", winner);
		pw.println();
		int points=g.pointsEarned();
		pw.printf("<div class=\"points\" id=\"%s\"/>",points);
		pw.println();
		pw.println("</section>");
		pw.println("<script src=" + "card.js" + ">");
		pw.println("</script>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		fos.close();
	}
}
