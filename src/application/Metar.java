package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Metar {

	public String getRawMetar(String icao) {
		String metar = "";
		
		icao = icao.trim();
		icao = icao.toUpperCase();
		if (icao.equals("")) return "Please enter an airport ICAO code!";
		
		try {
			URL myConnection = new URL("https://tgftp.nws.noaa.gov/data/observations/metar/stations/"+icao+".TXT");
			URLConnection connectMe = myConnection.openConnection();
			          
			InputStreamReader lineReader = new InputStreamReader(connectMe.getInputStream());
			BufferedReader buffer = new BufferedReader(lineReader);
			
			String read = buffer.readLine();
			metar = read + "\n";
			
			read = buffer.readLine();
			metar += read;
			
			buffer.close();
			lineReader.close();
			
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			metar = "An error occured while downloading the raw weather information from NOAA.";
			
		}
		//System.out.println(metar);
		return metar;
	}
	
	public String getDecodedMetar(String icao) {
		String metar = "";
		
		icao = icao.trim();
		icao = icao.toUpperCase();
		if (icao.equals("")) return "Please enter an airport ICAO code!";
		
		try {
			URL myConnection = new URL("https://tgftp.nws.noaa.gov/data/observations/metar/decoded/"+icao+".TXT");
			URLConnection connectMe = myConnection.openConnection();
			          
			InputStreamReader lineReader = new InputStreamReader(connectMe.getInputStream());
			BufferedReader buffer = new BufferedReader(lineReader);
			
			for(int i = 0; i<=15; i++)
			{
				String read = buffer.readLine();
				if (read == null) break;
				metar += read + "\n";
			} 
			
			buffer.close();
			lineReader.close();
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			metar = "An error occured while downloading the decoded weather information from NOAA.";
			
		}
		//System.out.println(metar);
		return metar;
	}
	
}
