package userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

import battle.BattleResults;
import card.Card;
import main.Player;

public class GUIManager implements UserInterface
{
	private JFrame window;
	private JPanel panel;
	BufferedReader br;

	public GUIManager()
	{
		br = new BufferedReader(new InputStreamReader(System.in));

		window = new JFrame();
		window.setTitle("Risk (GUI TEST)");
		window.setSize(1200, 700);

		panel = new JPanel(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();

		// add the elements


		//window.add(new JLabel(new ImageIcon("Risk_Final_Map.png")));

		//Allows termination of program when closed
		window.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
		});

		window.setVisible(true);
	}

	////////////////////////////////////////////////////////////
	//	Init Methods
	////////////////////////////////////////////////////////////

	@Override
	public int getNumPlayers()
	{
		return GUI_Init.getNumPlayers();
	}

	@Override
	public String getPlayerName()
	{
		return GUI_Init.getPlayerName();
	}

	@Override
	public String getStartingTerritory(String playerName)
	{
		return GUI_Init.getStartingTerritory(playerName);
	}

	////////////////////////////////////////////////////////////
	//	Pre Player Turn Methods
	////////////////////////////////////////////////////////////

	@Override
	public void promptPlayerTurn(Player p)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub

	}

	////////////////////////////////////////////////////////////
	//	Use Card Methods
	////////////////////////////////////////////////////////////

	@Override
	public Card selectCard(Player p)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean promptUseCard()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean promptTradeCard()
	{
		// TODO Auto-generated method stub
		return false;
	}

	////////////////////////////////////////////////////////////
	//	Deploy Armies methods
	////////////////////////////////////////////////////////////

	@Override
	public String getDeployTerritory(Player p)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumArmiesToDeploy(Player p, String deployTerritory)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////
	//	Attack Territories methods
	////////////////////////////////////////////////////////////

	@Override
	public boolean getFinishedAttacking()
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTerritoryToAttack(Player p)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTerritoryToAttackFrom(Player p, String territoryToAttack)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumArmiesToAttackWith(Player p, String territoryToAttackID, String territoryToAttackFromID)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displayBattleResults(BattleResults results)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub

	}

	////////////////////////////////////////////////////////////
	//	Fortify Troops methods
	////////////////////////////////////////////////////////////

	@Override
	public boolean getWantsToFortify(Player p)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTerritoryToFortify(Player p)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTerritoryToFortifyFrom(Player p, String terrID)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumArmiesToFortify(String terrToFortFrom)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub
		return 0;
	}

	////////////////////////////////////////////////////////////
	//	Utility Methods
	////////////////////////////////////////////////////////////

	@Override
	public void generateWarning(String string)
	{
		System.err.println("Unimplemented Feature"); // TODO Auto-generated method stub

	}
}
