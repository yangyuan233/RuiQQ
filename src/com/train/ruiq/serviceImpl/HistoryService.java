package com.train.ruiq.serviceImpl;
import com.train.ruiq.daoImpl.CommunicateDaoImpl;
import com.train.ruiq.daoImpl.HistoryDaoImpl;
import com.train.ruiq.entity.QQHistory;
import com.train.ruiq.service.IHistoryService;

import java.util.List;
import java.util.Vector;


public class HistoryService implements IHistoryService {
    List<QQHistory> qqHistories=null;
    HistoryDaoImpl historyDao=null;
    CommunicateDaoImpl communicateDao=null;

    @Override
    public String CheckRecord(long selfid) {
        communicateDao=new CommunicateDaoImpl();
        historyDao=new HistoryDaoImpl();
        qqHistories= (List<QQHistory>) historyDao.selectHistory(selfid);
        String str="";
        for(QQHistory qqHistory:qqHistories){
            str=str+qqHistory.getSendid()+"对"+qqHistory.getGetid()+"说："+qqHistory.getMessage()+"    "+qqHistory.getSendTime()+"\n";
        }
        System.out.println(str);
        return str;

    }

    @Override
    public void insertMessage(QQHistory qqHistory) {
        communicateDao=new CommunicateDaoImpl();
        communicateDao.insertMessage_his(qqHistory);
        communicateDao.insertMessage_mes(qqHistory);
    }

    @Override
    public String CheckRecord(long myselfId, long otherId) {
        historyDao=new HistoryDaoImpl();
        qqHistories=(List<QQHistory>)historyDao.selectHistory(myselfId, otherId);
        String str="";
        for(QQHistory qqHistory:qqHistories){
            str=str+qqHistory.getSendid()+"对"+qqHistory.getGetid()+"说："+qqHistory.getMessage()+"    "+qqHistory.getSendTime()+"%%%";
        }
        return str;
    }
}
