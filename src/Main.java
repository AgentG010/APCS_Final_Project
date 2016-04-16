import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main
{
	private Player[] players;

	// for cmd line inputs, will be replaced by GUI input
	private BufferedReader br;

	public static void main(String[] args) throws IOException
	{
		Main riskGame = new Main();
		riskGame.play();
	}

	private void play() throws IOException
	{
		// TODO: implement GUI
		init();

		while (players.length > 1)
		{
			for (Player p : players)
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

				// Phase 3: Fortify an owned territory
				fortifyTroops(p);

			}
		}
	}

	// right this is ugly but it's for testing purposes XD
	private void attackOther(Player p) throws IOException
	{
	    boolean doneAttacking = false;
	    while(!doneAttacking)
	    {
	        System.out.print("Do you wish to continue attacking? (y/n): ");
	        String input = br.readLine();
	        if(input != null && input.toLowerCase().charAt(0) == 'n')
	        {
	            doneAttacking = true;
	            System.out.println("Done attacking");
	            return;
	        }

            String territoryFrom = "", territoryTo = "";
            int numArmies = 0;

            System.out.println("Choose a territory to attack");
            boolean valid = false;
            System.out.println(getAttackTargets(p));

            while (!valid)
            {
                territoryTo = br.readLine();
                if (p.getOccupiedTerritories().contains(territoryTo))
                {
                    System.out.println("Nice try you own this one");
                } else if (!getAttackTargets(p).contains(territoryTo))
                {
                    System.out.println("can't attack");
                } else
                {
                    valid = true;
                }
            }
            Territory t = TerritoryMap.get(territoryTo);
            Set<String> available = t.getAdjacentTerritoriesOccupiedBy(p);
            System.out.println("Choose a territory to attack from:");
            System.out.println(available);

            valid = false;
            while (!valid)
            {
                territoryFrom = br.readLine();
                if(!t.getAdjacentTerritories().contains(territoryFrom))
                {
                    System.out.println("no");
                }
                else
                {
                    valid = true;
                }
                
            }

            System.out.println(
                    "Choose number of armies to attack with. Opponent has " + TerritoryMap.get(territoryTo).getNumArmies());
            System.out.println("You have: " + TerritoryMap.get(territoryFrom).getNumArmies());
            valid = false;
            numArmies = 0;
            while (!valid)
            {
                String numArmiesStr = br.readLine();
                if (numArmiesStr.equals(""))
                    numArmies = 1;
                else if (numArmiesStr.equals("all"))
                    numArmies = TerritoryMap.get(territoryFrom).getNumArmies()-1;
                else
                {
                    try
                    {
                        numArmies = Integer.parseInt(numArmiesStr);
                    } catch (NumberFormatException e)
                    {
                        System.err.println("Bad number of armies");
                        continue;
                    }
                }
                if (numArmies <= 0 || numArmies > TerritoryMap.get(territoryFrom).getNumArmies() - 1)
                {
                    System.out.println("no");
                } else
                {
                    valid = true;
                }
            }
            p.attackOther(TerritoryMap.get(territoryFrom), TerritoryMap.get(territoryTo), numArmies);
	    }
	}

	// Returns all territories that can be attacked by Player p
	private Set<String> getAttackTargets(Player p)
	{
		Set<String> returnSet = new HashSet<String>();
		Set<String> playerSet = p.getOccupiedTerritories();
		for (String s : playerSet)
		{
			Territory t = TerritoryMap.get(s);
			Set<String> neighbors = t.getAdjacentTerritories();
			for (String k : neighbors)
			{
				if (!playerSet.contains(k))
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

		int numPlayers = getNumPlayers();
		players = new Player[numPlayers];

		// initialize players manually for testing purposes
		players[0] = new Player("George", "Germany");
		players[1] = new Player("Richard Test", "China");

		// for(int i = 0; i < numPlayers; i++)
		// {
		// String name = "Derp" + i;
		// String territoryID = "null";
		//
		// //TODO: Change these displays to GUI later and pass in values to
		// variables
		// System.out.println("Player " + (i + 1) + ": Enter name");
		// System.out.println("Player " + (i + 1) + ": Choose Territory");
		//
		// players[i] = new Player(name, territoryID);
		// }
	}

	private void deployReinforcements(Player p) throws IOException
	{

		System.out.println("Phase 1: Deploy Reinforcements");
		p.calculateReinforcements();
		while (p.getNumReinforcementsAvailable() > 0)
		{
			System.out.println("Total reinforcements for " + p.getName() + ": " + p.getNumReinforcementsAvailable());
			System.out.print("Select territory to deploy to: ");
			String territory = br.readLine();

			if (!p.ownsTerritory(territory))
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
				if (numArmiesStr.equals(""))
					numArmies = 1;
				else if (numArmiesStr.equals("all"))
					numArmies = p.getNumReinforcementsAvailable();
				else
					numArmies = Integer.parseInt(numArmiesStr);
			} catch (NumberFormatException e) // In case user enters
												// non-numerical value
			{
				System.err.println("Bad number of armies to deploy, try again");
				continue;
			}

			// Check if numArmies is valid
			if (numArmies < 0 || numArmies > p.getNumReinforcementsAvailable())
			{
				System.err.println("You do not have such number of armies, try again");
			} else if (numArmies == 0)
			{
				System.out.println("Cancelling deploy to " + territory);
			} else
			{
				System.out.println("Deploying " + numArmies + " to " + territory);
				p.deployReinforcements(territory, numArmies);
			}
			System.out.println();
		}
	}

	private void fortifyTroops(Player p) throws IOException
	{
		if (p.getOccupiedTerritories().size() == 1)
		{
			System.out.println("Nothing to fortify");
			return;
		}

		Boolean isDone = false;
		while (!isDone)
		{
			System.out.println("Select a territory to fortify");
			System.out.println(p.getOccupiedTerritories());
			String fortified = br.readLine();

			if (fortified.equals(""))
			{
				System.out.println("Not fortifying anything");
				isDone = true;
				continue;
			}
			if (!p.ownsTerritory(fortified))
			{
				System.err.println("You do not own this territory");
				continue;
			}
			Territory fortifiedTer = TerritoryMap.get(fortified);
			System.out.println(fortified + " has " + fortifiedTer.getNumArmies() + " armies");

			System.out.println("Select a territory to fortify from");
			System.out.println(fortifiedTer.getAdjacentTerritoriesOccupiedBy(p));
			String fortifier = br.readLine();

			if (!p.ownsTerritory(fortifier))
			{
				System.err.println("You do not own this territory");
				continue;
			}

			Territory fortifierTer = TerritoryMap.get(fortifier);
			System.out.println(fortifier + " has " + fortifierTer.getNumArmies() + " armies");

			if (!fortifiedTer.isNeighborWith(fortifier))
			{
				System.err.println("territories are not neighbors");
				continue;
			}

			System.out.println("Number of armies to send (default 1):");
			String numArmiesStr = br.readLine();
			int numArmies;

			if (numArmiesStr.equals(""))
				numArmies = 1;
			else if (numArmiesStr.equals("all"))
				numArmies = fortifierTer.getNumArmies() - 1;
			else
			{
				try
				{
					numArmies = Integer.parseInt(numArmiesStr);
				} catch (NumberFormatException e)
				{
					System.err.println("Bad number of armies");
					continue;
				}
			}

			if (numArmies >= fortifierTer.getNumArmies())
			{
				System.err.println("Number of armies exceeds the amount ");
				continue;
			} else if (numArmies < 0)
			{
				System.err.println("Invalid number of armies");
				continue;
			} else if (numArmies == 0)
			{
				System.out.println("Not fortifying anything");
				isDone = true;
				continue;
			}

			fortifierTer.decrementArmiesBy(numArmies);
			fortifiedTer.incrementArmiesBy(numArmies);

			isDone = true;
		}
	}

	private int getNumPlayers()
	{
		// TODO: get input from player
		return 2;
	}
}
