package kg.attractor.jobsearch.service.Impl;

import kg.attractor.jobsearch.dao.ResumeDao;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.model.Resume;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
        private final ResumeDao resumeDao;

        @Override
        public List<ResumeDto> getAllResumes(){
                var list = resumeDao.findAll();

                return list.stream()
                        .map(e -> ResumeDto.builder()
                                .id(e.getId())
                                .applicant_id(e.getApplicantId())
                                .name(e.getName())
                                .category_id(e.getCategoryId())
                                .salary(e.getSalary())
                                .isActive(e.isActive())
                                .build())
                        .toList();

        }

        @Override
        public ResumeDto getByCategoryId(int categoryId) {
                Resume resume = resumeDao.findByCategoryId(categoryId)
                        .orElseThrow(() -> new RuntimeException("Resume not found"));
                return ResumeDto.builder()
                        .id(resume.getId())
                        .applicant_id(resume.getApplicantId())
                        .name(resume.getName())
                        .category_id(resume.getCategoryId())
                        .salary(resume.getSalary())
                        .isActive(resume.isActive())
                        .build();
        }

        @Override
        public List<ResumeDto> showResumes() {
                var list = resumeDao.findAll();
                return list.stream()
                        .map(e -> ResumeDto.builder()
                                .id(e.getId())
                                .applicant_id(e.getApplicantId())
                                .name(e.getName())
                                .category_id(e.getCategoryId())
                                .salary(e.getSalary())
                                .isActive(e.isActive())
                                .build())
                        .toList();
        }

        @Override
        public List<ResumeDto> getByApplicantId(int applicantId) {
                var list = resumeDao.findByApplicantId(applicantId);

                return list.stream()
                        .map(e -> ResumeDto.builder()
                                .id(e.getId())
                                .applicant_id(e.getApplicantId())
                                .name(e.getName())
                                .category_id(e.getCategoryId())
                                .salary(e.getSalary())
                                .isActive(e.isActive())
                                .build())
                        .toList();
        }

        @Override
        public List<ResumeDto> getAllUser() {
                var list = resumeDao.findAll();
                return list.stream()
                        .map(e -> ResumeDto.builder()
                                .id(e.getId())
                                .applicant_id(e.getApplicantId())
                                .name(e.getName())
                                .category_id(e.getCategoryId())
                                .salary(e.getSalary())
                                .isActive(e.isActive())
                                .build())
                        .toList();
        }

        @Override
        public List<ResumeDto> getResumesByCategory(int category_id) {
                var list = resumeDao.findByCategoryId(category_id);

                return list.stream()
                        .map(e -> ResumeDto.builder()
                                .id(e.getId())
                                .applicant_id(e.getApplicantId())
                                .name(e.getName())
                                .category_id(e.getCategoryId())
                                .salary(e.getSalary())
                                .isActive(e.isActive())
                                .build())
                        .toList();

        }

        @Override
        public void deleteById(int resumeId){
                resumeDao.deleteById(resumeId);
        }

        @Override
        public void edit(ResumeDto resumeDto) {
                Resume resume = Resume.builder()
                        .id(resumeDto.getId())
                        .applicantId(resumeDto.getApplicant_id())
                        .name(resumeDto.getName())
                        .categoryId(resumeDto.getCategory_id())
                        .salary(resumeDto.getSalary())
                        .isActive(resumeDto.isActive())
                        .createdDate(LocalDate.now())
                        .updatedTime(LocalDate.now())
                        .build();
                resumeDao.createResume(resume);
        }

        @Override
        public void create(ResumeDto resumeDto){
                Resume resume = Resume.builder()
                        .id(resumeDto.getId())
                        .applicantId(resumeDto.getApplicant_id())
                        .name(resumeDto.getName())
                        .categoryId(resumeDto.getCategory_id())
                        .salary(resumeDto.getSalary())
                        .isActive(resumeDto.isActive())
                        .createdDate(LocalDate.now())
                        .updatedTime(LocalDate.now())
                        .build();
                resumeDao.createResume(resume);
        }

        @Override
        public void editResume(ResumeDto resumeDto){
                Resume resume = Resume.builder()
                        .id(resumeDto.getId())
                        .applicantId(resumeDto.getApplicant_id())
                        .name(resumeDto.getName())
                        .categoryId(resumeDto.getCategory_id())
                        .salary(resumeDto.getSalary())
                        .isActive(resumeDto.isActive())
                        .createdDate(LocalDate.now())
                        .updatedTime(LocalDate.now())
                        .build();
                resumeDao.editResume(resume);
        }
//        @Autowired
//        private ResumeRepository resumeRepository;
//
//
//          @Override
//        public void saveResume(String name, Integer CategoryId, double salary) {
//                   Resume resume = new Resume();
//                  resume.setName(name);
//                  resume.setCategoryId(CategoryId);
//                  resume.setSalary(salary);
//
//                  resumeRepository.save(resume);
//          }

}
