package com.ajopaul.pojos;

public class ProgramBeanUtils {

	/**
	 * Return program beans
	 * @param programBean
	 * @param priorty
	 * @param clients
	 * @return
	 */
	public static ProgramBean getProgramBean(String programBean,int priorty,String clients){
		return new ProgramBean(programBean,priorty,clients);
	}
}
