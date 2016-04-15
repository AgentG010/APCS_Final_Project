import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main 
{
	private Player[] players;
	private int numPlayers;
	
	// for cmd line inputs, will be replaced by GUI input
	private BufferedReader br;
	
	public static void main(String[] args) throws IOException
	{
		Main riskGame = new Main();
		riskGame.play();
	}
	
	private void play() throws IOException
	{
		//TODO: implement GUI
		init();
		
		Die_Roll die;
		

		while(true)
		{
			for(Player p : players)
			{
				// CMDLine stuff, will be replaced by GUI Output
				String playerName = p.getName();
				Set<String> territories = p.getOccupiedTerritories();

				System.out.println("====================");
				System.out.println(playerName + "'s turn");
				System.out.println("--------------------");
				System.out.println(playerName + "'s territories:");
				System.out.println(territories);

				// Phase 1: Deploy Reinforcements
				deployReinforcements(p);
				
				// Phase 2: Attack a territory
				attackOther(p);
				
			}
		}
	}
	//right this is ugly but it's for testing purposes XD
	public void attackOther(Player p) throws IOException
	{
		System.out.println("Choose a territory to attack");
		System.out.println(getAvailableNeighbors(p));
		String territoryTo = br.readLine();
		Territory t = TerritoryMap.get(territoryTo);
		Set<String> temp = new HashSet<String>();
		for(String s : t.getAdjacentTerritories())
		{
			if(p.ownsTerritory(s))
			{
				temp.add(s);
			}
		}
		System.out.println("Choose a territory to attack from:");
		System.out.println(temp);
		String territoryFrom = br.readLine();
		System.out.println("Choose number of armies to attack with. Opponent has" + TerritoryMap.get(territoryTo).getNumArmies());
		int numArmies = br.read();
		p.attackOther(TerritoryMap.get(territoryFrom), TerritoryMap.get(territoryTo), numArmies);
		
	}
	//Lol o(n^2) what is this garbage code i just wrote
	public Set<String> getAvailableNeighbors(Player p)
	{
		Set<String> returnSet = new HashSet<String>();
		Set<String> playerSet = p.getOccupiedTerritories();
		for(String s:playerSet)
		{
			Territory t = TerritoryMap.get(s);
			Set<String> neighbors = t.getAdjacentTerritories();
			for(String k : neighbors)
			{
				if(!playerSet.contains(k))
				{
					returnSet.add(k);
				}
			}
		}
		return returnSet;
	}
	
	/*
	 * Initialize the players and the TerritoryMap
	 */
	private void init()
	{
		TerritoryMap.init();
		
		// For cmd line inputs, will be replaced by GUI inputs
		br = new BufferedReader(new InputStreamReader(System.in));

		getNumPlayers();
		players = new Player[numPlayers]; 

		// initialize players manually for testing purposes
		players[0] = new Player("George", "Germany");
		players[1] = new Player("Richard Test", "China");

		//for(int i = 0; i < numPlayers; i++)
		//{
		//	String name = "Derp" + i;
		//	String territoryID = "null";
		//	
		//	//TODO: Change these displays to GUI later and pass in values to variables
		//	System.out.println("Player " + (i + 1) + ": Enter name");
		//	System.out.println("Player " + (i + 1) + ": Choose Territory");
		//	
		//	players[i] = new Player(name, territoryID);
		//}
	}

	private void deployReinforcements(Player p) throws IOException
	{
		
			System.out.println("Phase 1: Deploy Reinforcements");
			p.calculateReinforcements();
			while(p.getNumReinforcementsAvailable() > 0)
			{
				System.out.println("Total reinforcements for " + p.getName() + ": " + p.getNumReinforcementsAvailable());
				System.out.print("Select territory to deploy to: ");
				String territory = br.readLine();
					 
				if(!p.ownsTerritory(territory))
				{
					System.err.println("You do not own this territory. Try again");
					continue;
				}
				
				// Get the number of armies to deploy. Can also enter "all"
				// If nothing entered, then assume 1 army
				System.out.println(territory + " has " + TerritoryMap.get(territory).getNumArmies() + " armies on it");
				System.out.print("How many armies to deploy? (default 1): ");
				String numArmiesStr = br.readLine();
				int numArmies = 1;
				try
				{
					if(numArmiesStr.equals(""))
						numArmies = 1;
					else if(numArmiesStr.equals("all"))
						numArmies = p.getNumReinforcementsAvailable();
					else
						numArmies =  Integer.parseInt(numArmiesStr);
				}
				catch(NumberFormatException e) // In case user enters non-numerical value
				{
					System.err.println("Bad number of armies to deploy, try again");
					continue;
				}
				
				// Check if numArmies is valid
				if(numArmies < 0 || numArmies > p.getNumReinforcementsAvailable())
				{
					System.err.println("You do not have such number of armies, try again");
				}
				else if(numArmies == 0)
				{
					System.out.println("Cancelling deploy to " + territory);
				}
				else
				{
					System.out.println("Deploying " + numArmies + " to " + territory);
					p.deployReinforcements(territory, numArmies);
				}
				System.out.println();
			}
	}

	private void getNumPlayers()
	{
		// TODO: get input from player
		numPlayers = 2;
	}
}
