package ast;

import Isi.datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand{

	private String id;
	private IsiVariable var;
	
	public CommandLeitura (String id, IsiVariable var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id  + "= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "nextLine();");
	}
	
}
