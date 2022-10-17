package br.com.comex.transacao;

public interface Command {
	public abstract void execute() throws Exception;
}
