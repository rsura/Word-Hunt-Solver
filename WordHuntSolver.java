import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordHuntSolver{
    // All of possible English words in a hashset for constant lookup time
    private static final Set<String> englishWords = new HashSet<>(172821);

    // All of the possible words to be found
    private static final Set<String> foundWords = new HashSet<>(100);

    // Minimum word size (since bigger words are worth more in this game)
    private static final int minWordSize = 4;

    // Maximum word size (since it's unlikely to have a word that can be found in this game)
    private static final int maxWordSize = 10;
    
    /**
     * Obtains all the graph nodes of each character in an NxN GraphNode 
     * array. This method assumes you already know the dimension of the NxN grid as well as
     * all the characters in that grid.
     * @param   dimension The side length of the NxN array.
     * @param   allChars All of the characters of grid represented by a String.
     * @return  An NxN array of all the GraphNodes.
     * @throws  InvalidPropertiesFormatException
     */
    private static GraphNode<Character>[][] getInputGraph(int dimension, String allChars) throws InvalidPropertiesFormatException{
		if (allChars.length() != (dimension * dimension)) {
			throw new InvalidPropertiesFormatException("Not " + (dimension * dimension) + " continuous characters");
		}

		char[][] inputCharacters = new char[dimension][dimension];
		int counter = 0;

		for (int i = 0; i < allChars.length(); i++) {
			if (Character.isAlphabetic(allChars.charAt(i))) {
				inputCharacters[counter / dimension][counter % dimension] = Character.toLowerCase(allChars.charAt(i));
				++counter;
			} else {
				throw new InvalidPropertiesFormatException("Not all " + (dimension * dimension) + " characters are alphabetical");
			}
		}
		GraphNode<Character>[][] graphNodes = new GraphNode[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				graphNodes[i][j] = new GraphNode<>(inputCharacters[i][j]);
			}
		}

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
                for(int m: new int[]{-1, 0, 1}){
                    for (int n: new int[]{-1, 0, 1}){
                        if (!(m == 0 && n == 0)){
                            try {
                                GraphNode.connectNodes(graphNodes[i][j], graphNodes[i + m][j + n]);
                            } 
                            catch (ArrayIndexOutOfBoundsException ignored){}
                        }
                    }
                }
			}
		}

		return graphNodes;
	}

    /**
     * (Overloaded method) Obtains the NxN GraphNode by prompting the user to input
     * all N² characters and uses {@link #getInputGraph(int, String)} to actually
     * create the GraphNode connections to be returned.
     * @param   dimension The side length of the NxN array.
     * @return  An NxN array of all the GraphNodes.
     * @throws  InvalidPropertiesFormatException
     * @see     {@link #getInputGraph(int, String)}
     */
    private static GraphNode<Character>[][] getInputGraph(int dimension) throws InvalidPropertiesFormatException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter all " + (dimension * dimension) + " word hunt characters with no spaces in between\n-->\t");
		String input = scanner.nextLine();

		if (input.length() != (dimension * dimension)) {
			throw new InvalidPropertiesFormatException("Not " + (dimension * dimension) + " continuous characters");
		}

		return getInputGraph(dimension, input);
	}


    /**
     * Reads in all the English Words (currently available) from a text file
     * into a HashSet, so that the word can be found quickly.
     * @param   filepath The file path (and file name) for the English Words.
     * @throws  IOException
     */
    private static void readEnglishWords(String filepath) throws IOException {
		englishWords.clear();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String currLine;
		while ((currLine = br.readLine()) != null){
			englishWords.add(currLine);
		}
	}

    public static List<String> run(int dimension){
		return null; // temporary
	}

}