package com.isesol.mes.ismes.war.activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.isesol.ismes.platform.module.Bundle;
import com.isesol.ismes.platform.module.Parameters;
import com.isesol.ismes.platform.module.Sys;
import com.isesol.mes.ismes.war.constant.CustomConstant;

public class GjActivity {

	/**
	 * 保存设备报警信息
	 * 
	 * @param parameters
	 * @param bundle
	 * @return
	 */
	public void saveSbgj(Parameters parameters, Bundle bundle) {
		Map<String, Object> sbgjmap = new HashMap<String, Object>();
		sbgjmap.put(CustomConstant.告警表_告警类型, CustomConstant.告警类型_设备告警);
		sbgjmap.put(CustomConstant.告警表_告警标题, "设备编号为：" + parameters.get("zybh") + "发生设备故障。");
		sbgjmap.put(CustomConstant.告警表_告警内容, "设备编号为：" + parameters.get("zybh") + "<br/>" + "设备名称：" + parameters.get("sbmc"));
		sbgjmap.put(CustomConstant.告警表_告警等级, CustomConstant.告警等级_低);
		sbgjmap.put(CustomConstant.告警表_告警处理状态, CustomConstant.告警处理状态_未处理);
		sbgjmap.put(CustomConstant.告警表_资源编号, parameters.get("zybh"));
		sbgjmap.put(CustomConstant.告警表_操作人, Sys.getUserIdentifier());
		sbgjmap.put(CustomConstant.告警表_告警时间, new Date());
		int count = Sys.insert(CustomConstant.告警表, sbgjmap);
		bundle.put("count", count);
	}

	/**
	 * 保存缺料报警信息
	 * 
	 * @param parameters
	 * @param bundle
	 * @return
	 */
	public void saveQlgj(Parameters parameters, Bundle bundle) {
		Map<String, Object> qlgjmap = new HashMap<String, Object>();
		qlgjmap.put(CustomConstant.告警表_告警类型, CustomConstant.告警类型_物料告警);
		qlgjmap.put(CustomConstant.告警表_告警标题,
				"批次号：" + parameters.get("pcbh") + "工单号：" + parameters.get("zybh") + "，缺料。");
		qlgjmap.put(CustomConstant.告警表_告警内容,
				"批次号：" + parameters.get("pcbh") +"<br/>"+ "工单号：" + parameters.get("zybh") + "<br/>" + "物料编号：" + parameters.get("wlbh") + "<br/>" + "物料名称：" + parameters.get("wlmc"));
		qlgjmap.put(CustomConstant.告警表_告警等级, CustomConstant.告警等级_低);
		qlgjmap.put(CustomConstant.告警表_告警处理状态, CustomConstant.告警处理状态_未处理);
		qlgjmap.put(CustomConstant.告警表_资源编号, parameters.get("zybh"));
		qlgjmap.put(CustomConstant.告警表_操作人, Sys.getUserIdentifier());

		qlgjmap.put(CustomConstant.告警表_告警时间, new Date());

		int count = Sys.insert(CustomConstant.告警表, qlgjmap);
		bundle.put("count", count);

	}

	/**
	 * 保存工装报警信息
	 * 
	 * @param parameters
	 * @param bundle
	 * @return
	 */
	public void saveGzgj(Parameters parameters, Bundle bundle) {

		Map<String, Object> gzgjmap = new HashMap<String, Object>();
		gzgjmap.put(CustomConstant.告警表_告警类型, CustomConstant.告警类型_物料告警);
		gzgjmap.put(CustomConstant.告警表_告警标题, "机台位置：" + parameters.get("zybh") + parameters.get("content"));
		gzgjmap.put(CustomConstant.告警表_告警内容, "机台位置：" + parameters.get("zybh") + "<br/>" + parameters.get("content"));
		gzgjmap.put(CustomConstant.告警表_告警等级, CustomConstant.告警等级_低);
		gzgjmap.put(CustomConstant.告警表_告警处理状态, CustomConstant.告警处理状态_未处理);
		gzgjmap.put(CustomConstant.告警表_资源编号, parameters.get("zybh"));
		gzgjmap.put(CustomConstant.告警表_告警时间, new Date());
		gzgjmap.put(CustomConstant.告警表_操作人, Sys.getUserIdentifier());
		int count = Sys.insert(CustomConstant.告警表, gzgjmap);
		bundle.put("count", count);
	}
	
	/**
	 * 保存质量报警信息
	 * 
	 * @param parameters
	 * @param bundle
	 * @return
	 */
	public void saveZlgj(Parameters parameters, Bundle bundle) {

		Map<String, Object> zlgjmap = new HashMap<String, Object>();
		zlgjmap.put(CustomConstant.告警表_告警类型, CustomConstant.告警类型_质量告警);
		zlgjmap.put(CustomConstant.告警表_告警标题, "批次编号为：" + parameters.get("pcbh") + "， 出现废品，废品数量：" + parameters.get("bfsl") + "个");
		zlgjmap.put(CustomConstant.告警表_告警内容, "批次编号：" + parameters.get("pcbh") +"<br/>"+ "工单编号：" + parameters.get("zybh")  +"<br/>"+ "废品数量：" + parameters.get("bfsl") + "个");
		zlgjmap.put(CustomConstant.告警表_告警等级, CustomConstant.告警等级_低);
		zlgjmap.put(CustomConstant.告警表_告警处理状态, CustomConstant.告警处理状态_未处理);
		zlgjmap.put(CustomConstant.告警表_资源编号, parameters.get("zybh"));
		zlgjmap.put(CustomConstant.告警表_告警时间, new Date());
		zlgjmap.put(CustomConstant.告警表_操作人, Sys.getUserIdentifier());
		int count = Sys.insert(CustomConstant.告警表, zlgjmap);
		bundle.put("count", count);
	}
	/**
	 * 保存换线申请信息<触摸屏专用>
	 * 
	 * @param parameters
	 * @param bundle
	 * @return
	 */
	public void saveHxsq(Parameters parameters, Bundle bundle) {
		
		Map<String, Object> zlgjmap = new HashMap<String, Object>();
		zlgjmap.put(CustomConstant.告警表_告警类型, CustomConstant.告警类型_进度告警);
		zlgjmap.put(CustomConstant.告警表_告警标题, "加工单元：" + parameters.get("jgdymc") + "， 申请换线, 时间:" + parameters.get("hxtznr"));
		zlgjmap.put(CustomConstant.告警表_告警内容, "加工单元：" + parameters.get("jgdymc") + "， 申请换线, 时间:" + parameters.get("hxtznr"));
		zlgjmap.put(CustomConstant.告警表_告警等级, CustomConstant.告警等级_低);
		zlgjmap.put(CustomConstant.告警表_告警处理状态, CustomConstant.告警处理状态_未处理);
		zlgjmap.put(CustomConstant.告警表_资源编号, "");
		zlgjmap.put(CustomConstant.告警表_告警时间, new Date());
		zlgjmap.put(CustomConstant.告警表_操作人, Sys.getUserIdentifier());
		int count = Sys.insert(CustomConstant.告警表, zlgjmap);
		bundle.put("count", count);
	}

}
