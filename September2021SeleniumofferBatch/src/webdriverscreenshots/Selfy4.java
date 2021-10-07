package webdriverscreenshots;

import java.io.File;
import java.util.Date;

public class Selfy4 
{

	public static void main(String[] args) 
	{
		Date d = new Date();
		System.out.println(d);
		String dt = d.toString().replace(':', '_').replace(' ', '_');
		System.out.println(dt);
		
		File f = new File("C:\\Users\\ravi\\Desktop\\a\\b\\c\\d");
		f.mkdirs();

	}

}
