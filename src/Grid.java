import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
public class Grid{
	private int grid[][] = new int[30][30];
	private int positionPX;
	private int positionPY;
	private int positionTX;
	private int positionTY;
	private int counter=0;
	private int positionTreasureX[] = new int[600];
	private int positionTreasureY[] = new int[600];
	private Random rand = new Random();
	private int treasures=0;
	public Grid(int positionPX,int positionPY,int positionTX, int positionTY)
	{
		
		Scanner file =  new Scanner(System.in);
		try {
			file = new Scanner(new FileReader("map.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
			{
				if(file.hasNextInt())
				{
					grid[i][j]= file.nextInt();
					if(grid[i][j]==0)
					{
						counter++;
						positionTreasureX[counter]=i; 
						positionTreasureY[counter]=j;
					}
					
				}
			}
		this.positionPX = positionPX;
		this.positionPY = positionPY;
		this.positionTX = positionTX;
		this.positionTY = positionTY;
		file.close();
	}
	public void move(String direction)
	{
		switch(direction)
		{
		case "north":
			if(grid[positionPX-1][positionPY]==0)
				positionPX=positionPX-1;
			break;
		case "south":
			if(grid[positionPX+1][positionPY]==0)
				positionPX=positionPX+1;
			break;
		case "east":
			if(grid[positionPX][positionPY+1]==0)
				positionPY=positionPY+1;
			break;
		case "west":
			if(grid[positionPX][positionPY-1]==0)
				positionPY=positionPY-1;

			break;
		case "8":
			if(grid[positionPX-1][positionPY]==0)
				positionPX=positionPX-1;
			break;
		case "2":
			if(grid[positionPX+1][positionPY]==0)
				positionPX=positionPX+1;
			break;
		case "6":
			if(grid[positionPX][positionPY+1]==0)
				positionPY=positionPY+1;
			break;
		case "4":
			if(grid[positionPX][positionPY-1]==0)
				positionPY=positionPY-1;

			break;
			
		}
		print();
	}
	public boolean win()
	{
		
		if(positionPX==positionTX && positionPY==positionTY && treasures<=2)
		{
			treasures++;
			int random=rand.nextInt(counter);
			if(random==counter)
				random--;
			positionTX=positionTreasureX[random];
			positionTY=positionTreasureY[random];
			
		}
		else
			if(positionPX==positionTX && positionPY==positionTY && treasures>2)
				return true;
		return false;
	}
	public void print()
	{
		System.out.print("The distance to the treasure is: " + Math.hypot(positionPX - positionTX, positionPY- positionTY));
		System.out.println();
		for(int i=0;i<30;i++)
		{
			
			for(int j=0;j<30;j++)
				if(grid[i][j]==2)
				{
					if(j==0 || j==29)
						System.out.print("| ");
					if((i==0 || i==29) && (j!=0 && j!=29))
						System.out.print("= ");
					if((i!=0 && i!=29) && (j!=0 && j!=29))
					{
						if(grid[i-1][j]==0 && grid[i+1][j]==0 )
							System.out.print("= ");
						else
							if(grid[i][j-1]==0 && grid[i][j+1]==0 )
								System.out.print("| ");
							else
								System.out.print("= ");
					}
				}
				else
					if(i==positionPX && j==positionPY)
						System.out.print("P ");
					else
						System.out.print(". ");
			System.out.println();
		}
	}
}