package com.HiringPlarform.HiringPlatform.service.ServiceImpl;

import com.HiringPlarform.HiringPlatform.converters.RandomStringGenerator;
import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.PartTypeDto;
import com.HiringPlarform.HiringPlatform.model.dto.ResponseDto;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Contest;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Part;
import com.HiringPlarform.HiringPlatform.repository.ContestRepository;
import com.HiringPlarform.HiringPlatform.service.ContestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.*;


@Service
@Slf4j
public class ContestServiceImpl implements ContestService {

    private final ContestRepository contestRepository;

    public ContestServiceImpl(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> createContest(ContestDto contestDto) {
//        Contest contest = new Contest();
//        contest.setContestId(RandomStringGenerator.generateRandomString(6));
//        contest.setName(contest.getName());
//        contest.setContestStartTime(contestDto.getStartTime());
//        contest.setContestEndTime(contestDto.getEndTime());
//        contest.setPassMark(contestDto.getPassMark());

        List<PartTypeDto> partTypeDtos = contestDto.getType();
//        List<Type> types = new ArrayList<>();
//        partTypeDtos.stream().map(partTypeDto -> {
//            Type type = new Type();
//            type.setTypeId(RandomStringGenerator.generateRandomLong(7));
//            partTypeDto.getParts().stream().map(partStream -> {
//                Part part = new Part();
//                part.setPartId(RandomStringGenerator.generateRandomString(5));
//                part.setEasy(partStream.getEasy());
//                part.setMedium(partStream.getMedium());
//                part.setHard(partStream.getHard());

//                switch (partStream.getCategory()) {
//
//                }

//                part.setCategory(partStream.getCategory());
//                return null;
//            });
//            List<Part> partsList = new ArrayList<>();
//            partTypeDto.getParts();
//            return null;
//        });
        return null;

    }

    @Override
    public ResponseEntity<ResponseDto> updateContest(Contest contest, String contestId) {
        return null;
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    @Override
    public ResponseEntity<ResponseDto> getContest(String contestId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDto> getAllContestDetails() {
        return null;
    }
}
