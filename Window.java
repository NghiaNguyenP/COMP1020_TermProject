package COMP1020_TermProject;

import java.awt.*;
import java.io.*;
import java.util.*;
public class Window extends Frame {
	private static final long serialVersionUID = -1324363758675184283L;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer st;
	private int numOfPlayers;
	Window (int numOfPlayers) throws IOException {
		// System.out.println("Enter number of players: ");
		// numOfPlayers = readInt();
		this.numOfPlayers = numOfPlayers;
		setTitle("Tetris");
		setSize(400*numOfPlayers, 600);
		setLocation(100, 100);
		setResizable(false);
		add(new TetrisPanel(numOfPlayers));
		setVisible(true);
	}
	private String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	private int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}
