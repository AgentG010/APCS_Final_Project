import java.util.HashMap;
import java.util.HashSet;

/*
 * Instantiates and keeps track of all territories on the map. May get a little ugly because it creates all territories on the map
 * 
 */

public class TerritoryMap
{
	// Holy wall of text, batman

	// Every single territory on the map.

	// North america - 12
	private Territory alaska;
	private Territory alberta;
	private Territory mexico;
	private Territory eastUS;
	private Territory cuba;
	private Territory centralAmerica;
	private Territory northWestTerritory;
	private Territory hawaii;
	private Territory greenland;
	private Territory quebec;
	private Territory ontario;
	private Territory westUS;

	// South america - 5

	private Territory brazil;
	private Territory argentina;
	private Territory peru;
	private Territory venezuela;
	private Territory bolivia;

	// Europe - 13

	private Territory unitedKingdom;
	private Territory iceland;
	private Territory scandinavia;
	private Territory sweden;
	private Territory eastEurope;
	private Territory lowCountries;
	private Territory spain;
	private Territory france;
	private Territory denmark;
	private Territory germany;
	private Territory poland;
	private Territory czechoslovakia;
	private Territory southernEurope;

	// asia - 16

	private Territory saudiArabia;
	private Territory turkey;
	private Territory iran;
	private Territory afganistan;
	private Territory pakistan;
	private Territory india;
	private Territory indochina;
	private Territory china;
	private Territory mongolia;
	private Territory kazakhstan;
	private Territory japan;
	private Territory ural;
	private Territory kamchatka;
	private Territory irkutsk;
	private Territory siberia;
	private Territory yakutsk;

	// Africa - 8

	private Territory morocco;
	private Territory algeria;
	private Territory egypt;
	private Territory eastAfrica;
	private Territory westAfrica;
	private Territory madagascar;
	private Territory southAfrica;
	private Territory congo;

	// Australia - 5

	private Territory eastAustralia;
	private Territory westAustralia;
	private Territory newGuinea;
	private Territory indonesia;
	private Territory philipines;

	// continent collections.
	private HashSet<String> northAmerica;
	private HashSet<String> southAmerica;
	private HashSet<String> africa;
	private HashSet<String> asia;
	private HashSet<String> europe;
	private HashSet<String> australia;
	
	//all locations
	private HashMap<String,Territory> allTerritories;

