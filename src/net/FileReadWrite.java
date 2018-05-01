package net;

import java.io.*;
import java.util.TreeSet;

public class FileReadWrite {
	
	/*public static void writeToFile(String filename,Library myLib) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename, StandardCharsets.UTF_8 ))) {
			oos.writeObject(myLib);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void writeToFile(String filename,String storesArray) {
		try(BufferedWriter fr=new BufferedWriter(new FileWriter(filename,true))){
        	fr.write(storesArray);
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}
	/*public static void readFromFile(String filename,Library myLib) {
		Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
		try (BufferedReader reader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))){
            String line;
            if ((line = reader.readLine()) != null) {
                myLib.setName(line);
            }
            if ((line = reader.readLine()) != null) {
                myLib.setLibId(line);
            }
            if ((line = reader.readLine()) != null) {
                myLib.setContryId(Integer.valueOf(line));
            }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*public static <T extends Resource>
	void readResourcesFromFile(String filename,Storage<T> x) {
		Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
		TreeSet<T> itemsTreeSet = null;
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename, StandardCharsets.UTF_8))) {
			itemsTreeSet = (TreeSet<T>) ois.readObject();
			x.setTreeSet(itemsTreeSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
