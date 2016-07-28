package sebor.nastran.loadrulesfromfile;

import org.eclipse.jface.text.rules.IRule;

public interface ILoadRulesFromFile {
	public IRule[] loadRulesFromFile(String theFile);

}
