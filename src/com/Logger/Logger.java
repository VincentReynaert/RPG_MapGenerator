package com.Logger;

import java.io.PrintStream;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Timer;

public class Logger {
    private static Hashtable<String,Logger> loggers = new Hashtable<>();    //use Hashtable in place of Dictionnary cause it'is deprecated
    private String id;
    private PrintStream stream = System.out;


    private Logger(String id,PrintStream stream){
        this.id = id;
        if(stream != null) {
            this.stream = stream;
        }
    }

    public static Logger getLogger(String id, PrintStream stream){
        if(!loggers.containsKey(id)){
            loggers.put(id,new Logger(id,stream));
        }
        return loggers.get(id);
    }

    private void log(String level, String data){        // I change the entry of log because I've forgot in the uml
                                                        // to put the msg in param
        System.out.println("[logger-"+id + ":"+ level +"]"+ LocalDateTime.now() + ":"+data);
    }

    public void info(String msg){
        log("INFO",msg);
    }
    public void warning(String msg){
        log("WARNING", msg);
    }
    public void error(String msg){
        log("ERROR",msg);
    }

}
