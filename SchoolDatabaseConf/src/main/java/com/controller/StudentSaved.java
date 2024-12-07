package com.controller;

import com.model.student.ClassTransfer;
import com.model.student.ClassTransferPK;
import com.model.student.StudentInfo;
import com.repository.ClassTransferRepository;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentSaved {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private ClassTransferRepository classTransferRepository;

    public long save(StudentInfo obj) {
        try {
            repository.save(obj);
            ClassTransfer transfer = new ClassTransfer();
            transfer.setPk(new ClassTransferPK(obj.getId(), obj.getAcademicYear(),obj.getClassId()));
            transfer.setProgram(obj.getProgram());
            transfer.setRollNo(obj.getRollNo());
            transfer.setSubjectGroup(obj.getSubjectGroup());
            transfer.setSection(obj.getSection());
            classTransferRepository.save(transfer);
            System.out.println("Saved " + obj.getId());
            return obj.getId();
        } catch (Exception ignored) {
            System.out.println("Error " + obj.getId());
        }
        return 0;
    }
}
