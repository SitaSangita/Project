package in.sita.sangitaTech.serviceImplement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sita.sangitaTech.DTO.CounsellorDTO;
import in.sita.sangitaTech.entity.CounsellorEntity;
import in.sita.sangitaTech.repo.CounsellorRepository;
import in.sita.sangitaTech.serviceInterface.CounsellorInterface;

@Service
public class CounsellorImplement implements CounsellorInterface {

	@Autowired
	private CounsellorRepository counsellorRepository;

	@Override
	public CounsellorDTO login(CounsellorDTO counsellorDTO) {
		CounsellorEntity entity = counsellorRepository.findByEmailAndPassword(counsellorDTO.getEmail(),
				counsellorDTO.getPassword());
		if (entity != null) {
			CounsellorDTO cdto = new CounsellorDTO();
			BeanUtils.copyProperties(entity, cdto);
			return cdto;
		}
		return null;
	}

	@Override
	public boolean uniqueEmailCheck(String email) {
		CounsellorEntity entity = counsellorRepository.findByEmail(email);
		return entity == null;
	}

	@Override
	public boolean register(CounsellorDTO counsellorDTO) {
		CounsellorEntity entity = new CounsellorEntity();
		BeanUtils.copyProperties(counsellorDTO, entity);
		CounsellorEntity save = counsellorRepository.save(entity);
		return null != save.getCounsellorId();
	}

}
