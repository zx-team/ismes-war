package com.isesol.mes.ismes.war.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.isesol.ismes.platform.core.service.bean.Dataset;
import com.isesol.ismes.platform.module.Bundle;
import com.isesol.ismes.platform.module.Parameters;
import com.isesol.ismes.platform.module.Sys;

public class YcgjActivity {
		
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 跳转程序管理页面
	 * 
	 * @param parameters
	 * @param bundle
	 * @return
	 */
	public String query_ycgj(Parameters parameters, Bundle bundle) {
		return "war_ycgj";
	}
	
	
	/**查询程序列表
	 * @param parameters
	 * @param bundle
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String table_ycgj(Parameters parameters, Bundle bundle) throws Exception {

		String gjlxdm = parameters.getString("gjlxdm"); //  
		
		String con = "1 = 1 and gjclztdm = '10' ";
		List<Object> val = new ArrayList<Object>();
		if(StringUtils.isNotBlank(gjlxdm))
		{
			con = con + " and gjlxdm = ? ";
			val.add(gjlxdm);
		}
			
		int page = Integer.parseInt(parameters.get("page").toString());
		int pageSize = Integer.parseInt(parameters.get("pageSize").toString());
		Dataset datasetcxgl = Sys.query("war_ycgjb","gjid,gjlxdm,gjbt,gjnr,gjdjdm,gjclztdm,zybh,gjsj,czr", con, "gjsj desc", (page-1)*pageSize, pageSize, val.toArray());
		List<Map<String, Object>> gjxx = datasetcxgl.getList(true);
		for (int i = 0; i < gjxx.size(); i++) {
			gjxx.get(i).put("gjsj", sdf.format(gjxx.get(i).get("gjsj")));
			gjxx.get(i).put("gjxx", gjxx.get(i).get("gjbt").toString()+"    "+ gjxx.get(i).get("gjsj").toString());
			parameters.set("account", gjxx.get(i).get("czr"));
			Bundle b_user = Sys.callModuleService("user", "userInfo", parameters);
			if (null!=b_user) {
				Map<String, Object> map = (Map<String, Object>) b_user.get("user");
				gjxx.get(i).put("czr_name", map.get("xm"));
			}
		}
		bundle.put("rows", gjxx);
		int totalPage = datasetcxgl.getTotal()%pageSize==0?datasetcxgl.getTotal()/pageSize:datasetcxgl.getTotal()/pageSize+1;
		bundle.put("totalPage", totalPage);
		bundle.put("currentPage", page);
		bundle.put("totalRecord", datasetcxgl.getTotal());
		return "json:";
	}
	
	/**告警处理
	 * @param parameters
	 * @param bundle
	 */
	public void gjcl(Parameters parameters, Bundle bundle) {
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("gjclztdm", "20");
		try {
			Sys.update("war_ycgjb", map, "gjid = ? ",new Object[]{parameters.getString("gjid")});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




