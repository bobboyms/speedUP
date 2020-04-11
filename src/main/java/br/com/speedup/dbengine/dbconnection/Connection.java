package br.com.speedup.dbengine.dbconnection;

public interface Connection {

    public Connection createCommand(String commandLine);
    void setDocument();
    String getDocument();
    void deleteDocument();
}
