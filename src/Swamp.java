import java.util.Scanner;
public class Swamp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Grid map =  new Grid(1,3,3,1);
		map.print();
		while(map.win()==false)
		{
			map.move(input.nextLine());
			
		}
		//int c = 1;
		//System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
		//for(c=1;c<450;c++)
			//System.out.println((char)c);
		//System.out.print("1");
		//System.out.println("[_|");
		input.close();
	}

}
