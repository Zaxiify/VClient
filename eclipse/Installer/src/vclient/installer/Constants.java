package vclient.installer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Constants {

	public static final String MC_LAUNCHER_ICON = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7DAAAOwwHHb6hkAAAAB3RJTUUH5QoLBR4k+WWm1AAAAxVJREFUWMPt1j1vXFUQBuDnrDexTVgnJMGJ+AjBCQgEQggKRANUCCkUNDSUVPAzIEg0/AF+AhRUlCChSGmgAEtIgMBEAjsf2CTEcT5Ygy/FzN3cXNZrryWEEBlppbtz7pl5z/vOzD3ctv+7lfqhqqqmr4JSyg5CjmedVvJp7MNky/+PWbf1/270sIJlbLQ3JKhdydQf9TttthrgO4LRCfxZL9d7uvVDbriB+zLoFVzbJOhDOIglLIw44AN4Er8n4F8zx7foDyRo2KVE2cN+lCEydHAMj+LwFgz3hKxPJwP3YA7rm0mwjgs4ggOJ+Hrrnd3J0oHaMaJYl3EW32euy5mjqvd0m0HytCtJ3d5MslhVVTNJD/fijqRzmETdBHoJp0aB7A7xXc3foTzpeVFstc3ieEo1qJFMPo1X8BT2JJuf4suqqq4OAzIMQJXUH8MUfsQvjfUjydB5rDaS78VbeB3ncn1PxprBaVxusXlrETYWlhNcfdomvXPpr7CWvulM/obonjP4GJ+lDOsJcFsSyMAX8SAex3zKIpnp5f9aglczeYUP8J4ovg7uFLWyPixRuw2bLJzJzcdrFlKSuTzxSgY9iDfF9Pwc7+JsKUUpZaOUslpK6ZdSqvSNBtCwRdGCh/Fs+mZEYe7KdXhOFF0f76d827ZRANbElNufAGZFWx5Kqn/K954XLfcNPmmxuDMAjQDzok4exjPJxl152sVk4rF89+uUZSzrbLG+INppFi/jEdFaq6LHJ4UsRKtuGNO2AnBNFFYvqX4p/SuivSo3h1Rv3OQjATRkOC16+368mL5zog2vi0EFTwh5BlZV1S2/nTAA3+ErMfun0rck6mBDDJu+qJMTdeKWTWFiGJDtALghplpT358bzx/l+hpewwvYnYk6YmYcFZPwb/k2m4QDGTLQKdF2R4cAuIi3cVJ880+I78WCqKHfxGzoy5vQuAwQU/FD8QX8AV/UANPm8Y7omAlxtZsTF5BJN7+wVXtGbGtiJAszYuotiZoYBGvouk9c1+qOuJDMXWkBHg/AOPZvXe9v23/X/gKNa/zIc/xaKwAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAyMS0xMC0xMVQwNTozMDozNiswMDowMD6PhG0AAAAldEVYdGRhdGU6bW9kaWZ5ADIwMjEtMTAtMTFUMDU6MzA6MzYrMDA6MDBP0jzRAAAAAElFTkSuQmCC";
	
	private static final String BASE_URL = "https://c023-2601-246-5880-e040-cd24-1d3d-a01-ca79.ngrok.io/downloads/";
	
	private static String versionNumber = null;
	
	public static String getVersionNumber() {
		
		if(versionNumber == null) {
			
			try {
				InputStream stream = FileHelper.getStreamFromUrl(BASE_URL + "version.txt");
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffReader = new BufferedReader(reader);
				versionNumber = buffReader.readLine();
				buffReader.close();
				reader.close();
				stream.close();
			} catch(IOException e) {
				e.printStackTrace();
				Installer.getInstance().die(e);
			}
			
		}
		
		return versionNumber;
	}
	
	
	public static InputStream getIcon() {
		return ClassLoader.getSystemResourceAsStream("assets/icon.png");
	}
	
	public static InputStream getJar() throws IOException {
		return FileHelper.getStreamFromUrl(BASE_URL + "VexClient.jar");
	}
	
	public static InputStream getJson() throws IOException {
		return FileHelper.getStreamFromUrl(BASE_URL + "VexClient.json");
	}
	
	public static URL getAudio() {
		return ClassLoader.getSystemResource("assets/audio.mp3");
	}
	
}
