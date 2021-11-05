package com.yishan.moneybook.record;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/records", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecordController {

    // 取得所有紀錄
    @GetMapping
    public ResponseEntity<Record> getRecordsAll() {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    // 取得{id}的紀錄
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") int id) {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    // 新增紀錄
    @PostMapping
    public ResponseEntity<Record> addRecord(@RequestBody Record request) {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    // 修改{id}的紀錄
    @PutMapping("/{id}")
    public ResponseEntity<Record> editRecord(@PathVariable("id") int id, @RequestBody Record request) {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    // 刪除{id}的紀錄
    @DeleteMapping("/{id}")
    public ResponseEntity<Record> deleteRecord(@RequestBody Record request) {
        Record record = new Record();
        return ResponseEntity.ok(record);
    }

    
}
