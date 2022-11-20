package project2;

import java.util.Arrays;

/**
 * storm data object for each entry in storm events
 * @author Zachary Boster
 *
 * @param <T>
 */
public class StormData<T> {
	
	private String[] data = new String[] {"Begin_YearMonth, Begin_Day, Begin_Time, End_YearMonth, End_Day, End_Time, Episode_Id, String State, State_Fips, Year, Month_Name, Event_Type, Cz_Type, Cz_Fips, Cz_Name, WFO, Begin_Date_Time, Cz_Time_Zone, End_Date_Time, Injuries_Direct, Injuries_Indirect, Deaths_Direct, Deaths_Indiret, Damage_Property, Damage_Crops, Source, Magnitude, Magnitude_Type, Flood_Cause, Category, Tor_F_Scale, Tor_Length, Tor_Width, Tor_Other_WFO, Tor_Other_Cz_State, Tor_Other_Cz_Fips, Tor_Other_Cz_Name, Begin_Range, Begin_Azimuth, Begin_Location, End_Range, End_Azimut, End_Location, Begin_Lat, Begin_Lon, String End_Lat, End_Lon, Episode_Narrative, Event_Narrative, Data_Source"};
	
	public StormData (String[] data) {
		setData(data);
	}

	public StormData() {
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "StormData: " + Arrays.toString(data);
	}
	
	public String getEventId() {
		String EventId = data[7];
		return EventId;
	}

}
