package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.UserDto;

import java.util.List;

public interface ResumeService {

 List<ResumeDto> getAllResumes();

    ResumeDto getByCategoryId(int categoryId);

    List<ResumeDto> getByApplicantId(int applicantId);

    List<ResumeDto> getAllUser();

   List<ResumeDto> getResumesByCategory(int categoryId);

    void deleteById(int resume_id);

    void edit(ResumeDto resumeDto);

    void create(ResumeDto resumeDto);

   void editResume(ResumeDto resumeDto);
}
