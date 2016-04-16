package jp.co.careertrek.candidate.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.careertrek.candidate.application.service.IApplicationService;
import jp.co.careertrek.candidate.application.vo.ApplicationVO;
import jp.co.careertrek.candidate.application.vo.ApplicationFormVO;
import jp.co.careertrek.core.application.exception.DuplicateApplicationException;
import jp.co.careertrek.core.application.po.Application;

/**
 * 応募関連のcontroller
 * 
 * 1.serviceのメソッドを呼び出す
 * 2.validation処理
 * 3.exception処理
 * 4.entity/POをDTOに詰替
 * 
 * !!!ロジックはcontrollerに書かない。
 * @author even.he
 *
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {
	
	@Autowired
	private IApplicationService applicationService;
	
	
	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  public List<ApplicationVO> list(@RequestParam("id") Long id){
	    List<Application> applications = applicationService.getList(id);
	    List<ApplicationVO> result = new ArrayList<>();
	    applications.forEach(a -> {
	    	result.add(new ApplicationVO(a));
	    });
	    return result;
	  }
	  
	  @RequestMapping(value = "/list", method = RequestMethod.POST)
	  public ApplicationVO apply(@RequestBody ApplicationFormVO applicationForm) throws DuplicateApplicationException{
	    Application application = applicationService.apply(applicationForm.getCandidateId(), applicationForm.getJobId(), applicationForm.getMessage());
	     return new ApplicationVO(application);
	  }
	  
	  @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="this job has already been applied")
	  @ExceptionHandler(DuplicateApplicationException.class)
	  private void handleDuplicationApplication(){
		  // nothing
	  }
}
