package io.GitHub.PancakeBoiii.CelestialEngine;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import io.github.pancakeboiii.core.OrdinalAPI.DataManager.FileMan;
import io.github.pancakeboiii.core.OrdinalAPI.DataManager.JSON;

public class PlanetPacks {
    public static void Main() throws ParseException, IOException {
    	String Repository = "https://raw.githubusercontent.com/PancakeBoiii/MinecraftDevelopment/main/CelestialEngine/PlanetPacks.json";
    	FileMan.Download(JSON.GetFromURL(Repository, "Mars"), "Plugins/Terra/packs");
    	FileMan.Download(JSON.GetFromURL(Repository, "Moon"), "Plugins/Terra/packs");
    }

}
