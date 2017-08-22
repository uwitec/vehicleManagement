package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import pojos.City;
import pojos.Customer;
import pojos.OrderCenter;
import pojos.OrderForm;
import pojos.Scheme;
import service.CityService;
import service.OrderCenterService;
import service.OrderFormService;
import service.SchemeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



 /**
 * <p>3S运营管理系统</p>
 * <p>西安荣峰软件科技有限公司</p>
 * <p>功能说明：OrderFormAction</p>
 * @author 陈兴
 * @version 1.0.0 2013-1-1
 *
*/
public class OrderFormAction extends ActionSupport{

	/**
	*属性名：serialVersionUID、类型：long、作成日：2012-12-31.<br>
	*含义：
	*/
	private static final long serialVersionUID = 7722552796377815239L;
	private OrderFormService orderFormService;
	private OrderForm orderForm;
	private List<OrderForm> orderformlist;
	private List<City> citylist;
	private CityService cityService;
	private SchemeService schemeService;
	private OrderCenterService ordercenterService;
	private List<Scheme> schemelist;
	private List<OrderCenter> ordercenterlist;
	private int isArrive;//是否到达
	private int otype;
	private double userDay;//所用天数
	private double cost;//成本
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getUserDay() {
		return userDay;
	}
	public void setUserDay(double userDay) {
		this.userDay = userDay;
	}
	public int getOtype() {
		return otype;
	}
	public void setOtype(int otype) {
		this.otype = otype;
	}
	public int getIsArrive() {
		return isArrive;
	}
	public void setIsArrive(int isArrive) {
		this.isArrive = isArrive;
	}
	public List<OrderCenter> getOrdercenterlist() {
		return ordercenterlist;
	}
	public void setOrdercenterlist(List<OrderCenter> ordercenterlist) {
		this.ordercenterlist = ordercenterlist;
	}
	public List<Scheme> getSchemelist() {
		return schemelist;
	}
	public void setSchemelist(List<Scheme> schemelist) {
		this.schemelist = schemelist;
	}
	public OrderCenterService getOrdercenterService() {
		return ordercenterService;
	}
	public void setOrdercenterService(OrderCenterService ordercenterService) {
		this.ordercenterService = ordercenterService;
	}
	public SchemeService getSchemeService() {
		return schemeService;
	}
	public void setSchemeService(SchemeService schemeService) {
		this.schemeService = schemeService;
	}
	public List<OrderForm> getOrderformlist() {
		return orderformlist;
	}
	public void setOrderformlist(List<OrderForm> orderformlist) {
		this.orderformlist = orderformlist;
	}
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	public OrderFormService getOrderFormService() {
		return orderFormService;
	}
	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}
	
	public List<City> getCitylist() {
		return citylist;
	}
	public void setCitylist(List<City> citylist) {
		this.citylist = citylist;
	}
	
	public CityService getCityService() {
		return cityService;
	}
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public String toadd(){
		citylist=cityService.getCityList();
		return SUCCESS;
	}
	public String add(){
		if(orderForm!=null){
			DateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			orderForm.setOrderNumber(UUID.randomUUID().toString().replace("-", ""));
			orderForm.setOrderTime(dFormat.format(new Date()));
			orderForm.setOrderStatus(1);
			orderFormService.add(orderForm);
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(dFormat.parse("2013-01-05 12:23:22"));
			} catch (ParseException e) {
				//TODO自动生成catch语句块
				e.printStackTrace();
			}
			int week=calendar.get(Calendar.DAY_OF_WEEK)-1;
			int type=1;
			if(week==2||week==6){
				type=2;
			}
			List<Scheme> list=schemeService.getSchemeListByEndCityId(orderForm.getEndCity().getCityId(),type);
				for (int i = 0; i < list.size(); i++) {
					Scheme scheme=list.get(i);
					OrderCenter orderCenter=new OrderCenter();
					if(scheme.getSchemeType()==1){//如果方案为铁路或公路
						if(scheme.getSchemeDistance()<200){//距离小于200用公路
							orderCenter.setTransportMode("1");
						}
						else if(200<scheme.getSchemeDistance()&&scheme.getSchemeDistance()<500){//距离大于200用公路小于500
							if(orderForm.getCarNumber()<210){//如果数量小于210用公路
								orderCenter.setTransportMode("1");
							}else{
								StringBuffer transportmode=new StringBuffer();
								if(orderForm.getCarNumber()>290&&orderForm.getCarNumber()%290<210){//大于290并且对290求余不等于0,需要用公路铁路联运
										transportmode.append("1,");
								}
								transportmode.append("2");
								orderCenter.setTransportMode(transportmode.toString());
							}
						}
						else if (500<scheme.getSchemeDistance()&&scheme.getSchemeDistance()<1000) {//距离大于500用公路小于1000
							if(orderForm.getCarNumber()<240){//如果数量小于240用公路
								orderCenter.setTransportMode("1");
							}else{
								StringBuffer transportmode=new StringBuffer();
								if(orderForm.getCarNumber()>290&&orderForm.getCarNumber()%290<240){//大于290并且对290求余不等于0,需要用公路铁路联运
									transportmode.append("1,");
								}
								transportmode.append("2");
								orderCenter.setTransportMode(transportmode.toString());
							}
						}else{//距离大于1000
							if(orderForm.getCarNumber()<260){//如果数量小于260用公路
								orderCenter.setTransportMode("1");
							}else{
								StringBuffer transportmode=new StringBuffer();
								if(orderForm.getCarNumber()>290&&orderForm.getCarNumber()%290<260){//大于290并且对290求余不等于0,需要用公路铁路联运
									transportmode.append("1,");
								}
								transportmode.append("2");
								orderCenter.setTransportMode(transportmode.toString());
							}
						}
					}else if(scheme.getSchemeType()==3){//如果方案为海路
						orderCenter.setTransportMode("3");
					}else{//如果方案为江路
						orderCenter.setTransportMode("4");
					}
					orderCenter.setOrderformId(orderForm.getOrderId());
					orderCenter.setScheme(scheme);
					orderCenter.setStatus(1);
					ordercenterService.add(orderCenter);
				}
		}
		return SUCCESS;
	}
	public String detail(){
		if(orderForm!=null){
			Customer customer=(Customer) ActionContext.getContext().getSession().get("user");
			orderForm=orderFormService.getOrderFormById(orderForm.getOrderId());
			schemelist=schemeService.getSchemeListByOrderFormId(orderForm.getOrderId());
			ordercenterlist=ordercenterService.getOrderCenterListByOrderId(orderForm.getOrderId());
			if(orderForm.getOrderStatus()==2){
				for(int i=0;i<ordercenterlist.size();i++){
					if(ordercenterlist.get(i).getScheme().getEndCity().getCityId()==customer.getCusCity().getCityId()){
						if(ordercenterlist.get(i).getStatus()==2){
							continue;
						}else{
							if(i>0&&ordercenterlist.get(i-1).getStatus()==2){
								isArrive=1;
							}
							if(i==0){
								isArrive=1;
								break;
							}
						}
					}
				}
			}
		}
		if(otype==0){
			return "detail";
		}else{
			return "current";
		}
	}
	public String update(){
		if(orderForm!=null){
			DateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			orderForm=orderFormService.getOrderFormById(orderForm.getOrderId());
			orderForm.setOrderStatus(2);//审核
			orderForm.setSendorderTime(dFormat.format(new Date()));//发货日期
			orderFormService.update(orderForm);
		}
		return SUCCESS;
	}
	public String updateOrderCenter(){
		if(orderForm!=null){
			DateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Customer customer=(Customer) ActionContext.getContext().getSession().get("user");
			orderForm=orderFormService.getOrderFormById(orderForm.getOrderId());
			ordercenterService.update(orderForm.getOrderId(), customer.getCusCity().getCityId());
			int count=ordercenterService.getOrderCenterCountByCityId(orderForm.getOrderId());
			if(count==0){//如果所有路程走完,则更新订单未已收货
				orderForm.setOrderStatus(3);
				orderForm.setReceiptTime(dFormat.format(new Date()));
				orderFormService.update(orderForm);
			}
		}
		return SUCCESS;
	}
	public String list(){
		citylist=cityService.getCityList();
		Customer customer=(Customer) ActionContext.getContext().getSession().get("user");
		orderformlist=orderFormService.getOrderFormList(customer.getCusCity().getCityId(),orderForm);
		if(otype==0){
			return "list";
		}else{
			return "currentlist";
		}
	}
	public String dispatchlist(){
		citylist=cityService.getCityList();
		Customer customer=(Customer) ActionContext.getContext().getSession().get("user");
		orderformlist=orderFormService.getOrderFormList(customer.getCusCity().getCityId(),orderForm);
		return SUCCESS;
	}
	public String dispatchdetail(){
		double rate=10;
		if(orderForm!=null){
			Customer customer=(Customer) ActionContext.getContext().getSession().get("user");
			orderForm=orderFormService.getOrderFormById(orderForm.getOrderId());
			schemelist=schemeService.getSchemeListByOrderFormId(orderForm.getOrderId());
			ordercenterlist=ordercenterService.getOrderCenterListByOrderId(orderForm.getOrderId());
			if(orderForm.getOrderStatus()==2){
				for(int i=0;i<ordercenterlist.size();i++){
					if(ordercenterlist.get(i).getScheme().getEndCity().getCityId()==customer.getCusCity().getCityId()){
						if(ordercenterlist.get(i).getStatus()==2){
							continue;
						}else{
							if(i>0&&ordercenterlist.get(i-1).getStatus()==2){
								isArrive=1;
							}
							if(i==0){
								isArrive=1;
								break;
							}
						}
					}
				}
			}
			for (int i = 0; i < ordercenterlist.size(); i++) {
				OrderCenter orderCenter=ordercenterlist.get(i);
				if(i>0&&!orderCenter.getTransportMode().equals(ordercenterlist.get(i-1))){//如果前一段路和当前路的运输方式不一致加0.5天
					userDay+=0.5;
				}
				if(orderCenter.getTransportMode().equals("1")||orderCenter.getTransportMode().equals("1,2")){//如果为公路铁路联运
					//时间
					userDay+=orderCenter.getScheme().getSchemeDistance()/500;
					//费用
					if(orderCenter.getTransportMode().equals("1")){//公路
						if(orderCenter.getScheme().getSchemeDistance()<100){
							cost+=(orderForm.getCarNumber()/10)*2*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (100<orderCenter.getScheme().getSchemeDistance()&&orderCenter.getScheme().getSchemeDistance()<200) {
							cost+=(orderForm.getCarNumber()/10)*1.7*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (200<orderCenter.getScheme().getSchemeDistance()&&orderCenter.getScheme().getSchemeDistance()<500) {
							cost+=(orderForm.getCarNumber()/10)*1.5*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (500<orderCenter.getScheme().getSchemeDistance()&&orderCenter.getScheme().getSchemeDistance()<1000) {
							cost+=(orderForm.getCarNumber()/10)*1.3*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (1000<orderCenter.getScheme().getSchemeDistance()) {
							cost+=(orderForm.getCarNumber()/10)*1.2*orderCenter.getScheme().getSchemeDistance()*rate;
						}
					}
					if(orderCenter.getTransportMode().equals("1,2")){
						int g=(orderForm.getCarNumber()%290);
						if(orderCenter.getScheme().getSchemeDistance()<100){//公路
							cost+=(g/10)*2*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (100<orderCenter.getScheme().getSchemeDistance()&&orderCenter.getScheme().getSchemeDistance()<200) {
							cost+=(g/10)*1.7*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (200<orderCenter.getScheme().getSchemeDistance()&&orderCenter.getScheme().getSchemeDistance()<500) {
							cost+=(g/10)*1.5*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (500<orderCenter.getScheme().getSchemeDistance()&&orderCenter.getScheme().getSchemeDistance()<1000) {
							cost+=(g/10)*1.3*orderCenter.getScheme().getSchemeDistance()*rate;
						}else if (1000<orderCenter.getScheme().getSchemeDistance()) {
							cost+=(g/10)*1.2*orderCenter.getScheme().getSchemeDistance()*rate;
						}
						cost+=(orderForm.getCarNumber()/290)*1.2*orderCenter.getScheme().getSchemeDistance()*rate;//铁路
					}
					
				}
				if(orderCenter.getTransportMode().equals("2")){//如果为铁路
					userDay+=orderCenter.getScheme().getSchemeDistance()/700;
					cost+=(orderForm.getCarNumber()/290)*1.1*orderCenter.getScheme().getSchemeDistance()*rate;
				}
				if(orderCenter.getTransportMode().equals("3")||orderCenter.getTransportMode().equals("4")){//如果是水路
					userDay+=orderCenter.getScheme().getSchemeDistance()/400;
					if(orderCenter.getTransportMode().equals("3")){
						cost+=(orderForm.getCarNumber()/300)*1.2*orderCenter.getScheme().getSchemeDistance()*rate;
					}
					if(orderCenter.getTransportMode().equals("4")){
						cost+=(orderForm.getCarNumber()/200)*1.2*orderCenter.getScheme().getSchemeDistance()*rate;
					}
				}
			}
		}
		return SUCCESS;
	}
	public String citylist(){
		citylist=cityService.getAllCityList();
		return SUCCESS;
	}
}
