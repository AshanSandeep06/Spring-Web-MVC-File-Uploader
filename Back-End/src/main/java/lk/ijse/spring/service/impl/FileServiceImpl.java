package lk.ijse.spring.service.impl;

import lk.ijse.spring.repo.FileRepo;
import lk.ijse.spring.service.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepo fileRepo;

    @Autowired
    private ModelMapper mapper;

    public String uploadFile() {
        return null;
    }
}
