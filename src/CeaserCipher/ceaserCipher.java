package CeaserCipher;

import java.util.Scanner;

public class ceaserCipher {

	/*
	 * HELLO WORLD-->IFMMP XPSME Bir sonraki harfi ile sifrelenir. Kullanıcıdan
	 * negatif değer alnırsa, -1=25 -2=24 -3=23 -27=25 gibi dönüstürülcek.
	 * Kullanıcıdan sifrelenicek String alınıcak 'E/D' gibi iki farklı deger
	 * alınıcak. encrypt=A ile Z arasında anahtar kadar arttırılıcak. ÖR: A+1=B ,
	 * A+25=Z , Z+2=B gibi. decrypt=verilen sifrelenmis mesajı anahtar ile
	 * cözümleyecek. //A B C D E her birinin sayı olduğunu düşünün A=1, B=2, C=3,
	 * D=4, E=5 HELLO WORD --> IFMMP XPSME
	 * 
	 * 
	 * ascii de a->65, A->97 a'yı sıfır kabul ederek yapmalıyız
	 * 
	 * 
	 * modda dusun
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); //
		System.out.println("Enter a word: ");

		String word = input.nextLine();  //Kac harf sonrasını istediğimizi belirledik.
		System.out.println("Enter a number: ");

		int number = input.nextInt();
		if (number < 0)  //Eğer sayi negatif iste alfabedeki 26 harf sayısıdan cıkarıcak.
			number = 26 + number;

		System.out.println("\nReturn value is: " + encryptFun(word, number));

	}

	public static String encryptFun(String word, int num) {

		String newWord = "";
		String returnWord;
		// char letter = 0;
		int indx = 0;
		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) <= 'z' && word.charAt(i) >= 'a')
			/* if(word.charAt(i)+num-'a' >=26) */
			{
				/*
				 * letter = 0; letter+=word.charAt(i)+num; letter+=i%26; newWord+=letter;
				 */
				newWord += (char) ('a' + (word.charAt(i) + num - 'a') % 26);

			} else if (word.charAt(i) <= 'Z' && word.charAt(i) >= 'A') { // 65 ile 90

				/*
				 * letter = 0;letter+=word.charAt(i)+num; newWord+=letter; letter+=i%26;
				 */
				newWord += (char) ('A' + (word.charAt(i) + num - 'A') % 26);

			} else if (word.charAt(i) == ' ') {

				indx = word.indexOf(" ");
				returnWord = newWord.substring(0, indx);
				returnWord += "";
				returnWord += newWord.substring(indx, word.length());
				newWord = "";
				newWord = returnWord;

			} else {
				System.out.println("Please enter a word..");
			}
		}

		return newWord;
	}

}