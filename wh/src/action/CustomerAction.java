package action;

import java.util.List;
import java.util.Locale;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.i18n.LocaleContext;

import net.sf.cglib.core.Local;

import pojos.Customer;
import pojos.Users;

import service.CustomerService;
import service.UsersService;
import sun.util.resources.LocaleData;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{
	 /**
	*灞炴�鍚嶏細serialVersionUID銆佺被鍨嬶細long銆佷綔鎴愭棩锛�012-12-30.<br>
	*鍚箟锛�
	*/
	private static final long serialVersionUID = -910456589191114077L;
	private CustomerService customerService;
	private List<Customer> customers;
	private Customer customer;
	private int flag=0;
	
	private String uu="341231";
	
	public String getUu()
	{
		return uu;
	}
	public void setUu(String uu)
	{
		this.uu = uu;
	}

	private Users users;
	public Users getUsers()
	{
		return users;
	}
	public void setUsers(Users users)
	{
		this.users = users;
	}

	private UsersService usersService;

    public String list(){
    	customers=customerService.getCustomerList();
    	return SUCCESS;
    }
    public String update(){
    	if(customer!=null){
    		customer=customerService.getCustomerById(customer.getCusId());
    		customer.setCusStatus(1);
    		customerService.updateCustomer(customer);
    	}
    	return SUCCESS;
    }
    public String delete()
    {
    	if(customer!=null){
    		customerService.deleteCustomer(customer);
    	}
    	return SUCCESS;
    }
    @SuppressWarnings("unchecked")
	public String login() throws Exception{
    	String password=users.getPassword();
    	users=usersService.getUsersByName(users.getUsername().trim());
    	if(users!=null&&users.getPassword().equals(password)){
    		ActionContext.getContext().getSession().put("user", users);
    		return SUCCESS;
    	}
    	setFlag(1);
    	return INPUT;
    }
    public UsersService getUsersService()
	{
		return usersService;
	}
	public void setUsersService(UsersService usersService)
	{
		this.usersService = usersService;
	}
	@SuppressWarnings("unchecked")
	public String toChinese(){
    	Locale local=new Locale("zh_CN");
    	ActionContext.getContext().setLocale(local);
    	ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE", "SESSION_LOCALE");
    	return SUCCESS;
    }
    @SuppressWarnings("unchecked")
	public String toEnglish(){
    	Locale local=new Locale("en_US");
    	ActionContext.getContext().setLocale(local);
    	ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE", "en_US");
    	return SUCCESS;
    }

    
    public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
    
    
}
