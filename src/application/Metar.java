package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Metar {

	public String getRawMetar(String icao) {
		String metar = "";
		
		try {
			URL myConnection = new URL("http://tgftp.nws.noaa.gov/data/observations/metar/stations/"+icao+".TXT");
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
			metar = "Bei dem Download der METAR ist ein Fehler geschehen.";
			
		}
		System.out.println(metar);
		return metar;
	}
	
}
