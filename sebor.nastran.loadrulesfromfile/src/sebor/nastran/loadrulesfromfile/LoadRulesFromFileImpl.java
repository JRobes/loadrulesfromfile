package sebor.nastran.loadrulesfromfile;

import org.eclipse.jface.text.rules.IRule;

public class LoadRulesFromFileImpl implements ILoadRulesFromFile {
	private String elPath;
	public LoadRulesFromFileImpl(String thPath){
		elPath = thPath;
	}
	@Override
	public IRule[] loadRulesFromFile() {
		System.out.println("Desde la implementacion!!!!!!!\t"+elPath);
		return null;
	}

}
