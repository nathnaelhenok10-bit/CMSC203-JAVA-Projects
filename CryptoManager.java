/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

package cmsc1;
public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/** 
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students
    	
    	if(!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds, Try again.";
    	}
    	
    	String encryptedText = "";
    	
    	for(int i = 0; i < plainText.length(); i++) {
    		
    		char current = plainText.charAt(i);
    		char keyChar = key.charAt(i % key.length());
    		
    		int shift = keyChar - 'A';
    		
    		current = (char)(current + shift);
    		
    		if(current > UPPER_RANGE) {
    			
    			current = (char)(current - RANGE);
    			
    		}
    		
    		encryptedText += current;
    	}
    	
    	return encryptedText;
    	
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         //to be implemented by students
    	
        String plainText = "";
    	
    	for(int i = 0; i < encryptedText.length(); i++) {
    		
    		char current = encryptedText.charAt(i);
    		char keyChar = key.charAt(i % key.length());
    		
    		int shift = keyChar - 'A';
    		
    		current = (char)(current - shift);
    		
    		if(current < LOWER_RANGE) {
    			
    			current = (char)(current + RANGE);
    			
    		}
    		
    		plainText += current;
    	}
    	
    	return plainText;
    	
    	
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
         //to be implemented by students
    	
    	if(!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds, Try again.";
    	}
    	
    	char[][] matrix = playfairMatrix(key);
    	
    	String encryptedText = "";
    	
    	for(int i = 0; i < plainText.length(); i += 2) {
    		
    		char first = plainText.charAt(i);
    		char second = plainText.charAt(i + 1);
    		
    		int firstRow = 0;
    		int firstColumn = 0;
    		int secondRow = 0;
    		int secondColumn = 0;
    		
    		for (int row = 0; row < 8; row++) {
    			for (int column = 0; column < 8; column++) {
    				
    				if(matrix[row][column] == first) {
    					
    					firstRow = row;
    					firstColumn = column;
    				}
    				
    				if(matrix[row][column] == second) {
    					
    					secondRow = row;
    					secondColumn = column;
    				}
    			}
    		}
    		
    		if(firstRow == secondRow) {
    			
    			encryptedText += matrix[firstRow][(firstColumn + 1) % 8];
    			encryptedText += matrix[secondRow][(secondColumn + 1) % 8];
    			
    		} else if(firstColumn == secondColumn) {
    			
    			encryptedText += matrix[(firstRow + 1) % 8][firstColumn];
    			encryptedText += matrix[(secondRow + 1) % 8][secondColumn];
    			
    		} else {
    			encryptedText += matrix[firstRow][secondColumn];
    			encryptedText += matrix[secondRow][firstColumn];
    			
    		}
    	}
    	
    	return encryptedText;
    }
	

	// Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
         //to be implemented by students
    	
        char[][] matrix = playfairMatrix(key);
    	
    	String plainText = "";
    	
    	for(int i = 0; i < encryptedText.length(); i += 2) {
    		
    		char first = encryptedText.charAt(i);
    		char second = encryptedText.charAt(i + 1);
    		
    		int firstRow = 0;
    		int firstColumn = 0;
    		int secondRow = 0;
    		int secondColumn = 0;
    		
    		for (int row = 0; row < 8; row++) {
    			for (int column = 0; column < 8; column++) {
    				
    				if(matrix[row][column] == first) {
    					
    					firstRow = row;
    					firstColumn = column;
    				}
    				
    				if(matrix[row][column] == second) {
    					
    					secondRow = row;
    					secondColumn = column;
    				}
    			}
    		}
    		
    		if(firstRow == secondRow) {
    			
    			plainText += matrix[firstRow][(firstColumn + 7) % 8];
    			plainText += matrix[secondRow][(secondColumn + 7) % 8];
    			
    		} else if(firstColumn == secondColumn) {
    			
    			plainText += matrix[(firstRow + 7) % 8][firstColumn];
    			plainText += matrix[(secondRow + 7) % 8][secondColumn];
    			
    		} else {
    			
    			plainText += matrix[firstRow][secondColumn];
    			plainText += matrix[secondRow][firstColumn];
    			
    		}
    	}
    	
    	return plainText;
    }

// 8x8 matrix for playfair Cipher
    private static char[][] playfairMatrix(String key) {
		
    	char[][] matrix = new char[8][8];
    	
    	String combined = "";
    	
    	for(int i = 0; i < key.length(); i++) {
    		
    		char current = key.charAt(i);
    		
    		if (ALPHABET64.indexOf(current) >= 0 && combined.indexOf(current) == -1) {
    			
    			combined += current;
    		}
    	}
    	
    	for(int i = 0; i < ALPHABET64.length(); i++) {
    		
    		char current = ALPHABET64.charAt(i);
    		
    		if(combined.indexOf(current) == -1) {
    			
    			combined += current;
    			
    		}
    	}
    	
    	int index = 0;
    	
    	for(int row = 0; row < 8; row++) {
    		
    		for(int column = 0; column < 8; column++) {
    			
    			
    			
    			matrix [row][column] = combined.charAt(index);
    			index++;
    		}
    	}
    	
    	
    	
    	return matrix;
	}
    
    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
	//to be implemented by students
    	
    	if(!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds, Try again.";
    	}
    	
    	String encryptedText = "";
    	
    	for(int i = 0; i < plainText.length(); i++) {
    		
    		char current = plainText.charAt(i);
    		
    		current = (char)(current + key);
    		
    		if (current > UPPER_RANGE) {
    			
    			current = (char)(current - RANGE);
    			
    		}
    		
    		encryptedText += current;
    		
    	}
    	
    	return encryptedText;
    
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
	//to be implemented by students
    	
    	String plainText = "";
    	
    	for(int i = 0; i < encryptedText.length(); i++) {
    		
    		char current = encryptedText.charAt(i);
    		
    		current = (char)(current - key);
    		
    		if(current < LOWER_RANGE) {
    			
    			current = (char)(current + RANGE);
    			
    		}
    		
    		plainText += current;
    	}
    	
    	return plainText;
    }    

}
