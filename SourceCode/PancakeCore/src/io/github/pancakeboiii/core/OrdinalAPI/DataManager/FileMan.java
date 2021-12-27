package io.github.pancakeboiii.core.OrdinalAPI.DataManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.pancakeboiii.core.OrdinalAPI.Minecraft.Print;

@SuppressWarnings("unused")
public class FileMan extends JavaPlugin implements Runnable {
    static int debug = 0;

    public static void Download(String URL, String file_destination) throws MalformedURLException {
        try {
            URL file = new URL(URL);
            String extension = URL.substring(URL.lastIndexOf("."));
            File dest = new File(file_destination);
            InputStream is = file.openStream();
            String filename = URL.substring(URL.lastIndexOf('/') + 1, URL.lastIndexOf('.'));
            File finaldest = new File(dest + "/" + filename + extension);
            finaldest.getParentFile().mkdirs();
            finaldest.createNewFile();
            OutputStream os = new FileOutputStream(finaldest);
            byte data[] = new byte[1024];
            int count;
            while ((count = is.read(data, 0, 1024)) != -1) {
                os.write(data, 0, count);
            }
            os.flush();
            is.close();
            os.close();
        } catch (Exception ec) {
            ec.printStackTrace();
        }
    }

    public static void DownloadCustomName(String URL, String file_destination, String LocalFileName) throws MalformedURLException {
        try {
            URL file = new URL(URL);
            String extension = URL.substring(URL.lastIndexOf("."));
            File dest = new File(file_destination);
            InputStream is = file.openStream();
            File finaldest = new File(dest + "/" + LocalFileName + extension);
            finaldest.getParentFile().mkdirs();
            finaldest.createNewFile();
            OutputStream os = new FileOutputStream(finaldest);
            byte data[] = new byte[1024];
            int count;
            while ((count = is.read(data, 0, 1024)) != -1) {
                os.write(data, 0, count);
            }
            os.flush();
            is.close();
            os.close();
        } catch (Exception ec) {
            ec.printStackTrace();
        }
    }
    public static void DownloadCustomNameExtension(String URL, String file_destination, String LocalFileName, String LocalFileExtension) throws MalformedURLException {
        try {
            URL file = new URL(URL);
            File dest = new File(file_destination);
            InputStream is = file.openStream();
            File finaldest = new File(dest + "/" + LocalFileName + LocalFileExtension);
            finaldest.getParentFile().mkdirs();
            finaldest.createNewFile();
            OutputStream os = new FileOutputStream(finaldest);
            byte data[] = new byte[1024];
            int count;
            while ((count = is.read(data, 0, 1024)) != -1) {
                os.write(data, 0, count);
            }
            os.flush();
            is.close();
            os.close();
        } catch (Exception ec) {
            ec.printStackTrace();
        }
    }
    public static void DeleteFile(String FilePath) {
        File myObj = new File(FilePath);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    public static void DeleteFolder(String FolderPath) {
        File myObj = new File(FolderPath);
        if (myObj.delete()) {
            if (debug == 1) {
                System.out.println("Deleted the folder: " + myObj.getName());
            }
        } else {
            if (debug == 1) {
                System.out.println("Failed to delete the folder.");
            }
        }
    }
    public static void CreateFile(String FilePath) {
        try {
            File myObj = new File(FilePath);
            if (myObj.createNewFile()) {
                if (debug == 1) {
                    System.out.println("File created: " + myObj.getName());
                }
            } else {
                if (debug == 1) {
                    System.out.println("File already exists.");
                }
            }
        } catch (IOException e) {
            if (debug == 1) {
                System.out.println("An error occurred.");
            }
            e.printStackTrace();
        }
    }
    public static void CreateFolder(String FolderPath) {
        File myObj = new File(FolderPath);
        if (myObj.mkdirs()) {
            if (debug == 1) {
                System.out.println("Created the folder: " + myObj.getName());
            }
        } else {
            if (debug == 1) {
                System.out.println("Failed to create the folder.");
            }
        }
    }
    public static void WriteToFile(String FilePath, String Data) {
        try {
            FileWriter myWriter = new FileWriter(FilePath);
            myWriter.write(Data);
            myWriter.close();
            if (debug == 1) {
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            if (debug == 1) {
                System.out.println("An error occurred.");
            }
            e.printStackTrace();
        }
    }
    public static void AppendToFile(String FilePath, String Data) {
        try {
            FileWriter fw = new FileWriter(FilePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(Data);
            bw.close();
            if (debug == 1) {
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            if (debug == 1) {
                System.out.println("An error occurred.");
            }
            e.printStackTrace();
        }
    }
    public static boolean IfFileExists(String FilePath) {
    	File f = new File(FilePath);
    	boolean FinalData = false;
    	if(f.exists() && !f.isDirectory()) { 
    		FinalData = true;
    	}
    	if(!f.exists() && !f.isDirectory()) { 
    		FinalData = false;
    	}
    	
		return FinalData;
    	
    }
    public static boolean IfFolderExists(String FolderPath) {
    	File f = new File(FolderPath);
    	boolean FinalData = false;
    	if(f.exists() && f.isDirectory()) { 
    		FinalData = true;
    	}
    	if(!f.exists() && f.isDirectory()) { 
    		FinalData = false;
    	}
    	
		return FinalData;
    	
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub

    }
}