	public TerritoryMap()
	{
		// Here we go...
		// North America
		alaska = new Territory("Alaska");
		alberta = new Territory("Alberta");
		mexico = new Territory("Mexico");
		eastUS = new Territory("Eastern United States");
		cuba = new Territory("Cuba");
		centralAmerica = new Territory("CentralAmerica");
		northWestTerritory = new Territory("Northwest Territory");
		hawaii = new Territory("Hawaii");
		greenland = new Territory("Greenland");
		quebec = new Territory("Quebec");
		ontario = new Territory("Ontario");
		westUS = new Territory("Western United States");

		// South America
		brazil = new Territory("Brazil");
		argentina = new Territory("Argentina");
		peru = new Territory("Peru");
		venezuela = new Territory("Venezuela");
		bolivia = new Territory("Bolivia");

		// Europe
		unitedKingdom = new Territory("United Kingdom");
		iceland = new Territory("Iceland");
		scandinavia = new Territory("Scandinavia");
		sweden = new Territory("Sweden");
		eastEurope = new Territory("Eastern Europe");
		lowCountries = new Territory("Low Countries");
		spain = new Territory("Spain");
		france = new Territory("France");
		denmark = new Territory("Denmark");
		germany = new Territory("Germany");
		poland = new Territory("Poland");
		czechoslovakia = new Territory("Czechoslovakia");
		southernEurope = new Territory("Southern Europe");

		// Africa
		morocco = new Territory("Morocco");
		algeria = new Territory("Algeria");
		egypt = new Territory("Egypt");
		eastAfrica = new Territory("East Africa");
		westAfrica = new Territory("West Africa");
		madagascar = new Territory("Madagascar");
		southAfrica = new Territory("South Africa");
		congo = new Territory("Congo");

		// Asia
		saudiArabia = new Territory("Saudi Arabia");
		turkey = new Territory("Turkey");
		iran = new Territory("Iran");
		afganistan = new Territory("Afganistan");
		pakistan = new Territory("Pakistan");
		india = new Territory("India");
		indochina = new Territory("Indochina");
		china = new Territory("China");
		mongolia = new Territory("Mongolia");
		kazakhstan = new Territory("Kazakhstan");
		japan = new Territory("Japan");
		ural = new Territory("Ural");
		kamchatka = new Territory("Kamchatka");
		irkutsk = new Territory("Irkutsk");
		siberia = new Territory("Siberia");
		yakutsk = new Territory("Yakutsk");

		// Australia

		eastAustralia = new Territory("Eastern Australia");
		westAustralia = new Territory("Western Australia");
		newGuinea = new Territory("New Guinea");
		indonesia = new Territory("Indonesia");
		philipines = new Territory("Philipines");

		// Set each territory's neighbors. This may take a while.
		// North America
		alaska.addNeighbor(northWestTerritory.getID());
		alaska.addNeighbor(alberta.getID());
		alaska.addNeighbor(kamchatka.getID());

		alberta.addNeighbor(alaska.getID());
		alberta.addNeighbor(westUS.getID());
		alberta.addNeighbor(ontario.getID());
		alberta.addNeighbor(northWestTerritory.getID());

		northWestTerritory.addNeighbor(greenland.getID());
		northWestTerritory.addNeighbor(ontario.getID());
		northWestTerritory.addNeighbor(alaska.getID());
		northWestTerritory.addNeighbor(alberta.getID());

		ontario.addNeighbor(northWestTerritory.getID());
		ontario.addNeighbor(greenland.getID());
		ontario.addNeighbor(quebec.getID());
		ontario.addNeighbor(eastUS.getID());
		ontario.addNeighbor(westUS.getID());
		ontario.addNeighbor(alberta.getID());

		greenland.addNeighbor(iceland.getID());
		greenland.addNeighbor(ontario.getID());
		greenland.addNeighbor(quebec.getID());
		greenland.addNeighbor(northWestTerritory.getID());

		quebec.addNeighbor(greenland.getID());
		quebec.addNeighbor(eastUS.getID());
		quebec.addNeighbor(ontario.getID());

		westUS.addNeighbor(eastUS.getID());
		westUS.addNeighbor(hawaii.getID());
		westUS.addNeighbor(alberta.getID());
		westUS.addNeighbor(ontario.getID());
		westUS.addNeighbor(mexico.getID());

		eastUS.addNeighbor(westUS.getID());
		eastUS.addNeighbor(quebec.getID());
		eastUS.addNeighbor(ontario.getID());
		eastUS.addNeighbor(mexico.getID());
		eastUS.addNeighbor(cuba.getID());

		mexico.addNeighbor(westUS.getID());
		mexico.addNeighbor(centralAmerica.getID());
		mexico.addNeighbor(cuba.getID());
		mexico.addNeighbor(eastUS.getID());

		cuba.addNeighbor(eastUS.getID());
		cuba.addNeighbor(mexico.getID());

		centralAmerica.addNeighbor(venezuela.getID());
		centralAmerica.addNeighbor(mexico.getID());

		hawaii.addNeighbor(westUS.getID());
		hawaii.addNeighbor(japan.getID());

		// South America
		venezuela.addNeighbor(peru.getID());
		venezuela.addNeighbor(brazil.getID());
		venezuela.addNeighbor(centralAmerica.getID());

		peru.addNeighbor(venezuela.getID());
		peru.addNeighbor(brazil.getID());
		peru.addNeighbor(bolivia.getID());
		peru.addNeighbor(argentina.getID());

		bolivia.addNeighbor(brazil.getID());
		bolivia.addNeighbor(argentina.getID());
		bolivia.addNeighbor(peru.getID());

		brazil.addNeighbor(peru.getID());
		brazil.addNeighbor(argentina.getID());
		brazil.addNeighbor(bolivia.getID());
		brazil.addNeighbor(venezuela.getID());
		brazil.addNeighbor(westAfrica.getID());

		argentina.addNeighbor(peru.getID());
		argentina.addNeighbor(bolivia.getID());
		argentina.addNeighbor(brazil.getID());

		// Africa
		southAfrica.addNeighbor(madagascar.getID());
		southAfrica.addNeighbor(congo.getID());
		southAfrica.addNeighbor(eastAfrica.getID());

		madagascar.addNeighbor(southAfrica.getID());
		madagascar.addNeighbor(eastAfrica.getID());

		eastAfrica.addNeighbor(congo.getID());
		eastAfrica.addNeighbor(madagascar.getID());
		eastAfrica.addNeighbor(westAfrica.getID());
		eastAfrica.addNeighbor(saudiArabia.getID());
		eastAfrica.addNeighbor(westAfrica.getID());
		eastAfrica.addNeighbor(egypt.getID());

		congo.addNeighbor(eastAfrica.getID());
		congo.addNeighbor(westAfrica.getID());
		congo.addNeighbor(southAfrica.getID());

		westAfrica.addNeighbor(brazil.getID());
		westAfrica.addNeighbor(algeria.getID());
		westAfrica.addNeighbor(morocco.getID());
		westAfrica.addNeighbor(eastAfrica.getID());
		westAfrica.addNeighbor(egypt.getID());
		westAfrica.addNeighbor(congo.getID());

		morocco.addNeighbor(westAfrica.getID());
		morocco.addNeighbor(algeria.getID());
		morocco.addNeighbor(spain.getID());

		algeria.addNeighbor(morocco.getID());
		algeria.addNeighbor(eastAfrica.getID());
		algeria.addNeighbor(egypt.getID());
		algeria.addNeighbor(southernEurope.getID());

		egypt.addNeighbor(algeria.getID());
		egypt.addNeighbor(westAfrica.getID());
		egypt.addNeighbor(westAfrica.getID());
		egypt.addNeighbor(turkey.getID());
		egypt.addNeighbor(southernEurope.getID());

		// Europe
		iceland.addNeighbor(greenland.getID());
		iceland.addNeighbor(unitedKingdom.getID());
		iceland.addNeighbor(scandinavia.getID());

		unitedKingdom.addNeighbor(iceland.getID());
		unitedKingdom.addNeighbor(france.getID());
		unitedKingdom.addNeighbor(scandinavia.getID());
		unitedKingdom.addNeighbor(lowCountries.getID());

		scandinavia.addNeighbor(denmark.getID());
		scandinavia.addNeighbor(iceland.getID());
		scandinavia.addNeighbor(unitedKingdom.getID());
		scandinavia.addNeighbor(poland.getID());
		scandinavia.addNeighbor(germany.getID());
		scandinavia.addNeighbor(lowCountries.getID());
		scandinavia.addNeighbor(sweden.getID());
		scandinavia.addNeighbor(eastEurope.getID());

		denmark.addNeighbor(scandinavia.getID());
		denmark.addNeighbor(germany.getID());

		germany.addNeighbor(poland.getID());
		germany.addNeighbor(czechoslovakia.getID());
		germany.addNeighbor(france.getID());
		germany.addNeighbor(lowCountries.getID());
		germany.addNeighbor(southernEurope.getID());
		germany.addNeighbor(scandinavia.getID());
		germany.addNeighbor(denmark.getID());

		poland.addNeighbor(germany.getID());
		poland.addNeighbor(czechoslovakia.getID());
		poland.addNeighbor(eastEurope.getID());
		poland.addNeighbor(scandinavia.getID());

		france.addNeighbor(unitedKingdom.getID());
		france.addNeighbor(lowCountries.getID());
		france.addNeighbor(germany.getID());
		france.addNeighbor(spain.getID());
		france.addNeighbor(southernEurope.getID());

		spain.addNeighbor(france.getID());
		spain.addNeighbor(morocco.getID());

		lowCountries.addNeighbor(france.getID());
		lowCountries.addNeighbor(germany.getID());
		lowCountries.addNeighbor(unitedKingdom.getID());
		lowCountries.addNeighbor(scandinavia.getID());

		southernEurope.addNeighbor(germany.getID());
		southernEurope.addNeighbor(czechoslovakia.getID());
		southernEurope.addNeighbor(eastEurope.getID());
		southernEurope.addNeighbor(egypt.getID());
		southernEurope.addNeighbor(algeria.getID());
		southernEurope.addNeighbor(france.getID());
		southernEurope.addNeighbor(turkey.getID());

		czechoslovakia.addNeighbor(southernEurope.getID());
		czechoslovakia.addNeighbor(eastEurope.getID());
		czechoslovakia.addNeighbor(poland.getID());
		czechoslovakia.addNeighbor(germany.getID());

		eastEurope.addNeighbor(ural.getID());
		eastEurope.addNeighbor(kazakhstan.getID());
		eastEurope.addNeighbor(iran.getID());
		eastEurope.addNeighbor(turkey.getID());
		eastEurope.addNeighbor(scandinavia.getID());
		eastEurope.addNeighbor(poland.getID());
		eastEurope.addNeighbor(sweden.getID());
		eastEurope.addNeighbor(czechoslovakia.getID());
		eastEurope.addNeighbor(southernEurope.getID());

		// Asia D:
		turkey.addNeighbor(eastEurope.getID());
		turkey.addNeighbor(southernEurope.getID());
		turkey.addNeighbor(egypt.getID());
		turkey.addNeighbor(saudiArabia.getID());
		turkey.addNeighbor(iran.getID());

		saudiArabia.addNeighbor(eastAfrica.getID());
		saudiArabia.addNeighbor(turkey.getID());

		iran.addNeighbor(turkey.getID());
		iran.addNeighbor(eastEurope.getID());
		iran.addNeighbor(pakistan.getID());
		iran.addNeighbor(kazakhstan.getID());
		iran.addNeighbor(afganistan.getID());

		pakistan.addNeighbor(india.getID());
		pakistan.addNeighbor(afganistan.getID());
		pakistan.addNeighbor(china.getID());
		pakistan.addNeighbor(kazakhstan.getID());
		pakistan.addNeighbor(iran.getID());

		afganistan.addNeighbor(iran.getID());
		afganistan.addNeighbor(pakistan.getID());
		afganistan.addNeighbor(kazakhstan.getID());

		kazakhstan.addNeighbor(china.getID());
		kazakhstan.addNeighbor(eastEurope.getID());
		kazakhstan.addNeighbor(iran.getID());
		kazakhstan.addNeighbor(afganistan.getID());
		kazakhstan.addNeighbor(ural.getID());

		ural.addNeighbor(kazakhstan.getID());
		ural.addNeighbor(eastEurope.getID());
		ural.addNeighbor(china.getID());
		ural.addNeighbor(siberia.getID());

		siberia.addNeighbor(ural.getID());
		siberia.addNeighbor(china.getID());
		siberia.addNeighbor(yakutsk.getID());
		siberia.addNeighbor(mongolia.getID());
		siberia.addNeighbor(irkutsk.getID());

		china.addNeighbor(siberia.getID());
		china.addNeighbor(ural.getID());
		china.addNeighbor(mongolia.getID());
		china.addNeighbor(indochina.getID());
		china.addNeighbor(india.getID());
		china.addNeighbor(pakistan.getID());
		china.addNeighbor(kazakhstan.getID());

		india.addNeighbor(china.getID());
		india.addNeighbor(pakistan.getID());
		india.addNeighbor(indochina.getID());

		yakutsk.addNeighbor(kamchatka.getID());
		yakutsk.addNeighbor(irkutsk.getID());
		yakutsk.addNeighbor(siberia.getID());

		irkutsk.addNeighbor(yakutsk.getID());
		irkutsk.addNeighbor(kamchatka.getID());
		irkutsk.addNeighbor(siberia.getID());
		irkutsk.addNeighbor(mongolia.getID());

		mongolia.addNeighbor(japan.getID());
		mongolia.addNeighbor(china.getID());
		mongolia.addNeighbor(irkutsk.getID());
		mongolia.addNeighbor(siberia.getID());
		mongolia.addNeighbor(kamchatka.getID());

		kamchatka.addNeighbor(mongolia.getID());
		kamchatka.addNeighbor(alaska.getID());
		kamchatka.addNeighbor(irkutsk.getID());
		kamchatka.addNeighbor(yakutsk.getID());
		kamchatka.addNeighbor(japan.getID());

		indochina.addNeighbor(china.getID());
		indochina.addNeighbor(india.getID());
		indochina.addNeighbor(indonesia.getID());
		indochina.addNeighbor(philipines.getID());

		japan.addNeighbor(hawaii.getID());
		japan.addNeighbor(kamchatka.getID());
		japan.addNeighbor(mongolia.getID());

		// Australia
		eastAustralia.addNeighbor(westAustralia.getID());
		eastAustralia.addNeighbor(newGuinea.getID());
		eastAustralia.addNeighbor(indonesia.getID());

		westAustralia.addNeighbor(eastAustralia.getID());
		westAustralia.addNeighbor(newGuinea.getID());

		newGuinea.addNeighbor(westAustralia.getID());
		newGuinea.addNeighbor(eastAustralia.getID());
		newGuinea.addNeighbor(indonesia.getID());

		indonesia.addNeighbor(indochina.getID());
		indonesia.addNeighbor(eastAustralia.getID());
		indonesia.addNeighbor(philipines.getID());

		philipines.addNeighbor(indochina.getID());
		philipines.addNeighbor(indonesia.getID());

		// Add territories to continent maps
		// North America
		northAmerica.add(alaska.getID());
		northAmerica.add(northWestTerritory.getID());
		northAmerica.add(greenland.getID());
		northAmerica.add(alberta.getID());
		northAmerica.add(ontario.getID());
		northAmerica.add(quebec.getID());
		northAmerica.add(hawaii.getID());
		northAmerica.add(westUS.getID());
		northAmerica.add(eastUS.getID());
		northAmerica.add(mexico.getID());
		northAmerica.add(cuba.getID());
		northAmerica.add(centralAmerica.getID());
		
		//South America
		southAmerica.add(venezuela.getID());
		southAmerica.add(argentina.getID());
		southAmerica.add(peru.getID());
		southAmerica.add(bolivia.getID());
		southAmerica.add(brazil.getID());
		
		//Africa
		africa.add(southAfrica.getID());
		africa.add(madagascar.getID());
		africa.add(congo.getID());
		africa.add(eastAfrica.getID());
		africa.add(westAfrica.getID());
		africa.add(egypt.getID());
		africa.add(algeria.getID());
		africa.add(morocco.getID());
		
		//Europe
		europe.add(spain.getID());
		europe.add(france.getID());
		europe.add(lowCountries.getID());
		europe.add(germany.getID());
		europe.add(southernEurope.getID());
		europe.add(poland.getID());
		europe.add(eastEurope.getID());
		europe.add(czechoslovakia.getID());
		europe.add(denmark.getID());
		europe.add(scandinavia.getID());
		europe.add(sweden.getID());
		europe.add(iceland.getID());
		europe.add(unitedKingdom.getID());
		
		//Asia
		asia.add(saudiArabia.getID());
		asia.add(turkey.getID());
		asia.add(iran.getID());
		asia.add(pakistan.getID());
		asia.add(afganistan.getID());
		asia.add(kazakhstan.getID());
		asia.add(ural.getID());
		asia.add(siberia.getID());
		asia.add(china.getID());
		asia.add(india.getID());
		asia.add(irkutsk.getID());
		asia.add(yakutsk.getID());
		asia.add(mongolia.getID());
		asia.add(indochina.getID());
		asia.add(kamchatka.getID());
		asia.add(japan.getID());
		
		//Australia
		australia.add(philipines.getID());
		australia.add(indonesia.getID());
		australia.add(newGuinea.getID());
		australia.add(eastAustralia.getID());
		australia.add(westAustralia.getID());
		
		//Add all territories 
		
		//North America
		allTerritories.put(alaska.getID(), alaska);
		allTerritories.put(alberta.getID(), alberta);
		allTerritories.put(mexico.getID(), mexico);
		allTerritories.put(eastUS.getID(), eastUS);
		allTerritories.put(cuba.getID(), cuba);
		allTerritories.put(centralAmerica.getID(), centralAmerica);
		allTerritories.put(northWestTerritory.getID(), northWestTerritory);
		allTerritories.put(hawaii.getID(), hawaii);
		allTerritories.put(greenland.getID(), greenland);
		allTerritories.put(quebec.getID(), quebec);
		allTerritories.put(ontario.getID(), ontario);
		allTerritories.put(westUS.getID(), westUS);
		
		//South America
		allTerritories.put(brazil.getID(), brazil);
		allTerritories.put(argentina.getID(), argentina);
		allTerritories.put(peru.getID(), peru);
		allTerritories.put(venezuela.getID(), venezuela);
		allTerritories.put(bolivia.getID(), bolivia);
		
		//Europe

		allTerritories.put(unitedKingdom.getID(), unitedKingdom);
		allTerritories.put(iceland.getID(), iceland);
		allTerritories.put(scandinavia.getID(), scandinavia);
		allTerritories.put(sweden.getID(), sweden);
		allTerritories.put(eastEurope.getID(), eastEurope);
		allTerritories.put(lowCountries.getID(), lowCountries);
		allTerritories.put(spain.getID(), spain);
		allTerritories.put(france.getID(), france);
		allTerritories.put(denmark.getID(), denmark);
		allTerritories.put(germany.getID(), germany);
		allTerritories.put(poland.getID(), poland);
		allTerritories.put(czechoslovakia.getID(), czechoslovakia);
		allTerritories.put(southernEurope.getID(), southernEurope);
		
		//Asia
		allTerritories.put(saudiArabia.getID(), saudiArabia);
		allTerritories.put(turkey.getID(), turkey);
		allTerritories.put(iran.getID(), iran);
		allTerritories.put(afganistan.getID(), afganistan);
		allTerritories.put(pakistan.getID(), pakistan);
		allTerritories.put(india.getID(), india);
		allTerritories.put(indochina.getID(), indochina);
		allTerritories.put(china.getID(), china);
		allTerritories.put(mongolia.getID(), mongolia);
		allTerritories.put(kazakhstan.getID(), kazakhstan);
		allTerritories.put(japan.getID(), japan);
		allTerritories.put(ural.getID(), ural);
		allTerritories.put(kamchatka.getID(), kamchatka);
		allTerritories.put(irkutsk.getID(), irkutsk);
		allTerritories.put(siberia.getID(), siberia);
		allTerritories.put(yakutsk.getID(), yakutsk);
		
		//Africa
		allTerritories.put(morocco.getID(), morocco);
		allTerritories.put(algeria.getID(), algeria);
		allTerritories.put(egypt.getID(), egypt);
		allTerritories.put(eastAfrica.getID(), eastAfrica);
		allTerritories.put(westAfrica.getID(), westAfrica);
		allTerritories.put(madagascar.getID(), madagascar);
		allTerritories.put(southAfrica.getID(), southAfrica);
		allTerritories.put(congo.getID(), congo);
		
		//Australia
		allTerritories.put(eastAustralia.getID(), eastAustralia);
		allTerritories.put(westAustralia.getID(), westAustralia);
		allTerritories.put(newGuinea.getID(), newGuinea);
		allTerritories.put(indonesia.getID(), indonesia);
		allTerritories.put(philipines.getID(), philipines);
	}
}
