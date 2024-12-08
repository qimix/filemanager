package ru.netology.filemanager.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@ToString
@Entity
@Table(name = "fileinfo")
public class FileInfo {

    private Long id;

    private String name;

    private Long size;

    private String key;

    private LocalDate uploadDate;
}
