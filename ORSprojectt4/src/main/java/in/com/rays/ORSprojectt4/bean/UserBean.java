package in.com.rays.ORSprojectt4.bean;

import java.util.Date;

/**
 * @author yashita
 *
 */
public class UserBean extends BaseBean{
    public static final String ACTIVE = "Active";
    public static final String INACTIVE = "Inactive";
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String confirmPassword;
    private Date dob;
    private String mobileNo;
    private long roleId;
    private String gender;
    
    public UserBean() {
		// TODO Auto-generated constructor stub
	}
    
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String getKey() {
        return id + "";
    }
    @Override
    public String getValue() {
        return login;
    }
}