package com.train.ruiq.service;

import com.train.ruiq.entity.QQHistory;

import java.util.List;
import java.util.Vector;

public interface IHistoryService {
    public String CheckRecord(long selfid);
    public String CheckRecord(long myselfId, long otherId);
    public void insertMessage(QQHistory qqHistory);
}
