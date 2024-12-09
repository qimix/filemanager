package ru.netology.filemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "fileinfo")
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private Long size;
    @Column
    private String key;
    @Column
    private LocalDate uploadDate;

    public static Builder builder() {
        return new FileInfo().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setName(String name) {
            FileInfo.this.name = name;
            return this;
        }

        public Builder setSize(Long size) {
            FileInfo.this.size = size;
            return this;
        }

        public Builder setKey(String key) {
            FileInfo.this.key = key;
            return this;
        }

        public Builder setLocalDate(LocalDate uploadDate) {
            FileInfo.this.uploadDate = uploadDate;
            return this;
        }

        public FileInfo build() {
            return FileInfo.this;
        }

    }

}
