package sebor.nastran.loadrulesfromfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.rules.IRule;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class LoadRulesFromFileImpl implements ILoadRulesFromFile {
	public LoadRulesFromFileImpl(){
	}
	@Override
	public IRule[] loadRulesFromFile(String theFile) {
	    URL urlOfInstanceLocation = Platform.getInstanceLocation().getURL();
	    String pathOfInstanceLocation = urlOfInstanceLocation.getPath();
	    String osPathOfInstanceLocation = System.getProperty("os.name").contains("indow") ? pathOfInstanceLocation.substring(1) : pathOfInstanceLocation;
	    //System.out.println("*************************************************");
	    //System.out.println("depende del SO:\t"+osPathOfInstanceLocation);
	    //System.out.println("*************************************************");
	    Path pathOfInstanceFile = Paths.get(osPathOfInstanceLocation, theFile);
	    if (!Files.exists(pathOfInstanceFile)){
	    	Path target = Paths.get(osPathOfInstanceLocation);
	    	URL urlOfProjectFile; 
	    	try {
				urlOfProjectFile = new URL("platform:/plugin/sebor.nastran.loadrulesfromfile/syntax_coloring/BULK-DATA-ENTRIES.syn");
				pathOfInstanceFile = Paths.get(urlOfProjectFile.getPath());
				
				Files.copy(pathOfInstanceFile, target);
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    BufferedReader linea; 
	    try {
			linea = new BufferedReader(new FileReader(pathOfInstanceFile.toString()));
						
			try {
				String aux = linea.readLine(); 
				String[] words = aux.trim().split("\\s++");
				System.out.println("El numero de palabras es:\t" + words.length);
				
				linea.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("**************________________************************");
	    
	 
		return null;
	}
	
	private Path loadProjectFile(Class<?> clazz, String path) {
		System.out.println("IMAGE LOADER.......");
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		URL url = FileLocator.find(bundle, new org.eclipse.core.runtime.Path(path), null);
		//ageDescriptor imageDescr = ImageDescriptor.createFromURL(url);
		return Paths.get(url.getPath());
	}

}
