package com.yishan.moneybook.record;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/records", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecordController {

    @Autowired
    private RecordService recordService;

    // 取得所有紀錄
    @GetMapping
    public ResponseEntity<Iterable<Record>> getRecordsAll() {
        Iterable<Record> records = recordService.getRecords();
        return ResponseEntity.ok(records);
    }

    // 取得{id}的紀錄
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") int id) {
        Record record = recordService.getRecord(id);
        return ResponseEntity.ok(record);
    }

    // 新增紀錄
    @PostMapping
    public ResponseEntity<Record> addRecord(@Valid @RequestBody Record request) {
        Record record = recordService.createRecord(request);

        // 建立 URI 指向這次新增的資源
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(record.getId())
            .toUri();

        // 新增完成 return 201 created
        return ResponseEntity.created(location).body(record);
    }

    // 修改{id}的紀錄
    @PutMapping("/{id}")
    public ResponseEntity<Record> editRecord(@Valid @PathVariable("id") int id, @RequestBody Record request) {
        Record record = recordService.replaceRecord(id, request);
        return ResponseEntity.ok(record);
    }

    // 刪除{id}的紀錄
    @DeleteMapping("/{id}")
    public ResponseEntity<Record> deleteRecord(@PathVariable("id") int id) {
        recordService.deleteRecord(id);
        // 刪除成功 return 204 no content
        return ResponseEntity.noContent().build();
    }

    
}
