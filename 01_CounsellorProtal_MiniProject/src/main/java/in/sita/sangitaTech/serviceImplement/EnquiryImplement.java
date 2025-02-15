package in.sita.sangitaTech.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.sita.sangitaTech.DTO.CounsellorDashboradDTO;
import in.sita.sangitaTech.DTO.EnquiryDTO;
import in.sita.sangitaTech.DTO.EnquiryFilterDTO;
import in.sita.sangitaTech.entity.CounsellorEntity;
import in.sita.sangitaTech.entity.EnquiryEntity;
import in.sita.sangitaTech.repo.CounsellorRepository;
import in.sita.sangitaTech.repo.EnquiryRepository;
import in.sita.sangitaTech.serviceInterface.EnquiryInterface;

@Service
public class EnquiryImplement implements EnquiryInterface {

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public CounsellorDashboradDTO getDashboardInfo(Integer counsellorId) {
		List<EnquiryEntity> enquiry = enquiryRepository.findByCounsellorCounsellorId(counsellorId);
		CounsellorDashboradDTO cdto = new CounsellorDashboradDTO();
		cdto.setTotalEnquiry(enquiry.size());
		int openCnt = enquiry.stream().filter(enq -> enq.getStatus().equalsIgnoreCase("Open"))
				.collect(Collectors.toList()).size();
		int enrolldCnt = enquiry.stream().filter(enq -> enq.getStatus().equalsIgnoreCase("Enrollerd"))
				.collect(Collectors.toList()).size();
		int lostCnt = enquiry.stream().filter(enq -> enq.getStatus().equalsIgnoreCase("Lost"))
				.collect(Collectors.toList()).size();
		cdto.setOpenEnquiry(openCnt);
		cdto.setEnrolledEnquiry(enrolldCnt);
		cdto.setLostEnquiry(lostCnt);

		return cdto;
	}

	@Override
	public boolean addEnquiry(EnquiryDTO enquiryDTO, Integer counsllorId) {
		EnquiryEntity entity = new EnquiryEntity();
		BeanUtils.copyProperties(enquiryDTO, entity);
		Optional<CounsellorEntity> byId = counsellorRepository.findById(counsllorId);
		if (byId.isPresent()) {
			CounsellorEntity cEntity = byId.get();
			entity.setCounsellor(cEntity);
		}
		EnquiryEntity save = enquiryRepository.save(entity);
		return save.getEnquiryId() != null;
	}

	@Override
	public List<EnquiryDTO> getEnqiry(Integer counsllorId) {
		List<EnquiryDTO> dtoList = new ArrayList();
		List<EnquiryEntity> list = enquiryRepository.findByCounsellorCounsellorId(counsllorId);

		for (EnquiryEntity entity : list) {
			EnquiryDTO dto = new EnquiryDTO();
			BeanUtils.copyProperties(entity, dto); // Fix this order
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public List<EnquiryDTO> getEnqiry(EnquiryFilterDTO filterDTO, Integer counsllorId) {
		EnquiryEntity entity = new EnquiryEntity();
		if (filterDTO.getClassMode() != null && !filterDTO.getClassMode().equals("")) {
			entity.setClassMode(filterDTO.getClassMode());
		}
		if (filterDTO.getCourse() != null && !filterDTO.getCourse().equals("")) {
			entity.setCourse(filterDTO.getCourse());
		}
		if (filterDTO.getStatus() != null && !filterDTO.getStatus().equals("")) {
			entity.setStatus(filterDTO.getStatus());
		}
		CounsellorEntity cEntity = new CounsellorEntity();
		cEntity.setCounsellorId(counsllorId);
		entity.setCounsellor(cEntity);

		Example<EnquiryEntity> of = Example.of(entity);
		List<EnquiryEntity> all = enquiryRepository.findAll(of);
		List<EnquiryDTO> list = new ArrayList<>();
		for (EnquiryEntity enq : all) {
			EnquiryDTO dto = new EnquiryDTO();
			BeanUtils.copyProperties(enq, dto);
			list.add(dto);
		}

		return list;
	}

	@Override
	public EnquiryDTO getEnquiryById(Integer enqId) {
		Optional<EnquiryEntity> byId = enquiryRepository.findById(enqId);
		if (byId.isPresent()) {
			EnquiryEntity entity = byId.get();
			EnquiryDTO dto = new EnquiryDTO();

			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

}
