package ru.netology.filemanager.repository;

import org.springframework.stereotype.Repository;
import ru.netology.filemanager.model.FileInfo;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface FileInfoRepository extends CrudRepository<FileInfo,Long> {

}
