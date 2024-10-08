package iuh.edu.week1_lab01_dongmanhdung_21099401.services;

import iuh.edu.week1_lab01_dongmanhdung_21099401.entities.Log;
import iuh.edu.week1_lab01_dongmanhdung_21099401.repositories.LogRepository;

public class LogService {
    private LogRepository logRepository;
    public LogService(){
        logRepository = new LogRepository();
    }

    public boolean addNewLog(Log log){
        return logRepository.addLog(log);
    }

    public Log getLog(String accountId){
        return logRepository.getLog(accountId);
    }

    public boolean updateLog(Log log){
        return logRepository.updateLog(log);
    }

}
