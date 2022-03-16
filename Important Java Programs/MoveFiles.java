// java Program to move files with certain 
// pattern from one folder to another

import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

public class MoveFiles
{
	public static void main(String [] args) throws IOException
	{
		File f1 = new File("E://College Project//Forgery Detection//dataset");
		
		FilenameFilter filter = new FilenameFilter()
			{
				@Override public boolean accept(File dir, String name)
				{
					return name.endsWith("_B.png");
				}
			};
			int i = 1;
			for (File f : f1.listFiles(filter))
			{
				
									
					String str[] = f.toString().split("\\\\");
					String file_name = str[str.length-1];
					File f2 = new File("E://College Project//Forgery Detection//processed//"+file_name);
				  
				   Path temp =   Files.move(f.toPath(), f2.toPath());
				   
				   if(temp != null)
					{
						System.out.println(i+": success");
					}
					else
					{
						System.out.println(i+": failed");
					}
					
					i++;
			}
	}
}