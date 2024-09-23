import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EILINKEA {

	static StringBuilder sb = new StringBuilder();
	static InputReader reader = new InputReader(System.in);
	
	 public static class LinkedList<T extends Number> {

		  static private class LinkedNode<U extends Number> {
		   U number;
		   LinkedNode<U> next;
		   
		   public LinkedNode(U number) {
		    this.number = number;
		   }
		  }
		  LinkedNode<T> head = null;
		  int size =0;
		  public void insertAt(int index, T number) {
		   LinkedNode<T> node = new LinkedNode<>(number);
		   if (head == null) {
		    head = node;
		   } else {
		    node.next = head;
		    head = node;
		   }
		   size++;
		  }
		  
		  public int getSize() {
		   return size;
		  }
		  
		  
		  public T getAt(int index) {
		   LinkedNode<T> temHead = head;   
		   for (int i = 0; i < index; i++) {
		    temHead = temHead.next;
		   }
		   return temHead.number;
		  }
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		  int o = reader.nextInt();
		  int numOfCommand = reader.nextInt();
		  for (int i = 0; i < numOfCommand; i++) {
		   String command = reader.next();
		   switch (command) {
		   case "insertAt":
		    int index = reader.nextInt();
		    int number = reader.nextInt();
		    linkedList.insertAt(index, number);
		    break;
		   case "getAt":
		    int indexx = reader.nextInt();
		    if(indexx>=0&&indexx<linkedList.getSize()) {
		     sb.append(linkedList.getAt(indexx)).append("\n");
		    }else
		     sb.append("null").append("\n");
		    
		    break;
		   }
		  }
		  System.out.println(sb);
		
	}
	
	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
