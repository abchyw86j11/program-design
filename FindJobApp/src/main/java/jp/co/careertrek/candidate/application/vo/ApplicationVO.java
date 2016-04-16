package jp.co.careertrek.candidate.application.vo;

import jp.co.careertrek.core.application.po.Application;
import lombok.Data;

/**
 * 応募API用のmodel
 * @author even.he
 *
 */
@Data
public class ApplicationVO {
	
	private Long applicationId;

	private Long jobId;
	
	private String jobName;
	
	private String companyName;
	
	// 進捗ステータス
	private String applicationProgressStatus;
	
	public ApplicationVO(){
		
	}
	
	public ApplicationVO(Application application){
		applicationId = application.getApplicationId();
		jobId = application.getJobId();
	}
	
}
