package com.yishan.moneybook.record;

import java.net.URI;
import java.util.Optional;

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
    // testing data list
    @Autowired
    RecordRepository recordRepository;

    // 取得所有紀錄
    @GetMapping
    public ResponseEntity<Iterable<Record>> getRecordsAll() {
        Iterable<Record> records = recordRepository.findAll();
        return ResponseEntity.ok().body(records);
    }

    // 取得{id}的紀錄
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") int id) {
        boolean isExist = recordRepository.existsById(id);
        if (isExist) {
            Optional<Record> record = recordRepository.findById(id);
            return ResponseEntity.ok().body(record.get());
        } else {
            // if no data, return 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    // 新增紀錄
    @PostMapping
    public ResponseEntity<Record> addRecord(@Valid @RequestBody Record request) {
        Record record = new Record();
        record.setCost(request.getCost());
        record.setTitle(request.getTitle());
        record.setDate(request.getDate());
        record.setDetail(request.getDetail());
        recordRepository.save(record);

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
        boolean isExist = recordRepository.existsById(id);

        // 檢查該筆資料 id 是否存在
        if (isExist) {
            Record record = new Record();
            record.setCost(request.getCost());
            record.setTitle(request.getTitle());
            record.setDate(request.getDate());
            record.setDetail(request.getDetail());
            recordRepository.save(record);

            return ResponseEntity.ok().body(record);
        } else {
            // 若資料不存在則 return 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    // 刪除{id}的紀錄
    @DeleteMapping("/{id}")
    public ResponseEntity<Record> deleteRecord(@PathVariable("id") int id) {
        boolean isExist = recordRepository.existsById(id);
        if (isExist) {
            recordRepository.deleteById(id);
            // 刪除成功 return 204 no content
            return ResponseEntity.noContent().build();
        } else {
            // 若資料不存在則 return 404 not found
            return ResponseEntity.notFound().build();
        }
    }

    
}
