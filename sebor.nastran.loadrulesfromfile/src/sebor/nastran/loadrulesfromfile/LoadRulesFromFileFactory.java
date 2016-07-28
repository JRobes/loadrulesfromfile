package sebor.nastran.loadrulesfromfile;

import org.eclipse.jface.text.rules.IRule;

public class LoadRulesFromFileFactory {
	private static ILoadRulesFromFile loadRulesFromFile;
	
	public static IRule[] getInstace(String path){
		loadRulesFromFile = new LoadRulesFromFileImpl();
		return loadRulesFromFile.loadRulesFromFile(path);
	}

}
