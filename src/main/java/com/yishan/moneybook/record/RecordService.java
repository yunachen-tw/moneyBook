package com.yishan.moneybook.record;

import com.yishan.moneybook.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    
    @Autowired
    private RecordRepository recordRepository;

    public Record getRecord(Integer id) {
        return recordRepository.findById(id).orElseThrow(() -> new NotFoundException("Can't find Record."));
    }

    public Iterable<Record> getRecords() {
        return recordRepository.findAllByOrderByDateAsc();
    }

    public Record createRecord(Record request) {
        Record record = new Record();
        record.setCost(request.getCost());
        record.setTitle(request.getTitle());
        record.setDate(request.getDate());
        record.setDetail(request.getDetail());

        return recordRepository.save(record);
    }

    public Record replaceRecord(Integer id, Record request) {
        Record oldRecord = getRecord(id);

        Record record = new Record();
        record.setId(oldRecord.getId());
        record.setCost(request.getCost());
        record.setTitle(request.getTitle());
        record.setDate(request.getDate());
        record.setDetail(request.getDetail());

        return recordRepository.save(record);
    }

    public void deleteRecord(Integer id) {
        if (recordRepository.existsById(id)){
            recordRepository.deleteById(id);
        } else {
            throw new NotFoundException("Can't find Record.");
        }
    }

}
