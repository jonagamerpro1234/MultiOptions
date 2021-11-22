package jss.multioptions.modules;

public class ModulesLoader {
	
	private void init(Module... modules) {
		for(Module module : modules) {
			module.load();
		}
	}
	
	public void getLoader() {
		init();
	}
}
