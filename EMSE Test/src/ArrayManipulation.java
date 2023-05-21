import java.util.Arrays;

public class ArrayManipulation {
	
	/*
	 * Diese Methode soll das uebergebene Array "umdrehen".
	 * Das heisst: das letzte Element steht nach dem Aufruf an erster Stelle, ...
	 * das erste Element steht an letzter Stelle.
	 * Es soll wieder nichts zurueckgegeben werden, das uebergebene Array soll stattdessen veraendert werden.
	 */
	public static void reverse(int[] array) {
		
		int[] neu = new int[array.length];
		
		for (int i = array.length-1, a = 0; i>=0; i--, a++) {
			
			neu[a] = array[i];
		}
		
		for (int i = 0 ; i<array.length ; i++) {
			
			array[i] = neu[i];
			
		}
		
	}
	
	//In der Main Methode kannst du deine Methoden testen
	public static void main(String[] args) {
		int[] test = new int[]{1,2,3,4,5};
		reverse(test);
		System.out.println("Diese Ausgabe sollte [5, 4, 3, 2, 1] sein: "+Arrays.toString(test));
	}
}